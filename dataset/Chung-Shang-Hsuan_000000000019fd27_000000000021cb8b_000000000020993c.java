import java.util.*;

public class Solution{

  int[][] arr;
  int n;
  int k;
  int r;
  int c;

  public Solution(int n, Scanner sc){
    this.n = n;
    arr = new int[n][n];
    r = 0;
    for (int i = 0; i < n; i ++){
      HashSet<Integer> set = new HashSet<Integer>(n);
      for (int j = 0; j < n; j ++){
        arr[i][j] = sc.nextInt();
        set.add(arr[i][j]);
      }
      if (set.size() < n) r ++;
    }
    k = 0;
    for (int i = 0; i < n; i ++){
      k += arr[i][i];
    }
    c = 0;
    for (int i = 0; i < n; i ++){
      HashSet<Integer> setc = new HashSet<Integer>(n);
      for (int j = 0; j < n; j ++){
        setc.add(arr[j][i]);
      }
      if (setc.size() < n) c ++;
    }
  }

  public static void main(String args[]){
    Scanner sc1 = new Scanner(System.in);
    int cases = sc1.nextInt();
    for (int c = 1; c < cases+1; c ++){
      int numHouses = sc1.nextInt();
      Solution b = new Solution(numHouses,sc1);
      System.out.println("Case #" + c + ": " + b.k + " " + b.r + " " + b.c);
    }
  }
}