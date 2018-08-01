package oracleuse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class OracleInsert {
	public static void main(String[] args) {
		// 사용하고자 하는 드라이버 클래스를 로드
		// 데이터베이스 종류에 따라 다름

		// 데이터베이스 연결 변수 선언
		// 반드시 close()를 호출해야 하므로 finally에서 close()를 호출
		Connection con = null;
		//SQL 실행 변수
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","scott", "tiger");
			//SQL 실행 객체를 생성
			//pstmt = con.prepareStatement("insert into dept(deptno, dname, loc)" +" values(60, '영업', '부산')");
			
			//삭제하는 거
			//pstmt = con.prepareStatement("delete from dept where deptno = 50");
			//pstmt = con.prepareStatement("delete from dept where deptno = 70");
			
			//dept 테이블에서 deptno가 10번인 데이터
			//loc를 만재도로 변경
			pstmt = con.prepareStatement("update dept set loc = '만재도' where deptno = 10");
			
			//SQL을 실행 - select를 제외한 구문 실행
			//아래 저장되는 값은 영향 받은 행의 개수
		int r = pstmt.executeUpdate();
		//성공여부 출력
		if(r > 0) {
			System.out.println("삽입 성공");
		}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// 연결이 되어 있으면 반드시 연결 해제
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}

	}

}



