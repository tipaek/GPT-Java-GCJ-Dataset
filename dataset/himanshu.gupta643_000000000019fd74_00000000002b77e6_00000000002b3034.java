import java.util.Scanner;

/**
 * @author himanshugupta - created on 11/04/20
 */
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- != 0) {
      int n = sc.nextInt();
      sc.nextLine();
      String arr[] = new String[n];
      int max = 0;
      String maxString = "";
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextLine();
        if (arr[i].length() > max) {
          max = arr[i].length();
          maxString = arr[i];
        }
      }
      maxString = maxString.substring(1);
      boolean ansFound = false;
      for (int i = 0; i < n; i++) {
        String check = arr[i].substring(1);
        if (!maxString.contains(check)) {
          ansFound = true;
          System.out.println("*");
        }
      }
      if(!ansFound){
        System.out.println(maxString);
      }
    }
  }
}
