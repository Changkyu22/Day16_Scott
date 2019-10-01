package com.nuri.input;

import java.util.Scanner;

import com.nuri.emp.EmpDAO;

public class EmpInput {
	
	private Scanner sc;
	
	public EmpInput() {
		sc = new Scanner(System.in);
	}
	
	// empnoInput
	// 사원번호를 입력하세요.
	
	public int empnoInput() {
		System.out.println("사원번호를 입력하세요");
		int input = sc.nextInt();
		
		return input;
	}

}
