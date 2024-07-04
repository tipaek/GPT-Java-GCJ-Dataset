import java.util.Scanner;

public class Solution {

    public static String getResult(String original) {
        StringBuilder result = new StringBuilder();
        int previous = 0;

        for (int i = 0; i < original.length(); i++) {
            int current = Character.getNumericValue(original.charAt(i));

            if (current == previous) {
                result.append(current);
            } else if (current > previous) {
                for (int j = previous; j < current; j++) {
                    result.append("(");
                }
                result.append(current);
            } else {
                for (int j = previous; j > current; j--) {
                    result.append(")");
                }
                result.append(current);
            }

            previous = current;
        }

        for (int i = previous; i > 0; i--) {
            result.append(")");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + getResult(scanner.nextLine()));
        }

        scanner.close();
    }
}