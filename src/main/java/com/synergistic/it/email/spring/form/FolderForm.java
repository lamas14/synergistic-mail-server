package com.synergistic.it.email.spring.form;

import java.util.Date;

public class FolderForm {

	private int id;
	private String uName;
	private String folder;
	private Date doe;
	private Date dom;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	public Date getDoe() {
		return doe;
	}
	public void setDoe(Date doe) {
		this.doe = doe;
	}
	public Date getDom() {
		return dom;
	}
	public void setDom(Date dom) {
		this.dom = dom;
	}
	@Override
	public String toString() {
		return "FolderForm [id=" + id + ", uName=" + uName + ", folder="
				+ folder + ", doe=" + doe + ", dom=" + dom + "]";
	}
	

}
