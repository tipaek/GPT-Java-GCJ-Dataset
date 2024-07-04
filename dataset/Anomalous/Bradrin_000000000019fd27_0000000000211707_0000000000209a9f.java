import java.util.Scanner;

public class Solution {

    private void solve(Scanner scanner) {
        String input = scanner.next();
        int previousDigit = 0;
        StringBuilder output = new StringBuilder();
        
        for (char digitChar : input.toCharArray()) {
            int currentDigit = digitChar - '0';
            int difference = currentDigit - previousDigit;
            
            if (difference > 0) {
                output.append("(".repeat(difference));
            } else if (difference < 0) {
                output.append(")".repeat(-difference));
            }
            
            output.append(digitChar);
            previousDigit = currentDigit;
        }
        
        output.append(")".repeat(previousDigit));
        System.out.println(output);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            new Solution().solve(scanner);
        }
        
        scanner.close();
    }
}