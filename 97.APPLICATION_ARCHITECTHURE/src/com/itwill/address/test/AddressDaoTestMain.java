package com.itwill.address.test;

import java.util.*;

import com.itwill.address.*;

public class AddressDaoTestMain {

	public static void main(String[] args) throws Exception {
		/*
			
		 */
		AddressDao addressDao = new AddressDao();
		System.out.println("1.insert");
		Address newAddress = 
				new Address(0,"짱구", "111-3333", "대구시민"); 
		int rowCount = addressDao.insert(newAddress);
		System.out.println(" >> insert row count : " + rowCount);
		System.out.println("2.update");
		Address updateAddress = 
				new Address(10, "김변경", "000-0000", "주소변경");
		rowCount = addressDao.update(updateAddress);
		System.out.println(" >> update row count : " + rowCount);
		System.out.println("3.delete");
		rowCount = addressDao.delete(15);
		System.out.println(" >> delete row count : " + rowCount);
		System.out.println("4.findByPrimaryKey");
		
		Address findAddress = addressDao.findByPrimaryKey(10);
		if(findAddress != null) {
			System.out.println(" >> " + findAddress);
		}else {
			System.out.println(" >> 조건을 만족하는 주소록이 존재하지 않습니다.");
		}
		System.out.println(addressDao.findByPrimaryKey(15));
		System.out.println(addressDao.findByPrimaryKey(4));
		System.out.println(addressDao.findByPrimaryKey(5));
		
		System.out.println("5.findAll");
		List<Address> addressList = addressDao.findAll();
		System.out.println(addressList);
		
		
	}

}
