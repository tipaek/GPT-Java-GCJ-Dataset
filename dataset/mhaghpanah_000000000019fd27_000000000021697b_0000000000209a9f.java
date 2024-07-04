import java.util.Scanner;

public class Solution {

  public static String f(int[] nums, int[] nums2,  int lo, int hi) {
    StringBuilder sb = new StringBuilder();
    if (lo > hi) return "";
    if (lo == hi) {
//      System.out.printf("a %d\n", nums[lo]);
      for (int i = 0; i < nums[lo]; i++) sb.append("(");
      sb.append(nums2[lo]);
      for (int i = 0; i < nums[lo]; i++) sb.append(")");
//      System.out.println(sb.toString());
      return sb.toString();
    }

    int min = 10;
    for (int i = lo; i <= hi; i++) min = Math.min(min, nums[i]);;
    for (int i = 0; i < min; i++) sb.append("(");
    for (int i = lo; i <= hi; i++) nums[i] -= min;
//    System.out.printf("lo: %d hi: %d min: %d\n", lo, hi, min);
//    System.out.println(Arrays.toString(nums));
    int last = lo;
    for (int i = lo; i <= hi; i++) {
      if (nums[i] == 0) {
//        System.out.println(i);
        if (i == lo) {
          sb.append(f(nums, nums2, lo, lo));
          sb.append(f(nums, nums2, lo + 1, hi));
        } else {
          sb.append(f(nums, nums2, lo, i - 1));
          sb.append(f(nums, nums2, i, hi));
        }
//        System.out.println(sb.toString());
        break;
      }
    }
    for (int i = 0; i < min; i++) sb.append(")");

    return sb.toString();
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int t = input.nextInt();
    input.nextLine();
    for (int c = 0; c < t; c++) {
      String str = input.nextLine();
//      System.out.println(str.length());
      int n = str.length();
      int[] nums = new int[n];
      for (int i = 0; i < n; i++) nums[i] = str.charAt(i) - '0';
      System.out.printf("Case #%d: %s\n", c + 1, f(nums, nums.clone(), 0, n - 1));
    }
  }
}
