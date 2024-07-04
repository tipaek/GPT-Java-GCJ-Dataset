import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); 
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int sum = 0, rc = 0, cc = 0;
      HashSet<Integer>[] rows = new HashSet<Integer>[n];
      HashSet<Integer>[] cols = new HashSet<Integer>[n];
      for(int c = 0; c < n; c++){
        cols[c] = new HashSet<Integer>();
      }
      for(int r = 0; r < n; r++){
        rows[r] = new HashSet<Integer>();
        for(int c = 0; c < n; c++){
          int m = in.nextInt();
          rows[r].add(m);
          cols[c].add(m);
          if(r == c){
            sum += m;
          }
        }
      }
      for(int j = 0; j < n; j++){
        if(rows[j].size() != n){
          rc++;
        }
        if(cols[j].size() != n){
          cc++;
        }
      }
      System.out.println("Case #" + i + ": " + sum + " " + rc + " " +cc);
    }
  }
}