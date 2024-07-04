import java.util.Scanner;

/**
 * @author himanshugupta - created on 11/04/20
 */
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int tt = t;
    while (t-- != 0) {
      int n = sc.nextInt();
      sc.nextLine();
      String arr[] = new String[n];
      int max = 0;
      String maxString = "";
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextLine();
        int stringLength = ('*' == arr[i].charAt(0)) ? arr[i].length() - 1 : arr[i].length();
        if (stringLength > max) {
          max = stringLength;
          maxString = arr[i];
        }
      }
      maxString = ('*' == maxString.charAt(0)) ? maxString.substring(1) : maxString;
      if(maxString.length()>10000){
        System.out.println("Case #" + (tt - t) + ": *");
        continue;
      }
      boolean ansFound = false;
      for (int i = 0; i < n; i++) {
        String check = ('*' == arr[i].charAt(0)) ? arr[i].substring(1) : arr[i];
        if (!maxString.contains(check)) {
          ansFound = true;
          System.out.println("Case #" + (tt - t) + ": *");
        }
      }
      if(!ansFound){
        System.out.println("Case #" + (tt - t) + ": "+maxString);
      }
    }
  }
}
