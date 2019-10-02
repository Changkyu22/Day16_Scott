package com.nuri.input;

import java.util.Scanner;

import com.nuri.dept.DeptDTO;

public class DeptInput {

	// empnoInput
	// 부서번호를 입력하세요.

	private Scanner sc;

	public DeptInput() {
		sc = new Scanner(System.in);
	}
	
	// method insert
	
	public DeptDTO insert() {
		DeptDTO deptDTO = new DeptDTO();
		System.out.println("추가할 부서번호를 입력하세요");
		deptDTO.setDeptno(sc.nextInt());
		System.out.println("추가할 부서이름을 입력하세요");
		deptDTO.setDname(sc.next());
		System.out.println("추가할 부서지역을 입력하세요");
		deptDTO.setLoc(sc.next());
		
		return deptDTO;
	}
	
	public int deptnoInput() {
		System.out.println("부서번호를 입력하세요");
		int input = sc.nextInt();
		
		return input;

	}
}

