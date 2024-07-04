import java.util.Scanner;

public class Solution {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testCaseCount = sc.nextInt();
        
        for (int i = 0; i < testCaseCount; i++) {
            String s = sc.next();
            solve(s, i);
        }
    }

    public static void solve(String s, int testCase) {
        StringBuilder finalVal = new StringBuilder();
        
        int num = Integer.parseInt(s);
        if (num == 0) {
            System.out.println("Case #" + (testCase + 1) + ": " + s);
            return;
        }

        if (s.length() == 1) {
            int digit = Integer.parseInt(s);
            finalVal.append("(".repeat(digit));
            finalVal.append(s);
            finalVal.append(")".repeat(digit));
            System.out.println("Case #" + (testCase + 1) + ": " + finalVal);
            return;
        }

        int length = s.length();
        finalVal.append(s.charAt(0));
        for (int i = 0; i < length - 1; i++) {
            int currentDigit = Character.getNumericValue(s.charAt(i));
            int nextDigit = Character.getNumericValue(s.charAt(i + 1));
            if (currentDigit < nextDigit) {
                finalVal.append("(".repeat(nextDigit - currentDigit));
            } else if (currentDigit > nextDigit) {
                finalVal.append(")".repeat(currentDigit - nextDigit));
            }
            finalVal.append(nextDigit);
        }
        
        int firstDigit = Character.getNumericValue(s.charAt(0));
        int lastDigit = Character.getNumericValue(s.charAt(length - 1));
        finalVal.insert(0, "(".repeat(firstDigit));
        finalVal.append(")".repeat(lastDigit));
        
        System.out.println("Case #" + (testCase + 1) + ": " + finalVal);
    }
}