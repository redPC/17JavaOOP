package ex1;

public class InstanceTest {
	static int a = staticcall("1번");
	
	int b = staticcall("2번");
	
	public static int staticcall(String msg){
		System.out.println(msg);
		return 100;
	}
	
	public InstanceTest(){
		this.b=staticcall("3번");
	}
	
	public static void main(String[] args){
		System.out.println("4번");
		int c = staticcall("5번");
		InstanceTest d= new InstanceTest();
	}
}
