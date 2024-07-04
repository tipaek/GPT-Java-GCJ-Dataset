import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.nextLine();
            String result = processString(input, 0);
            System.out.println("case #" + t + ": " + result);
        }
    }

    private static String processString(String str, int inside) {
        if (str.length() == 1) {
            int num = Integer.parseInt(str);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < num - inside; i++) {
                sb.insert(sb.length() / 2, "()");
            }
            sb.insert(sb.length() / 2, num);
            return sb.toString();
        } else {
            int minIndex = 0;
            int minValue = Integer.parseInt(String.valueOf(str.charAt(minIndex)));

            for (int j = 1; j < str.length(); j++) {
                int currentValue = Integer.parseInt(String.valueOf(str.charAt(j)));
                if (currentValue < minValue) {
                    minValue = currentValue;
                    minIndex = j;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < minValue - inside; j++) {
                sb.insert(sb.length() / 2, "()");
            }

            String middlePart;
            if (minIndex == str.length() - 1) {
                String leftPart = processString(str.substring(0, minIndex), minValue);
                middlePart = leftPart + minValue;
            } else if (minIndex == 0) {
                String rightPart = processString(str.substring(minIndex + 1), minValue);
                middlePart = minValue + rightPart;
            } else {
                String leftPart = processString(str.substring(0, minIndex), minValue);
                String rightPart = processString(str.substring(minIndex + 1), minValue);
                middlePart = leftPart + minValue + rightPart;
            }

            sb.insert(sb.length() / 2, middlePart);
            return sb.toString();
        }
    }
}