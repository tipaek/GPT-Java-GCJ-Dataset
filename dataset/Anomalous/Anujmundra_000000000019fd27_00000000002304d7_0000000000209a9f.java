import java.util.Scanner;

public class Solution {

    public String addBrackets(int num) {
        String result = Integer.toString(num);
        for (int i = 0; i < num; i++) {
            result = "(" + result + ")";
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();

            if (input.charAt(0) == '0') {
                result.append("0");
            } else {
                result.append(solution.addBrackets(Character.getNumericValue(input.charAt(0))));
            }

            for (int j = 1; j < input.length(); j++) {
                int previous = Character.getNumericValue(input.charAt(j - 1));
                int current = Character.getNumericValue(input.charAt(j));

                if (current > previous) {
                    result.append(solution.addBrackets(current));
                } else if (current == 0) {
                    result.append("0");
                } else {
                    int insertPosition = result.length() - current;
                    result.insert(insertPosition, current);
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}