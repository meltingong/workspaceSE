package dao.address.fourth;

import java.util.*;

public class AddressDao4TestMain {

	public static void main(String[] args) throws Exception {
		/*
		 * AddressDao4에서 
		 * AddressDao4Main으로 데이터 리턴(전달)
		 */
		AddressDao4 addressDao4 = new AddressDao4();
		System.out.println("1.insert");
		Address newAddress = 
				new Address(0,"문상훈", "111-3333", "대구시민"); 
		int rowCount = addressDao4.insert(newAddress);
		System.out.println(" >> insert row count : " + rowCount);
		System.out.println("2.update");
		Address updateAddress = 
				new Address(10, "김변경", "000-0000", "주소변경");
		rowCount = addressDao4.update(updateAddress);
		System.out.println(" >> update row count : " + rowCount);
		System.out.println("3.delete");
		rowCount = addressDao4.delete(15);
		System.out.println(" >> delete row count : " + rowCount);
		System.out.println("4.findByPrimaryKey");
		
		Address findAddress = addressDao4.findByPrimaryKey(10);
		if(findAddress != null) {
			System.out.println(" >> " + findAddress);
		}else {
			System.out.println(" >> 조건을 만족하는 주소록이 존재하지 않습니다.");
		}
		System.out.println(addressDao4.findByPrimaryKey(15));
		System.out.println(addressDao4.findByPrimaryKey(4));
		System.out.println(addressDao4.findByPrimaryKey(5));
		
		System.out.println("5.findAll");
		List<Address> addressList = addressDao4.findAll();
		System.out.println(addressList);
		
		
	}

}
