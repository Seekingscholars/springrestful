/**
 * 
 */
package com.cn.pc.entity;

/**
 * @serial : .... 
 */
public class User {
	
	private String userId;
	
	private String userName;
	
	private String b_t;
	
	public User(){}
	
	public User(String userId,String userName,String b_t){
		this.userId=userId;
		this.userName=userName;
		this.b_t=b_t;
	}
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getB_t() {
		return b_t;
	}

	public void setB_t(String b_t) {
		this.b_t = b_t;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", b_t=" + b_t + "]";
	}
	
}
