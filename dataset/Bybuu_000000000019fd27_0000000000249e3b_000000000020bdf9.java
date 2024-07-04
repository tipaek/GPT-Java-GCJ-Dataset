import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Solution {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int recursive = scanner.nextInt();
		for (int r = 0; r<recursive; r++) {
			int n = scanner.nextInt();
			int[][] arSh = new int[n][2];
			for(int i=0;i<n;i++) {
					arSh[i][0] = scanner.nextInt();
					arSh[i][1] = scanner.nextInt();
			}
			int temp;
			int temp2;
			for (int i = 1; i < n; i++) {
				for (int j = i; j > 0; j--) {
					if (arSh[j][0] < arSh [j - 1][0]) {
					  temp = arSh[j][0];
					  temp2 = arSh[j][1];
					  arSh[j][0] = arSh[j - 1][0];
					  arSh[j - 1][0] = temp;
					  arSh[j][1] = arSh[j - 1][1];
					  arSh[j - 1][1] = temp2;
					}
				}
	 	    }
			int C = -1;
			int J = -1;
			StringBuilder sb = new StringBuilder("");
			for (int i = 0; i < n; i++) {
				if (C<=arSh[i][0]) {
					C = arSh[i][1];
					sb.append("C");
				} else if (J<=arSh[i][0]){
					J = arSh[i][1];
					sb.append("J");
				} else {
					sb = new StringBuilder("IMPOSSIBLE");
					break;
				}
	 	    }
			System.out.println("Case #" + (r+1) + ": "+sb.toString());
		}
	}
}