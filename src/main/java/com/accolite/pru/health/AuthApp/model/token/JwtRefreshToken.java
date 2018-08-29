package com.accolite.pru.health.AuthApp.model.token;

import com.accolite.pru.health.AuthApp.model.UserDevice;
import com.accolite.pru.health.AuthApp.model.audit.DateAudit;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import java.time.Instant;

@Entity(name = "JWT_REFRESH_TOKEN")
public class JwtRefreshToken extends DateAudit {

	@Id
	@Column(name = "TOKEN_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "refresh_token_seq")
	@SequenceGenerator(name = "refresh_token_seq", allocationSize = 1)
	private Long id;

	@Column(name = "TOKEN", nullable = false, unique = true)
	@NaturalId(mutable = true)
	private String token;

	@OneToOne(targetEntity = UserDevice.class, fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "USER_DEVICE_ID")
	private UserDevice userDevice;

	@Column(name = "REFRESH_COUNT")
	private Long refreshCount;

	@Column(name = "EXPIRY_DT", nullable = false)
	private Instant expiryDate;

	public JwtRefreshToken() {
	}

	public JwtRefreshToken(Long id, String token, UserDevice userDevice, Long refreshCount, Instant expiryDate) {
		this.id = id;
		this.token = token;
		this.userDevice = userDevice;
		this.refreshCount = refreshCount;
		this.expiryDate = expiryDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserDevice getUserDevice() {
		return userDevice;
	}

	public void setUserDevice(UserDevice userDevice) {
		this.userDevice = userDevice;
	}

	public Instant getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Instant expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Long getRefreshCount() {
		return refreshCount;
	}

	public void setRefreshCount(Long refreshCount) {
		this.refreshCount = refreshCount;
	}
}