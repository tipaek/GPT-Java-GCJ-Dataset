import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		StringBuffer sb = new StringBuffer();
		
		int[] cB = new int[10000];
		int ci = 1;
		int[] cF = new int[10000];
		boolean actIsPossibleC = true;
		
		int[] jB = new int[10000];
		int ji = 1;
		int[] jF = new int[10000];
		boolean actIsPossibleJ = true;
 		
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			for (int j = 1; j <= n; j++) {
				int beg = in.nextInt();
				int fin = in.nextInt();
				
				for(int k = 0; k < ci; k++) {
					if(fin<=cB[k] || beg>=cF[k]) {
						
					}else {
						actIsPossibleC = false;
					}
				}if(actIsPossibleC) {
					cB[ci] = beg;
					cF[ci] = fin;
					ci++;
					sb.append('C');
				}else {
					for(int k = 0; k < ji; k++) {
						if(fin<=jB[k] || beg>=jF[k]) {
							
						}else {
							actIsPossibleJ = false;
						}
					}if(actIsPossibleJ) {
						jB[ji] = beg;
						jF[ji] = fin;
						ji++;
						sb.append('J');
						actIsPossibleC = true;
					}
				}
			}	
			if(!actIsPossibleC && !actIsPossibleJ) {
				System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
			}else {
				System.out.println("Case #" + i + ": " + sb.toString());
			}
			cB = new int[10000];
			ci = 1;
			cF = new int[10000];
			actIsPossibleC = true;
			
			jB = new int[10000];
			ji = 1;
			jF = new int[10000];
			actIsPossibleJ = true;
			sb = new StringBuffer();
		}
	}
}