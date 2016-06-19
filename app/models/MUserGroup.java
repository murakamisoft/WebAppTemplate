package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.avaje.ebean.annotation.CreatedTimestamp;

import play.db.ebean.Model;

/**
 * ユーザグループマスタ
 * 
 * @author murakami
 *
 */
@Entity
public class MUserGroup extends Model {

	private static final long serialVersionUID = 7075670232070355593L;

	@Id
	@NotNull
	public String groupId;

	@NotNull
	public String groupName;

	@CreatedTimestamp
	public Date createDate;

	@Version
	public Date updateDate;
}
