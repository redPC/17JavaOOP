package excercise1;


public class Owner extends Object {
	private String name;
	private String cellPhone;
	
	public Owner(){
		
	}
	

	public Owner(String name, String cellPhone) {
		super();
		this.name = name;
		this.cellPhone = cellPhone;
	}


	public boolean equals(Object obj){
		boolean result = false;
		
		if (obj instanceof Owner){
			Owner tmp=(Owner) obj;
			if(this.name.equals(tmp.name)){
				result=true;
			}else{
				result=false;
			}
		}
		else{
			result=false;
		}
		return result;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "이름은"+name+"이고, 핸드폰번호는 "+cellPhone+"입니다";
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	
	
	
}
