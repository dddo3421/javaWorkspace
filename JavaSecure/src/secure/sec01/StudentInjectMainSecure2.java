package secure.sec01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.*; //정규 클래스 추가, 정규 표현식을 사용하기 위한 import

public class StudentInjectMainSecure2 {

	public static void main(String[] args) {
		// 입력값 필터링 - 정규식 활용
		// 문자와 숫자를 제외한 나머지 특수 기호 필터링
		// union 삽입 공격에 사용하는 키워드들은 필터링
		DBConnect dbCon = new DBConnect(); // DBconnect 객체 하나 구성
		Connection con = dbCon.getConnection(); // Connection을 통해 데이터베이스와 연결

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]|select|delete|update|insert|create|alter|drop|all|union"); // 괄호를 빼서 단어만 필터링
//		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]|[select|delete|update|insert|create|alter|drop|all|union]");  // 단어가 아니라 s e l ... 문자 하나하나 필터링
		Matcher matcher = null;

		try {
			System.out.print("학생 번호 입력 : ");
			String studentNo = sc.nextLine();
			System.out.println(studentNo);

			matcher = pattern.matcher(studentNo.toLowerCase());
			boolean match = true;
			// matcher.find(); //설정한 정규식 패턴과 전달된 문자열을 매칭시켜서 정규식 패턴에 대한 문자열 확인되면 true 반환
			while (matcher.find()) {
				match = false;
				break;
			}
			System.out.println(match);

			// 필터링 통해 취약점 제거
			// String sql = "select * from student where stdNo='" + studentNo + "'";
			if (match) {
				String sql = "select * from student where stdNo= ?";
				System.out.println(sql);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, studentNo);
				rs = pstmt.executeQuery();

				// 제목 출력
				System.out.println("--------------------학생 정보 조회---------------------");
				System.out.println("학생번호 \t 학생이름 \t\t\t\t 학년");

				// 필요 내용만 추출
				while (rs.next()) {
					String stdNo = rs.getString(1);
					String stdName = rs.getString(2);
					int stdYear = rs.getInt(3);

					// 한 행씩 출력
					System.out.printf("%-10s\t %-20s\t %6d \n", stdNo, stdName, stdYear);

				}

				// 리소스반환
				rs.close();
				pstmt.close();
				con.close();
			} else {
				System.out.println("잘못된 입력입니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace(); // 개발단계에서 개발자가 확인하기 위한 에러 출력문
		}

	}

}
