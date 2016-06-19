package common.flg;

import common.util.StringUtil;

/**
 * 管理者フラグ
 * 
 * @author murakami
 *
 */
public class KanrishaFlg {
	public static final String ON = "1";
	public static final String OFF = "0";

	public static String getKanrishaMei() {
		return "管理者";
	}

	/**
	 * 管理者フラグONか
	 * 
	 * @param adminFlg
	 * @return
	 */
	public static boolean isOn(String adminFlg) {
		return StringUtil.isEqual(ON, adminFlg);
	}
}
