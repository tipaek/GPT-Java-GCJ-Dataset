import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // Given a string of digits S, insert a minimum number of opening and closing parentheses such that the resulting string is balanced and each digit
        //  d is inside exactly d pairs of matching parentheses

        // Input:
        //  first line - num test cases
        //  following n lines contain only the string S

        // Output:
        //  "Case #x: y" where x is the test case number (starting from 1) and y is the string S' defined above)

        Scanner scanner = new Scanner(System.in);
        int numTestCases = Integer.parseInt(scanner.nextLine());

        for (int x = 1; x <= numTestCases; x++) {
            String in = scanner.nextLine();
            char[] S = in.toCharArray();

            StringBuilder sPrime = new StringBuilder();
            int currDepth = 0;
            for (int i = 0; i < S.length; i++) {
                int diff = Character.getNumericValue(S[i]) - currDepth;
                if (diff > 0) {
                    for (int j = 0; j < diff; j++) {
                        sPrime.append('(');
                    }
                } else if (diff < 0) {
                    for (int j = 0; j > diff; j--) {
                        sPrime.append(')');
                    }
                }
                currDepth += diff;
                sPrime.append(S[i]);
            }
            for (int j = 0; j < currDepth; j++) {
                sPrime.append(')');
            }
            System.out.println("Case #" + x+ ": " + sPrime.toString());
        }
    }
}
