package com.nuri.scott;

import java.util.ArrayList;

import com.nuri.control.EmpController;
import com.nuri.emp.EmpDAO;
import com.nuri.emp.EmpDTO;
import com.nuri.input.EmpInput;
import com.nuri.view.EmpView;

public class ScottMain {
	
	public static void main(String[] args) {
		// db connector get connect
		
		EmpDAO empDAO = new EmpDAO();
		//EmpView ev = new EmpView();
		EmpInput empInput = new EmpInput();
		//ArrayList<EmpDTO> ar = empDAO.getSelectList();
		//ev.allview(ar);
		EmpController empController = new EmpController();
		empController.start();
		//EmpDTO empDTO = empDAO.getSelectOne(empInput.empnoInput());
		//if(empDTO != null) {
		//	ev.view(empDTO);
		//}else {
		//	System.out.println("없는 사원번호입니다.");
		//}
		
		
	}

}
