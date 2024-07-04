import java.util.Scanner;

public class Solution {
    static Scanner input;
    public static void solve(int x) {
        String result = "";
        if (x == 1) {
            input.nextLine();
        }
        String base = input.nextLine();
        int prev = 0;
        for (int b = 0; b < base.length(); b++) {
            char n = base.charAt(b);
            int val = (int) n - 48;
            if (val > prev) {
                for (int o = 0; o < (val - prev); o++) {
                    result += "{";
                }
            } else if (val < prev) {
                for (int c = 0; c < (prev - val); c++) {
                    result += ")";
                }
            }
            result += val;
            prev = val;
        }
        for (int f = 0; f < prev; f++) {
            result += ")";
        }
        
        System.out.println("Case #" + x + ": " + result);
    }
    
    public static void main(String args[]) {
      input = new Scanner(System.in);
      int t = input.nextInt();
      for (int i = 0; i < t; i++) {
          solve(i + 1);
      }
    }
}