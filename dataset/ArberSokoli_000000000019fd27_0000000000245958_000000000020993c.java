import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) {
      try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
         int t = Integer.parseInt(sc.nextLine());
         int[] k = new int[t];
         int[] r = new int[t];
         int[] c = new int[t];
         for(int t0 = 0; t0 < t; t0++) {
            int n = Integer.parseInt(sc.nextLine());
            int[][] m = new int[n][n];
            for(int i = 0; i < n; i++) {
               boolean row = false;
               String[] arrOfStr = sc.nextLine().split(" ");
               for(int j = 0; j < n; j++) {
                  m[i][j] = Integer.parseInt(arrOfStr[j]);
                  if(i == j) {
                     k[t0] += m[i][j];
                  }
                  if(!row) {
                     for(int z = j -1; z >= 0; z--) {
                        if(m[i][j] == m[i][z]) {
                           row = true;
                        }
                     }
                  }
               }
               if(row) {
                  r[t0]++;
               }
            }
            for(int j = 0; j < n; j++) {
               boolean col = false;
               for(int i = 1; i < n; i++) {
                  if(!col) {
                     for(int z = i -1; z >= 0; z--) {
                        if(m[i][j] == m[z][j]) {
                           col = true;
                        }
                     }
                  }
               }
               if(col) {
                  c[t0]++;
               }
            }
            
            System.out.println("Case #" + (t0 + 1) + ": " + k[t0] + " " + r[t0] + " " + c[t0]);
         }
      }
	}
}