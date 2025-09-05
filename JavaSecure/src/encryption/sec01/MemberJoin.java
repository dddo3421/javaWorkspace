package encryption.sec01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MemberJoin {

	public static void main(String[] args) {
		// 취약한 패스워드 저장1: plain text 그대로 저장
		
		DBConnect dbCon = new DBConnect(); //DBconnect 객체 하나 구성
		Connection con = dbCon.getConnection(); // Connection을 통해 데이터베이스와 연결 		
		PreparedStatement pstmt = null;
		
		
		Scanner sc = new Scanner(System.in); 
		
		try {
			System.out.print("ID 입력 : ");
			String memID = sc.nextLine(); 
			System.out.print("비밀번호 입력 : ");
			String memPwd  = sc.nextLine(); 
			System.out.print("이름 입력 : ");
			String memName = sc.nextLine(); 
			System.out.print("e-mail 입력 : ");
			String memEmail = sc.nextLine(); 
			
			//회원가입 시간
			LocalDate now = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			String memJoinDate = now.format(formatter);
			String sql = "insert into member values(?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memID);
			pstmt.setString(2, memPwd); //바인딩되는 패스워드는 plain text
			pstmt.setString(3, memName);
			pstmt.setString(4, memEmail);
			pstmt.setString(5, memJoinDate);
				
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("회원가입 성공");
			}else {
				System.out.println("회원가입 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnect.close(con, pstmt);
			sc.close();
		}
	}

}
