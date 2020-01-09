package com.imonkey.entity;

public class LMONKEY_USER {
	private String USER_ID;
	private String USER_NAME;
	private String USER_PASSWORD;
	private String USER_SEX;
	private String USER_BIRHFDAY;
	private String USER_IDENITY_CODE; 
	private String USER_EAMIL; 
	private String USER_MOBILE; 
	private String USER_ADDRESS; 
	private int USER_STATUES;
	
	public LMONKEY_USER(String uSER_ID, String uSER_NAME, String uSER_PASSWORD,
			String uSER_SEX, String uSER_BIRHFDAY, String uSER_IDENITY_CODE,
			String uSER_EAMIL, String uSER_MOBILE, String uSER_ADDRESS,
			int uSER_STATUES) {
		super();
		USER_ID = uSER_ID;
		USER_NAME = uSER_NAME;
		USER_PASSWORD = uSER_PASSWORD;
		USER_SEX = uSER_SEX;
		USER_BIRHFDAY = uSER_BIRHFDAY;
		USER_IDENITY_CODE = uSER_IDENITY_CODE;
		USER_EAMIL = uSER_EAMIL;
		USER_MOBILE = uSER_MOBILE;
		USER_ADDRESS = uSER_ADDRESS;
		USER_STATUES = uSER_STATUES;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}

	public void setUSER_PASSWORD(String uSER_PASSWORD) {
		USER_PASSWORD = uSER_PASSWORD;
	}

	public String getUSER_SEX() {
		return USER_SEX;
	}

	public void setUSER_SEX(String uSER_SEX) {
		USER_SEX = uSER_SEX;
	}

	public String getUSER_BIRHFDAY() {
		return USER_BIRHFDAY;
	}

	public void setUSER_BIRHFDAY(String uSER_BIRHFDAY) {
		USER_BIRHFDAY = uSER_BIRHFDAY;
	}

	public String getUSER_IDENITY_CODE() {
		return USER_IDENITY_CODE;
	}

	public void setUSER_IDENITY_CODE(String uSER_IDENITY_CODE) {
		USER_IDENITY_CODE = uSER_IDENITY_CODE;
	}

	public String getUSER_EAMIL() {
		return USER_EAMIL;
	}

	public void setUSER_EAMIL(String uSER_EAMIL) {
		USER_EAMIL = uSER_EAMIL;
	}

	public String getUSER_MOBILE() {
		return USER_MOBILE;
	}

	public void setUSER_MOBILE(String uSER_MOBILE) {
		USER_MOBILE = uSER_MOBILE;
	}

	public String getUSER_ADDRESS() {
		return USER_ADDRESS;
	}

	public void setUSER_ADDRESS(String uSER_ADDRESS) {
		USER_ADDRESS = uSER_ADDRESS;
	}

	public int getUSER_STATUES() {
		return USER_STATUES;
	}

	public void setUSER_STATUESl(int uSER_STATUES) {
		USER_STATUES = uSER_STATUES;
	}
	
	
}
