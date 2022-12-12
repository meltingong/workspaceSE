package com.itwill05.service.array.student;

/*
 * Student객체전체에관련된 업무를 실행할클래스
 * 		1.학생객체들(Student[]) 을멤버변수로가진다.
 * 		2.학생객체들을 사용해서 업무실행
 */

public class StudentService {
	private Student[] students={
			new Student(1,"KIM",89,93,94),
			new Student(2,"HIM",88,77,98),
			new Student(3,"AIM",65,87,99),
			new Student(4,"KIM",75,97,60),
			new Student(5,"XIM",85,98,90),
			new Student(6,"TIM",95,88,77),
			new Student(7,"KIM",99,93,95),
			new Student(8,"LIM",83,80,99),
			new Student(9,"QIM",73,90,80),
			
	};
	
	public Student[] getStudents() {
		return this.students;
	}
	/*
	 *  0.전체학생출력
	 */
	public void print() {
		Student.headerPrint();
		for (int i = 0; i < students.length; i++) {
			students[i].print();
		}
	}
	/*
	 * 0.학생객체받아서 추가
	 */
	public void addStudent(Student student) {
		
	}
	private void studentTot() {
		for(int i = 0; i < students.length; i++) {
			students[i].calculateTotal();
		}
	}
	private void studentAvg() {
		for(int i = 0; i < students.length; i++) {
			students[i].calculateAvg();
		}
	}
	private void studentGrade() {
		for(int i = 0; i < students.length; i++) {
			students[i].calculateGrade();
		}
	}
	/*
	 * 1. 전체학생총점,평균,평점계산
	 */
	public void calculate() {
		this.studentTot();
		this.studentAvg();
		this.studentGrade();
		
	}
	/*
	 * 2. 전체학생 총점으로 석차계산
	 */
	public void calculateRank() {
		
		for(int i = 0; i < students.length; i++) {
			for(int j = 0; j < students.length-1; j++) {
			if(students[i].getTot() < students[j].getTot()) {
					students[i].setRank(students[i].getRank()+1);
				}
			}
		}
		
	}
	/*
	 * 3. 전체학생반환
	 */
	public void totStudent() {
		 this.print();
	}
	
	/*
	 * 4. 번호3번 학생한명 반환  
	 */
	public Student findByNo(int no) {
		Student findStudent=null;
		for(int i = 0 ; i < students.length; i++) {
			if(students[i].getNo() == no) {
				findStudent = students[i];
				break;
			}
		}
		return findStudent;
	}
	/*
	 * 5. 학점A인 학생들 반환
	 */
	public Student[] findByGrade(char grade) {
		int count = 0;
		for(int i = 0; i < students.length; i++) {
			if(students[i].getGrade() == grade) {
				count++;
			}
		}
		Student[] findStudents = new Student[count];
		int index = 0;
		for(int i = 0; i < students.length; i++) {
			if(students[i].getGrade() == grade) {
				findStudents[index] = students[i];
				index++;
			}
		}
		return findStudents;
	}
	public Student[] findByName(String name) {
		int count = 0;
		for(int i = 0; i < students.length; i++) {
			if(students[i].getName().equals(name)) {
				count++;
			}
		}
		int index = 0;
		Student[] findStudents= new Student[count];
		for(int i = 0; i < students.length; i++) {
			if(students[i].getName().equals(name)) {
				findStudents[index] = students[i];
				index++;
			}
		}
		return findStudents;
	}
	/*
	 * 6. 학생석차로 오름차순 정렬
	 */
	public void sortByRankAsc() {
		for(int i = 0; i < students.length; i++) {
			for(int j = 0; j < students.length-1; j++) {
				if(students[j].getRank() < students[j+1].getRank()) {
					Student temp = students[j];
					students[j] = students[j+1];
					students[j+1] = temp;
				}
			}
		}
	}
	/*
	 * 7. 학생총점으로 오름차순 정렬
	 */
	public void sortByTotAsc() {
		for(int i = 0; i < students.length; i++) {
			for(int j = 0; j < students.length-1; j++) {
				if(students[j].getTot() > students[j+1].getTot()) {
					Student temp = students[j];
					students[j] = students[j+1];
					students[j+1] = temp;
				}
			}
		}
		for (Student student : students) {
			student.print();
		}
	}
	/*
	 * 8. 학생이름순으로 오름차순 정렬
	 */
	public void sortByNameAsc() {
		for(int i = 0; i < students.length; i++) {
			for(int j = 0; j < students.length-1; j++) {
				if(students[j].getName().compareTo(students[j+1].getName())>0) {
					Student temp = students[j];
					students[j] = students[j+1];
					students[j+1] = temp;
				}
			}
		}
		for (Student student : students) {
			student.print();
		}
	}
	

	
}
