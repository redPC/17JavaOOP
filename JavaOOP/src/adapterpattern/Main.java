package adapterpattern;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<TerranInterface> unit = new ArrayList<>();
		
		unit.add(new Marine());
		unit.add(new Marine());
		unit.add(new Marine());
		unit.add(new Tank());
		unit.add(new MedicAdapter(new Medic()));
		for(TerranInterface tmp : unit){
			tmp.move();
		}
		for(TerranInterface tmp : unit){
			tmp.attack();
		}
		
	}

}
