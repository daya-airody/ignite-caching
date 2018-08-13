package com.partnertap.cache.persistence.entity;

import org.hibernate.annotations.GenericGenerator;
import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AutoProperty
@Table(name = "TEST_PROFILE")
public class Profile  {

	private static final long serialVersionUID = -8283227214698884112L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROFILE_ID", unique = true)
	private String id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;


	public Profile() {

	}

	public String getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}

	public Profile setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public Profile setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}


	public String getEmailAddress() {
		return emailAddress;
	}

	public Profile setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
		return this;
	}


	@Override
	public boolean equals(Object o) {
		return Pojomatic.equals(this, o);
	}

	@Override
	public int hashCode() {
		return Pojomatic.hashCode(this);
	}

	@Override
	public String toString() {
		return Pojomatic.toString(this);
	}
}
