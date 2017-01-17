package ex3;

public class A {
	static int staticcall(String message){
		System.out.println(message);
		return (0);
	}
	
	static int a =staticcall("1번");
	
	int b=staticcall("2번");
	
	public A(){
		staticcall("3번");
	}
	
	public A(int i){
		this();
		staticcall("4번");
	}
}
