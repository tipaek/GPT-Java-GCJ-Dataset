
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.compute();
    }

    public void compute() {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        in.nextLine();

        for (int caseNo = 1; caseNo <= cases; ++caseNo) {
            String line = in.nextLine();

            StringBuffer sb = new StringBuffer();
            int openParenthesis = 0;

            for (int lineIndex = 0; lineIndex < line.length(); lineIndex++) {

                String currentChar = String.valueOf(line.charAt(lineIndex));
                int currentDigit = Integer.parseInt(currentChar);
                int diff = currentDigit - openParenthesis;
                String parenthesisChar = "";

                if (diff > 0) {
                    parenthesisChar = "(";
                } else if (diff < 0) {
                    parenthesisChar = ")";
                }

                for (int occurrence = 0; occurrence < Math.abs(diff); occurrence++) {
                    sb.append(parenthesisChar);
                }

                sb.append(currentChar);

                openParenthesis += diff;
            }

            for (int occurrence = 0; occurrence < openParenthesis; occurrence++) {
                sb.append(")");
            }

            System.out.println("Case #" + caseNo + ": " + sb.toString());
        }
    }


}