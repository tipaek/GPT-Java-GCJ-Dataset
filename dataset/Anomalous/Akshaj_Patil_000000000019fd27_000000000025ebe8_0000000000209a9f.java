import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        sc.nextLine(); // consume the newline character

        for (int caseNo = 1; caseNo <= testCases; caseNo++) {
            String input = sc.nextLine();
            int[] digits = new int[input.length()];
            for (int i = 0; i < input.length(); i++) {
                digits[i] = Character.getNumericValue(input.charAt(i));
            }

            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (int digit : digits) {
                while (currentDepth < digit) {
                    result.append("(");
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    result.append(")");
                    currentDepth--;
                }
                result.append(digit);
            }

            while (currentDepth > 0) {
                result.append(")");
                currentDepth--;
            }

            System.out.println("#" + caseNo + " " + result.toString());
        }
    }
}