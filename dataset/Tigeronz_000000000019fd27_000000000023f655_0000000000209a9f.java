import java.util.*;
import java.io.*;
public class Solution
{
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(in.readLine());
    for (int i = 0; i < T; i++) {
      String s = in.readLine();
      int N = s.length();
      int[] nums = new int[N];
      
      for (int j = 0; j < N; j++)
      {
        nums[j] = Integer.parseInt(s.substring(j,j+1));
      }
      
      String ans = "";
      int pre = nums[0];
      
      for (int k=0; k < pre; k++){
        ans += "(";
      }
      ans += pre;
      
      for (int j = 1; j < N; j++)
      {
        int dif = nums[j] - pre;
        
        //bigger than pre
        for (int k=0; k < dif; k++){
          ans += "(";
        }
        //smaller than pre
        for (int k=0; k > dif; k--){
          ans += ")";
        }
        
        pre = nums[j];
        ans += pre;
      }
      for (int k=0; k < pre; k++){
        ans += ")";}
      
      System.out.println ("Case #" + (i+1) + ": " + ans);
    }
  }
}