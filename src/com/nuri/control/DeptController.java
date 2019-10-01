package com.nuri.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.nuri.emp.DeptDAO;
import com.nuri.emp.DeptDTO;
import com.nuri.input.DeptInput;
import com.nuri.view.DeptView;

public class DeptController {
	// start
	// 1. 사원 전체정보출력
	// 2. 사원검색출력
	// 3. 종료
	private Scanner sc;
	
	public DeptController() {
		sc = new Scanner(System.in);
	}
	
	public void start() {
		System.out.println("1. 전체정보출력");
		System.out.println("2. 부서검색출력");
		System.out.println("3. 종            료");
		int select = sc.nextInt();
		
		DeptDTO dto = new DeptDTO();
		DeptDAO dao = new DeptDAO();
		DeptInput input = new DeptInput();
		DeptView view = new DeptView();
		ArrayList<DeptDTO> ar = new ArrayList<DeptDTO>();
		
		switch(select) {
			case 1 :
				ar = dao.getSelectlist();
				view.allview(ar);
				break;
			case 2 :
				dto = dao.getSelectOne(input.deptnoInput());
				view.view(dto);
				break;
			case 3 :
				System.out.println("프로그램 종료");
				break;
		}
		
	}
}
