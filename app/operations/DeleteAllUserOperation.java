package operations;

import models.MUser;
import models.MUserAccessor;

/**
 * 全ユーザ削除オペレーション
 * 
 * @author murakami
 *
 */
public class DeleteAllUserOperation {

	/**
	 * 実行
	 */
	public void execute() {
		for (MUser user : new MUserAccessor().findAll()) {
			user.delete();
		}

	}

}
