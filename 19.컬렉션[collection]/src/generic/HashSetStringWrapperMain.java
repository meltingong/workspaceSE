package generic;

import java.util.*;

public class HashSetStringWrapperMain {

	public static void main(String[] args) {
		System.out.println("----------String---------");
		HashSet <String> nameSet = new HashSet<String>();
		nameSet.add("KIM");
		nameSet.add("JIM");
		nameSet.add("GIM");
		nameSet.add("SIM");
		System.out.println(nameSet);
		nameSet.add("KIM");
		boolean isAdd = nameSet.add("KIM");
		System.out.println("추가여부 : " + isAdd);
		System.out.println(nameSet);
		
	
		System.out.println("-----------Integer---------");
		
		HashSet<Integer> lottoSet = new HashSet<Integer>();
		
		while(lottoSet.size() < 6){
			lottoSet.add((int)(Math.random()*45+1));
		}
		
		System.out.println(lottoSet);
		
		
	
	}

}
