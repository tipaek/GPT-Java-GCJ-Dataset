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
                    for (int j = 0; j < currentDigit - previousDigit; j++)
                        S2.append("(");
                else
                    for (int j = 0; j < previousDigit - currentDigit; j++)
                        S2.append(")");

                S2.append(currentDigit);
                previousDigit = currentDigit;
            }

            for (int i = 0; i < currentDigit; i++)
                S2.append(")");
            System.out.println(S2);
        }
    }
}