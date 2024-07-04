import java.util.Scanner;

public class Prog2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(sc.nextLine());

        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            String input = sc.nextLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (int i = 0; i < input.length(); i++) {
                int digit = input.charAt(i) - '0';

                while (openBrackets < digit) {
                    result.append('(');
                    openBrackets++;
                }

                while (openBrackets > digit) {
                    result.append(')');
                    openBrackets--;
                }

                result.append(digit);
            }

            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }

            System.out.println("Case #" + testCase + ": " + result);
        }

        sc.close();
    }
}