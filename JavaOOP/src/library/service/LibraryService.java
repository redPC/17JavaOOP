package library.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import library.dao.LibraryDAO;
import library.dto.LibraryDTO;

public class LibraryService {

	public LibraryService(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	public boolean bookRegister(LibraryDTO dto){
		Connection con= null;
		boolean result=false;
		try{
			String id="java";
			String pw="java";
			String url="jdbc:mysql://localhost:3306/library";
			con = DriverManager.getConnection(url,id, pw);

			LibraryDAO dao =new LibraryDAO(con);
			result= dao.insert(dto);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
				con.close();
			}catch(Exception e2){
				System.out.println(e2);
			}
		}
		
		return result;
	}
	
	public ArrayList<LibraryDTO> findBookByKeyword(String keyword) {
		
		Connection con= null;

		ArrayList<LibraryDTO> list = new ArrayList<LibraryDTO>();
		try{
			String id="java";
			String pw="java";
			String url="jdbc:mysql://localhost:3306/library";
			con = DriverManager.getConnection(url,id, pw);
			LibraryDAO dao = new LibraryDAO(con);
			list=dao.select(keyword);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
				con.close();
			}catch(Exception e2){
				System.out.println(e2);
			}
		}

		
		return list;

	}

	public boolean deleteByNumber(String number) {
		
		Connection con= null;
		boolean result=false;
		try{
			String id="java";
			String pw="java";
			String url="jdbc:mysql://localhost:3306/library";
			con = DriverManager.getConnection(url,id, pw);

			LibraryDAO dao =new LibraryDAO(con);
			result= dao.delete(number);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
				con.close();
			}catch(Exception e2){
				System.out.println(e2);
			}
		}
		
		
		return result;
	}

	public boolean reviseByNumber(LibraryDTO dto,String isbn, String number) {
		Connection con= null;
		boolean result=false;
		try{
			String id="java";
			String pw="java";
			String url="jdbc:mysql://localhost:3306/library";
			con = DriverManager.getConnection(url,id, pw);

			LibraryDAO dao =new LibraryDAO(con);
			result= dao.revise(dto,isbn,number);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{
				con.close();
			}catch(Exception e2){
				System.out.println(e2);
			}
		}
		
		
		return result;
	}
}
