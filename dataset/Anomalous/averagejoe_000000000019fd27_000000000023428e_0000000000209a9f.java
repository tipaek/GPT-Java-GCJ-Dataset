import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int cases = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < cases; i++) {
                String[] strDigits = br.readLine().split("");
                int len = strDigits.length;
                int[] digits = new int[len + 1];
                digits[len] = 0;

                for (int j = 0; j < len; j++) {
                    digits[j] = Integer.parseInt(strDigits[j]);
                }

                StringBuilder sb = new StringBuilder();
                int previousDigit = 0;

                for (int digit : digits) {
                    int difference = digit - previousDigit;

                    while (difference > 0) {
                        sb.append('(');
                        difference--;
                    }
                    while (difference < 0) {
                        sb.append(')');
                        difference++;
                    }

                    sb.append(digit);
                    previousDigit = digit;
                }

                sb.deleteCharAt(sb.lastIndexOf("0"));
                System.out.printf("Case #%d: %s%n", i + 1, sb.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}