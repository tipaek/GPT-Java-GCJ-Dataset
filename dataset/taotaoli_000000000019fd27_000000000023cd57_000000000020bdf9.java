import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner file = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = file.nextInt();
		for (int i = 1; i <= t; i++) {
			int t1 = file.nextInt();
			int[][] k = new int[t1][2];
			for (int j = 0; j < t1; j++) {
				for (int j2 = 0; j2 < 2; j2++) {
					k[j][j2] = file.nextInt();
				}
			}
			System.out.println("Case #" + i + ": " + method(k));
		}
	}

	public static String method(int[][] k) {
		
		int[][]heyy = new int[k.length][k[0].length];
		int[] hi = new int[k.length];
		for (int i = 0; i < k.length; i++) {
			for (int l = 0; l < k[0].length; l++) {
				heyy[i][l] = k[i][l];
				hi[i] = i;
			}
		}
		
		for (int i = 0; i < k.length; i++) {
			for (int l = 0; l < k.length - 1; l++) {
				if (heyy[l][0] > heyy[l + 1][0]) {
					int[] temp = heyy[l];
					heyy[l] = heyy[l + 1];
					heyy[l + 1] = temp;
					int tempp = hi[l];
					hi[l] = hi[l + 1];
					hi[l + 1] = tempp;
				}
			}
		}
		k = heyy;
		
		String hey = "";
		int J = 0;
		int C = 0;
		
		for (int i = 0; i < k.length; i++) {
	        if (J <= k[i][0]){
	            J = k[i][1];
	            hey += "J";
	        }
	        else if( C <= k[i][0]) {
	            C = k[i][1];
	            hey += "C";
	        }
	        else {
	            return "IMPOSSIBLE";
	        }
		}
		String no = "";
		for (int i = 0; i < hi.length; i++) {
			no += hey.charAt(hi[i]);
		}
		return no;
	}
}
