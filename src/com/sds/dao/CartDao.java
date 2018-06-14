package com.sds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sds.frame.Dao;
import com.sds.frame.SQL;
import com.sds.vo.CartVO;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

public class CartDao extends Dao<String, CartVO> {

	@Override
	public void insert(CartVO v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.insertCart);
			pstmt.setString(1, v.getCustomer().getId());
			pstmt.setString(2, v.getItem().getId());
			pstmt.setInt(3, v.getQuantity());
			pstmt.executeUpdate();
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			close(pstmt);
			if (con != null)
				con.close();
		}
	}

	@Override
	public void delete(String t, Connection con) throws Exception {

	}

	@Override
	public void update(CartVO v, Connection con) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public CartVO select(String t, Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CartVO> select(Connection con) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<CartVO> carts = new ArrayList<>();
		CartVO cart = null;
		try {
			pstmt = con.prepareStatement(SQL.selectCart);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cart = new CartVO(new CustomerVO(rs.getString("ID"), "***", rs.getString("NAME")),
						new ItemVO(rs.getString("ITEM_ID"), "", 0), rs.getInt("QUANTITY"));
				carts.add(cart);
				cart = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}
		return carts;
	}

}
