package com.mule.magento.pojo;

public class MagentoAuthData {

	private int id;
	private String swUserId;
	private String magentoUsername;
	private String magentoPass;
	private String magentoURL;

	public MagentoAuthData() {

	}

	public MagentoAuthData(int id, String swUserId, String magentoUsername,
			String magentoPass, String magentoURL) {

		this.id = id;
		this.swUserId = swUserId;
		this.magentoUsername = magentoUsername;
		this.magentoPass = magentoPass;
		this.magentoURL = magentoURL;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSwUserId() {
		return swUserId;
	}

	public void setSwUserId(String swUserId) {
		this.swUserId = swUserId;
	}

	public String getMagentoUsername() {
		return magentoUsername;
	}

	public void setMagentoUsername(String magentoUsername) {
		this.magentoUsername = magentoUsername;
	}

	public String getMagentoPass() {
		return magentoPass;
	}

	public void setMagentoPass(String magentoPass) {
		this.magentoPass = magentoPass;
	}

	public String getMagentoURL() {
		return magentoURL;
	}

	public void setMagentoURL(String magentoURL) {
		this.magentoURL = magentoURL;
	}

}
