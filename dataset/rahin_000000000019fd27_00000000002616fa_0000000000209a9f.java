import java.util.Scanner;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {

        int testCase = scanner.nextInt();

        for (int i = 1; i <= testCase; i++) {
            String s = scanner.next();
            LargeSolution(s, i);
        }


    }

    public static void LargeSolution(String s, int testCase) {


        StringBuilder stringBuilder = new StringBuilder();

        int firstChar = (int) s.charAt(0) - '0';

        for (int i = 0; i < firstChar; i++) {
            stringBuilder.append("(");
        }
        stringBuilder.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {

            int first = (int) s.charAt(i) - '0';
            int second = (int) s.charAt(i - 1) - '0';

            if (first - second > 0) {
                for (int j = 0; j < first - second; j++) {
                    stringBuilder.append("(");
                }
            } else if (first - second < 0) {
                for (int j = 0; j < Math.abs(first - second); j++) {
                    stringBuilder.append(")");
                }
            }
            stringBuilder.append(s.charAt(i));
        }

        int lastChar = (int) s.charAt(s.length() - 1) - '0';

        for (int i = 0; i < lastChar; i++)
            stringBuilder.append(")");

        System.out.println("Case #" + testCase + ": " + stringBuilder);

    }
}