import java.util.*;
class Solution {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    int cases = 1;
    while(t-->0) {
      int n = scan.nextInt();
      int s [] = new int[n];
      int e [] = new int[n];
      for(int i = 0; i<n; i++) {
        s[i] = scan.nextInt();
        e[i] = scan.nextInt();
      }
      System.out.println("Case #" + cases + ": " + solve(s, e, n));
      cases++;

    }
  }
  public static String solve(int s[], int e[], int n) { 
      boolean taken [] = new boolean[n];
      Character [] res = new Character[n];
      boolean first = true;
      int start = 0;
      int i, j;   
      i = 0;   
      taken[i] = true;
      res[i] = 'C';
      for (j = 1; j < n; j++) {  //for C
        if (s[j] >= e[i] || e[j] <= s[i]) { 
          i = j; 
          taken[j] = true;
          res[j] = 'C';
        } 
        else {
          if(first) {
            start = j;
            first = false;
          }
        }
      } 
      i = start;
      res[i] = 'J';
      taken[i] = true;
      for (j = 1; j < n; j++) { // for J
        if(taken[j]) {
          continue;
        }
        if (s[j] >= e[i] || e[j] <= s[i]) { 
          i = j; 
          taken[j] = true;
          res[j] = 'J';
        } 
        else {
          return "IMPOSSIBLE";
        }
      } 
      String sr = "";
      for(char val : res) {
        sr += val;
      }
      return sr;
  } 
}