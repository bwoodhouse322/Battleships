import java.util.ArrayList;

public class Main {
	
		
	public static void main(String[] args) {
		ArrayList<Ship> shipList = new ArrayList<>();
		
		int coordinates[] ;
		int howManyPlayers =1;
	
		//Create boards
		Board board1= new Board(9,9);
		Board board2= new Board(9,9);
		
		//Create ship and ship list
		Ship ship1= new Ship("Patrol Boat", 3,1, true, 3);
		Ship ship2= new Ship("Destroyer", 1,4, true, 4);
		Ship ship3= new Ship("Patrol Boat", 1,3, true, 3);
		Ship ship4= new Ship("Cruiser", 1,6, true, 6);
		//Create users
		User user1= new User("ben",true,false,ship1.getLife()+ship2.getLife()+ship3.getLife()+ship4.getLife());
		User user2= new User("leon",false,false,ship1.getLife()+ship2.getLife()+ship3.getLife()+ship4.getLife());
		AI AI= new AI("AI",false,false,ship1.getLife()+ship2.getLife()+ship3.getLife()+ship4.getLife(),1);
		
		shipList.add(ship1);
		shipList.add(ship2);
		shipList.add(ship3);
		shipList.add(ship4);
		int placementCoordinates[][] = new int[shipList.size()][shipList.size()];
		
		if(howManyPlayers== 2){
		
		placementCoordinates= user1.shipPlacement(placementCoordinates, shipList);
		board1.create(board1,board1.length,board1.width, shipList, placementCoordinates, user1);
		
		
		
		placementCoordinates= user2.shipPlacement(placementCoordinates, shipList);
		board2.create(board2,board1.length,board1.width, shipList, placementCoordinates, user2);
		
		
		do{
			coordinates = user1.turn(user1);
			board1.attackEvent(coordinates, board2, user2,user1);
			if(user1.isHasWon()){
				continue;
			}
			coordinates = user2.turn(user2);
			board2.attackEvent(coordinates, board1, user1, user2);
		}while (user1.isHasWon()== false && user2.isHasWon() == false);
		
		
		System.out.println("GAME OVER");
		
		} else{
			

			placementCoordinates= user1.shipPlacement(placementCoordinates, shipList);
			board1.create(board1,board1.length,board1.width, shipList, placementCoordinates, user1);
			
			
			
			placementCoordinates= AI.shipPlacement(placementCoordinates, shipList);
			board2.create(board2,board1.length,board1.width, shipList, placementCoordinates,AI);
			
			
			do{
				coordinates = user1.turn(user1);
				board1.attackEvent(coordinates, board2,AI,user1);
				if(user1.isHasWon()){
					continue;
				}
				coordinates = AI.turn(AI);
				board2.attackEvent(coordinates, board1, user1, AI);
			}while (user1.isHasWon()== false && user2.isHasWon() == false);
			
			System.out.println("GAME OVER");
			
		}
		
	}
	
	public  int[][] shipPlacement(int[][] placementCoordinates){
		
		for(int i=0; i < placementCoordinates.length;i++){
			System.out.println("Choose row to place ship");
			placementCoordinates[i][0] = i+1;
			System.out.println("Choose column to place ship");			
		}
		
		return placementCoordinates;
		
	}

}
