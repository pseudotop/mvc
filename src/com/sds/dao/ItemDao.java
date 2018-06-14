package com.sds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sds.frame.Dao;
import com.sds.frame.SQL;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

public class ItemDao extends Dao<String, ItemVO> {

	@Override
	public void insert(ItemVO v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.insertItem);
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getName());
			pstmt.setDouble(3, v.getPrice());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if(pstmt != null) pstmt.close();
		}
	}

	@Override
	public void delete(String t, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.deleteItem);
			pstmt.setString(1, t);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
		}		
	}

	@Override
	public void update(ItemVO v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.updateItem);
			pstmt.setString(1, v.getName());
			pstmt.setDouble(2, v.getPrice());
			pstmt.setString(3, v.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
		}
		
	}

	@Override
	public ItemVO select(String t, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ItemVO item = new ItemVO();
		try {
			pstmt = con.prepareStatement(SQL.selectCustomer);
			pstmt.setString(1, t);
			rs = pstmt.executeQuery();
			rs.next();
			item.setId(rs.getString("ID"));
			item.setName(rs.getString("NAME"));
			item.setPrice(rs.getDouble("PRICE"));
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}
		return item;

	}

	@Override
	public ArrayList<ItemVO> select(Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ItemVO> items = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(SQL.selectAll);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ItemVO item = new ItemVO();
				item.setId(rs.getString("ID"));
				item.setName(rs.getString("ITEMNAME"));
				item.setPrice(rs.getDouble("PRICE"));
				items.add(item);
				item = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}
		return items;
	}

}
