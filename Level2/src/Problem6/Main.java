package Problem6;

import java.util.Scanner;

/*
 * Problem 6. PERKET
 * 
 * N개의 재료가 주어지고 S는 신맛, B는 쓴맛을 뜻한다고 할때, 
 * 신맛은 각 신맛 재료이 신맛 지수를 곱한 값이고 쓴맛의 합은 우리가 선택한 재료의 쓴맛 지수들을 더한 값이다
 * 하지만 퍼킷은 신맛도 쓴맛도 나지 않기 때문에 신맛의 합과 쓴맛의 합의 차가 최소가 되도록 하고자 한다.
 * 적어도 하나 이상의 재료를 선택해야 하고 물은 사용할 수 없다.
 * 
 * 입력 : 요리에 사용될 재료의 수 N, 각 재료의 S와 B
 * 		모든 재료를 넣어 요리를 만들떄 신맛의 곱이나 쓴맛의 합은 모두 10억을 넘지 않는다.
 * 출력 : 신맛의 곱과 쓴맛의 합 사이의 가능한 가장 작은 차를 출력
 * 
 */

public class Main {

	static int min = 1000000000;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		int[] s = new int[n];
		int[] b = new int[n];
		
		for(int i=0; i<n; i++) {
			
			s[i] = scanner.nextInt();
			b[i] = scanner.nextInt();
			
		}
		
		
		findMinDifference(0, 1, 0, s, b);
		System.out.println(min);
		
	}

	private static void findMinDifference(int i, int mulValue, int sumValue, int[] s, int[] b) {
		
		for(int j=i; j<s.length; j++) {
			int temp = mulValue * s[j] - (sumValue+b[j]);
			
			if(Math.abs(temp) < min) {
				min = Math.abs(temp);
			}
			
			findMinDifference(j+1, mulValue*s[j], sumValue+b[j], s, b);
			
		}
		
	}

}
