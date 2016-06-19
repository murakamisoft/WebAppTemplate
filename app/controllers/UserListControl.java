package controllers;

import common.util.StringUtil;
import operations.DeleteOperation;
import operations.SearchOperation;
import operations.TorokuOperation;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class UserListControl extends Controller {

	public static Result init() {
		// return ok(views.html.user.render(new ArrayList<User>()));
		return searchUser();
	}

	public static Result searchUser() {

		DynamicForm input = Form.form().bindFromRequest("userId");
		String userId = input.data().get("userId");

		SearchOperation operation = new SearchOperation(userId);
		operation.execute();

		return ok(views.html.user.render(operation.getUserList()));
	}

	public static Result torokuUser() {
		DynamicForm input = Form.form().bindFromRequest("userName");
		String userName = input.data().get("userName");

		TorokuOperation operation = new TorokuOperation(userName);
		operation.execute();

		SearchOperation searchOperation = new SearchOperation(null);
		searchOperation.execute();

		return ok(views.html.user.render(searchOperation.getUserList()));
	}

	public static Result controlUser() {
		DynamicForm input = Form.form().bindFromRequest("deleteUserId");
		String deleteUserId = input.data().get("deleteUserId");

		input = Form.form().bindFromRequest("kunrenUserId");
		String kunrenUserId = input.data().get("kunrenUserId");

		if (StringUtil.hasValue(kunrenUserId)) {
			System.out.println("訓練ユーザ：" + kunrenUserId);
			return ok(views.html.kunren.render(kunrenUserId));

		} else if (StringUtil.hasValue(deleteUserId)) {
			DeleteOperation operation = new DeleteOperation(deleteUserId);
			operation.execute();
		}

		SearchOperation searchOperation = new SearchOperation(null);
		searchOperation.execute();

		return ok(views.html.user.render(searchOperation.getUserList()));
	}

}
