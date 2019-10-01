package com.nuri.input;

import java.util.Scanner;

public class DeptInput {

	// empnoInput
	// 사원번호를 입력하세요.

	private Scanner sc;

	public DeptInput() {
		sc = new Scanner(System.in);
	}
	
	public int deptnoInput() {
		System.out.println("부서번호를 입력하세요");
		int input = sc.nextInt();
		
		return input;

	}
}

