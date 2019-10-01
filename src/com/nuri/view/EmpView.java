package com.nuri.view;

import java.util.ArrayList;

import com.nuri.emp.EmpDTO;

public class EmpView {

	// 전체 사원  view = EmpView

	public void allview(ArrayList<EmpDTO> ar) {
		for (EmpDTO empDTO : ar) {

			this.view(empDTO);
		}

	}

	public void view(EmpDTO empDTO) {
		System.out.println("===============================");
		System.out.println("EMPNO : " + empDTO.getEmpno());
		System.out.println("ENAME : " + empDTO.getEname());
		System.out.println("JOB : " + empDTO.getJob());
		System.out.println("MGR : " + empDTO.getMgr());
		System.out.println("HIREDATE : " + empDTO.getHiredate());
		System.out.println("SAL : " + empDTO.getSal());
		System.out.println("COMM : " + empDTO.getComm());
		System.out.println("DEPTNO : " + empDTO.getDeptno());
	}
}
