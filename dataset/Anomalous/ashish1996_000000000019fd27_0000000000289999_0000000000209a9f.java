import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            String input = scanner.next();
            StringBuilder output = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '1') {
                    output.append("(");
                    while (i < input.length() && input.charAt(i) == '1') {
                        output.append(input.charAt(i));
                        i++;
                    }
                    output.append(")");
                }
                if (i < input.length() && input.charAt(i) == '0') {
                    output.append(input.charAt(i));
                }
            }

            System.out.println("Case #" + (caseNumber++) + ": " + output);
        }

        scanner.close();
    }
}