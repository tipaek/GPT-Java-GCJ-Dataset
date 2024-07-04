import java.util.*;

class vestigium {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int cases = sc.nextInt();

      for (int i = 0; i < cases; i++) {

        int n = sc.nextInt();

        int[][] mat = new int[n][n];

        int trace = 0;
        HashSet<Integer> dupRows = new HashSet<>();
        HashSet<Integer> dupCols = new HashSet<>();

        for (int j = 0; j < n; j++) {
          HashSet<Integer> seen = new HashSet<>();
          for (int k = 0; k < n; k++) {
            mat[j][k] = sc.nextInt();
            if (seen.contains(mat[j][k])) {
              dupRows.add(j);
            } else {
              seen.add(mat[j][k]);
            }
            if (j == k) trace += mat[j][k];
          }
        }

        for (int j = 0; j < n; j++) {
          HashSet<Integer> seen = new HashSet<>();
          for (int k = 0; k < n; k++) {
            if (seen.contains(mat[k][j])) {
              dupCols.add(j);
            } else {
              seen.add(mat[k][j]);
            }
          }
        }

        System.out.println("Case #" + (i + 1) + ": " + trace + " " + dupRows.size() + " " + dupCols.size());
      }
    }
}