import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
   Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int i = 1; i <= t; i++) {

			int n = scn.nextInt();
			int mat[][] = new int[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					mat[j][k] = scn.nextInt();
				}
			}
			int trace = 0;
			int nrow = 0;
			int ncol = 0;
			for (int g = 0; g < n; g++) {
				trace += mat[g][g];
			}
			for (int j = 0; j < n; j++) {
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				for (int k = 0; k < n; k++) {
					if (map.containsKey(mat[j][k])) {
						nrow++;
						break;
					} else {
						map.put(mat[j][k], 1);
					}
				}
			}
			for (int j = 0; j < n; j++) {
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				for (int k = 0; k < n; k++) {
					if (map.containsKey(mat[k][j])) {
						ncol++;
						break;
					} else {
						map.put(mat[k][j], 1);
					}
				}
			}

			System.out.println("Case #" + i + ":" + trace + " " + nrow + " " + ncol);
		}
    }
  }
