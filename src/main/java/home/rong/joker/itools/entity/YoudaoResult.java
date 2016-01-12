package home.rong.joker.itools.entity;

import java.util.List;

/**
 * @author joker4lr
 * @date:2016-1-10 下午4:11:52
 * @company:
 * @description
 * @version:0.0.1
 */
public class YoudaoResult {
	private String type;
	private Integer errorCode;
	private Integer elapsedTime;

	private List<List<Translate>> translateResult;

	private SmartResult smartResult;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public Integer getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(Integer elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public SmartResult getSmartResult() {
		return smartResult;
	}

	public void setSmartResult(SmartResult smartResult) {
		this.smartResult = smartResult;
	}

	public List<List<Translate>> getTranslateResult() {
		return translateResult;
	}

	public void setTranslateResult(List<List<Translate>> translateResult) {
		this.translateResult = translateResult;
	}

	public class SmartResult {

		private Integer type;

		private String[] entries;

		public Integer getType() {
			return type;
		}

		public void setType(Integer type) {
			this.type = type;
		}

		public String[] getEntries() {
			return entries;
		}

		public void setEntries(String[] entries) {
			this.entries = entries;
		}

	}

	public class Translate {

		private String src;
		private String tgt;

		public String getSrc() {
			return src;
		}

		public void setSrc(String src) {
			this.src = src;
		}

		public String getTgt() {
			return tgt;
		}

		public void setTgt(String tgt) {
			this.tgt = tgt;
		}

	}

}
