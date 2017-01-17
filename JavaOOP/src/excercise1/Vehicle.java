package excercise1;

public class Vehicle extends Owner{
	private Owner owner;
	private int price;

	
	public Vehicle(){
		
	}
	public Vehicle(String string, String string2, int i) {
		// TODO Auto-generated constructor stub
		owner = new Owner(string,string2);
		price = i;
	}
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if (obj instanceof Vehicle){
			Vehicle tmp=(Vehicle) obj;
			if(this.owner.equals(tmp.owner)){
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return owner.toString()+"\n"+"차량정보 : 가격은 "+price+"입니다.";
	}
	
}
