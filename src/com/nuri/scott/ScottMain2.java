package com.nuri.scott;

import java.util.ArrayList;
import java.util.List;

import com.col.bo.BonusController;
import com.col.sal.SalgradeController;
import com.nuri.control.DeptController;
import com.nuri.control.EmpController;
import com.nuri.control.FrontController;
import com.nuri.dept.DeptDAO;
import com.nuri.dept.DeptDTO;
import com.nuri.input.DeptInput;
import com.nuri.view.DeptView;

public class ScottMain2 {
	
	public static void main(String[] args) {
		
		DeptDAO dao = new DeptDAO();
		DeptDTO dto = new DeptDTO();
		DeptView view = new DeptView();
		DeptInput input = new DeptInput();
		DeptController deptController = new DeptController();
		FrontController frontController = new FrontController();
		
		//view.view(dao.getSelectOne(input.deptnoInput()));
		//List<DeptDTO> ar = dao.getSelectlist();
		//for(int i=0; i<ar.size(); i++) {
		//	dto = ar.get(i);
		//}  
		//view.allview(ar);
		//DeptController control = new DeptController();
		//control.start();
		
		// frontController.start();
		
		//dto.setDeptno(93);
		//dto.setDname("test");
		//dto.setLoc("test");
		
		
		//view.insertview(dto);
		// deptController.start();
		
		SalgradeController salgradeController = new SalgradeController();
		//salgradeController.start();
		// BonusController bonusController = new BonusController();
		//bonusController.start();
		
		EmpController empController = new EmpController();
		empController.start();
		
	}
}
