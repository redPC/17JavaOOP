package university;

public class Human extends Object{
	private String name;
	private String age;
	
	
	public Human(){
		super();
	}
	
	public void print(){
		System.out.println("여기는 human");
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}
}
