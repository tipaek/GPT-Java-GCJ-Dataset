import java.util.Scanner;

public class Solution {

    private void solve(Scanner in) throws Exception {
        String raw = in.next();
        StringBuilder sb = new StringBuilder(raw);
        int totalInserted = 0;
        int[] numbers = new int[sb.length()];

        // Initialization of array
        for (int i = 0; i < raw.length(); i++) {
            numbers[i] = Character.getNumericValue(raw.charAt(i));
        }

        // Beginning parentheses
        for (int i = 0; i < numbers[0]; i++) {
            sb.insert(0, '(');
            totalInserted++;
        }

        // Follow-up parentheses
        for (int index = 0; index < numbers.length - 1; index++) {
            if (numbers[index] > numbers[index + 1]) {
                int difference = numbers[index] - numbers[index + 1];
                int currentIndex = sb.indexOf(String.valueOf(numbers[index + 1]), index + totalInserted);
                for (int i = 0; i < difference; i++) {
                    sb.insert(currentIndex, ')');
                    totalInserted++;
                }
            } else if (numbers[index] < numbers[index + 1]) {
                int difference = numbers[index + 1] - numbers[index];
                int currentIndex = sb.indexOf(String.valueOf(numbers[index + 1]), index + totalInserted);
                for (int i = 0; i < difference; i++) {
                    sb.insert(currentIndex++, '(');
                    totalInserted++;
                }
            }
        }

        // Ending parentheses
        for (int i = 0; i < numbers[numbers.length - 1]; i++) {
            sb.append(')');
        }

        System.out.println(sb.toString());
    }

    private void run() throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.printf("Case #%d: ", i);
            solve(in);
        }
        in.close();
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }
}