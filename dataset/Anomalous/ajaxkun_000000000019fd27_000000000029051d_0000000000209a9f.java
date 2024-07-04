import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.nextLine();
            StringBuilder resultString = new StringBuilder();
            for (int i = 0; i < inputString.length(); i++) {
                char currentChar = inputString.charAt(i);
                if (currentChar == '1') {
                    resultString.append("(1)");
                } else {
                    resultString.append(currentChar);
                }
            }
            System.out.println("Case #" + caseNumber + ": " + resultString);
        }
        scanner.close();
    }
}