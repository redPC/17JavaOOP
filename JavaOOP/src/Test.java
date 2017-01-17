//interface의 형태
//이런 interface를 도대체 어떻게 사용하나요?

public interface Test {
	
	public static final String name = "홍길동"; 
	int age=20;  //javac compiler가 public static final 생략해줌
	
	void printInfo(); //public abstract도 javac compiler가 생략해줌
	
}

//java는 단일 상속만 지원한다. 
interface MyInterface extends Test{
	
}

//java는 다중 구현을 지원한다.
class MyClass implements Test {

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		
	}
	
	
}