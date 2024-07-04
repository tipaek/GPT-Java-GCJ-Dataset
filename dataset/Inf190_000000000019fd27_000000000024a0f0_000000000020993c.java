import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) {
      Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      int tCount = sc.nextInt();
      for (int t = 1; t <= tCount; t++) {
          int n = sc.nextInt();
            int[][] arr = new int[n][n];

            // Input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();
            }

            int[][] arrRows = new int[n][101], arrColumns = new int[n][101];
            int trace = 0, rRepeated = 0, cRepeated = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = arr[i][j];
                    if (i == j)
                        trace += num;
                    arrRows[i][num]++;
                    arrColumns[j][num]++;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < 101; j++) {
                    if (arrRows[i][j] > 1) {
                        rRepeated++;
                        break;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < 101; j++) {
                    if (arrColumns[i][j] > 1) {
                        cRepeated++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + rRepeated + " " + cRepeated);
      }
      sc.close();
  }
}