package com.sds.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sds.frame.SQL;
import com.sds.frame.Service;
import com.sds.vo.CartVO;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

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
		// TODO Auto-generated method stub

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
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<CartVO> results = null;

		try {
			// dummy SQL QUery TODO :: Change sql
			conn = getConn();
			ps = conn.prepareStatement("SELECT * FROM CART");
			rs = ps.executeQuery();
			results = new ArrayList<CartVO>();
			while (rs.next()) {
				// TODO : change add source
				
				// results.add(new CartVO(
				// new CustomerVO(rs.getString("ID"), "***",
				// rs.getString("NAME"))
				// ,new ItemVO(rs.getString("item_id"), 0,
				// rs.getDouble("QUANTITY"))
				// ))

				results.add(new CartVO());
			}

		} catch (Exception e) {
			throw e;
		} finally {
			if (ps != null)
				ps.close();
			if (rs != null)
				rs.close();
			close(conn);
		}

		return null;
	}

}
