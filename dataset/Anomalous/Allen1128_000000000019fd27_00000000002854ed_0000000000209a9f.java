import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputLine = scanner.nextLine();
            String result = processLine(inputLine);
            System.out.println("Case #" + caseNumber + ": " + result);
            System.out.flush();
        }
    }

    private static String processLine(String line) {
        StringBuilder resultBuilder = new StringBuilder();
        boolean isOpen = false;

        for (int index = 0; index < line.length(); index++) {
            char currentChar = line.charAt(index);

            if (currentChar == '1') {
                if (!isOpen) {
                    resultBuilder.append("{");
                    isOpen = true;
                }
            } else {
                if (isOpen) {
                    resultBuilder.append("}");
                    isOpen = false;
                }
            }
            resultBuilder.append(currentChar);
        }

        if (isOpen) {
            resultBuilder.append("}");
        }

        return resultBuilder.toString();
    }
}