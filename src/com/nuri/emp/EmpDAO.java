package com.nuri.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.nuri.utill.DBconnector;

public class EmpDAO {

	// getSelectList
	// 전체사원정보 - 최신입사순
	public ArrayList<EmpDTO> getSelectList() {
		EmpDTO empDTO = null;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<EmpDTO> ar = new ArrayList<EmpDTO>();

		try {
			con = DBconnector.getConnect();
			String sql = "select empno, ename, job, mgr, hiredate, sal, nvl(comm,0) as COMM, deptno "
					+ "from emp order by hiredate desc";

			st = con.prepareStatement(sql);

			rs = st.executeQuery();

			while(rs.next()) {
				empDTO = new EmpDTO();
				empDTO.setEmpno(rs.getInt("empno"));
				empDTO.setEname(rs.getString("ename"));
				empDTO.setJob(rs.getString("job"));
				empDTO.setMgr(rs.getInt("mgr"));
				empDTO.setHiredate(rs.getString("hiredate"));
				empDTO.setSal(rs.getInt("sal"));
				empDTO.setComm(rs.getInt("comm"));
				empDTO.setDeptno(rs.getInt("deptno"));
				ar.add(empDTO);
			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ar;

	}

	// getSelectOne
	// 매개변수로 사원번호

	DBconnector dc = new DBconnector();
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public EmpDTO getSelectOne(int empno) {
		EmpDTO empDTO = null;

		try {
			con = DBconnector.getConnect();
			String sql = "select empno, ename, job, mgr, hiredate, sal, nvl(comm,0) as COMM, deptno from emp "
					+ "where empno=?";

			st = con.prepareStatement(sql);

			st.setInt(1, empno);

			rs = st.executeQuery();

			if(rs.next()) {
				empDTO = new EmpDTO();
				empDTO.setEmpno(rs.getInt("empno"));
				empDTO.setEname(rs.getString("ename"));
				empDTO.setJob(rs.getString("job"));
				empDTO.setMgr(rs.getInt("mgr"));
				empDTO.setHiredate(rs.getString("hiredate"));
				empDTO.setSal(rs.getInt("sal"));
				empDTO.setComm(rs.getInt("comm"));
				empDTO.setDeptno(rs.getInt("deptno"));
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
		return empDTO;
	}

}
