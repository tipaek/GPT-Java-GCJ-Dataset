import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());

        for (int test = 1; test <= cases; test++) {
            String input = sc.nextLine().trim();
            System.out.print("Case #" + test + ": ");
            System.out.println(findNestingDepth(input));
        }
    }

    static String findNestingDepth(String input) {
        StringBuilder result = new StringBuilder();
        int previous = Character.getNumericValue(input.charAt(0));

        // Add opening brackets for the first character
        for (int i = 0; i < previous; i++) {
            result.append("(");
        }
        result.append(input.charAt(0));

        int remaining = previous;

        for (int i = 1; i < input.length(); i++) {
            int current = Character.getNumericValue(input.charAt(i));

            if (current == previous) {
                result.append(current);
            } else if (current == 0) {
                for (int j = 0; j < remaining; j++) {
                    result.append(")");
                }
                result.append(current);
                remaining = 0;
            } else {
                if (remaining == 0) {
                    for (int j = 0; j < current; j++) {
                        result.append("(");
                    }
                    result.append(current);
                    remaining = current;
                } else {
                    int difference = remaining - current;
                    if (difference > 0) {
                        for (int j = 0; j < difference; j++) {
                            result.append(")");
                        }
                    } else {
                        for (int j = 0; j < -difference; j++) {
                            result.append("(");
                        }
                    }
                    result.append(current);
                    remaining = current;
                }
            }
            previous = current;
        }

        // Close any remaining open brackets
        for (int j = 0; j < remaining; j++) {
            result.append(")");
        }

        return result.toString();
    }
}