package Problem8;

import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * Problem 8. Window Management
 * 
 * The initial screen is filled with blanks. ( the number of ASCII 32)
 * 
 * First input is window height and width, 1<= this number <= 100 && height*width <=8000
 * And next input is windows numbers N ( N <= 50)
 * 
 * The vertex of the window is '+', and the top and bottom is '-', and the right and left is '|'.
 * And inside the window is 'X'.
 * 
 * The command for creating windows is [ tlv tlh vs hs fill ]
 * tlv = Vertical location, -100000000 <= tlv <= 100000000 integer
 * tlh = Horizontal location, -100000000 <= tlh <= 100000000 integer
 * vs = vertical length, 2<= vs <= 100000000
 * hs = Horizontal length, 2<= hs <= 100000000
 * fill = character of the inside the window, 33 <= fill (the number of ASCII) <= 126
 * 
 * The init window (full window size) size location is (0,0) ~ (height-1, width-1)
 * If some window gets off init window, output only contents within init window range.
 * If the window overlaps, the window contents generated later ate given priority.
 *  
 */

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int init_window_height = scanner.nextInt();
		int init_window_width = scanner.nextInt();
		int N = scanner.nextInt();
		scanner.nextLine();

		int count = 0;

		char[][] window = createWindow(init_window_height, init_window_width, ' ');

		while (count < N) {

			String temp = scanner.nextLine();
			Windows tmp = convertStringToWindows(temp);

			window = popUpNewWindow(window, tmp);
			count++;
		}

		//printWindow(window);
	}

	private static char[][] createWindow(int init_window_height, int init_window_width, char inside) {

		char[][] result = new char[init_window_height][init_window_width];

		if (inside == ' ') {
			for (int h = 0; h < init_window_height; h++) {
				for (int w = 0; w < init_window_width; w++) {
					result[h][w] = inside;
				}
			}
		} else {
			for (int h = 0; h < init_window_height; h++) {
				for (int w = 0; w < init_window_width; w++) {

					if ((h == 0 || h == init_window_height - 1) && (w == 0 || w == init_window_width - 1)) {
						result[h][w] = '+';
					} else if ((h == 0 || h == init_window_height - 1) && (0 < w && w < init_window_width - 1)) {
						result[h][w] = '-';
					} else if ((h > 0 && h < init_window_height - 1) && (w == 0 || w == init_window_width - 1)) {
						result[h][w] = '|';
					} else {
						result[h][w] = inside;
					}
				}
			}
		}

		return result;
	}

	private static void printWindow(char[][] window) {

		for (int i = 0; i < window.length; i++) {
			for (int j = 0; j < window[0].length; j++) {
				System.out.print(window[i][j]);
			}
			System.out.println();
		}

	}

	private static char[][] popUpNewWindow(char[][] window, Windows tmp) {

		char[][] newWindow = createWindow(tmp.vs, tmp.hs, tmp.fill);

		int new_index_w;
		int init_index_w;
		int range_w;

		int new_index_h;
		int init_index_h;
		int range_h;

		// width overlap
		if (tmp.tlh < window[0].length && tmp.tlh + tmp.hs > 0) {
			if (tmp.tlh < 0) {
				new_index_w = Math.abs(tmp.tlh);
				init_index_w = 0;

				if (tmp.tlh + tmp.hs < window[0].length) {
					range_w = (tmp.tlh + tmp.hs) - init_index_w;
				} else {
					range_w = window[0].length;
				}

			} else {
				new_index_w = 0;
				init_index_w = Math.abs(tmp.tlh);

				if (tmp.tlh + tmp.hs < window[0].length) {
					range_w = newWindow[0].length;
				} else {
					range_w = window[0].length - init_index_w;
				}
			}
		} else {
			new_index_w = -1;
			init_index_w = -1;
			range_w = 0;
		}

		// height overlap
		if (tmp.tlv < window.length) {
			if (tmp.tlv < 0) {
				new_index_h = Math.abs(tmp.tlv);
				init_index_h = 0;

				if (tmp.tlv + tmp.vs < window.length) {
					range_h = (tmp.tlv + tmp.vs) - init_index_h;
				} else {
					range_h = window.length;
				}

			} else {
				new_index_h = 0;
				init_index_h = Math.abs(tmp.tlv);

				if (tmp.tlv + tmp.vs < window.length) {
					range_h = newWindow.length;
				} else {
					range_h = window.length - init_index_h;
				}
			}

		} else {
			new_index_h = -1;
			init_index_h = -1;
			range_h = 0;
		}

		if (range_w != 0 && range_h != 0) {
			window = overlapWindow(window, newWindow, init_index_w, new_index_w, range_w, init_index_h, new_index_h,
					range_h);
		}

		printWindow(window);

		return window;
	}

	private static char[][] overlapWindow(char[][] window, char[][] newWindow, int init_index_w, int new_index_w,
			int range_w, int init_index_h, int new_index_h, int range_h) {


		for (int h = 0; h < range_h; h++) {
			for (int w = 0; w < range_w; w++) {
				window[h + init_index_h][w + init_index_w] = newWindow[h + new_index_h][w + new_index_w];
			}
		}

		return window;
	}

	private static Windows convertStringToWindows(String temp) {

		Windows result = new Windows();

		StringTokenizer stringTokenizer = new StringTokenizer(temp);

		result.tlv = Integer.parseInt(stringTokenizer.nextToken());
		result.tlh = Integer.parseInt(stringTokenizer.nextToken());
		result.vs = Integer.parseInt(stringTokenizer.nextToken());
		result.hs = Integer.parseInt(stringTokenizer.nextToken());
		result.fill = stringTokenizer.nextToken().charAt(0);

		return result;
	}

	static class Windows {

		int tlv;
		int tlh;
		int vs;
		int hs;
		char fill;

	}

}
