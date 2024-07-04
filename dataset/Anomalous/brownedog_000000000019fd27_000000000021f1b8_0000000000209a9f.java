import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // number of test cases

        for (int i = 1; i <= t; ++i) {
            String n = in.next();
            StringBuilder answer = new StringBuilder();
            int previousNum = 0;

            for (int j = 0; j < n.length(); j++) {
                int currentNum = n.charAt(j) - '0';

                // Add opening parentheses if needed
                if (currentNum > previousNum) {
                    for (int k = 0; k < currentNum - previousNum; k++) {
                        answer.append('(');
                    }
                }

                // Add closing parentheses if needed
                if (currentNum < previousNum) {
                    for (int k = 0; k < previousNum - currentNum; k++) {
                        answer.append(')');
                    }
                }

                // Add the current number
                answer.append(currentNum);
                previousNum = currentNum;
            }

            // Close any remaining open parentheses
            for (int k = 0; k < previousNum; k++) {
                answer.append(')');
            }

            System.out.println("Case #" + i + ": " + answer.toString());
        }
    }
}