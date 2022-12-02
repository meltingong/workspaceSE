package generic;

import java.util.*;

public class CollectionsMain {

	public static void main(String[] args) {
		/*
		 * Collections 클래스
		 * 		- Collection객체들의 utility메소드 제공
		 */
		List<Integer> intList = Arrays.asList(34,45,78,90,23);
		List<String> stringList = Arrays.asList("유재석","조세호","김경호","이효리","유재식");
		
		System.out.println("-------------sort[Integer]------------");
		Collections.sort(intList);
		System.out.println(intList);
		System.out.println("----------reverse[Integer]------------");
		Collections.reverse(intList);
		System.out.println(intList);
		System.out.println("----------shuffle[Integer]------------");
		Collections.shuffle(intList);
		System.out.println(intList);
		System.out.println("-------------sort[String]------------");
		Collections.sort(stringList);
		System.out.println(stringList);
		System.out.println("----------reverse[String]------------");
		Collections.reverse(stringList);
		System.out.println(stringList);
		System.out.println("----------shuffle[String]------------");
		Collections.shuffle(stringList);
		System.out.println(stringList);
		System.out.println("-----------account------------");
		List<Account> accountList = Arrays.asList(	new Account(4523,"BING",33000,0.5),
				new Account(2367,"KING",23000,0.1),
				new Account(1234,"KING",89000,0.2),
				new Account(8909,"YONG",99000,0.7),
				new Account(2789,"SANG",12000,0.3));
		System.out.println("----------reverse--------");
		System.out.println(accountList);
		Collections.reverse(accountList);
		System.out.println(accountList);
		System.out.println("----------shuffle--------");
		System.out.println(accountList);
		Collections.shuffle(accountList);
		System.out.println(accountList);
		System.out.println("----------sort[Comparable]---------");
		System.out.println(accountList);
		Collections.sort(accountList);
		System.out.println(accountList);
		System.out.println("----------sort[Comparator]---------");
		System.out.println(">> balance desc");
		Collections.sort(accountList,new AccountBalanceDescComparator());
		System.out.println(accountList);
		System.out.println(">> owner asc");
		Collections.sort(accountList, new AccountOwnerAscComparator());
		System.out.println(accountList);
	}

}
