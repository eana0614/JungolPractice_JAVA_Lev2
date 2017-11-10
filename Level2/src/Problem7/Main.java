package Problem7;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * Problem 7.  Uniqueness
 * 
 *  N개의 문자열이 주어졌을때 동일한 문자열이 존재하는지 판단하는 프로그램을 작성하라
 *  
 */

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int textNum = scanner.nextInt();
		scanner.nextLine();

		String inputs = scanner.nextLine();

		StringTokenizer st = new StringTokenizer(inputs, " ");

		ArrayList<Elements> elements = new ArrayList<>();
		ArrayList<String> strs = new ArrayList<>();

		int count = 1;
		boolean isSame = false;

		while (st.hasMoreTokens()) {

			String tempStr = st.nextToken();

			if (strs.contains(tempStr)) {

				int index = strs.indexOf(tempStr);

				elements.get(index).indexs.add(count);
				isSame = true;

			} else {
				Elements tmp = new Elements(tempStr, count);
				elements.add(tmp);
				strs.add(tempStr);
			}
			count++;
		}

		if (isSame) {
			for (int i = 0; i < elements.size(); i++) {
				elements.get(i).printIndexs();
			}
		} else {
			System.out.println("unique");
		}

	}

	static class Elements {
		String str;
		ArrayList<Integer> indexs = new ArrayList<>();

		public Elements(String str, int n) {
			this.str = str;
			this.indexs.add(n);
		}

		void printIndexs() {
			
			if (indexs.size() > 1) {
				System.out.print(str);
			
				for (int i = 0; i < indexs.size(); i++) {
					System.out.print(" " + indexs.get(i));
				}
				
				System.out.println();
			}
		}

	}
}
