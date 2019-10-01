package com.nuri.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.nuri.emp.EmpDAO;
import com.nuri.emp.EmpDTO;
import com.nuri.input.EmpInput;
import com.nuri.view.EmpView;

public class EmpController {
	
	private Scanner sc;
	// start
	// 1. 사원 전체정보출력
	// 2. 사원검색출력
	// 3. 종료
	
	public EmpController() {
		sc = new Scanner(System.in);
	}
	
	public void start() {
		
		System.out.println("1. 전체정보출력");
		System.out.println("2. 사원검색출력");
		System.out.println("3. 종            료");
		int select = sc.nextInt();
		
		EmpDTO empDTO = new EmpDTO();
		EmpDAO empDAO = new EmpDAO();
		EmpInput empInput = new EmpInput();
		EmpView empView = new EmpView();
		ArrayList<EmpDTO> ar = new ArrayList<EmpDTO>();
		
		switch(select){
			case 1 : 
				ar = empDAO.getSelectList();
				empView.allview(ar);
				break;
			case 2 :
				empDTO = empDAO.getSelectOne(empInput.empnoInput());
				empView.view(empDTO);
				break;
			case 3 :
				System.out.println("프로그램을 종료합니다.");
				break;
		}
			
			
		
		
	}
	
	
	
	// com.nuri.dept.DeptDTO
	// com.nuri.dept.DeptDAO
	// com.nuri.view.DeptView
	// com.nuri.input.DeptInput
	// com.nuri.controll.deptController
	
}
