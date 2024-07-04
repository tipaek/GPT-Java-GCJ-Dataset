import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            String N = sc.next();
            StringBuilder y = new StringBuilder();
            int previousDigit = 0;

            for (int i = 0; i < N.length(); i++) {
                int currentDigit = Character.getNumericValue(N.charAt(i));
                int diff = currentDigit - previousDigit;

                if (diff > 0) {
                    for (int j = 0; j < diff; j++) {
                        y.append('(');
                    }
                } else if (diff < 0) {
                    for (int j = 0; j < -diff; j++) {
                        y.append(')');
                    }
                }

                y.append(N.charAt(i));
                previousDigit = currentDigit;
            }

            for (int j = 0; j < previousDigit; j++) {
                y.append(')');
            }

            System.out.printf("Case #%d: %s\n", t, y.toString());
        }

        sc.close();
    }
}