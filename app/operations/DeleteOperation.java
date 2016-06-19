package operations;

import java.util.List;

import models.MUser;
import play.db.ebean.Model.Finder;

public class DeleteOperation {

	private String deleteUserId;

	public DeleteOperation(String deleteUserId) {
		this.deleteUserId = deleteUserId;
	}

	public void execute() {
		// 現在のUserを全検索して表示
		Finder<String, MUser> finder = new Finder<String, MUser>(String.class, MUser.class);
		List<MUser> muserList = finder.all();

		for (MUser muser : muserList) {
			if (muser.userId.equals(this.deleteUserId)) {
				muser.delete();
				break;
			}
		}

	}

}
