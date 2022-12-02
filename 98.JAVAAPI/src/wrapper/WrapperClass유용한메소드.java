package wrapper;

public class WrapperClass유용한메소드 {

	public static void main(String[] args) {
		System.out.println("int --> String");
		int y = 2147483647;
		String yStr1 = Integer.toString(y);
		System.out.println(yStr1);
		String yStr2 = y + "";
		/*
		 *  + 연산자
		 *  	- 연산항에 문자열이 포함되어있을 경우 concat
		 *  	- 연산항이 숫자일 경우 더함
		 *  	- 연상항안에 숫자와 문자가 혼합되어 있는 경우 문자열이 나오기 전까지의 숫자는 연산하고 문자열 이후의 숫자는 연산하지 않음(문자로 출력)
		 */
		String result1 = 1 + 2 + "문자열";
		String result2 = 1 + "문자열" + 2;
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(yStr2);
		String yStr3 = Integer.toBinaryString(y);
		System.out.println(yStr3);
		String yStr4 = Integer.toHexString(y);
		System.out.println(yStr4);
		System.out.println("String --> int,double,boolean");
		int i1 = Integer.parseInt("2147483647");
		System.out.println(i1);
		double d1 = Double.parseDouble("3.141592");
		System.out.println(d1+1);
		boolean b1 = Boolean.parseBoolean("true");
		System.out.println(b1);
		
		
		System.out.println("--------------Character-------------");
		Character wc1 = new Character('김');
		Character wc2 = '김';
		char c1 = wc1.charValue();
		char c2 = wc2;
		/*
		if (wc1 == wc2) {
			System.out.println("wc1과 wc2 주소동일");
		}else {
			System.out.println("wc1과 wc2 주소 동일하지 않음");
		}
		 */
		/*
		 * Wrapper 객체의 값비교는 equals메소드를 사용해야 한다.
		 */
		if(wc1.equals(wc2)) {
			System.out.println("wc1객체의 char값과 wc2객체의 char값이 동일");
		}
		String strs = "Hello Java!! 아우안미ㅏ러123509@#(4ㅑ";
		
		for(int i= 0; i < strs.length(); i++) {
			char tempChar = strs.charAt(i);
			int type = Character.getType(tempChar);
			System.out.println(type);
			if(type == Character.UPPERCASE_LETTER) {
				System.out.println("UPPERCASE_LETTER : " + tempChar);
			}
			if(type == Character.LOWERCASE_LETTER) {
				System.out.println("LOWERCCASE_LETTER : " + tempChar);
						}
			if(type == Character.DECIMAL_DIGIT_NUMBER) {
				System.out.println("DECIMAL_DIGIT_NUMBER : " + tempChar);
			}
			if(type == Character.SPACE_SEPARATOR) {
				System.out.println("SPACE_SEPARATOR : " + tempChar);
			}
		}
		
		
		
		
		
		
	}

}
