package Problem5;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Problem 5. Domino 
 * 
 * There are N dominoes. Each domino is a rectangle and is divided above and bottom.
 * And numbers are written above part and bottom.
 * 
 * Write a program that print the max sum value of the two numbers.
 * The two numbers are sum of the above parts and sum of the bottom parts.
 * Example, if dominoes are [1,2] and [3, 4], 
 * 			number of cases the sum of above parts are 13, 31
 * 			and number of case the sum of bottom parts are 24, 42.
 * 
 *  Anyway, sort the dominoes and print max sum value.
 *  
 *  Input : N (number of dominoes, 1<= N <= 40), Domino Data 
 *  		>> written number range the dominoes = 0 ~ 9
 *  Output : Max value
 *  
 */

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		int tempAbove;
		int tempBottom;

		Pair[] domino = new Pair[n];

		for (int i = 0; i < n; i++) {
			tempAbove = scanner.nextInt();
			tempBottom = scanner.nextInt();
			domino[i] = new Pair(tempAbove, tempBottom);
		}

		String result = findMaxValue(domino);
		// perm(above, bottom, n, n);

		System.out.println(result);

	}

	private static String findMaxValue(Pair[] domino) {

		// sort
		Arrays.sort(domino);

		int up = 0;
		String sum = "";

		for (int i = domino.length - 1; i >= 0; i--) {

			int temp = domino[i].above + domino[i].bottom + up;

			if (i != 0) {
				
				if (temp  >= 10) {
					up = temp / 10;
					temp = temp % 10;
				} else {
					up = 0;
				}
			}

			sum = temp + sum;
		}

		if (isValueZero(sum)) {
			sum = "0";
		}

		return sum;

	}

	private static boolean isValueZero(String sum) {
		
		for(int i=0; i<sum.length(); i++) {
			if(sum.charAt(i) != '0') {
				return false;
			}
		}
		return true;
	}

	static class Pair implements Comparable<Pair> {
		int above;
		int bottom;
		int differenceValue;

		public Pair(int ab, int bo) {
			this.above = ab;
			this.bottom = bo;
			this.differenceValue = Math.abs(ab - bo);
		}

		@Override
		public int compareTo(Pair o) {

			if (this.above + this.bottom > o.above + o.bottom) {
				return -1;
			} else if (this.above + this.bottom < o.above + o.bottom) {
				return 1;
			} else {

				if (this.differenceValue > o.differenceValue) {
					return 1;
				} else if (this.differenceValue < o.differenceValue) {
					return -1;
				} else {
					return 0;
				}

			}
		}
	}

	/*
	 * private static void perm(int[] above, int[] bottom, int n, int r) {
	 * 
	 * if (r == 0) { storageCases(above, bottom); }
	 * 
	 * for (int i = n - 1; i >= 0; i--) { above = swap(above, i, n - 1); bottom =
	 * swap(bottom, i, n - 1);
	 * 
	 * perm(above, bottom, n - 1, r - 1);
	 * 
	 * above = swap(above, i, n - 1); bottom = swap(bottom, i, n - 1); }
	 * 
	 * }
	 * 
	 * private static int[] swap(int[] array, int i, int j) {
	 * 
	 * int temp = array[i];
	 * 
	 * array[i] = array[j]; array[j] = temp;
	 * 
	 * return array; }
	 * 
	 * private static void storageCases(int[] above, int[] bottom) {
	 * 
	 * String aStr="", bStr="";
	 * 
	 * for(int i= above.length-1; i>=0; i--) { aStr +=above[i]; bStr +=bottom[i]; }
	 * 
	 * int up = 0; String sum = "";
	 * 
	 * for(int i=aStr.length()-1; i>=0; i--) {
	 * 
	 * int temp =
	 * Integer.parseInt(aStr.charAt(i)+"")+Integer.parseInt(bStr.charAt(i)+"");
	 * 
	 * if((temp+up) >= 10) { up = (temp+up) / 10; temp = (temp+up) % 10; }else { up
	 * = 0; temp = temp+up; }
	 * 
	 * sum = sum+temp; }
	 * 
	 * System.out.println(aStr + " | "+bStr);
	 * 
	 * 
	 * if (max.length() < sum.length()) { max = sum; }else if (max.length() ==
	 * sum.length()) {
	 * 
	 * boolean isbig = false;
	 * 
	 * for(int i=0; i<max.length(); i++) { if(sum.charAt(i) > max.charAt(i)) { isbig
	 * = true; break; } }
	 * 
	 * if(isbig) { max = sum; }
	 * 
	 * }
	 * 
	 * }
	 */
}