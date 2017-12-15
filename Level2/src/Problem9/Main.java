package Problem9;

import java.util.Scanner;

/*
 * Problem 9. MCS
 * 
 * When input some DNA sequence string. 
 * Even if substring of length k different orders, 
 * treat two substring as similar if the frequency of each character is matched.
 * Print the most frequent frequencies for substring of length k.
 * 
 * First input is k. ( 1<= k <= 1000)
 * And next input is String consist of A, C, G, T of length below 60000.
 * 
 * Output : Number of max frequencies substring of length k.
 * 
 */

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int k = scanner.nextInt();
		scanner.nextLine();

		String dna = scanner.nextLine();

		int max = findMaxFrequency(dna, k);

		System.out.println(max);
	}

	private static int findMaxFrequency(String dna, int k) {

		int max = 0;

		int element_size = dna.length() - k + 1;

		String[] element = divideElement(dna, k, element_size);

		for (int i = 0; i < element_size; i++) {
			int count = 1;

			for (int j = i + 1; j < element_size; j++) {
				if (element[i].equals(element[j])) {
					count++;
				}
			}

			if (count <= element_size / 2 && count > max) {
				max = count;
			} else if (count > element_size / 2) {
				max = count;
				break;
			}

		}

		return max;
	}

	private static String[] divideElement(String dna, int k, int element_size) {

		String[] result = new String[element_size];

		for (int i = 0; i < element_size; i++) {

			String tmp = dna.substring(i, k + i);
			int a = 0;
			int c = 0;
			int g = 0;
			int t = 0;

			for (int j = 0; j < tmp.length(); j++) {
				if (tmp.charAt(j) == 'A') {
					a++;
				} else if (tmp.charAt(j) == 'C') {
					c++;
				} else if (tmp.charAt(j) == 'G') {
					g++;
				} else {
					t++;
				}
			}

			result[i] = a + " " + c + " " + g + " " + t;
		}

		return result;
	}
}
