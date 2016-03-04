package com.cdd.bean;

import java.io.Serializable;

public class OrderMenu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pic;
	private String name;

	public OrderMenu(int pic, String name) {
		super();
		this.pic = pic;
		this.name = name;
	}

	public int getPic() {
		return pic;
	}

	public void setPic(int pic) {
		this.pic = pic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "OrderMenu [pic=" + pic + ", name=" + name + "]";
	}

}
