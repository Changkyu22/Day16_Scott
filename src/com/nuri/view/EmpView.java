package com.nuri.view;

import java.util.ArrayList;

import com.nuri.emp.EmpDTO;

public class EmpView {

	// 전체 사원  view = EmpView

	public void allview(ArrayList<EmpDTO> ar) {
		if(ar.size() != 0) {
			for (EmpDTO empDTO : ar) {
				this.view(empDTO);
			}
		}else {
			System.out.println("정보가 없습니다");
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

	public void insertview(EmpDTO empDTO) {
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
