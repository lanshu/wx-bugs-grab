package cn.pigpi.grab.webmagic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.joda.time.DateTime;

import cn.pigpi.grab.domain.AppMsgExtInfoVo;
import cn.pigpi.grab.domain.Article;
import cn.pigpi.grab.domain.CommMsgInfoVo;
import cn.pigpi.grab.domain.JsonInfoVo;
import cn.pigpi.grab.domain.OfficialAccount;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;

public class GithubRepoPageProcessor implements PageProcessor {

	private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

	private static final String LIST_URL = "http://mp\\.weixin\\.qq\\.com/mp/getmasssendmsg.*";
	private static final String ARTICLE_URL = "http://mp\\.weixin\\.qq\\.com/s.*";

	@Override
	public Site getSite() {
		return site;
	}

	@Override
	public void process(Page page) {
		Json json = page.getJson();
		if (page.getUrl().regex(LIST_URL).match()) {
			// ret 0为成功 -3为失败
			String ret = json.jsonPath("$.ret").get();
			// errmsg ok为成功 no session为失败
			String errMsg = json.jsonPath("$.errmsg").get();
			if ("-3".equals(ret)) {
				System.out.println("key过期了");
				return;
			}
			// Biz
			String biz = json.jsonPath("$.bizuin_code").get();
			// uni
			String uni = json.jsonPath("$.uin_code").get();
			// 文章列表
			String general_msg_list = json.jsonPath("$.general_msg_list").get();
			List<String> listStr = new Json(general_msg_list).jsonPath("$.list").all();
			//没有信息列表
			if(CollectionUtils.isEmpty(listStr)) {
				System.out.println("没有文章啦");
				return;
			}

			Gson gson = new Gson();
			List<Article> articles = Lists.newArrayList();
			Article article = null;
			for (String string : listStr) {
				string = formatStr(string);
				JsonInfoVo jsonInfoVo = gson.fromJson(string, JsonInfoVo.class);
				CommMsgInfoVo commMsgInfoVo = jsonInfoVo.getComm_msg_info();
				// 如果app_msg_ext_info为null, 文章没有采集意义，不做解析
				if (jsonInfoVo.getApp_msg_ext_info() == null) {
					continue;
				}
				AppMsgExtInfoVo appMsgExtInfoVo = jsonInfoVo.getApp_msg_ext_info();
				article = getArticle(appMsgExtInfoVo, commMsgInfoVo, biz, uni, "1");
				articles.add(article);
				// 子文章
				if (CollectionUtils.isNotEmpty(jsonInfoVo.getApp_msg_ext_info().getMulti_app_msg_item_list())) {
					List<AppMsgExtInfoVo> childArticles = jsonInfoVo.getApp_msg_ext_info().getMulti_app_msg_item_list();
					for (int i = 0; i < childArticles.size(); i++) {
						AppMsgExtInfoVo childAppMsgExtInfoVo = childArticles.get(i);
						article = getArticle(childAppMsgExtInfoVo, commMsgInfoVo, biz, uni, String.valueOf(i + 2));
						articles.add(article);
					}
				}
			}
			//只加入第一篇文章url， 取公众号信息
			page.addTargetRequest(articles.get(0).getUrl());
			
			//第一次读取需要爬取所有历史文章
			
		}
		if (page.getUrl().regex(ARTICLE_URL).match()) {
			//具体文章链接其实只是为了抓取微信公众号的基本信息
			//只抓第一条
			OfficialAccount officialAccount = new OfficialAccount();
			
		}
	}

	/**
	 * 构造article
	 * 
	 * @param jsonInfoVo
	 * @param biz
	 * @return
	 */
	private Article getArticle(AppMsgExtInfoVo appMsgExtInfoVo, CommMsgInfoVo commMsgInfoVo, String biz, String uni,
			String idx) {
		Article article = new Article();
		article.setBiz(biz);
		article.setGroupId(commMsgInfoVo.getId());
		article.setPublishTime(new DateTime(Long.valueOf(commMsgInfoVo.getDatetime() + "000"))
				.toString("yyyy年MM月dd日HH:mm"));
		article.setAppUni(uni);
		article.setTitle(appMsgExtInfoVo.getTitle());
		article.setDigest(appMsgExtInfoVo.getDigest());
		article.setHeadImg(appMsgExtInfoVo.getCover());
		article.setIdx(idx);
		article.setUrl(appMsgExtInfoVo.getContent_url());

		return article;
	}

	private String formatStr(String jsonStr) {
		// 先去除转义
		jsonStr = StringEscapeUtils.unescapeJson(jsonStr);

		// 去除特殊符号
		String[] replace = { "&#39;", "'", "&quot;", "\"", "&nbsp;", " ", "&gt;", ">", "&lt;", "<", "&amp;", "&",
				"&yen;", "¥", "\\", "" };
		for (int i = 0; i < replace.length; i += 2) {
			jsonStr = jsonStr.replace(replace[i], replace[i + 1]);
		}
		// jsonStr = jsonStr.substring(9);
		// jsonStr = jsonStr.substring(0, jsonStr.length() - 1);
		System.out.println(jsonStr);
		return jsonStr;
	}

	public static void main(String[] args) {
		String url = "http://mp.weixin.qq.com/mp/getmasssendmsg?__biz=MjM5NTgwODEwMQ==&uin=MTgyMTk1OTMwMA%3D%3D&key=1a6dc58b177dc626c162efc5b5a39004e90131aa7c0121e9d995de4c228e723536a86c2ad32fe8b7592ec9c16381558e28259ef8255c7a4a&devicetype=Windows+10&version=6202002e&lang=zh_CN&ascene=7&pass_ticket=rBegOplUEgBtPcBKnJfgeY2YqeRzRngzeWOejHTQ%2BnMSP2csZBDA%2FiQQ0ALEznY4";
		url += "&f=json";
		Spider.create(new GithubRepoPageProcessor()).addUrl(url).thread(1).run();
	}
}
