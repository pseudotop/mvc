package com.sds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sds.frame.Dao;
import com.sds.frame.SQL;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

public class CustomerDao extends Dao<String, CustomerVO> {

	@Override
	public void insert(CustomerVO v, Connection con) throws Exception {
		// Connection을 통해 PreparedStatement 생성
		// SQL 작성하여 DB전송
		// Resource Close()
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.insertCustomer);
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null)
				pstmt.close();
		}
	}

	@Override
	public void delete(String t, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.deleteCustomer);
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
	public void update(CustomerVO v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.updateCustomer);
			pstmt.setString(1, v.getPwd());
			pstmt.setString(2, v.getName());
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
	public CustomerVO select(String t, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerVO customer = new CustomerVO();
		try {
			pstmt = con.prepareStatement(SQL.selectCustomer);
			pstmt.setString(1, t);
			rs = pstmt.executeQuery();
			rs.next();
			customer.setId(rs.getString("ID"));
			customer.setPwd(rs.getString("PWD"));
			customer.setName(rs.getString("NAME"));
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}
		return customer;

	}

	@Override
	public ArrayList<CustomerVO> select(Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CustomerVO> customers = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(SQL.selectAll);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CustomerVO customer = new CustomerVO();
				customer.setId(rs.getString("ID"));
				customer.setPwd(rs.getString("PWD"));
				customer.setName(rs.getString("NAME"));
				customer.setItem(new ItemVO(
						rs.getString("ID"),
						rs.getString("ITEMNAME"),
						rs.getDouble("PRICE")						
						));
				customers.add(customer);
				customer = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}
		return customers;
	}

}
