import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = sc.nextInt();
    for (int k = 1; k <= t; k++) {
      int n = sc.nextInt();
      int trace = 0,row_dup = 0,col_dup = 0;
      int arr[][] = new int[n][n];
      HashSet<Integer> hset = new HashSet<Integer>();
      for(int i = 0; i < n; i++){
        hset = new HashSet<Integer>();
        boolean dup = false;
        for(int j = 0; j < n; j++){
          arr[i][j] = sc.nextInt();
          if(hset.contains(arr[i][j])){
            dup = true;
          }
          else{
            hset.add(arr[i][j]);
          }
        }
        if(dup){
          row_dup+=1;
        }
        trace+=arr[i][i];
      }
      for(int i = 0; i < n; i++){
        hset = new HashSet<Integer>();
        boolean dup = false;
        for(int j = 0; j < n; j++){
          if(hset.contains(arr[j][i]) && !dup){
            dup = true;
          }
          else{
            hset.add(arr[j][i]);
          }
        }
        if(dup){
          col_dup+=1;
        }
      }
      System.out.println("Case #" + k + ": " + trace+ " " + row_dup+ " "+col_dup);
    }
  }
}