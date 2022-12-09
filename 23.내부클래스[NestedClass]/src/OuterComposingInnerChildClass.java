
public class OuterComposingInnerChildClass {
	public int outer_member_field;
	public void outer_member_method() {
		System.out.println("OuterComposingInnerChildClass.outer_member_method()");
	}
	/*********Outer클래스에서 InnerClass사용*********/
	public void outer_inner_class_use() {
		int local_variable =100;
		/***************************member inner class[CASE1]**************************
		ParentFirstConcreateClass childFirstConcreateClass = new ChildFirstConcreateClass();
		childFirstConcreateClass.local_inner_outer_access();
		*****************************************************************************/
		/*
		 << 특정클래스의 메소드를 재정의해야할 때>>
		  	1. local위치   에서 이름이 존재하지않는 클래스를 정의
		  	2. local위치(?)에서 객체를 생성
		 */
		/*************************anonymous local inner class[CASE2]************************/
		ParentFirstConcreateClass childFirstConcreateClass = new ParentFirstConcreateClass() {
			@Override
			public void local_inner_outer_access() {
				System.out.println("ParentFirstConcreteClass를 상속받는 "
						+ "anonymous(이름없는)로칼 내부클래스에서 재정의한 local_inner_outer_access()");
			}
		};
		childFirstConcreateClass.local_inner_outer_access();
		
		ParentSecondAbstractClass childSecondAbstractClass = new ParentSecondAbstractClass() {
			@Override
			public void local_inner_outer_access() {
				System.out.println("ParentSecondAbstractClass를 상속받는 "
						+ "anonymous(이름없는) 클래스에서 재정의한 local_inner_outer_access()");
			}
		};
		
		childSecondAbstractClass.local_inner_outer_access();
		
		ParentThirdInterface childThirdInterface = new ParentThirdInterface() {
			@Override
			public void local_inner_outer_access() {
				System.out.println("ParentThirdInterface를 상속받은(구현한)"
						+ "anonymous(이름없는) 클래스에서 재정의한 local_inner_outer_access()");
			}
		};
		childThirdInterface.local_inner_outer_access();
		
		Object oc = new Object() {
			@Override
			public String toString() {
				return "난 재정의된 toString";
			}
		};
		System.out.println(oc);
	}
	
	/*
	 ParentFirstConcreteClass를 상속받고 
	 local_inner_outer_access()를 재정의하는 Inner클래스
	*/
	
	/*
	public class ChildFirstConcreateClass extends ParentFirstConcreateClass{
		@Override
		public void local_inner_outer_access() {
			System.out.println("ParentFirstConcreteClass를 상속받는 "
					+ "ChildFirstConcreteClass에서 재정의한 local_inner_outer_access ");
			
		}
	}
	*/
	
	public static void main(String[] args) {
	OuterComposingInnerChildClass outerComposingInnerChildClass = new OuterComposingInnerChildClass(); 
	outerComposingInnerChildClass.outer_inner_class_use();
	}
	
}
