import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            String S1 = in.next();
            StringBuilder S2 = new StringBuilder();
            S2.append("Case #").append(t+1).append(": ");
            int previousDigit = 0;
            int currentDigit = 0;
            for (int i = 0; i < S1.length(); i++) {
                currentDigit = Character.getNumericValue(S1.charAt(i));

                if (currentDigit > previousDigit)
                    S2.append("(".repeat(Math.max(0, currentDigit - previousDigit)));
                else
                    S2.append(")".repeat(Math.max(0, previousDigit - currentDigit)));

                S2.append(currentDigit);
                previousDigit = currentDigit;
            }

            S2.append(")".repeat(Math.max(0, currentDigit)));
            System.out.println(S2);
        }
    }
}