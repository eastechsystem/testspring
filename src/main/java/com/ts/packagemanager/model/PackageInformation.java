package com.ts.packagemanager.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jahanzaib Ali
 * @since June 19, 2017
 */
@Entity
@Table(name = "PackageInformation", catalog = "packagedb")
public class PackageInformation implements Serializable {

	public static final String SUCCESS = "Success";
	public static final String FAILURE = "Failure";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Integer price;
	private Boolean active;
	private String description;
	private Integer duration;
	private Date createDateTime;
	private Date modifiedDateTime;

	/**
	 * @return the id
	 */

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Id")
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */

	@Column(name = "Name")
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */

	@Column(name = "Price")
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * @return the active
	 */

	@Column(name = "Active")
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * @return the description
	 */

	@Column(name = "Description")
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the duration
	 */
	@Column(name = "Duration")
	public Integer getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * @return the createDateTime
	 */

	@Column(name = "CreateDateTime")
	public Date getCreateDateTime() {
		return createDateTime;
	}

	/**
	 * @param createDateTime
	 *            the createDateTime to set
	 */
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	/**
	 * @return the modifiedDateTime
	 */
	@Column(name = "ModifiedDateTime")
	public Date getModifiedDateTime() {
		return modifiedDateTime;
	}

	/**
	 * @param modifiedDateTime
	 *            the modifiedDateTime to set
	 */
	public void setModifiedDateTime(Date modifiedDateTime) {
		this.modifiedDateTime = modifiedDateTime;
	}
}
