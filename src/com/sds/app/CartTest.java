package com.sds.app;

import java.util.ArrayList;

import com.sds.frame.Service;
import com.sds.service.CartService;
import com.sds.vo.CartVO;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

public class CartTest {

	public static void main(String[] args) {

		Service<String, CartVO> service = new CartService();

		try {
			//insert
			service.register(new CartVO(new CustomerVO("id99", "", ""), new ItemVO("id99", "휴대폰", 5000), 10));

			ArrayList<CartVO> values = service.get();
			System.out.println(values == null ? "no data" : values.toString());
		} catch (Exception e) {
			System.out.println("select error!!");
		} finally {

		}

	}

}
