import java.io.*;
import java.util.*;

public class Vestigium {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int runs = Integer.parseInt(sc.nextLine().trim());
    for (int run = 1; run <= runs; run++) {
      int N = Integer.parseInt(sc.nextLine().trim());

      boolean[][] rows = new boolean[N][N];
      boolean[][] cols = new boolean[N][N];
      Set<Integer> rowDupes = new HashSet<Integer>();
      Set<Integer> colDupes = new HashSet<Integer>();
      int diag = 0;

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          int val = sc.nextInt();

          if (rows[i][val - 1]) {
            rowDupes.add(i);
          }

          if (cols[j][val - 1]) {
            colDupes.add(j);
          }

          if (i == j) {
            diag += val;
          }

          rows[i][val - 1] = true;
          cols[j][val - 1] = true;
        }
        if (sc.hasNextLine()) {
          sc.nextLine();
        }
      }

      System.out.printf("Case #%d: %d %d %d\n", run, diag, rowDupes.size(), colDupes.size());
    }
  }
}