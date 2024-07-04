import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            boolean openBracket = false;

            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);

                if (currentChar == '1') {
                    if (!openBracket) {
                        output.append('(');
                        openBracket = true;
                    }
                } else if (currentChar == '0') {
                    if (openBracket) {
                        output.append(')');
                        openBracket = false;
                    }
                }
                output.append(currentChar);
            }

            if (openBracket) {
                output.append(')');
            }

            System.out.println("Case #" + t + ": " + output.toString());
        }
    }
}