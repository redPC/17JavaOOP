package library.controller;

import java.util.ArrayList;
import java.util.Scanner;

import library.dto.LibraryDTO;
import library.service.LibraryService;

public class LibraryController {

	public LibraryController(){
		Scanner s = new Scanner(System.in);
		String menu=null;
		String keyword=null;
		String isbn=null;
		String title=null;
		String author=null;
		int price =0;
		String number=null;
		
		do{
			System.out.println("==도서관리 프로그램==");
			System.out.println("1.도서입력");
			System.out.println("2.도서수정(책번호)");
			System.out.println("3.도서삭제(책번호)");
			System.out.println("4.도서검색(키워드)");
			System.out.println("5.도서대여(책번호)");
			System.out.println("6.도서반납(책번호)");
			System.out.println("7.종료");
			System.out.println("메뉴를 입력하세요.");
			menu=s.nextLine();
			
			if(menu.equals("1")){
				LibraryService service = new LibraryService();
				LibraryDTO dto = new LibraryDTO();
				System.out.println("책번호를 입력하세요");
				isbn=s.nextLine();
				dto.setBisbn(isbn);
				System.out.println("책제목을 입력하세요");
				title=s.nextLine();
				dto.setBtitle(title);
				System.out.println("책저자를 입력하세요");
				author = s.nextLine();
				dto.setBauthor(author);
				System.out.println("책가격을 입력하세요");
				price = s.nextInt();
				s.nextLine();
				dto.setBprice(price);
				
				boolean result = service.bookRegister(dto);
				if(result){
					System.out.println("입력되었습니다.");
				}else{
					System.out.println("입력되지 않았습니다.");
				}
			}
			if(menu.equals("2")){
				System.out.println("책번호를 입력하세요.");
				isbn=s.nextLine();
				LibraryService service=new LibraryService();
				LibraryDTO dto = new LibraryDTO();
				System.out.println("수정할 곳이 어디입니까?");
				System.out.println("1.책번호");
				System.out.println("2.책제목");
				System.out.println("3.책저자");
				System.out.println("4.책가격");
				System.out.println("번호를 입력하세요");
				number=s.nextLine();

				if(number.equals("1")){
					System.out.println("수정할 내용을 입력하세요.");
					String revision=s.nextLine();
					dto.setBisbn(revision);
				}
				if(number.equals("2")){
					System.out.println("수정할 내용을 입력하세요.");
					String revision=s.nextLine();
					dto.setBtitle(revision);
				}
				if(number.equals("3")){
					System.out.println("수정할 내용을 입력하세요.");
					String revision=s.nextLine();
					dto.setBauthor(revision);
				}
				if(number.equals("4")){
					System.out.println("수정할 내용을 입력하세요.");
					int revision=s.nextInt();
					s.nextLine();
					dto.setBprice(revision);
				}
				boolean result = service.reviseByNumber(dto,isbn,number);
				if(result){
					System.out.println("수정되었습니다.");
				}else{
					System.out.println("수정되지 않았습니다.");
				}
			}
			if(menu.equals("3")){
				System.out.println("책번호를 입력하세요.");
				number=s.nextLine();
				LibraryService service=new LibraryService();
				boolean result = service.deleteByNumber(number);
				if(result){
					System.out.println("삭제되었습니다.");
				}else{
					System.out.println("삭제되지않았습니다.");
				}
			}
			if(menu.equals("4")){
				System.out.println("키워드를 입력하세요.");
				keyword=s.nextLine();
				LibraryService service=new LibraryService();
				ArrayList<LibraryDTO> list =service.findBookByKeyword(keyword);
				for( LibraryDTO dto : list ) {
					System.out.println(dto.getBisbn()+", "+dto.getBtitle() + ", " + 
				dto.getBauthor()+", "+dto.getBprice());
				}
				
			}
			if(menu.equals("5")){
				System.out.println("책번호를 입력하세요.");
			}
			if(menu.equals("6")){
				System.out.println("책번호를 입력하세요.");
			}
			if(menu.equals("7")){
				System.out.println("프로그램을 종료합니다.");
			}
	
		}while(!menu.equals("7"));
	}
}
