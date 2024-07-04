import java.util.*; 

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in); 

    int numT = in.nextInt();
    for(int t=0; t<numT; t++) {
      int n = in.nextInt(); 
      int[][] grid = new int[n][n];
      int trace = 0;
      HashSet<Integer>[] cols = new HashSet[n];
      HashSet<Integer>[] rows = new HashSet[n];
      for(int i=0; i<n; i++) {
        cols[i] = new HashSet<>();
        rows[i] = new HashSet<>();
      }
      for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
          grid[i][j] = in.nextInt();
          if(i==j) trace += grid[i][j]; 
          cols[j].add(grid[i][j]); 
          rows[i].add(grid[i][j]);
        }
      }

      int numBadCols = 0;
      int numBadRows = 0;
      for(int i=0; i<n; i++) {
        if(cols[i].size() != n) numBadCols++; 
        if(rows[i].size() != n) numBadRows++;
      }

      System.out.printf("Case #%d: %d %d %d\n", t, trace, numBadRows, numBadCols);
    }
  }
}

/* 

3
4
1 2 3 4
2 1 4 3
3 4 1 2
4 3 2 1
4
2 2 2 2
2 3 2 3
2 2 2 3
2 2 2 2
3
2 1 3
1 3 2
1 2 3

Case #1: 4 0 0
Case #2: 9 4 4 
Case #3: 8 0 2



*/