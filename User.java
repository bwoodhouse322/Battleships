import java.util.ArrayList;
import java.util.Scanner;
public class User {
	 Scanner scanner = new Scanner(System.in);
	String name;
	boolean isTurn;
	boolean hasWon;
	int lives;
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
	
	public User(String name, boolean isTurn, boolean hasWon, int lives) {
		super();
		this.name = name;
		this.isTurn = isTurn;
		this.hasWon = hasWon;
		this.lives = lives;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isTurn() {
		return isTurn;
	}
	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}
	public boolean isHasWon() {
		return hasWon;
	}
	public void setHasWon(boolean hasWon) {
		this.hasWon = hasWon;
	}
	
	public  int[][] shipPlacement(int[][] placementCoordinates, ArrayList<Ship> shipList){
		
		for(int i=0; i < placementCoordinates.length;i++){
			System.out.println(this.getName()+ ", Choose a row to place "+ shipList.get(i).getName() + "("+shipList.get(i).getLength() + " across,"+ shipList.get(i).getWidth()+ " down)");
			placementCoordinates[i][0] = scanner.nextInt();
			System.out.println("Now choose a column");	
			placementCoordinates[i][1] = scanner.nextInt();
		}
		
		return placementCoordinates;
		
	}
	
	
	public int[] turn(User user1){
		
		
		System.out.println(user1.getName()+ ", take your shot! choose a column.");
		int column = scanner.nextInt();
		System.out.println("now choose a row,");
		int row = scanner.nextInt();
		//scanner.close();
		
		 return new int[] {row,column};
		
	}
	
	}
