import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int previous = 0;

            for (char ch : input.toCharArray()) {
                int current = ch - '0';

                if (current == 0) {
                    if (previous == 1) {
                        result.append(')').append(ch);
                    } else {
                        result.append(ch);
                    }
                } else { // current == 1
                    if (previous == 0) {
                        result.append('(').append(ch);
                    } else {
                        result.append(ch);
                    }
                }
                previous = current;
            }

            if (previous == 1) {
                result.append(')');
            }

            System.out.println("Case #" + i + ": " + result.toString());
        }

        scanner.close();
    }
}