import java.util.*;
import java.io.*;
   
class Vestigum {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int num = in.nextInt();
			int [][] darr = new int[num][num]; 
			
			for(int y = 0; y<num; y++) {
				for(int x = 0; x<num; x++) {
					darr[x][y]= in.nextInt();
				}
			}
			
			int tot = 0;
			for(int dia = 0; dia<num; dia++) {
				tot = darr[dia][dia];
			}
			
			int ncol = 0;
			boolean bcol = false;
			for(int col = 0; col<ncol; col++) {
				bcol = false;
				for(int currow = 0; currow<(num-1); currow++) {
					for(int chkrow = currow+1; chkrow<num; chkrow++) {
						if(darr[col][chkrow] == darr[col][currow]) {
							bcol = true;
							break;
						}
					}
				}
				if(bcol)
					ncol++;
			}
			
			int nrow = 0;
			boolean brow = false;
			for(int row = 0; row<nrow; row++) {
				brow = false;
				for(int curcol = 0; curcol<(num-1); curcol++) {
					for(int chkcol = curcol+1; chkcol<num; chkcol++) {
						if(darr[chkcol][row] == darr[curcol][row]) {
							brow = true;
							break;
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
