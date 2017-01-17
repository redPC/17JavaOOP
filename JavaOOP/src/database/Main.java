package database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {

	public static void main(String[] args) {
		
		//입력을 받는다
		//입력을 받기위해서는 기본적으로 Stream이라는걸 이용해야 함.
		//Stream을 직접이용하는건 나중에 다시하고 . 여기선 좀 쉬운형태로 사용자로부터 입력을 받는다.
		Scanner s = new Scanner(System.in);
		System.out.println("검색어를 입력하세요: ");
		String keyword = s.nextLine();
		
		// JDBC (java database Connectivity)
		// 총 6단계를 거쳐서 java program이 database를 이용
		// 조심할건 database 프로그램은 예외상황에 대한 처리가 같이 나와야함
		// exception handling
		// try ~ catch()
		
		try {
			//1. 드라이버 로딩
			// 자바가 특정 데이터 베이스를 이용하기 위해서는
			// 특수한 class의 instance가 필요
			// java ------ JDBC Driver -----> database
			// 파일을 찾았으면 이 파일을 사용하기 위해 경로를 설정.
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
			//2. 데이터베이스에 접속
			//접속을 위해서는 크게 3가지가 필요함
			// id /pw / 어느데이터베이스에 접속할건지에 대한 주소
			String id="java";
			String pw="java";
			String url="jdbc:mysql://localhost:3306/library";
			Connection con = DriverManager.getConnection(url,id,pw);
			System.out.println("드라이버 연결 성공");
			//3. 문장생성(SQL 질의 작성)
			// SQL에서 사용할 수 있는 wildcard중에 "%" => 0개 이상의 문자열 
			// %java ==> 문자열이긴 한데 끝이 java임. %java% java라는 글자를 포함하는 문자열.
			//IN parameter인 "?"를 이용해서 코드를 읽기 쉽게 만들 수 있다.
			String sql="select btitle, bauthor from book where btitle like ?"; 
			PreparedStatement pstmt =con.prepareStatement(sql);
			pstmt.setString(1,"%"+keyword+"%");  //1은 첫번째 물음표를 의미함.
			//4. 실행
			//실행시 조심해야 할건 어떤 종류의 sql을 사용하는지에 따라 실행하는 method가 달라짐.
			//데이터를 얻어오는 경우 (select ~~)
			ResultSet rs=pstmt.executeQuery();
			//5. 결과처리단계
			//지금의 경우는 select를 이용해서 결과데이터의 집합을 db로부터 가져온 경우.
			while(rs.next()){
				String title = rs.getString("btitle");
				String author = rs.getString("bauthor");
				System.out.println(title+", "+author);
			}
			//6.사용한 resource를 해제
			rs.close();
			pstmt.close();
			con.close();
			s.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
