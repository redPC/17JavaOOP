package exercise7;

public class Coffee extends Beverage{

	public static int amount;

	public Coffee(){
		
	}
	
	public Coffee(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void calcPrice() {
		// TODO Auto-generated method stub
		int currentPrice;
		if (getName()=="Americano"){
			setPrice(1500);
		}else if(getName()=="Cafe latte"){
			setPrice(2500);
		}else if(getName()=="Cappucino"){
			setPrice(3000);
		}
		amount+=1;
	}
	
	
}
