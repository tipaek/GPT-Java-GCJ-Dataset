import java.util.Scanner;

public class Solution {
    public static String solve (String str) {
        int prev = 0, curr = 0;
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            curr = Integer.parseInt("" + str.charAt(i));
            if (curr > prev) {
                int diff = curr - prev;
                while (diff > 0) {
                    res += '(';
                    diff--;
                }
            } else if (curr < prev) {
                int diff = prev - curr;
                while (diff > 0) {
                    res += ')';
                    diff--;
                }
            }
            res += str.charAt(i);
            prev = curr;
        }
        while (prev > 0) {
            res += ')';
            prev--;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 1; i <= t; i++) {
            String str = input.next();
            System.out.println("Case #" + i + ": " + solve(str));
        }
    }
}
