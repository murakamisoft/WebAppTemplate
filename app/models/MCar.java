package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.avaje.ebean.annotation.CreatedTimestamp;

import play.db.ebean.Model;

/**
 * カーマスタ
 * 
 * @author murakami
 *
 */
@Entity
public class MCar extends Model {

	private static final long serialVersionUID = 5187132346008028204L;

	@Id
	public String carId;

	public String carName;

	public long price;

	public String color;

	public int cc;

	@CreatedTimestamp
	public Date createDate;

	@Version
	public Date updateDate;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
	public List<TUserCar> userCarList = new ArrayList<TUserCar>();
}
