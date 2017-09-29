package com.tutycarcare.service.beans;

public class ResponseMessage {

	private String message;
	private int id;
	private int nId;

	public ResponseMessage() {

	}

	public ResponseMessage(String status) {
		message = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getnId() {
		return nId;
	}

	public void setnId(int nId) {
		this.nId = nId;
	}

	@Override
	public String toString() {
		return "ResponseMessage [message=" + message + ", id=" + id + ", nId=" + nId + "]";
	}

}
