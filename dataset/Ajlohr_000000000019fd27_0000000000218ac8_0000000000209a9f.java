import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int ca = 1; ca <= t; ++ca) {
      String seq = in.next();
      String[] nums_t = seq.split("");
      int[] nums = new int[seq.length()];
      for(int i=0;i<seq.length();i++)
      {
          nums[i] = Integer.parseInt(nums_t[i]);
      }
      StringBuilder output = new StringBuilder();
      int depth = 0;
      for(int i=0;i<nums.length;i++)
      {
          for(int j=0;j<nums[i]-depth;j++)
          {
              output.append('(');
          }
          for(int j=0;j<depth-nums[i];j++)
          {
              output.append(')');
          }
          depth = nums[i];
          output.append(nums_t[i]);
      }
      for(int i=0;i<depth;i++)
      {
          output.append(')');
      }
      
      System.out.println("Case #" + ca + ": " + output.toString());
    }
  }
}