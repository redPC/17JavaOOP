package adapterpattern;

public class Marine implements TerranInterface {

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("총을 쏜다.");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("열심히 뛰어다닌다.");
	}

	
}
