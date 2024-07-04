import java.util.*;
import java.io.*;
public class Solution {
    static int[] hi;
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
			k = sort(k);
			
			if(method(k) == "IMPOSSIBLE")
				System.out.println("Case #" + i + ": " + method(k));
			else {
				String no = "";
				for (int j = 0; j < method(k).length(); j++) {
					no += method(k).charAt(hi[j]);
				}
				System.out.println("Case #" + i + ": " + no);
			}
		}
	}

	public static String method(int[][] k) {
		/*
		*/
		String hey = "";
		int J = 0;
		int C = 0;
		
		for (int i = 0; i < k.length; i++) {
	        if (C <= k[i][0]){
	            C = k[i][1];
	            hey += "C";
	        }
	        else if( J <= k[i][0]) {
	            J = k[i][1];
	            hey += "J";
	        }
	        else {
	        	hey = "IMPOSSIBLE";
	            break;
	        }
		}
		
		return hey;
	}
	public static int[][] sort(int[][] k) {
		int[][]heyy = new int[k.length][k[0].length];
		hi = new int[k.length];
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
		return heyy;
	}
}
