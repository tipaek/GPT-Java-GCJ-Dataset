import java.util.*;

class Solution{
  public static void main(String[] args) {
    Scanner x = new Scanner(System.in);
    int t = x.nextInt();
    int n = 2;
    for(int z=1; z<=t; z++){
      n = x.nextInt();

      long m[][] = new long[n][n];
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          m[i][j] = x.nextLong();
        }
      }

      long k = 0;
      for(int i=0;i<n;i++){
        k = k + m[i][i];
      }

      int r = 0;
      int c = 0;
      for(int i=0;i<n;i++){
        HashSet<Long> row = new HashSet<>();
        HashSet<Long> column = new HashSet<>();
        for(int j=0;j<n;j++){
          row.add(m[i][j]);
          column.add(m[j][i]);
        }
        if(row.size() != n){
          r++;
        }
        if(column.size() != n){
          c++;
        }
      }
      System.out.println("Case #"+z+": "+k+" "+r+" "+c);

    }

    x.close();
  }
}

