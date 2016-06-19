package common.kbn;

import common.util.StringUtil;

/**
 * 性別区分
 * 
 * @author murakami
 *
 */
public class SexKbn {
	public static final String MAN = "0";
	public static final String WOMAN = "1";

	public static String getManMei() {
		return "男性";
	}

	public static String getWoManMei() {
		return "女性";
	}

	/**
	 * 男か
	 * 
	 * @param sex
	 * @return
	 */
	public static boolean isMan(String sex) {
		return StringUtil.isEqual(MAN, sex);
	}

	/**
	 * 女か
	 * 
	 * @param sex
	 * @return
	 */
	public static boolean isWoMan(String sex) {
		return StringUtil.isEqual(WOMAN, sex);
	}
}
