package com.example.demo.domain;

public class Cards {

	private Integer id;
	private Integer number;
	private String mark;
	private String imagepath;
	
	//toStringメソッド
	@Override
	public String toString() {
		return "Cards [id=" + id + ", number=" + number + ", mark=" + mark + ", imagepath=" + imagepath + "]";
	}
	
	//ゲッターおよびセッター
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
}
