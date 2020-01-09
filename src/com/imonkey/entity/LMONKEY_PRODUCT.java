package com.imonkey.entity;

public class LMONKEY_PRODUCT {
	private int PRODUCT_ID;
	private String PRODUCT_NAME;
	private String PRODUCT_DESCRIPTION;
	private float PRODUCT_PRICE;
	private int PRODUCT_STOCK;
	private int PRODUCT_FCATE;
	private int PRODUCT_CCATE;
	private String PRODUCT_FILENAME;
	public LMONKEY_PRODUCT(int pRODUCT_ID, String pRODUCT_NAME,
			String pRODUCT_DESCRIPTION, float pRODUCT_PRICE, int pRODUCT_STOCK,
			int pRODUCT_FCATE, int pRODUCT_CCATE, String pRODUCT_FILENAME) {
		super();
		PRODUCT_ID = pRODUCT_ID;
		PRODUCT_NAME = pRODUCT_NAME;
		PRODUCT_DESCRIPTION = pRODUCT_DESCRIPTION;
		PRODUCT_PRICE = pRODUCT_PRICE;
		PRODUCT_STOCK = pRODUCT_STOCK;
		PRODUCT_FCATE = pRODUCT_FCATE;
		PRODUCT_CCATE = pRODUCT_CCATE;
		PRODUCT_FILENAME = pRODUCT_FILENAME;
	}
	public int getPRODUCT_ID() {
		return PRODUCT_ID;
	}
	public void setPRODUCT_ID(int pRODUCT_ID) {
		PRODUCT_ID = pRODUCT_ID;
	}
	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}
	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}
	public String getPRODUCT_DESCRIPTION() {
		return PRODUCT_DESCRIPTION;
	}
	public void setPRODUCT_DESCRIPTION(String pRODUCT_DESCRIPTION) {
		PRODUCT_DESCRIPTION = pRODUCT_DESCRIPTION;
	}
	public float getPRODUCT_PRICE() {
		return PRODUCT_PRICE;
	}
	public void setPRODUCT_PRICE(float pRODUCT_PRICE) {
		PRODUCT_PRICE = pRODUCT_PRICE;
	}
	public int getPRODUCT_STOCK() {
		return PRODUCT_STOCK;
	}
	public void setPRODUCT_STOCK(int pRODUCT_STOCK) {
		PRODUCT_STOCK = pRODUCT_STOCK;
	}
	public int getPRODUCT_FCATE() {
		return PRODUCT_FCATE;
	}
	public void setPRODUCT_FCATE(int pRODUCT_FCATE) {
		PRODUCT_FCATE = pRODUCT_FCATE;
	}
	public int getPRODUCT_CCATE() {
		return PRODUCT_CCATE;
	}
	public void setPRODUCT_CCATE(int pRODUCT_CCATE) {
		PRODUCT_CCATE = pRODUCT_CCATE;
	}
	public String getPRODUCT_FILENAME() {
		return PRODUCT_FILENAME;
	}
	public void setPRODUCT_FILENAME(String pRODUCT_FILENAME) {
		PRODUCT_FILENAME = pRODUCT_FILENAME;
	}
	
	
}
