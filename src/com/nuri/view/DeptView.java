package com.nuri.view;

import java.util.ArrayList;

import com.nuri.emp.DeptDTO;

public class DeptView {

	public void allview(ArrayList<DeptDTO> ar) {
		for(DeptDTO dto : ar) {
			this.view(dto);
		}
	}
	
	public void view(DeptDTO dto) {
		if(dto != null) {
		System.out.println("========================");
		System.out.println("DEPTNO : " + dto.getDeptno());
		System.out.println("DNAME : " + dto.getDname());
		System.out.println("LOC : " + dto.getLoc());
		}else {
			System.out.println("없는 부서번호입니다.");
		}
	}
}
