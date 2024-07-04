import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            String s = sc.next();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;

            for (char c : s.toCharArray()) {
                int currentDigit = Character.getNumericValue(c);
                while (previousDigit < currentDigit) {
                    result.append('(');
                    previousDigit++;
                }
                while (previousDigit > currentDigit) {
                    result.append(')');
                    previousDigit--;
                }
                result.append(c);
            }

            while (previousDigit > 0) {
                result.append(')');
                previousDigit--;
            }

            System.out.println("Case #" + caseNumber + ": " + result);
            caseNumber++;
        }
    }
}