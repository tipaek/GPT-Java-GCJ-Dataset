import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTests = Integer.parseInt(scanner.nextLine());

        for (int testNum = 1; testNum <= numTests; testNum++) {
            String input = scanner.nextLine();
            StringBuffer result = new StringBuffer();

            int prev = 0;
            for (char digit : input.toCharArray()) {
                int current = (digit - '0');

                for (int j = 0; j < current - prev; j++) {
                    result.append('(');
                }

                for (int j = current - prev; j < 0; j++) {
                    result.append(')');
                }
                result.append(digit);
                prev = current;
            }

            for (int j = 0; j < prev; j++) {
                result.append(')');
            }
            System.out.println(String.format("Case #%d: %s", testNum, result.toString()));
        }

        scanner.close();
    }

}