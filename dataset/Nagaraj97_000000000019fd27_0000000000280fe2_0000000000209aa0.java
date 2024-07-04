
import java.util.*;
import java.io.*;
public class Solution {
  public static ArrayList<String> pert;
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = sc.nextInt();
    for (int k = 1; k <= t; k++) {
      int n = sc.nextInt();
      int req_trace = sc.nextInt();
      pert = new ArrayList<String>();
      int trace = 0;
      int arr[][] = new int[n][n];
      boolean found = false;
      getPermut(n);
      int size = pert.size();
      for(int z = 0; z < size; z++){
        for(int i = 0; i < n; i++){
          arr[0][i] = pert.get(z).charAt(i) - '0';
        }
        trace = arr[0][0];
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
          found = true;
          break;
        }
      }
      if(!found){
        System.out.println("Case #" + k + ": " + "IMPOSSIBLE");
      }
      else{
        System.out.println("Case #" + k + ": " + "POSSIBLE");
        for(int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
            if(j == n-1){
              System.out.print(arr[i][j]);
            }
            else{
              System.out.print(arr[i][j]+" ");
            }
          }
          System.out.println("");
        }
      }
      //System.out.println("Case #" + k + ": " + s);
    }
  }
  public static void getPermut(int n){
    StringBuilder str = new StringBuilder(n);
    for(int i = 1; i <= n; i++){
      str.append(i);
    }
    //System.out.println("P"+str.toString());
    permut(str.toString(), 0, n-1);
  }
  public static void permut(String str, int s,int f){
    if(s == f){
      pert.add(str);
      //System.out.println("PER"+str);
      return;
    }
    for(int i = s; i <= f; i++){
      str = swap(str,s,i);
      permut(str,s+1,f);
      str = swap(str,s,i);
    }
  }
  public static String swap(String str,int i,int j){
    char temp = str.charAt(i);
    StringBuilder s = new StringBuilder(str);
    s.setCharAt(i, s.charAt(j));
    s.setCharAt(j, temp);
    return s.toString();
  }
}
