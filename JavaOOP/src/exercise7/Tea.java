package exercise7;

public class Tea extends Beverage{
	
	public static int amount;

	public Tea(){
		
	}
	@Override
	public void calcPrice() {
		// TODO Auto-generated method stub
		if(getName()=="Lemon Tea"){
			setPrice(1500);
		}else if(getName()=="Jasmin Tea"){
			setPrice(2000);
		}else if(getName()=="Black Tea"){
			setPrice(2500);
		}
		
		amount+=1;
	}
}
