package generic;

import java.util.*;

public class ArrayListStringWrapperMain {

	public static void main(String[] args) {
		System.out.println("------------String---------");
		ArrayList<String> nameList = new ArrayList<String>();
		System.out.println("--------1.add-------");
		nameList.add("KIM");
		nameList.add("JIM");
		nameList.add("HIM");
		nameList.add("AIM");
		nameList.add("TIM");
		nameList.add("BIM");
		nameList.add("CIM");
		nameList.add(new String("KIM"));
		System.out.println(nameList);
		System.out.println("--------2.get(index)-------");
		System.out.println(nameList.get(1));
		System.out.println(nameList.get(3));
		System.out.println(nameList.get(5));
		System.out.println("--------3.remove(index)-------");
		nameList.remove(1);
		System.out.println(nameList);
		System.out.println("--------3.remove(element)-------");
		nameList.remove("TIM");
		System.out.println(nameList);
		/*
		 * Removes the first occurrence of the specified element from this
		 * 처음 걸리는 하나만 지워줌 (모든 값 지우지 못함)
		 */
		nameList.remove("KIM");
		System.out.println(nameList);
		System.out.println("--------Wrapper-------");
		ArrayList<Integer> scoreList = new ArrayList<Integer>();
		scoreList.add(90);
		scoreList.add(30);
		scoreList.add(45);
		scoreList.add(78);
		scoreList.add(89);
		scoreList.add(12);
		scoreList.add(new Integer(90));
		scoreList.add(new Integer(100));
		System.out.println(scoreList);
		System.out.println("------------1.get----------");
		int score1 = scoreList.get(2);
		System.out.println(score1);
		int score2 = scoreList.get(scoreList.size()-1);
		System.out.println(score2);
		System.out.println("------------2.set----------");
		scoreList.set(2, 99);
		System.out.println(scoreList);
		System.out.println("----------3.remove---------");
		/*
		 * Integer java.util.ArrayList.remove(int index)
		 * 인덱스 넣으면 5번에 들어있는 객체가 날라감
		 */
		scoreList.remove(5);
		/*
		 * Integer java.util.ArrayList.remove(Objcet element)
		 * 객체의 값으로 넣으면 90점이 날라감
		 */
		scoreList.remove(new Integer(90));
		System.out.println(scoreList);
		
	
	}

}
