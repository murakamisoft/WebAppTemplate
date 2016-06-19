package operations;

import java.util.List;

import models.MCar;
import models.MUserGroup;
import play.db.ebean.Model.Finder;

/**
 * データ作成オペレーション
 * 
 * @author murakami
 *
 */
public class CreateDataOperation {

	/**
	 * 作成
	 */
	public void execute() {

		createCar();
		createUserGroup();

	}

	/**
	 * ユーザグループを作成する
	 */
	private void createUserGroup() {
		Finder<String, MUserGroup> finder = new Finder<String, MUserGroup>(String.class, MUserGroup.class);
		List<MUserGroup> userGroupList = finder.all();

		if (userGroupList == null) {
		} else {
			for (MUserGroup userGroup : userGroupList) {
				userGroup.delete();
			}
		}

		MUserGroup userGroup = null;

		userGroup = new MUserGroup();
		userGroup.groupId = "G000";
		userGroup.groupName = "さくら";
		userGroup.save();

		userGroup = new MUserGroup();
		userGroup.groupId = "G001";
		userGroup.groupName = "うめ";
		userGroup.save();

		userGroup = new MUserGroup();
		userGroup.groupId = "G002";
		userGroup.groupName = "ひまわり";
		userGroup.save();

		userGroup = new MUserGroup();
		userGroup.groupId = "G003";
		userGroup.groupName = "はくちょう";
		userGroup.save();
	}

	/**
	 * 車を作成する
	 */
	private void createCar() {
		Finder<String, MCar> finder = new Finder<String, MCar>(String.class, MCar.class);
		List<MCar> carList = finder.all();

		if (carList == null) {
		} else {
			for (MCar car : carList) {
				car.delete();
			}
		}

		MCar car = new MCar();
		car.carId = "000";
		car.carName = "マークX";
		car.color = "ホワイト";
		car.cc = 2500;
		car.price = 2500000;
		car.save();

		car = new MCar();
		car.carId = "001";
		car.carName = "クラウンアスリート";
		car.color = "ホワイト";
		car.cc = 2500;
		car.price = 4000000;
		car.save();

		car = new MCar();
		car.carId = "002";
		car.carName = "BMW 3";
		car.color = "ホワイト";
		car.cc = 2500;
		car.price = 4500000;
		car.save();

		car = new MCar();
		car.carId = "003";
		car.carName = "メルセデスベンツ C";
		car.color = "ホワイト";
		car.cc = 2500;
		car.price = 5000000;
		car.save();

		car = new MCar();
		car.carId = "004";
		car.carName = "カローラアクシオ";
		car.color = "ホワイト";
		car.cc = 1500;
		car.price = 1500000;
		car.save();

		car = new MCar();
		car.carId = "005";
		car.carName = "メルセデスベンツS";
		car.color = "ホワイト";
		car.cc = 5500;
		car.price = 8000000;
		car.save();

		car = new MCar();
		car.carId = "006";
		car.carName = "BMW 5";
		car.color = "ホワイト";
		car.cc = 3500;
		car.price = 7500000;
		car.save();

		car = new MCar();
		car.carId = "007";
		car.carName = "レクサス LS460";
		car.color = "ホワイト";
		car.cc = 4600;
		car.price = 8000000;
		car.save();

		car = new MCar();
		car.carId = "008";
		car.carName = "BMW 7";
		car.color = "ホワイト";
		car.cc = 5000;
		car.price = 10000000;
		car.save();

		car = new MCar();
		car.carId = "009";
		car.carName = "センチュリー";
		car.color = "ブラック";
		car.cc = 5000;
		car.price = 12500000;
		car.save();

	}

}
