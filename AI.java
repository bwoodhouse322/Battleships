import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class AI extends User {
	int num ;

	public AI(String name, boolean isTurn, boolean hasWon, int lives, int num) {
		super(name, isTurn, hasWon, lives);
		this.num = num;
	}
	

	
	public  int[][] shipPlacement(int[][] placementCoordinates, ArrayList<Ship> shipList){
		
		
		
		for(int i=0; i < placementCoordinates.length;i++){
			//row
			placementCoordinates[i][0] = ThreadLocalRandom.current().nextInt(1,8-shipList.get(i).getWidth());
					
			//column
			placementCoordinates[i][1] = ThreadLocalRandom.current().nextInt(1,8-shipList.get(i).getLength());
		}
		return placementCoordinates;
		
		
	}
	
	
	
	public int[] turn(AI AI){

		
		int column = ThreadLocalRandom.current().nextInt(1,9);
		int row = ThreadLocalRandom.current().nextInt(1,9);
		//scanner.close();
		
		 return new int[] {row,column};
		
	}

}
