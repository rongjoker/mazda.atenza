package home.rong.joker.itools.util;

import home.rong.joker.itools.entity.YoudaoResult;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.com.dms.sms.bean.CrawlElement;
import org.com.dms.sms.util.Htmltools;
import org.com.dms.sms.util.RequestProperty;
import org.com.ronger.joker.robot.Core4Machine;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author joker4lr
 * @date:2016-1-10 下午4:44:08
 * @company:
 * @description
 * @version:0.0.1
 */
public class YoudaoTransUtil {

	private static final Logger LOG = LoggerFactory.getLogger(YoudaoTransUtil.class);

	public static Map<Integer, String> translateTypeMap = new HashMap<Integer, String>() {

		private static final long serialVersionUID = -6179383185207522842L;

		{

			put(1, "ZH_CN2EN");
			put(2, "EN2ZH_CN");

		}

	};

	public static Set<String> translate(String word) {

		String type = "AUTO";

		Set<String> list = new HashSet<String>();

		Core4Machine core = new Core4Machine("http://fanyi.youdao.com/translate?i=" + word + "&ue=utf-8&keyfrom=baidu&smartresult=dict&type=" + type, 3,
				new RequestProperty());

		LOG.debug("word:" + word);

		CrawlElement element = core.execute();

		Elements es = Jsoup.parse(element.getHtmlCode()).getElementsByTag("script");

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

		String json = code.replace("global.translatedJson", "").replace("=", "").trim().replace(";", "").trim();
		LOG.debug(json);
		YoudaoResult entity = Htmltools.getGson().fromJson(json, YoudaoResult.class);

		list.add(entity.getTranslateResult().get(0).get(0).getTgt());

		if (entity.getSmartResult() == null)
			return list;

		String[] entries = entity.getSmartResult().getEntries();

		for (String ent : entries) {
			String sk = ent.trim();
			LOG.debug("sk:" + sk);
			if (sk.length() > 0)
				list.add(sk);
		}

		return list;

	}
}
