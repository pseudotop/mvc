package com.sds.frame;

public class SQL {
	public static String insertCustomer = 
			"INSERT INTO CUSTOMER VALUES (?,?,?)";
	public static String insertItem = 
			"INSERT INTO CUSTOMERITEM VALUES (?,?,?)";
	public static String deleteCustomer = 
			"DELETE FROM CUSTOMER WHERE ID=?";
	public static String deleteItem = 
			"DELETE FROM CUSTOMERITEM WHERE ID=?";
	public static String updateCustomer = 
			"UPDATE CUSTOMER SET PWD=? NAME=? WHERE ID=?";
	public static String updateItem = 
			"UPDATE CUSTOMERITEM SET NAME=? PRICE=? WHERE ID=?";
	public static String selectCustomer = 
			"SELECT * FROM CUSTOMER WHERE ID=?";
	public static String selectItem = 
			"SELECT * FROM CUSTOMERITEM WHERE ID=?";
//	public static String selectAllCustomer = 
//			"SELECT * FROM CUSTOMER";
//	public static String selectAllItem = 
//			"SELECT * FROM CUSTOMERITEM";
	public static String selectAll = 
			"SELECT c.ID, c.PWD, c.NAME, ci.NAME AS ITEMNAME, ci.PRICE"
			+ " FROM CUSTOMER c, CUSTOMERITEM ci"
			+ " WHERE c.ID = ci.ID";
	public static String selectCart = 
	         "select c.id, c.name, ca.customer_id, ca.item_id, ca.quantity from customer c, cart ca where c.id = ca.id";		

	public static String insertCart =
	         "INSERT INTO CART VALUES (?,?,?)";

}
