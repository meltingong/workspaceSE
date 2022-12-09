
public class OuterComposingInnerChildClass {
	public int outer_member_field;
	public void outer_member_method() {
		System.out.println("OuterComposingInnerChildClass.outer_member_method()");
	}
	/*********Outer클래스에서 InnerClass사용*********/
	public void outer_inner_class_use() {
		int local_variable =100;
		//ParentFirstConcreateClass childFirstConcreteClass = new ChildFirstConcreateClass();
		
		ParentFirstConcreateClass childFirstConcreateClass = new ParentFirstConcreateClass(){
			@Override
			public void local_inner_outer_access() {
				System.out.println("ParentFirstConcreteClass를 상속받는 "
						+ "ChildFirstConcreteClass에서 재정의한 local_inner_outer_access ");
				
			}
		};
		childFirstConcreateClass.local_inner_outer_access();
	}
	/*
	 ParentFirstConcreteClass를 상속받고 
	 local_inner_outer_access()를 재정의하는 Inner클래스
	*/
	
	//public class ChildFirstConcreateClass extends ParentFirstConcreateClass
	
	public static void main(String[] args) {
	OuterComposingInnerChildClass outerComposingInnerChildClass = new OuterComposingInnerChildClass(); 
	outerComposingInnerChildClass.outer_inner_class_use();
	}
	
}
