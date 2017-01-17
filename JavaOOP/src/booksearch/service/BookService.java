package booksearch.service;

import java.util.ArrayList;

import booksearch.dao.BookDAO;
import booksearch.dto.BookDTO;

public class BookService {

	public ArrayList<BookDTO> findBookByKeyword(String Keyword) {
		//로직처리가 나온다
		//일반 로직은 service에서 구현을 함
		//
		BookDAO dao = new BookDAO();		
		return dao.select(Keyword);
	}

	public boolean deleteByNumber(String number) {
		// TODO Auto-generated method stub
		BookDAO dao = new BookDAO();
		return dao.delete(number);
		
	}

}
