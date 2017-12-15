package Problem10;

import java.util.Scanner;

/*
 * Problem 10. Relatively Prime
 * 
 * Write a program that print the number of relatively-prime for N.
 * 
 * There are several test cases.
 * And when zero is input program, program is quit.
 * 
 * N <= 1000000000
 * 
 */

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		
		while(N != 0) {
			
			int result = countRelatvelyPrime(N);
			System.out.println(result);
			
			N = scanner.nextInt();
			
		}

	}

	private static int countRelatvelyPrime(int n) {

		int t_count = 0;
		int count = 0;
		
		for(int t=2; t<=n; t++) {
			for(int i=2; i<=n; i++) {
				if(n%i == 0 && t%i == 0) {
					t_count++;
				}
			}
			
			if(t_count <= 0) {
				count++;;
			}
			
			t_count = 0;
		}	
		return count+1;
	}

}
