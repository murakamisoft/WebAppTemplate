package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.avaje.ebean.annotation.CreatedTimestamp;

import play.db.ebean.Model;

/**
 * ユーザカー
 * 
 * @author murakami
 *
 */
@Entity
public class TUserCar extends Model {

	private static final long serialVersionUID = -1586475360271866377L;

	@Id
	@NotNull
	public String userId;

	@Id
	@NotNull
	public String carId;

	public String daihyoFlg;

	@CreatedTimestamp
	public Date createDate;

	@Version
	public Date updateDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
	public MUser user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id", referencedColumnName = "car_id", insertable = false, updatable = false)
	public MCar car;
}
