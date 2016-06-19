package models;

import java.util.ArrayList;
import java.util.List;

import play.db.ebean.Model.Finder;

/**
 * ユーザマスタアクセサ
 * 
 * @author murakami
 *
 */
public class MUserAccessor {

	/**
	 * 全データ取得
	 * 
	 * @return
	 */
	public List<MUser> findAll() {
		Finder<String, MUser> finder = new Finder<String, MUser>(String.class, MUser.class);
		List<MUser> muserList = finder.all();
		if (muserList == null) {
			return new ArrayList<MUser>();
		}
		return muserList;
	}
}
