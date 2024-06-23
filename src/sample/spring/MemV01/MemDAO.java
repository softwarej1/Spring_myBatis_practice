package sample.spring.MemV01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DbClose;
import common.DbSet;

public class MemDAO {
	static Connection conn;
	PreparedStatement pstmt;
	static ResultSet rs;
	public ArrayList<MemDTO> memSelList() {

		String sql = "select * from membert01";
		String vId, vPwd, vName, vAddr, vPhone, vEmail = "";
		ArrayList<MemDTO> dtoL = new ArrayList<MemDTO>();
		MemDTO dto = new MemDTO();
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1단계 : 드라이버 연동 성공!!");
			conn = DbSet.getConnection();
			pstmt = conn.prepareStatement(sql);

			// executeUpdate() -> sql 구문 : 반환값 int 정수값
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// getString() -> 현재 행에 있는 지정된 열값을 문자열로 반환해준다.
				vId = rs.getString("mem_id");
				vPwd = rs.getString("mem_pwd");
				vName = rs.getString("mem_name");
				vAddr = rs.getString("mem_email");
				vPhone = rs.getString("mem_phone");
				vEmail = rs.getString("mem_addr");
				dto = new MemDTO(vId, vPwd, vName, vEmail, vPhone, vAddr);
				dtoL.add(dto);
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbClose.close(conn, pstmt, rs);
		}
		return dtoL;
	}
	
	public boolean memLog(MemDTO dto) {
		String sql = "select * from membert01 where mem_id = ? and mem_pwd = ? ";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DbSet.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, dto.getMem_id());
			pstmt.setNString(2, dto.getMem_pwd());
			
			int su = pstmt.executeUpdate();

			if (su != 0) {
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbClose.close(conn, pstmt);
		}

		return false;
	}
	
	
	public int memDel(MemDTO dto) {

		String sql = "delete from memberT01 where mem_id = ? and mem_pwd = ? ";
		int su = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1단계 : 드라이버 연동 성공!!");
			conn = DbSet.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, dto.getMem_id());
			pstmt.setNString(2, dto.getMem_pwd());
			// executeUpdate() -> sql 구문 : 반환값 int 정수값
			su = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbClose.close(conn, pstmt);
		}
		return su;
	}
	
	public int memIns(MemDTO dto) {
		String sql = "insert into memberT01(mem_id, mem_pwd, mem_name, mem_email, mem_phone, mem_addr) values(?, ?, ?, ?, ?, ?)";
		int su = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1단계 : 드라이버 연동 성공!!");
			conn = DbSet.getConnection();
			System.out.println("2단계 : DB연동 성공!!");
			pstmt = conn.prepareStatement(sql);
			// prepareStatement(sql) 사용할 시 반환형 PreparedStatement로 해주어야 합니다.
			// setNString()형으로 인덱스 값을 포함하여 적용합니다.
			
			pstmt.setNString(1, dto.getMem_id());
			pstmt.setNString(2, dto.getMem_pwd());
			pstmt.setNString(3, dto.getMem_name());
			pstmt.setNString(4, dto.getMem_email());
			pstmt.setNString(5, dto.getMem_phone());
			pstmt.setNString(6, dto.getMem_addr());
			su = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbClose.close(conn, pstmt);
		}

		return su;
	}
	
	
	public int memUpd(MemDTO dto) {
		String sql = "update memberT01 set mem_pwd = ?, mem_name = ?, mem_email = ?, mem_phone = ?, mem_addr = ? where mem_id = ?";

		int su = 0;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1단계 : 드라이버 연동 성공!!");
			conn = DbSet.getConnection();
			System.out.println("2단계 : DB연동 성공!!");
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, dto.getMem_pwd());
			pstmt.setNString(2, dto.getMem_name());
			pstmt.setNString(3, dto.getMem_email());
			pstmt.setNString(4, dto.getMem_phone());
			pstmt.setNString(5, dto.getMem_addr());
			pstmt.setNString(6, dto.getMem_id());

			// executeUpdate() -> sql 구문 : 반환값 int 정수값
			
			su = pstmt.executeUpdate();
			System.out.println("실행문 완!!");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DbClose.close(conn, pstmt);
		}

		return su;
	}
}
