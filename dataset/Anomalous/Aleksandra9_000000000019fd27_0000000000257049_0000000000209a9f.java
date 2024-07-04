import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfTests = scanner.nextInt();
            for (int testCase = 1; testCase <= numberOfTests; testCase++) {
                String inputString = scanner.next();
                System.out.print("Case #" + testCase + ": ");
                
                int currentDepth = 0;
                for (char ch : inputString.toCharArray()) {
                    int digit = ch - '0';
                    if (digit > currentDepth) {
                        System.out.print("(".repeat(digit - currentDepth));
                    } else if (digit < currentDepth) {
                        System.out.print(")".repeat(currentDepth - digit));
                    }
                    currentDepth = digit;
                    System.out.print(digit);
                }
                System.out.print(")".repeat(currentDepth));
                System.out.println();
            }
        }
    }
}