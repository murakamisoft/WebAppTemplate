package operations;

import java.math.BigDecimal;
import java.util.List;

import common.util.StringUtil;
import models.MUser;
import operations.tool.RandomUserCreator;
import play.db.ebean.Model.Finder;

public class TorokuOperation {

	private String userName;
	private String userId;

	public TorokuOperation(String userName) {
		this.userName = userName;
	}

	public void execute() {
		this.userId = saibanUserId();
		MUser muser = new MUser();
		muser.userId = this.userId;
		if (StringUtil.isNullOrEmpty(this.userName)) {
			RandomUserCreator creator = new RandomUserCreator();
			creator.create();
			muser.name = creator.getName();
			muser.passWord = creator.getPassWord();
			muser.sex = creator.getSex();
			muser.tel = creator.getTel();
			muser.address = creator.getAddress();
			muser.mailAddress = creator.getMailAddress();
			muser.userCarList = creator.getUserCarList(this.userId);
			muser.adminFlg = creator.getAdminFlg();

		} else {
			muser.name = this.userName;
		}

		muser.save();

	}

	private String saibanUserId() {
		// 現在のUserを全検索して表示
		Finder<String, MUser> finder = new Finder<String, MUser>(String.class, MUser.class);
		List<MUser> muserList = finder.all();

		if (muserList == null) {
			return "1001";
		}
		if (muserList.isEmpty()) {
			return "1001";
		}
		String userId = muserList.get(0).userId;
		for (MUser muser : muserList) {

			BigDecimal m = new BigDecimal(muser.userId);
			BigDecimal u = new BigDecimal(userId);

			if (m.compareTo(u) > 0) {
				userId = muser.userId;
			}

		}

		BigDecimal num = new BigDecimal(userId);

		num = num.add(BigDecimal.ONE);

		return num.toString();
	}

	/**
	 * ユーザーIDを取得する
	 * 
	 * @return
	 */
	public String getUserId() {
		return this.userId;
	}
}
