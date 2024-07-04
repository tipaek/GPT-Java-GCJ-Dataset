import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {

            StringBuilder string = new StringBuilder(scanner.next());
            int length = string.length();
            int depth = 0;

            for (int i = 0; i < length; i++) {
                if (string.charAt(i) == '(' || string.charAt(i) == ')') continue;

                int valueAtI = Character.getNumericValue(string.charAt(i));

                if (valueAtI > depth) {
                    int difference = valueAtI - depth;
                    depth += difference;

                    for (int j = 0; j < difference; j++) {
                        string.insert(i, "(");
                        length++;
                    }
                } else if (depth > valueAtI) {
                    int difference = depth - valueAtI;
                    depth -= difference;

                    for (int j = 0; j < difference; j++) {
                        string.insert(i, ")");
                        length++;
                    }
                }
            }

            while (depth > 0) {
                string.append(")");
                depth--;
            }

            System.out.println("Case #" + caseNum + ": " + string);
        }
    }
}