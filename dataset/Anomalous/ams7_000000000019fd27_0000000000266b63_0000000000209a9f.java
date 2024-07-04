import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline

        for (int i = 1; i <= t; i++) {
            String s = sc.nextLine();
            StringBuilder res = new StringBuilder();

            int prevDigit = 0;
            for (int j = 0; j < s.length(); j++) {
                int currentDigit = Character.getNumericValue(s.charAt(j));
                int diff = currentDigit - prevDigit;

                if (diff > 0) {
                    res.append("(".repeat(diff));
                } else if (diff < 0) {
                    res.append(")".repeat(-diff));
                }

                res.append(currentDigit);
                prevDigit = currentDigit;
            }

            res.append(")".repeat(prevDigit));

            System.out.println("Case #" + i + ": " + res);
        }
    }
}