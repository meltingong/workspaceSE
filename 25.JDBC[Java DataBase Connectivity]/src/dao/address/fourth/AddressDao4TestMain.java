package dao.address.fourth;

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
		addressDao4.insert(newAddress);
		
		System.out.println("2.update");
		Address updateAddress = 
				new Address(10, "김변경", "000-0000", "주소변경");
		addressDao4.update(updateAddress);
		System.out.println("3.delete");
		addressDao4.delete(15);
		System.out.println("4.findByPrimaryKey");
		addressDao4.findByPrimaryKey(10);
		System.out.println("5.findAll");
		addressDao4.findAll();
		
		
		
	}

}
