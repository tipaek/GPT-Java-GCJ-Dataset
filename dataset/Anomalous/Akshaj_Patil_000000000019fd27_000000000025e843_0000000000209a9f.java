import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        sc.nextLine(); // consume the newline character

        for (int caseNo = 1; caseNo <= testCases; caseNo++) {
            String input = sc.nextLine();
            int[] digits = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
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