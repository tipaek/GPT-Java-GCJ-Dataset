import java.util.*;
import java.io.*;
   
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int num = in.nextInt();
			int [][] darr = new int[num][num]; 
			
			for(int y = 0; y<num; y++) {
				for(int x = 0; x<num; x++) {
					darr[y][x]= in.nextInt();
				}
			}
			
			int tot = 0;
			for(int dia = 0; dia<num; dia++) {
				tot += darr[dia][dia];
			}
			
			int ncol = 0;
			boolean bcol = false;
			for(int col = 0; col<num; col++) {
				bcol = false;
				for(int currow = 0; currow<(num-1); currow++) {
					for(int chkrow = currow+1; chkrow<num; chkrow++) {
						if(darr[chkrow][col] == darr[currow][col]) {
							bcol = true;
						}
					}
				}
				if(bcol)
					ncol++;
			}
			
			int nrow = 0;
			boolean brow = false;
			for(int row = 0; row<num; row++) {
				brow = false;
				for(int curcol = 0; curcol<(num-1); curcol++) {
					for(int chkcol = curcol+1; chkcol<num; chkcol++) {
						if(darr[row][chkcol] == darr[row][curcol]) {
							brow = true;
						}
					}
				}
				if(brow)
					nrow++;
			}
			
			
			System.out.println("Case #" + i + ": " + tot + " " + nrow + " " + ncol);
		}
	}

}
