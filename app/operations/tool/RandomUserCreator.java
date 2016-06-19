package operations.tool;

import java.util.ArrayList;
import java.util.List;

import common.flg.CheckFlg;
import common.util.NumberUtil;
import models.TUserCar;

/**
 * ランダムユーザークリエーター
 * 
 * @author murakami
 *
 */
public class RandomUserCreator {

	private String name;
	private List<String> shiList;
	private List<String> meiList;

	public RandomUserCreator() {
		this.shiList = getShiList();
		this.meiList = getMeiList();
	}

	public void create() {
		int s = NumberUtil.getRandomNo(this.shiList.size());
		int m = NumberUtil.getRandomNo(this.meiList.size());
		StringBuffer buf = new StringBuffer();
		buf.append(this.shiList.get(s));
		buf.append(this.meiList.get(m));
		this.name = buf.toString();
	}

	private List<String> getMeiList() {
		List<String> meiList = new ArrayList<String>();
		meiList.add("一郎");
		meiList.add("二郎");
		meiList.add("三郎");
		meiList.add("俊輔");
		meiList.add("俊朗");
		meiList.add("和樹");
		meiList.add("大岐");
		meiList.add("総一郎");
		meiList.add("誠");
		meiList.add("勉");
		meiList.add("マイ");
		meiList.add("理恵");
		meiList.add("慶太");
		meiList.add("文雄");
		meiList.add("智");
		meiList.add("明訓");
		meiList.add("大輔");
		meiList.add("百恵");
		return meiList;
	}

	private List<String> getShiList() {
		List<String> shiList = new ArrayList<String>();
		shiList.add("山田");
		shiList.add("青木");
		shiList.add("重田");
		shiList.add("藤原");
		shiList.add("伊藤");
		shiList.add("佐々木");
		shiList.add("下田");
		shiList.add("市原");
		shiList.add("陰元");
		shiList.add("坂下");
		shiList.add("米田");
		shiList.add("市川");
		shiList.add("櫻井");
		shiList.add("木村");
		shiList.add("高田");
		shiList.add("上田");
		shiList.add("村上");
		shiList.add("戸田");
		shiList.add("和平");
		shiList.add("岩本");
		return shiList;
	}

	public String getName() {
		return name;
	}

	/**
	 * パスワードを取得する
	 * 
	 * @return
	 */
	public String getPassWord() {
		return "pass";
	}

	/**
	 * 性別を取得する
	 * 
	 * @return
	 */
	public String getSex() {
		return Integer.toString(NumberUtil.getRandomNo(1));
	}

	/**
	 * 電話番号を取得する
	 * 
	 * @return
	 */
	public String getTel() {
		return "03-9999-9999";
	}

	/**
	 * 住所を取得する
	 * 
	 * @return
	 */
	public String getAddress() {
		return "東京都港区六本木6-10-1 六本木ヒルズ森タワー 32F ";
	}

	/**
	 * ユーザーカーリストを取得する
	 * 
	 * @param userId
	 * @return
	 */
	public List<TUserCar> getUserCarList(String userId) {
		List<TUserCar> carList = new ArrayList<TUserCar>();
		TUserCar userCar = new TUserCar();
		userCar.userId = userId;

		userCar.carId = getCarId();
		userCar.daihyoFlg = CheckFlg.ON;

		carList.add(userCar);
		return carList;
	}

	private String getCarId() {
		StringBuffer buf = new StringBuffer();
		String n = Integer.toString(NumberUtil.getRandomNo(9));

		buf.append("00");
		buf.append(n);

		return buf.toString();
	}

	/**
	 * 管理者フラグを取得する
	 * 
	 * @return
	 */
	public String getAdminFlg() {
		return CheckFlg.ON;
	}

	/**
	 * メールアドレスを取得する
	 * 
	 * @return
	 */
	public String getMailAddress() {
		return "nori@vbminigame.sakura.ne.jp";
	}

}
