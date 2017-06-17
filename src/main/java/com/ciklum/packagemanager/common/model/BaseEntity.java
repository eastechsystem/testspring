package com.ciklum.packagemanager.common.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author mtariq
 * since 2/5/2015
 */
public class BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Integer id;
	protected Integer contactId;
	protected Integer createdById;
	protected Integer modifiedById;
	protected Date createDateTime;
	protected Date modifyDateTime;
	protected Date mergeDateTime;
	protected Date approveDateTime;
	protected Short action;
	protected Short status;
	protected Boolean deleted;
	
	public static final Short ACTION_CREATED = 1;
	public static final Short ACTION_UPDATED = 2;
	public static final Short ACTION_DELETED = 3;
	public static final Short ACTION_MERGED = 4;
	public static final Short ACTION_APPROVED = 5;

	public static final Short STATUS_APPROVED = 1;
	public static final Short STATUS_UNAPPROVED = 2;
	
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the contactId
	 */
	public Integer getContactId() {
		return contactId;
	}
	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	/**
	 * @return the createdById
	 */
	public Integer getCreatedById() {
		return createdById;
	}
	/**
	 * @param createdById the createdById to set
	 */
	public void setCreatedById(Integer createdById) {
		this.createdById = createdById;
	}
	/**
	 * @return the modifiedById
	 */
	public Integer getModifiedById() {
		return modifiedById;
	}
	/**
	 * @param modifiedById the modifiedById to set
	 */
	public void setModifiedById(Integer modifiedById) {
		this.modifiedById = modifiedById;
	}
	/**
	 * @return the createDateTime
	 */
	public Date getCreateDateTime() {
		return createDateTime;
	}
	/**
	 * @param createDateTime the createDateTime to set
	 */
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	/**
	 * @return the modifyDateTime
	 */
	public Date getModifyDateTime() {
		return modifyDateTime;
	}
	/**
	 * @param modifyDateTime the modifyDateTime to set
	 */
	public void setModifyDateTime(Date modifyDateTime) {
		this.modifyDateTime = modifyDateTime;
	}
	/**
	 * @return the mergeDateTime
	 */
	public Date getMergeDateTime() {
		return mergeDateTime;
	}
	/**
	 * @param mergeDateTime the mergeDateTime to set
	 */
	public void setMergeDateTime(Date mergeDateTime) {
		this.mergeDateTime = mergeDateTime;
	}
	/**
	 * @return the approveDateTime
	 */
	public Date getApproveDateTime() {
		return approveDateTime;
	}
	/**
	 * @param approveDateTime the approveDateTime to set
	 */
	public void setApproveDateTime(Date approveDateTime) {
		this.approveDateTime = approveDateTime;
	}
	/**
	 * @return the action
	 */
	public Short getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(Short action) {
		this.action = action;
	}
	/**
	 * @return the status
	 */
	public Short getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Short status) {
		this.status = status;
	}
	/**
	 * @return the deleted
	 */
	public Boolean isDeleted() {
		return deleted;
	}
	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}