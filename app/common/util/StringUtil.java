package common.util;

public class StringUtil {

	public static boolean hasValue(String str) {
		if (str == null) {
			return false;
		}
		if (str.equals("")) {
			return false;
		}
		return true;
	}

	public static boolean isNullOrEmpty(String str) {
		return !hasValue(str);
	}

	/**
	 * 等しいか
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean isEqual(String str1, String str2) {
		if (str1 == null) {
			return false;
		}
		if (str2 == null) {
			return false;
		}
		return str1.equals(str2);
	}
}
