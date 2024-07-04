import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            StringBuilder result = new StringBuilder();

            int consecutiveOnes = 0;
            for (int index = 0; index < inputString.length();) {
                if (inputString.charAt(index) == '1') {
                    consecutiveOnes = 1;
                    while (index + consecutiveOnes < inputString.length() && inputString.charAt(index + consecutiveOnes) == '1') {
                        consecutiveOnes++;
                    }

                    result.append("(").append(inputString, index, index + consecutiveOnes).append(")");
                    index += consecutiveOnes;
                } else {
                    result.append(inputString.charAt(index));
                    index++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}