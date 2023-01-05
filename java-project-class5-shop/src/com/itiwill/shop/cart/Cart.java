package com.itiwill.shop.cart;

import com.itiwill.shop.product.*;
import com.itiwill.shop.user.*;

/*
 이름       널?       유형           
-------- -------- ------------ 
CART_NO  NOT NULL NUMBER(10)   
CART_QTY          NUMBER(10)   
USERID            VARCHAR2(50) 
P_NO              NUMBER(10)   
 */
public class Cart {
	private int cart_no;
	private int cart_qty;
	/***********FK***********/
	private String user_id; //FK
	
	/**********FK***********/
	//private int p_no;		
	private Product product;

	public Cart() {
		
	}

	public Cart(int cart_no, int cart_qty, String user_id, Product product) {
		super();
		this.cart_no = cart_no;
		this.cart_qty = cart_qty;
		this.user_id = user_id;
		this.product = product;
	}

	public int getCart_no() {
		return cart_no;
	}

	public int getCart_qty() {
		return cart_qty;
	}

	public String getUser_id() {
		return user_id;
	}

	public Product getProduct() {
		return product;
	}

	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}

	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Cart [cart_no=" + cart_no + ", cart_qty=" + cart_qty + ", user_id=" + user_id + ", product=" + product
				+ "]\n";
	}
	
	
}
