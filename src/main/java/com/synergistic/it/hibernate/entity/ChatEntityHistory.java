package com.synergistic.it.hibernate.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chat_history_tbl")
public class ChatEntityHistory {
	private int hid;
	private int cid;
	private String fromuser;
	private String touser;
	private String msg;
	private Date cdate;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getFromuser() {
		return fromuser;
	}

	public void setFromuser(String fromuser) {
		this.fromuser = fromuser;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	@Override
	public String toString() {
		return "ChatEntity [cid=" + cid + ", fromuser=" + fromuser
				+ ", touser=" + touser + ", msg=" + msg + ", cdate=" + cdate
				+ "]";
	}

}
