import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int cno = 1; cno <= t; cno++) {
            String s1 = sc.next();
            int l = s1.length();
            char[] ch = s1.toCharArray();
            StringBuilder paro = new StringBuilder();

            int left = Character.getNumericValue(ch[0]);
            int right = Character.getNumericValue(ch[l - 1]);

            for (int i = 0; i < left; i++) {
                paro.append("(");
            }
            paro.append(ch[0]);

            for (int i = 1; i < l; i++) {
                int currentDigit = Character.getNumericValue(ch[i]);
                int previousDigit = Character.getNumericValue(ch[i - 1]);

                if (currentDigit > previousDigit) {
                    int diff = currentDigit - previousDigit;
                    for (int k = 0; k < diff; k++) {
                        paro.append("(");
                    }
                } else if (currentDigit < previousDigit) {
                    int diff = previousDigit - currentDigit;
                    for (int k = 0; k < diff; k++) {
                        paro.append(")");
                    }
                }
                paro.append(ch[i]);
            }

            for (int i = 0; i < right; i++) {
                paro.append(")");
            }

            System.out.println("Case #" + cno + ": " + paro.toString());
        }
    }
}