package university;

public class Main {

	public static void main(String[] args) {
		Human a=new Human();
		Student s=new Student();
		Human c= new Student();		
		
		s.setDepartment("컴퓨터");
		s.setName("홍길동");
		s.print(); //여기는 student입니다
		c.print(); //여기는 student입니다.
		//이런 경우 비록 상위 클래스 type을 지정되어 있찌만 print()가 overriding된 형태이기때문에
		//하위 클래스의 overriding method가 호출됨
		//Dynamic binding(동적 바인딩)
		
	}
}
