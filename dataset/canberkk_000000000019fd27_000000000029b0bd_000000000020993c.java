import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    int cases = in.nextInt();

    for (int c = 1; c <= cases; c++) {
      String answer = "Case #" + c + ": ";

      int N = in.nextInt();
      int[][] matrix = new int[N][N];
      int counts[];
      int trace = 0;
      int row = 0;
      int col = 0;
      for (int i = 0; i < N; i++) {
        counts = new int[N];
        for (int j = 0; j < N; j++) {
          int n = in.nextInt();
          matrix[i][j] = n;
          counts[n-1]++;
          if(i==j) trace += n;
        }
        int j = 0;
        while (j<N && counts[j] != 0) j++;
        if(j != N) row++;
      }
      for (int i = 0; i < N; i++) {
        counts = new int[N];
        for (int j = 0; j < N; j++) {
          counts[matrix[j][i]-1]++;
        }
        int j = 0;
        while (j<N && counts[j] != 0) j++;
        if(j != N) col++;
      }
      out.println(answer + trace + " " + row +" " + col);
    }
    in.close();
    out.close();
  }
}