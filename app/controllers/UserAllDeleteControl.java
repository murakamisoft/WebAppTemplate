package controllers;

import operations.DeleteAllUserOperation;
import operations.SearchOperation;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * ユーザー全削除コントローラ
 * 
 * @author murakami
 *
 */
public class UserAllDeleteControl extends Controller {

	/**
	 * ユーザを全削除する
	 * 
	 * @return
	 */
	public static Result deleteAllUser() {

		DeleteAllUserOperation deleteOperation = new DeleteAllUserOperation();
		deleteOperation.execute();

		SearchOperation searchOperation = new SearchOperation(null);
		searchOperation.execute();

		return ok(views.html.user.render(searchOperation.getUserList()));
	}
}
