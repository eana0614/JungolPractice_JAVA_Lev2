package Problem1;

import java.util.Scanner;

/*
 * Problem 1. 911  
 * 
 * Input map size, map information and goal point location.
 * (0,0) is the starting point. And find the fastest way to reach the goal point.
 * 
 *  Print the number of turns of the corner while moving the way.
 *  
 *  Input
 *  	>> Map size : M (1<= M <= 100) , N (1<=N<=100)
 *  	>> goal point : m , n 
 *  	>> Map information : only contain of 0, 1 
 *  						0 : wall, 1 : ways
 *  
 */

public class Main {

	static int[][] map;
	static int min = Integer.MAX_VALUE;
	
	static int UP = 1;
	static int DOWN = 2;
	static int RIGHT = 3;
	static int LEFT = 4;
	static int NONE = 0;
			
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int M = scanner.nextInt();
		int N = scanner.nextInt();

		int m = scanner.nextInt() - 1;
		int n = scanner.nextInt() - 1;

		map = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = scanner.nextInt();
			}
		}

		findWay(m, n, 0, NONE);
		
		System.out.println(min);
	}

	private static void findWay(int x, int y, int count, int vector) {

		if(x == 0 && y == 0) {
			if(min > count ) {
				min = count;
				return ;
			}
		}
		
		map[x][y] = 0;
		
		//go up
		if(y > 0 && map[x][y-1] != 0) {
			if(vector != UP) {
				findWay(x, y-1, count+1, UP);
			}else {
				findWay(x, y-1, count, UP);
			}
		}
		
		//go down
		if(y < map[0].length-1 && map[x][y+1] != 0) {
			if(vector != DOWN) {
				findWay(x, y+1, count+1, DOWN);
			}else {
				findWay(x, y+1, count, DOWN);
			}
		}
		
		//go right
		if(x < map.length-1 && map[x+1][y] != 0) {
			if(vector != RIGHT) {
				findWay(x+1, y, count+1, RIGHT);
			}else {
				findWay(x+1, y, count, RIGHT);
			}
		}
		
		//go left
		if( x > 0 && map[x-1][y] != 0) {
			if(vector != LEFT) {
				findWay(x-1, y, count+1, LEFT);
			}else {
				findWay(x-1, y, count, LEFT);
			}
		}
		
		map[x][y] = 1;
	}

}
