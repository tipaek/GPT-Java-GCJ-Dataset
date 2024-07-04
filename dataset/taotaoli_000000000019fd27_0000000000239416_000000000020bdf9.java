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
			System.out.println(method(k));
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
		String hey = "C";
		int[][] c = new int[k.length][2];
		int[][] j = new int[k.length][2];
		int Ccounter = 0;
		int Jcounter = 0;
		c[0][0] = k[0][0];
		c[0][1] = k[0][1];
		
		for (int i = 0; i < k.length - 1; i++) {
			int start1 = k[i + 1][0];
			if (start1 < c[Ccounter][1] && start1 >= c[Ccounter][0]) {
				if (start1 < j[Jcounter][1] && start1 >= j[Jcounter][0]) {
					return "IMPOSSIBLE";
				} else {
					j[Jcounter + 1][0] = k[i + 1][0];
					j[Jcounter + 1][1] = k[i + 1][1];
					Jcounter++;
					hey += "J";
				}
			} else {
				
				c[Ccounter + 1][0] = k[i + 1][0];
				c[Ccounter + 1][1] = k[i + 1][1];
				Ccounter++;
				hey += "C";
			}
		}
		
		String no = "";
		for (int i = 0; i < hey.length(); i++) {
			no += hey.charAt(hi[i]);
		}
		return no;
	}
}