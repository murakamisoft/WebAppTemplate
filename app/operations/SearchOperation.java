package operations;

import java.util.ArrayList;
import java.util.List;

import common.util.StringUtil;
import models.MUser;
import play.db.ebean.Model.Finder;

public class SearchOperation {

	private String userId;
	private List<MUser> userList;

	public SearchOperation(String userId) {
		this.userId = userId;
	}

	public void execute() {
		this.userList = getUserListFromEntity();

	}

	private List<MUser> getUserListFromEntity() {

		// 現在のUserを全検索して表示
		Finder<String, MUser> finder = new Finder<String, MUser>(String.class, MUser.class);
		List<MUser> muserList = finder.all();

		if (muserList == null) {
			return null;
		}

		if (StringUtil.isNullOrEmpty(this.userId)) {
			return muserList;
		}

		MUser targetUser = getTargetUser(muserList);

		List<MUser> targetUserList = new ArrayList<MUser>();

		targetUserList.add(targetUser);

		return targetUserList;
	}

	/**
	 * ターゲットユーザーを取得する
	 * 
	 * @param muserList
	 * @return
	 */
	private MUser getTargetUser(List<MUser> muserList) {
		for (MUser user : muserList) {
			if (StringUtil.isEqual(this.userId, user.userId)) {
				return user;
			}
		}
		return new MUser();
	}

	public List<MUser> getUserList() {
		return this.userList;
	}
}
