import java.util.*;
import java.io.*;

class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        sc.nextLine();
        int caseNo = 1;

        while (testCases-- > 0) {
            String input = sc.nextLine();
            StringBuilder ans = new StringBuilder();
            int[] input1 = new int[input.length()];
            int[] countBraces = new int[input.length()];

            for (int i = 0; i < input.length(); i++) {
                input1[i] = input.charAt(i) - '0';
            }

            for (int i = 0; i < input1.length; i++) {
                int currentDigit = input1[i];
                if (i > 0) {
                    int previousDigit = input1[i - 1];
                    if (currentDigit > previousDigit) {
                        for (int j = 0; j < currentDigit - previousDigit; j++) {
                            ans.append('(');
                        }
                    } else if (currentDigit < previousDigit) {
                        for (int j = 0; j < previousDigit - currentDigit; j++) {
                            ans.append(')');
                        }
                    }
                } else {
                    for (int j = 0; j < currentDigit; j++) {
                        ans.append('(');
                    }
                }
                ans.append(currentDigit);
            }

            for (int i = 0; i < input1[input1.length - 1]; i++) {
                ans.append(')');
            }

            System.out.println("Case #" + caseNo++ + ": " + ans.toString());
        }
    }
}