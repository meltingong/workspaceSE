package com.itwill05.service.array.student.ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.itwill05.service.array.student.*;

public class StudentServiceArrayFrameMain  extends JFrame{
	/*
	 * 1. service객체(업무실행객체) 변수선언
	 */
	private StudentService studentService;
	
	
	
	
	private JTextField noTF;
	private JTextField gradeTF;
	private JTextField nameTF;
	private JButton claculateTotAvgGradeBtn;
	private JButton calculateRankBtn;
	private JButton findAllStudentsBtn;
	private JButton findByNoStudentBtn;
	private JButton findByGradeStudentsBtn;
	private JButton findByNameStudentsBtn;
	private JButton sortStudentByTotAscBtn;
	private JButton sortByNameStudentsAscBtn;
	public StudentServiceArrayFrameMain() {
		
		super("학생관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(800, 550);
		getContentPane().setLayout(null);
		
		claculateTotAvgGradeBtn = new JButton("1. 전체학생총점,평균,평점계산");
		claculateTotAvgGradeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1. 전체학생총점,평균,평점계산");
				studentService.calculate();
			}
		});
		claculateTotAvgGradeBtn.setBounds(42, 34, 700, 40);
		getContentPane().add(claculateTotAvgGradeBtn);
		
		calculateRankBtn = new JButton("2. 전체학생 총점으로 석차계산");
		calculateRankBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("2. 전체학생 총점으로 석차계산");
				studentService.calculateRank();
			}
		});
		calculateRankBtn.setBounds(42, 89, 700, 46);
		getContentPane().add(calculateRankBtn);
		
		findAllStudentsBtn = new JButton("3. 전체학생반환");
		findAllStudentsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("3. 전체학생반환출력");
				//Student[] students = studentService.getStudents();
				Student.headerPrint();
				studentService.totStudent();
			}
		});
		findAllStudentsBtn.setBounds(42, 150, 700, 40);
		getContentPane().add(findAllStudentsBtn);
		
		findByNoStudentBtn = new JButton("4.번호 입력하면 학생한명 반환");
		findByNoStudentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("4.번호 입력하면 학생한명 반환  ");
				String noStr = noTF.getText();
				int no = Integer.parseInt(noStr);
				Student student = studentService.findByNo(no);
				if(student != null) {
				student.print();
				}else {
					System.out.println(no + "번 학생 없음");
				}
			}
		});
		
		findByNoStudentBtn.setBounds(185, 205, 557, 39);
		getContentPane().add(findByNoStudentBtn);
		
		findByGradeStudentsBtn = new JButton("5. 학점 입력하면 학생들 반환");
		findByGradeStudentsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("5. 학점 입력하면 학생들 반환 ");
				String gradeChar = gradeTF.getText();
				char grade = gradeChar.charAt(0);
				Student[] findStudents = studentService.findByGrade(grade);
				for (Student student : findStudents) {
					student.print();
				}
			}
		});
		findByGradeStudentsBtn.setBounds(185, 259, 557, 40);
		getContentPane().add(findByGradeStudentsBtn);
		
		findByNameStudentsBtn = new JButton("6.  이름KIM 인 학생들 반환");
		findByNameStudentsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("6.  이름KIM 인 학생들 반환 ");
				String name = nameTF.getText();
				Student[] findStudents = studentService.findByName(name);
				for (Student student : findStudents) {
					student.print();
				}
			}
		});
		findByNameStudentsBtn.setBounds(185, 314, 557, 40);
		getContentPane().add(findByNameStudentsBtn);
		
		sortStudentByTotAscBtn = new JButton("7. 학생총점으로 오름차순정렬");
		sortStudentByTotAscBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("7. 학생총점으로 오름차순정렬");
				studentService.sortByTotAsc();
				
			}
		});
		sortStudentByTotAscBtn.setBounds(42, 369, 700, 40);
		getContentPane().add(sortStudentByTotAscBtn);
		
		sortByNameStudentsAscBtn = new JButton("8. 학생이름순으로 오름차순정렬");
		sortByNameStudentsAscBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("8. 학생이름순으로 오름차순정렬");
				studentService.sortByNameAsc();
			}
		});
		sortByNameStudentsAscBtn.setBounds(42, 424, 700, 41);
		getContentPane().add(sortByNameStudentsAscBtn);
		
		noTF = new JTextField();
		noTF.setFont(new Font("D2Coding", Font.BOLD, 18));
		noTF.setHorizontalAlignment(SwingConstants.CENTER);
		noTF.setBounds(42, 208, 131, 33);
		getContentPane().add(noTF);
		noTF.setColumns(10);
		
		gradeTF = new JTextField();
		gradeTF.setBounds(42, 265, 131, 30);
		getContentPane().add(gradeTF);
		gradeTF.setColumns(10);
		
		nameTF = new JTextField();
		nameTF.setBounds(42, 320, 131, 30);
		getContentPane().add(nameTF);
		nameTF.setColumns(10);
		setVisible(true);
		/*
		 * 2. Service객체(업무실행객체) 생성
		 */
		
		studentService = new StudentService();
		
		
	}
	public static void main(String[] args) {
		
		new StudentServiceArrayFrameMain();
	}
}
