package university;

public class Student extends Human {

	private String name; //shadow
	private String department;
	

	public Student(int k){
		
	}
	
	public Student(){
		//상위클래스가 존재한다.
		//상위클래스의 instance부터 만들어야겠다.
		//근데 생성자가 상속이 안되기때문에 Human();이 안됨
		//만약 생성자안에서 상위클래스의 생성자를 호출해주는 구문이 존재하지않으면
		//javac comnpiler가 추가해줌.
		
		this(100); //super와 this는 같이 나올 수가 없다. why 상위클래스의 instance가 두개만들어지니까
		
	}
	
	//overriding
	public void print(){
		System.out.println("여기는 student입니다");
		super.print();
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


}
