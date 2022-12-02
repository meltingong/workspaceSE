package lang;

public class StringCompareMain {

	public static void main(String[] args) {
		/*
		 * String객체의 생성
		 * 	1. 생성자 호출 (명시적생성)
		 * 	2. ""로 생성   (암시적생성)
		 */
		String name1 = new String("KIM");
		String name2 = new String("KIM");
		String name3 = "KIM";
		String name4 = "KIM";
		// "KIM"자체로도 객체 > 예를들어 Account accounts = new Account(); 로 accounts객체 생성하지만 String은 String자체로 클래스 이기때문에 바로 대입하면
		//  대입한 문자열 자체가 객체가 됨
		
		
		
		
		System.out.println("-------------String객체내용 비교는 equals메소드를 사용하여야 합니다------------");
		/*
		 << public boolean equals(String otherString) >>
		 */
		if(name1.equals(name2)) {
			System.out.println("name1객체의 문자열과 name2객체의 문자열이 동일하다");
		}
		if(name1.equals(name3)) {
			System.out.println("name1객체의 문자열과 name2객체의 문자열이 동일하다");
		}
		if(name3.equals(name4)) {
			System.out.println("name3객체의 문자열과 name4객체의 문자열이 동일하다");
		}
		if(name1.equals("KIM")) {
			System.out.println("name1객체의 문자열과 \"KIM\"객체의 문자열이 동일하다");
		}
		if("KIM".equals("KIM")) {
			System.out.println("\"KIM\"객체의 문자열과 \"KIM\"객체의 문자열이 동일하다");
			
		}
		
		/*
		 *  public int compareTo(String anotherString)
		 *   - the value 0 if the argument string is equal to this string; 
		 *   - a value less than 0 if this string is lexicographically less than the string argument; 
		 *   - and a value greater than 0 if this string is lexicographically greater than the string argument
		 *   
		 *   - (앞쪽문자열유니코드숫자- 뒤쪽문자열유니코드숫자) 의 결과를 반환한다.
		 *   
		 */
		int uniCodeGap = "aaa".compareTo("aaa");
		System.out.println(uniCodeGap);
		uniCodeGap = "aaa".compareTo("aab");
		System.out.println(uniCodeGap);
		uniCodeGap = "aab".compareTo("aaa");
		System.out.println(uniCodeGap);
		String irum1 = "aaa";
		String irum2 = "aab";
		if(irum1.compareTo(irum2) > 0) {
			System.out.println("irum1,irum2 교환[오름차순]");
		}
		
		
		
	}

}
