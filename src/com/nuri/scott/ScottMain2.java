package com.nuri.scott;

import java.util.ArrayList;

import com.nuri.control.DeptController;
import com.nuri.emp.DeptDAO;
import com.nuri.emp.DeptDTO;
import com.nuri.input.DeptInput;
import com.nuri.view.DeptView;

public class ScottMain2 {
	
	public static void main(String[] args) {
		
		DeptDAO dao = new DeptDAO();
		DeptDTO dto = new DeptDTO();
		DeptView view = new DeptView();
		DeptInput input = new DeptInput();
		
		//view.view(dao.getSelectOne(input.deptnoInput()));
		//ArrayList<DeptDTO> ar = dao.getSelectlist();
		//view.allview(ar);
		DeptController control = new DeptController();
		control.start();
		
	}
}
