import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numEntries = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numEntries; i++) {
            char[] entries = scanner.nextLine().toCharArray();
            StringBuilder result = new StringBuilder("Case#" + (i + 1) + ": ");
            int currentParentheses = 0;

            for (char entryChar : entries) {
                int entry = Character.getNumericValue(entryChar);
                int difference = currentParentheses - entry;

                while (difference > 0) {
                    result.append(")");
                    currentParentheses--;
                    difference--;
                }
                while (difference < 0) {
                    result.append("(");
                    currentParentheses++;
                    difference++;
                }

                result.append(entry);
            }

            while (currentParentheses > 0) {
                result.append(")");
                currentParentheses--;
            }

            System.out.println(result.toString());
        }

        scanner.close();
    }
}