package com.nuri.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.nuri.utill.DBconnector;

public class DeptDAO {

	// getSelectList
	// 전체부서출력 - 부서번호로
	
	public ArrayList<DeptDTO> getSelectlist() {
		DeptDTO dto = null;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<DeptDTO> ar = new ArrayList<DeptDTO>();
		
		try {
			con = DBconnector.getConnect();
			String sql = "select * from dept";
			
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				dto = new DeptDTO();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				ar.add(dto);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ar;
		
	}
	
	
	public DeptDTO getSelectOne(int deptno) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		DeptDTO dto = null;
		
		try {
			con = DBconnector.getConnect();
			String sql = "select * from dept where deptno = ?";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, deptno);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				dto = new DeptDTO();
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dto;
		
	}
		
		
}
