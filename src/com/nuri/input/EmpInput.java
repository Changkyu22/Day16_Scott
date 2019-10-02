package com.nuri.input;

import java.util.Scanner;

import com.nuri.emp.EmpDAO;
import com.nuri.emp.EmpDTO;

public class EmpInput {
	
	private Scanner sc;
	
	public EmpInput() {
		sc = new Scanner(System.in);
	}
	
	public String searchInput() {
		System.out.println("사원이름을 입력하세요");
		String b = sc.next();
		return b.toUpperCase();
	}
	
	public EmpDTO delete() {
		EmpDTO empDTO = new EmpDTO();
		System.out.println("삭제할 사원번호를 입력하세요");
		empDTO.setEmpno(sc.nextInt());
		return empDTO;
	}
	
	public EmpDTO inset() {
		EmpDTO empDTO = new EmpDTO();
		System.out.println("추가할 사원번호를 입력하세요");
		empDTO.setEmpno(sc.nextInt());
		System.out.println("추가할 사원이름을 입력하세요");
		empDTO.setEname(sc.next());
		System.out.println("추가할 직종을 입력하세요");
		empDTO.setJob(sc.next());
		System.out.println("추가할 매니저번호를 입력하세요");
		empDTO.setMgr(sc.nextInt());
		//System.out.println("추가할 고용일을 입력하세요");
		//empDTO.setHiredate(sc.next());
		System.out.println("추가할 급여를 입력하세요");
		empDTO.setSal(sc.nextInt());
		System.out.println("추가할 커밋을 입력하세요");
		empDTO.setComm(sc.nextInt());
		System.out.println("추가할 부서번호를 입력하세요");
		empDTO.setDeptno(sc.nextInt());
		
		return empDTO;
		
	}
	// empnoInput
	// 사원번호를 입력하세요.
	
	public int empnoInput() {
		System.out.println("사원번호를 입력하세요");
		int input = sc.nextInt();
		
		return input;
	}

}
