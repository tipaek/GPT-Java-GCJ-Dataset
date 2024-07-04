import java.util.*;  

public class Solution {
  public static void solve(int[][] arr, int n, int ks) {
    int sum = 0, k = 0, r = 0, c = 0;
    for(int i=0; i < n; i++){
        k += arr[i][i];
    }
    
    for(int i=0; i < n; i++){
        HashSet<Integer> set = new HashSet<Integer>();
        for(int j=0; j < n; j++){
            if(set.contains(arr[i][j])){
                r++;
                break;
            } else {
                set.add(arr[i][j]);
            }
        }
    }
    
    for(int i=0; i < n; i++){
        HashSet<Integer> set = new HashSet<Integer>();
        for(int j=0; j < n; j++){
            if(set.contains(arr[j][i])){
                c++;
                break;
            } else {
                set.add(arr[j][i]);
            }
        }
    }
     
System.out.println("Case #"+ks+": "+k+" "+r+" "+c);
  }

  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      int n = input.nextInt();
      int[][] arr = new int[n][n];
      for(int i=0; i < n; i++){
        for(int j=0; j < n; j++){
            arr[i][j] = input.nextInt();   
        }
      }
      solve(arr, n, ks);
    }
  }
}
