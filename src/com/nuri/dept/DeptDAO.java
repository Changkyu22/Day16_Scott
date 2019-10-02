package com.nuri.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.nuri.utill.DBconnector;
import com.sun.xml.internal.ws.api.pipe.NextAction;

public class DeptDAO {
	
	public int deptInsert(DeptDTO deptDTO) {
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.56.102:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		try {
			con = DBconnector.getConnect();
			String sql = "insert into dept values(?, ?, ?)";
			st = con.prepareStatement(sql);
			
			st.setInt(1, deptDTO.getDeptno());
			st.setString(2, deptDTO.getDname());
			st.setString(3, deptDTO.getLoc());
			
			result = st.executeUpdate();
			
			
			if(result>0) {
				System.out.println("입력성공");
			}else {
				System.out.println("입력실패");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	// getSelectList
	// 전체부서출력 - 부서번호로
	
	public ArrayList<DeptDTO> getSelectlist() {
		ArrayList<DeptDTO> ar = new ArrayList<DeptDTO>();
		DeptDTO dto = null;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = DBconnector.getConnect();
			String sql = "select * from dept order by deptno asc";
			
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
			rs = st.executeQuery();
			st.setInt(1, deptno);
			
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
