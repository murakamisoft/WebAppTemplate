package models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.avaje.ebean.annotation.CreatedTimestamp;

import common.flg.KanrishaFlg;
import common.kbn.SexKbn;
import play.db.ebean.Model;

/**
 * ユーザマスタ
 * 
 * @author murakami
 *
 */
@Entity
public class MUser extends Model {

	private static final long serialVersionUID = -1586475360271866377L;

	@Id
	@NotNull
	public String userId;

	public String passWord;

	@NotNull
	public String name;
	public String sex;

	public String tel;
	public String address;
	public String mailAddress;
	public String message;
	public BigDecimal money;
	public String adminFlg;

	@CreatedTimestamp
	public Date createDate;

	@Version
	public Date updateDate;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	public List<TUserCar> userCarList = new ArrayList<TUserCar>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_id", referencedColumnName = "group_id", insertable = false, updatable = false)
	public MUserGroup userGroup;

	/**
	 * 車名を取得する
	 * 
	 * @return
	 */
	public String getCarName() {
		for (TUserCar car : this.userCarList) {
			if (car.car == null) {
				continue;
			}

			return car.car.carName;
		}
		return null;
	}

	/**
	 * 性別名を取得する
	 * 
	 * @return
	 */
	public String getSexMei() {
		if (SexKbn.isMan(sex)) {
			return SexKbn.getManMei();
		}
		if (SexKbn.isWoMan(sex)) {
			return SexKbn.getWoManMei();
		}
		return null;
	}

	public String getKanrishaMei() {
		if (KanrishaFlg.isOn(adminFlg)) {
			return KanrishaFlg.getKanrishaMei();
		}
		return null;
	}
}
