import java.util.ArrayList;

public class Board {
	int length;
	int width;
	int[][] boardState;

	public int[][] getBoardState() {
		return boardState;
	}

	public void setBoardState(int[][] board) {
		this.boardState = board;
	}

	public Board(int length, int width) {
		super();
		this.length = length;
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void print(Board board) {
		int[][] b1 = board.getBoardState();
		int a = board.getLength();
		int b = board.getWidth();

		System.out.print("____1________2________3________4________6________7________8________9________");
		System.out.println();

		for (int j = 0; j < b; j++) {
			System.out.print((j + 1) + "|");
			for (int i = 0; i < a; i++) {
				if (b1[i][j] == 0) {
					System.out.print("  .      ");
				} else if (b1[i][j] == 1) {
					System.out.print("  .      ");
				} else if (b1[i][j] == 3) {
					System.out.print("  0      ");
				} else {
					System.out.print("  X      ");
				}
			}
			System.out.println();
			System.out.println();
		}
	}

	public void create(Board bo, int a, int b, ArrayList<Ship> shipList, int[][] placementCoordinates, User user) {
		int[][] board = new int[a][b];
		

		System.out.print("____1________2________3________4________6________7________8________9________");
		System.out.println();
		for (int j = 0; j < b; j++) {
			System.out.print((j + 1) + "|");
			for (int i = 0; i < a; i++) {

				board[i][j] = 0;
				System.out.print("  .      ");
			}
			System.out.println();
			System.out.println();
		}

		for (int k = 0; k < shipList.size(); k++) {
			int d = shipList.get(k).getLength();
			int e = shipList.get(k).getWidth();
		
			for (int j = 0; j < e; j++) {
				for (int i = 0; i < d; i++) {
					if (board[i +  placementCoordinates[k][1] - 1][j +placementCoordinates[k][0] - 1] == 0) {
						board[i + placementCoordinates[k][1] - 1][j +  placementCoordinates[k][0] - 1] = 1;
					}
					else{
						System.out.println("SHIP OVERLAP, try new coordinates");
						placementCoordinates= user.shipPlacement(placementCoordinates, shipList);
						
					}

				}
			}
		}

		System.out.print("___________________________");
		System.out.println();

		bo.setBoardState(board);

	}

	// 0 open water, 1 is ship and 2 is hit ship
	public void attackEvent(int[] coordinates, Board board, User userDefend, User userAttack) {
		int[][] boardie = board.getBoardState();
		if (boardie[coordinates[1] - 1][coordinates[0] - 1] == 1) {
			boardie[coordinates[1] - 1][coordinates[0] - 1] = 2;
			board.setBoardState(boardie);
			System.out.println("HIT");

			board.print(board);

			userDefend.setLives(userDefend.getLives() - 1);
			if (userDefend.getLives() == 0) {
				userAttack.setHasWon(true);
				System.out.println(userAttack.getName() + "Wins!");
				return;

			}

			coordinates = userAttack.turn(userAttack);
			board.attackEvent(coordinates, board, userDefend, userAttack);
		} else {
			boardie[coordinates[1] - 1][coordinates[0] - 1] = 3;
			board.setBoardState(boardie);
			System.out.println("MiSS!");
			board.print(board);
		}

	}

}
