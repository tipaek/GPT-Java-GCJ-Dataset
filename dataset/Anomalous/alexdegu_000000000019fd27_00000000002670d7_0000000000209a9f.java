import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int k = 1; k <= t; ++k) {
            String s = in.next();
            StringBuilder sb = new StringBuilder();
            int lastDigit = 0;

            for (char c : s.toCharArray()) {
                int currDigit = Character.getNumericValue(c);

                if (currDigit > lastDigit) {
                    sb.append("(".repeat(currDigit - lastDigit));
                } else if (currDigit < lastDigit) {
                    sb.append(")".repeat(lastDigit - currDigit));
                }

                sb.append(currDigit);
                lastDigit = currDigit;
            }

            sb.append(")".repeat(lastDigit));

            System.out.println("Case #" + k + ": " + sb.toString());
        }
    }
}