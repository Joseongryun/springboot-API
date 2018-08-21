package com.infranics.api.asset.model;

public class LikeModel {
	private long gid;
	private String token;
	private String likeYN;
	public long getGid() {
		return gid;
	}
	public void setGid(long gid) {
		this.gid = gid;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getLikeYN() {
		return likeYN;
	}
	public void setLikeYN(String likeYN) {
		this.likeYN = likeYN;
	}
}
