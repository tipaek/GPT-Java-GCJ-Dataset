import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = createScaner();

        int testCases;

        testCases = in.nextInt();
        in.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String N = in.nextLine();
            solve(i, N);
        }
    }

    private static void solve(int testCase, String N) {
        StringBuilder sb = new StringBuilder();
        int openBracketsCount = 0;
        int closeBracketsCount = 0;
        int numArrLength = N.toCharArray().length;

        for (int i = 0; i < numArrLength; i++) {
            int digit = N.toCharArray()[i] - 48;

            //open brackets
            if (i == 0) {
                for (int j = 0; j < digit; j++) {
                    sb.append("(");
                }
            } else if (digit > N.toCharArray()[i - 1] - 48) {
                openBracketsCount = digit - (N.toCharArray()[i - 1] - 48);
                for (int j = 0; j < openBracketsCount; j++) {
                    sb.append("(");
                }
            } else if (digit <= (N.toCharArray()[i - 1] - 48)) {
                //do nothing
            } else if (digit != 0) {
                for (int j = 0; j < digit; j++) {
                    sb.append("(");
                }
            }

            //append digit
            sb.append(digit);

            //close brackets
            if (i == numArrLength - 1) {
                for (int j = 0; j < digit; j++) {
                    sb.append(")");
                }
            } else if (digit < N.toCharArray()[i + 1] - 48) {
                //do nothing
            } else if (digit > (N.toCharArray()[i + 1] - 48)) {
                closeBracketsCount = digit - (N.toCharArray()[i + 1] - 48);
                for (int j = 0; j < closeBracketsCount; j++) {
                    sb.append(")");
                }
            }
        }

        System.out.println("Case #" + testCase + ": " + sb.toString());
    }

    public static Scanner createScaner() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        return sc;
    }

}