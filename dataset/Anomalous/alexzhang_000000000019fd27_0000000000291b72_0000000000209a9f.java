import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();
            int prevDigit = 0;

            sb.append("Case #").append(caseNum).append(": ");

            for (int i = 0; i < s.length(); i++) {
                int currDigit = Character.getNumericValue(s.charAt(i));
                int difference = currDigit - prevDigit;

                if (difference > 0) {
                    for (int j = 0; j < difference; j++) {
                        sb.append("(");
                    }
                } else if (difference < 0) {
                    for (int j = 0; j < -difference; j++) {
                        sb.append(")");
                    }
                }

                sb.append(currDigit);
                prevDigit = currDigit;
            }

            for (int i = 0; i < prevDigit; i++) {
                sb.append(")");
            }

            System.out.println(sb.toString());
        }
    }
}