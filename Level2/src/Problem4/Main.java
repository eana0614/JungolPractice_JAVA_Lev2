package Problem4;

import java.util.Scanner;

/*
 * Problem 4. Rook location
 * 
 *  In the chess, rook is able to move horizontal and vertical.
 *  And in the a N*N size chessboard, write program to figure out the maximum number of
 *      rookes that can not be hit by each other.
 *      
 * Input : N (1<=N<=4), chessboard information
 * Output : Maximum number of rookes.
 * 
 */

public class Main {

	static int max = 0;
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		scanner.nextLine();

		String[] inputs = new String[n];

		for (int i = 0; i < n; i++) {
			inputs[i] = scanner.nextLine();
		}

		boolean[][] chassboard = convertArrays(inputs);

		findMaxNumber(chassboard);
	}

	private static void findMaxNumber(boolean[][] chassboard) {

		int startIndex = 0;

		boolean[][] rookboard = new boolean[chassboard.length][chassboard.length];
		
		for(int i=0; i<chassboard.length; i++) {
			for(int j=0; j<chassboard.length; j++) {
				rookboard[i][j] = false;
			}
		}
		
		for (int i = 0; i < chassboard.length; i++) {
			if (!isrowAllWall(chassboard[i])) {
				startIndex = i;
				break;
			}
		}
		
		for(int j=0; j<chassboard.length; j++) {
			
			if(chassboard[startIndex][j]) {
				max = 1;
				rookboard[startIndex][j] = true;
				runRooks(chassboard, startIndex, j, rookboard);
				rookboard[startIndex][j] = false;
			}
			
		}


	}

	private static void runRooks(boolean[][] chassboard, int startIndex, int j, boolean[][] rookboard) {
		
		int tempR, tempD;
		
		if((tempR=hasWallRight(chassboard[startIndex], j)) != -1) {
			rookboard[startIndex][tempR+1] = true;
		}
		
		if((tempD = hasWallDown(chassboard, startIndex, j)) != -1) {
			rookboard[tempD+1][j] = true;
		}
		
		
	}

	private static int hasWallDown(boolean[][] chassboard, int startIndex, int j) {
		
		for(int i=startIndex+1; i<chassboard.length; i++) {
			if(!chassboard[i][j]) {
				return i;
			}
		}
		
		return -1;
	}


	private static int hasWallRight(boolean[] bs, int r) {
		
		for(int i=r+1; i<bs.length; i++) {
			if(!bs[i]) {
				return i;
			}
		}
		return -1;
	}

	private static boolean isrowAllWall(boolean[] bs) {
		
		for(int i=0; i<bs.length; i++) {
			if(bs[i] == true) {
				return false;
			}
		}
		return true;
	}

	private static boolean[][] convertArrays(String[] inputs) {
		int num = inputs.length;

		boolean[][] result = new boolean[num][num];

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {

				if (inputs[i].charAt(j) == '.') {
					result[i][j] = true;
				} else {
					result[i][j] = false;
				}

			}
		}

		return result;
	}

}
