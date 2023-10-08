package com.example.Vending_Machine.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_TBL")
public class User implements Serializable {
	@Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "passwor")
    private String password;
    @Column(name = "deposit")
    private String deposit;

	@Column(name = "saved_eposit")
	private String savesDeposit;

    @Column(name = "role")
    private String role;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSavesDeposit() {
		return savesDeposit;
	}

	public void setSavesDeposit(String savesDeposit) {
		this.savesDeposit = savesDeposit;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", deposit='" + deposit + '\'' +
				", role='" + role + '\'' +
				'}';
	}
}
