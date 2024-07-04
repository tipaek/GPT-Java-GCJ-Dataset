
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = sc.nextInt();
    for (int k = 1; k <= t; k++) {
      int n = sc.nextInt();
      int req_trace = sc.nextInt();
      int trace = 1;
      int arr[][] = new int[n][n];
      for(int i = 0; i < n; i++){
        arr[0][i] = (i+1);
      }
      for(int i = 1; i < n; i++){
        for(int j = 0; j < n; j++){
          if(arr[i-1][j] != n){
            arr[i][j] = arr[i-1][j] + 1;
          }
          else{
            arr[i][j] = 1;
          }
        }
        trace+=arr[i][i];
      }
      if(trace == req_trace){
        System.out.println("Case #" + k + ": " + "POSSIBLE");
        for(int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
            System.out.print(arr[i][j]+" ");
          }
          System.out.println("");
        }
      }
      else{
        System.out.println("Case #" + k + ": " + "IMPOSSIBLE");
      }
      //System.out.println("Case #" + k + ": " + s);
    }
  }
}
