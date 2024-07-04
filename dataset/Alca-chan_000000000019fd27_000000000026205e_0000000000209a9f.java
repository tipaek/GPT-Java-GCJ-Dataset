import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        if (numOfCases <= 0) {
            return;
        }
        scanner.nextLine();

        StringBuilder result = new StringBuilder();
        for (int c = 0; c < numOfCases; c++) {
            String input = scanner.nextLine();

            result.append("Case #").append(c+1).append(": ");

            int parentheses = 0;
            for (int i = 0; i < input.length(); i++) {
                int n = Character.getNumericValue(input.charAt(i));
                while (n > parentheses) {
                    result.append("(");
                    parentheses++;
                }
                while (n < parentheses) {
                    result.append(")");
                    parentheses--;
                }
                result.append(input.charAt(i));
                if (i == input.length() - 1) {
                    for (int j = 0; j < parentheses; j++) {
                        result.append(")");
                    }
                }
            }
            result.append("\n");
        }
        System.out.println(result.toString());
    }
}
