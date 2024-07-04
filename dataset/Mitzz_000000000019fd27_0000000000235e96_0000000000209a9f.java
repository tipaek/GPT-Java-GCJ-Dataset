import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    for(int i = 0; i < t; ++i) {
      String ipStr = sc.nextLine();
      StringBuilder sb = new StringBuilder();

      char[] chars = ipStr.toCharArray();
      int[] nums = new int[chars.length];
      for(int j = 0; j < chars.length; ++j) {
        nums[j] = Integer.parseInt(String.valueOf(chars[j]));
      }
      int closingBrackets = 0;
      for(int j = 0; j < nums[0]; ++j) {
        sb.append('(');
        ++closingBrackets;
      }
      sb.append(nums[0]);
      for(int j = 1; j < nums.length; ++j) {
        if(nums[j] > nums[j - 1]) {
          for(int l = 0; l < (nums[j] - nums[j - 1]); ++l) {
            sb.append('(');
            ++closingBrackets;
          }
        } else if(nums[j] < nums[j - 1]) {
          for(int l = 0; l < (nums[j - 1] - nums[j]); ++l) {
            sb.append(')');
            --closingBrackets;
          }
        }
        sb.append(nums[j]);
      }
      for(int j = 0; j < closingBrackets; ++j) {
        sb.append(')');
      }

      System.out.println("Case #" + (i + 1) + ": " + sb.toString());
    }
  }
}