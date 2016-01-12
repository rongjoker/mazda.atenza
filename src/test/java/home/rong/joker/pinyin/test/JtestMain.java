package home.rong.joker.pinyin.test;

import home.rong.joker.itools.entity.YoudaoResult;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.com.dms.sms.bean.CrawlElement;
import org.com.dms.sms.util.Htmltools;
import org.com.dms.sms.util.RequestProperty;
import org.com.ronger.joker.robot.Core4Machine;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author joker4lr
 * @date:2016-1-10 下午1:38:44
 * @company:
 * @description
 * @version:0.0.1
 */
public class JtestMain {

	public static void test1() {

		Core4Machine core = new Core4Machine("http://fanyi.youdao.com/translate?i=%E4%BB%BB%E5%8A%A1&ue=utf-8&keyfrom=baidu&smartresult=dict&type=ZH_CN2EN", 3,
				new RequestProperty());

		CrawlElement element = core.execute();

		System.out.println(Htmltools.unicodeToString(element.getHtmlCode()));

		Htmltools.writeDataToFile("D:/data/html.html", Htmltools.unicodeToString(element.getHtmlCode()));

	}

	public static void test2() {

		try {

			System.out.println(Htmltools.unicodeToString("\u6d4b\u8bd5"));

			System.out.println(Htmltools.unicodeFromString("测试"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void trans(String word) {
		Core4Machine core = new Core4Machine("http://fanyi.youdao.com/translate?i=" + word + "&ue=utf-8&keyfrom=baidu&smartresult=dict&type=AUTO", 3,
				new RequestProperty());

		CrawlElement element = core.execute();

		testk(Htmltools.unicodeToString(element.getHtmlCode()));

	}

	public static void testk(String htmlCode) {

		Elements es = Jsoup.parse(htmlCode).getElementsByTag("script");

		Iterator<Element> it = es.iterator();

		String code = "";

		while (it.hasNext()) {
			Element e = it.next();
			String html = e.html();

			if (html.contains("global.translatedJson")) {
				code = html;
				break;
			}
		}

		String[] ss = code.split("\n");

		for (String s : ss) {
			if (s.contains("global.translatedJson")) {
				code = s.trim();
				break;
			}
		}

		// System.out.println(code);
		String json = Htmltools.getAttrs(code.replace(" ", "")).get("global.translatedJson").replace(";", "");
		System.out.println(json);

		YoudaoResult entity = Htmltools.getGson().fromJson(json, YoudaoResult.class);

		System.out.println("src:" + entity.getTranslateResult().get(0).get(0).getSrc());

		String[] entries = entity.getSmartResult().getEntries();

		for (String ent : entries) {
			String sk = ent.replace("[计]", "");
			if (sk.trim().length() > 0)
				System.out.println(sk);

		}

	}

	public static void test3() {

		String htmlCode = Htmltools.readfiletoData("D:/data/html.html");

		Elements es = Jsoup.parse(htmlCode).getElementsByTag("script");

		Iterator<Element> it = es.iterator();

		String code = "";

		while (it.hasNext()) {
			Element e = it.next();
			String html = e.html();

			if (html.contains("global.translatedJson")) {
				code = html;
				break;
			}
		}

		String[] ss = code.split("\n");

		for (String s : ss) {
			if (s.contains("global.translatedJson")) {
				code = s.trim();
				break;
			}
		}

		// System.out.println(code);
		String json = Htmltools.getAttrs(code.replace(" ", "")).get("global.translatedJson").replace(";", "");
		System.out.println(json);

		YoudaoResult entity = Htmltools.getGson().fromJson(json, YoudaoResult.class);

		System.out.println("src:" + entity.getTranslateResult().get(0).get(0).getSrc());

		String[] entries = entity.getSmartResult().getEntries();

		for (String ent : entries) {
			String sk = ent.trim();
			if (sk.length() > 0)
				System.out.println(sk);

		}

		// System.out.println(Htmltools.getAttrs(code.replace(" ", "")).get("global.translatedJson"));

	}

	public static void test4() {
		String json = Htmltools.readfiletoData("D:/data/ss");
		System.out.println(json);

		Map<String, Object> obs = Htmltools.getGson().fromJson(json, Map.class);

		System.out.println(obs.get("translateResult"));

	}

	public static void test5() {

		String json = Htmltools.readfiletoData("D:/data/ss");
		System.out.println(Htmltools.jsonFormatter(json));

		System.out.println(2 << 2);

		// YoudaoResult entity = Htmltools.getGson().fromJson(json, YoudaoResult.class);
		// System.out.println(Htmltools.getGsonIndent().toJson(entity));

	}

	public static void test6() {
		String s = "http://fanyi.youdao.com/translate?i=following file&ue=utf-8&keyfrom=baidu&smartresult=dict&type=AUTO";
		s = "http://192.168.78.22:8080/solr/applist/select?q=%E6%B5%8B%E8%AF%95&wt=json&indent=true";
		s = "abc";
		try {
			URL u = new URL(s);
			System.out.println("u.getPath()：" + u.getPath());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		Core4Machine core = new Core4Machine(null, null, null);
		System.out.println(core.buildURL(s));

	}

	public static void main(String[] args) {

		// test4();

		// test3();

		// trans("test");

		test6();

	}

}
