package Problem8;

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
		
		
		int init_window_height;
		int init_window_width;
		int N;
		

	}

}
