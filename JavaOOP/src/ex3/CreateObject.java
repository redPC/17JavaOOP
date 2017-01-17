package ex3;

public class CreateObject extends A{
	public int c = staticcall("5번");
	
	public static int d=staticcall("6번");
	
	public CreateObject(){
		super(100);
		staticcall("7번");
	}
	
	public static void main(String[] args){
		System.out.println("8번");
		CreateObject k = new CreateObject();
	}
}
