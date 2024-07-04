import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            String s = sc.next();
            StringBuilder result = new StringBuilder();

            for (int j = 0; j < s.length(); j++) {
                char currentChar = s.charAt(j);
                if (j > 0 && currentChar == s.charAt(j - 1)) {
                    result.append(currentChar);
                } else {
                    if (j != 0) {
                        int prevCharValue = s.charAt(j - 1) - '0';
                        for (int k = 0; k < prevCharValue; k++) {
                            result.append(')');
                        }
                    }
                    int currentCharValue = currentChar - '0';
                    for (int k = 0; k < currentCharValue; k++) {
                        result.append('(');
                    }
                    result.append(currentChar);
                }
            }

            int lastCharValue = s.charAt(s.length() - 1) - '0';
            for (int k = 0; k < lastCharValue; k++) {
                result.append(')');
            }

            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }

        sc.close();
    }
}