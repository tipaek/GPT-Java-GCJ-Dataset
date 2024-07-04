import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int length = scanner.nextInt();

        Solution solution = new Solution();

        for (int i = 0; i < testCases; i++) {
            try {
                solution.handleTestCase(length, scanner);
            } catch (Exception e) {
                return;
            }
        }
    }

    private void handleTestCase(int length, Scanner scanner) throws Exception {
        char[] array = new char[length];

        for (int i = 0; i < length; i++) {
            System.out.println(i + 1);
            array[i] = (char) (scanner.nextInt() + '0');
        }

        System.out.println(new String(array));

        String response = scanner.next();
        if ("N".equals(response)) {
            throw new Exception();
        }
    }
}