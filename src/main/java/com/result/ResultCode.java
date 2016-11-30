package com.result;

public enum ResultCode {

	SUCCESS("200", "Success"),

	NOT_LOGIN("400", "Not Logged-in"),

	EXCEPTION("401", "Exception Occured"),

	SYS_ERROR("402", "System Error"),

	PARAMS_ERROR("403", "Parameters Error"),

	NOT_SUPPORTED("410", "Not Supported"),

	INVALID_AUTHCODE("444", "AuthCode Invalid"),

	TOO_FREQUENT("445", "Call Too Frequently"),

	UNKNOWN_ERROR("499", "Unknown Erro");

	private ResultCode(String value, String msg) {
		this.val = value;
		this.msg = msg;
	}

	public String val() {
		return val;
	}

	public String msg() {
		return msg;
	}

	private String val;
	private String msg;
}
