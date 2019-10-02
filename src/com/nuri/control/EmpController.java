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
		boolean check = true;
		while(check) {
			
			System.out.println("1. 전체정보출력");
			System.out.println("2. 사  원  검  색");
			System.out.println("3. 사원정보출력");
			System.out.println("4. 사  원  삭  제");
			System.out.println("5. 사업이름검색");
			System.out.println("6. 종            료");
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
				empDTO = empInput.inset();
				select = empDAO.empInsert(empDTO);
				String s = "Insert Fail";
				if(select>0) {
					s = "Insert Success";
				}
				break;
			case 4 :
				int a = empInput.empnoInput();
				select = empDAO.delete(a);
				break;
			case 5 :
				String b = empInput.searchInput();
				empView.allview(empDAO.searchOne(b));
				break;
			case 6 :
				check = !check;
				System.out.println("프로그램을 종료합니다.");
				break;
			default :
				System.out.println("없는 메뉴입니다. 다시입력하세요");
				break;
			}
			
		}
		
		
			
			
		
		
	}
	
	
	
	// com.nuri.dept.DeptDTO
	// com.nuri.dept.DeptDAO
	// com.nuri.view.DeptView
	// com.nuri.input.DeptInput
	// com.nuri.controll.deptController
	
}
