package com.sds.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sds.dao.CartDao;
import com.sds.frame.Service;
import com.sds.vo.CartVO;

public class CartService extends Service<String, CartVO> {

	public CartService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Connection getConn() throws SQLException {
		return super.getConn();
	}

	@Override
	public void register(CartVO v) throws Exception {
		new CartDao().insert(v, getConn());
	}

	@Override
	public void remove(String t) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(CartVO v) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public CartVO get(String t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartVO> get() throws Exception {
		return new CartDao().select(getConn());
	}

}
