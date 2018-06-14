package com.sds.app;

import java.util.ArrayList;

import com.sds.frame.Service;
import com.sds.service.CartService;
import com.sds.vo.CartVO;

public class CartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Service<String, CartVO> service = new CartService();

		try {
			// service.register(makeRandomData());

			ArrayList<CartVO> values = service.get();
			System.out.println(values == null ? "no data" : values.toString());
		} catch (Exception e) {
			System.out.println("select error!!");
		} finally {

		}

	}

	// private static CartVO makeRandomData() {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
