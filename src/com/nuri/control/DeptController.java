package com.nuri.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.nuri.dept.DeptDAO;
import com.nuri.dept.DeptDTO;
import com.nuri.input.DeptInput;
import com.nuri.view.DeptView;

public class DeptController {
	// start
	// 1. 사원 전체정보출력
	// 2. 사원검색출력
	// 3. 종료
	private Scanner sc;
	private DeptDAO dao;
	private DeptDTO dto;
	private DeptInput input; 
	private DeptView view;

	public DeptController() {
		sc = new Scanner(System.in);
		dao = new DeptDAO();
		dto = new DeptDTO();
		input = new DeptInput();
		view = new DeptView();
	}

	public DeptDTO start() {
		ArrayList<DeptDTO> ar = new ArrayList<DeptDTO>();
		int select = 0;


		System.out.println("1. 전체정보출력");
		System.out.println("2. 부서검색출력");
		System.out.println("3. 부서정보추가");
		System.out.println("4. 종            료");
		select = sc.nextInt();

		switch(select) {
		case 1 :
			ar = dao.getSelectlist();
			view.allview(ar);
			break;
		case 2 :
			select = input.deptnoInput();
			dto = dao.getSelectOne(select);
			break;
		case 3 :
			dto = input.insert();
			select = dao.deptInsert(dto);
			String s = "Insert Fail";
			if(select>0) {
				s = "Insert Success";
			}
			break;
		default :
			System.out.println("프로그램 종료");
			break;

		}
		return dto;
	}
}





