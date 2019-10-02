package com.nuri.view;

import java.util.ArrayList;

import com.nuri.dept.DeptDTO;

public class DeptView {

	public void allview(ArrayList<DeptDTO> ar) {
		for(DeptDTO dto : ar) {
			this.view(dto);
		}
	} // 향상된 for 문  : ar에 모아둔 dto 타입을 돌림

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

	public void insertview(DeptDTO dto) {
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
