package library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import library.dto.LibraryDTO;

public class LibraryDAO {
	
	private Connection con;
	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public LibraryDAO(){
		
	}
	
	public LibraryDAO(Connection con){
		this.con=con;
	}

	public ArrayList<LibraryDTO> select(String keyword){

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<LibraryDTO> list = new ArrayList<LibraryDTO>();
		try{
			String sql = 
					"select btitle, bauthor,bisbn, bprice from book where btitle like ?";			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String title = rs.getString("btitle");
				String author = rs.getString("bauthor");
				String isbn = rs.getString("bisbn");
				int price = rs.getInt("bprice");
				LibraryDTO dto = new LibraryDTO();
				dto.setBtitle(title);
				dto.setBauthor(author);
				dto.setBisbn(isbn);
				dto.setBprice(price);
				list.add(dto);
			}			
			
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{ //close라는 method가 try catch를 강제한다.
				rs.close();
				pstmt.close();
			}catch(Exception e1){
				System.out.println(e1);
			}
		}
		
		return list;
	}

	public boolean delete(String number) {
		boolean result = false;
		try{
			String sql = "delete from book where bisbn = ?";			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, number);
			int tmp = pstmt.executeUpdate();
			if( tmp == 1 ) {
				result = true;
			}
			pstmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return result;
	}

	public boolean revise(LibraryDTO dto, String isbn,String number) {
		boolean result = false;
		PreparedStatement pstmt=null;
		try{
			if(number.equals("1")){
				String sql = "update book set bisbn=? where bisbn = ?";			
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,dto.getBisbn() );
				pstmt.setString(2, isbn);
			}
			else if(number.equals("2")){
				String sql = "update book set btitle=? where bisbn = ?";			
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,dto.getBtitle());
				pstmt.setString(2,isbn);
			}
			else if(number.equals("3")){
				String sql = "update book set bauthor=? where bisbn = ?";			
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,dto.getBauthor());
				pstmt.setString(2,isbn);
			}
			else if(number.equals("4")){
				String sql = "update book set bprice=? where bisbn=?";			
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,dto.getBprice());
				pstmt.setString(2,isbn);
			}
			
			int tmp = pstmt.executeUpdate();
			if( tmp == 1 ) {
				result = true;
			}
			pstmt.close();
		}catch(Exception e) {
			System.out.println(e);
		}finally{
			try{ 
				pstmt.close();
			}catch(Exception e1){
				System.out.println(e1);
			}
		}
		return result;
	}

	public boolean insert(LibraryDTO dto) {
		boolean result = false;
		PreparedStatement pstmt =null;
		try{
			String sql = 
					"insert into book (btitle, bauthor,bisbn, bprice)"
					+ " values (? , ?, ?, ?)";			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBauthor());
			pstmt.setString(3, dto.getBisbn());
			pstmt.setInt(4, dto.getBprice());
			int tmp = pstmt.executeUpdate();
			if( tmp == 1 ) {
				result = true;
			}
		}catch(Exception e){
			System.out.println(e);
		}finally{
			try{ //close라는 method가 try catch를 강제한다.
				pstmt.close();
			}catch(Exception e1){
				System.out.println(e1);
			}
		}
		
		return result;
	}
}
