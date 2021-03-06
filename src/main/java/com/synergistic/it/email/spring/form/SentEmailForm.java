package com.synergistic.it.email.spring.form;

import java.util.Date;

public class SentEmailForm {

	private int MAILID;
	private String MAILFROM;
	private String MAILTO;
	private String SUBJECT;
	private String MAILCC;
	private String MAILBCC;
	private String MAILEXCH;
	private String MAILDATA;
	private String FOLDER;
	private Date MAILDATE;
	private String MAILST;

	public int getMAILID() {
		return MAILID;
	}

	public void setMAILID(int mAILID) {
		MAILID = mAILID;
	}

	public String getMAILFROM() {
		return MAILFROM;
	}

	public void setMAILFROM(String mAILFROM) {
		MAILFROM = mAILFROM;
	}

	public String getMAILTO() {
		return MAILTO;
	}

	public void setMAILTO(String mAILTO) {
		MAILTO = mAILTO;
	}

	public String getSUBJECT() {
		return SUBJECT;
	}

	public void setSUBJECT(String sUBJECT) {
		SUBJECT = sUBJECT;
	}

	public String getMAILCC() {
		return MAILCC;
	}

	public void setMAILCC(String mAILCC) {
		MAILCC = mAILCC;
	}

	public String getMAILBCC() {
		return MAILBCC;
	}

	public void setMAILBCC(String mAILBCC) {
		MAILBCC = mAILBCC;
	}

	public String getMAILEXCH() {
		return MAILEXCH;
	}

	public void setMAILEXCH(String mAILEXCH) {
		MAILEXCH = mAILEXCH;
	}

	public String getMAILDATA() {
		return MAILDATA;
	}

	public void setMAILDATA(String mAILDATA) {
		MAILDATA = mAILDATA;
	}

	public String getFOLDER() {
		return FOLDER;
	}

	public void setFOLDER(String fOLDER) {
		FOLDER = fOLDER;
	}

	public Date getMAILDATE() {
		return MAILDATE;
	}

	public void setMAILDATE(Date mAILDATE) {
		MAILDATE = mAILDATE;
	}

	public String getMAILST() {
		return MAILST;
	}

	public void setMAILST(String mAILST) {
		MAILST = mAILST;
	}

	@Override
	public String toString() {
		return "EmailController [MAILID=" + MAILID + ", MAILFROM=" + MAILFROM
				+ ", MAILTO=" + MAILTO + ", SUBJECT=" + SUBJECT + ", MAILCC="
				+ MAILCC + ", MAILBCC=" + MAILBCC + ", MAILEXCH=" + MAILEXCH
				+ ", MAILDATE=" + MAILDATE + ", MAILST=" + MAILST + "]";
	}

}
