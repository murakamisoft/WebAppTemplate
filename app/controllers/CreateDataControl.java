package controllers;

import operations.CreateDataOperation;
import operations.SearchOperation;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * データ作成
 * 
 * @author murakami
 *
 */
public class CreateDataControl extends Controller {

	/**
	 * データ作成
	 * 
	 * @return
	 */
	public static Result createData() {

		CreateDataOperation operation = new CreateDataOperation();
		operation.execute();

		SearchOperation searchOperation = new SearchOperation(null);
		searchOperation.execute();

		return ok(views.html.user.render(searchOperation.getUserList()));
	}
}
