import java.util.Scanner;

public class Solution {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    int T = input.nextInt();
    int B = input.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      int arr[] = new int[B];
      for (int i = 1; i <= B; i++) {
        int c = i;
        System.out.println(c);
        String r = input.next();
        if (r.equals("N")) {
          return;
        } else if (r.equals("Y")) {
          break;
        } else {
          int rp = Integer.parseInt(r);
          arr[c - 1] = rp;
        }
      }

      StringBuilder builder = new StringBuilder();
      for (int value : arr) {
        builder.append(value);
      }
      String text = builder.toString();
      System.out.println(text);
      String r = input.next();
      if (r.equals("N")) {
        return;
      }
    }
  }
}
