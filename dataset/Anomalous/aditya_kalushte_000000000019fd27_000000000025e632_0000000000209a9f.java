import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = sc.nextInt();
            for (int t = 1; t <= testCases; t++) {
                String digitStr = sc.next();
                StringBuilder outputStr = new StringBuilder();
                int prevDigit = 0;

                for (char ch : digitStr.toCharArray()) {
                    int currDigit = ch - '0';
                    int paraCount = currDigit - prevDigit;

                    char paraChar = paraCount < 0 ? ')' : '(';
                    paraCount = Math.abs(paraCount);

                    outputStr.append(String.valueOf(paraChar).repeat(paraCount));
                    outputStr.append(currDigit);
                    prevDigit = currDigit;
                }

                outputStr.append(")".repeat(prevDigit));

                System.out.println("Case #" + t + ": " + outputStr);
            }
        }
    }

}