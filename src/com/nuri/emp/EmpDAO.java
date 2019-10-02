package com.nuri.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.col.bo.BonusDTO;
import com.nuri.utill.DBconnector;

public class EmpDAO {

	// getSelectList
	// 전체사원정보 - 최신입사순
	
	public ArrayList<EmpDTO> searchOne(String ename) {
		ArrayList<EmpDTO> ar = new ArrayList<EmpDTO>();
		try {
			con = DBconnector.getConnect();
			String sql = "select ename, job, sal, comm from bonus where ename = ?";
			ename = "%"+ename+"%";
		
			st = con.prepareStatement(sql);
			st.setString(1, ename);
			EmpDTO dto = null;

			rs = st.executeQuery();
			while(rs.next()) {
				dto = new EmpDTO();
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setSal(rs.getInt("sal"));
				dto.setComm(rs.getInt("comm"));
				ar.add(dto);
			}
			System.out.println(ename);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
	
	
	
	public int delete(int empno) {
		
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		try {
			con = DBconnector.getConnect();
			String sql = "delete emp where empno = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, empno);
			
			result =st.executeUpdate();
			
			if(result>0) {
				System.out.println("입력성공");
			}else {
				System.out.println("입력실패");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
		
		
	}
	
	public int empInsert(EmpDTO empDTO) {
		
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		try {
			con = DBconnector.getConnect();
			String sql = "insert into emp values(?,?,?,?,sysdate,?,?,?)";
			st = con.prepareStatement(sql);
			
			st.setInt(1, empDTO.getEmpno());
			st.setString(2, empDTO.getEname());
			st.setString(3, empDTO.getJob());
			st.setInt(4, empDTO.getMgr());
			// st.setString(5, empDTO.getHiredate());
			st.setInt(5, empDTO.getSal());
			st.setInt(6, empDTO.getComm());
			st.setInt(7, empDTO.getDeptno());
			
			result = st.executeUpdate();
			
			if(result>0) {
				System.out.println("입력성공");
			}else {
				System.out.println("입력실패");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
		
	}
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
