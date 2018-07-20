package com.sankalpa.auction.model;

import javax.persistence.*;

@Entity
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn( name = "userRole")
public class User {

	@Id
	@GeneratedValue
	private Long userId;

	@Column(nullable = false)
	private String userName;

	@Column(nullable = false)
	private String userPassword;

	public User(){}

	public User(String userName, String userPassword){
		this.userName = userName;
		this.userPassword = userPassword;
	}

	@Transient
	public String getDiscriminatorValue(){
		DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );

		return val == null ? null : val.value();
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return userPassword;
	}

	public void setPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
