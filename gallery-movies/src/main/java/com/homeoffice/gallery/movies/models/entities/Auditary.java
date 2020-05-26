package com.homeoffice.gallery.movies.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Auditary implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "create_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Column(name = "create_user")
	private String createUser;
	@Column(name = "update_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	@Column(name = "update_user")
	private String updateUser;
}
