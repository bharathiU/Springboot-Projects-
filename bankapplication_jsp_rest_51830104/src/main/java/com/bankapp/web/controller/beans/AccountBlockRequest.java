package com.bankapp.web.controller.beans;

public class AccountBlockRequest {
	private Boolean blocked;

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	public AccountBlockRequest() {
	}

	public AccountBlockRequest(Boolean blocked) {
		this.blocked = blocked;
	}
}
