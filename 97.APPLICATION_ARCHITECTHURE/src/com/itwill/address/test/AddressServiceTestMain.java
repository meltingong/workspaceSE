package com.itwill.address.test;

import com.itwill.address.*;

public class AddressServiceTestMain {

	public static void main(String[] args) throws Exception {
		AddressService addressService = new AddressService();
		
		System.out.println("1. 주소록 쓰기");
		Address newAddress = new Address(0, "배고파", "010-8657-5417", "제주");
		System.out.println(">> " + addressService.addressWrite(newAddress));
		
		System.out.println("2. 주소록 번호로 검색");
		Address findAddress = addressService.addressDetail(10);
		System.out.println(">> " + findAddress);
		
		System.out.println("3. 주소록 수정");
		findAddress.setAddress("주소변경");
		findAddress.setName("이름변경");
		findAddress.setPhone("123-45567");
		System.out.println(">> " + addressService.addressUpdate(findAddress));
		System.out.println(">> " + addressService.addressDetail(10));
		
		System.out.println("4. 주소록 삭제");
		System.out.println(">> "+ addressService.addressDelete(2));
		System.out.println(">> "+ addressService.addressDelete(3));
		
		System.out.println("5. 주소록리스트");
		System.out.println(">> " + addressService.addressAll());
		
	}

}
