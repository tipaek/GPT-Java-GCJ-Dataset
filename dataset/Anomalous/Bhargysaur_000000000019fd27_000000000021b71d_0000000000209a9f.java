import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            String line = sc.nextLine();
            int[] digits = new int[line.length()];

            for (int j = 0; j < line.length(); j++) {
                digits[j] = Character.getNumericValue(line.charAt(j));
            }

            StringBuilder newLine = new StringBuilder();
            int nesting = 0;

            for (int digit : digits) {
                while (digit > nesting) {
                    newLine.append("(");
                    nesting++;
                }

                while (digit < nesting) {
                    newLine.append(")");
                    nesting--;
                }

                newLine.append(digit);
            }

            while (nesting > 0) {
                newLine.append(")");
                nesting--;
            }

            System.out.println("Case #" + (i + 1) + ": " + newLine);
        }
    }
}