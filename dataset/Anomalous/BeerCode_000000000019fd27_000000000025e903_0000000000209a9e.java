import java.util.Scanner;

public class Solution {
    public static void main(String[] commands) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int t = 1; t <= T; t++) {
            char[] data = new char[B];
            int left = 1;
            int right = B;
            char first = 'X';

            while (left < right) {
                System.out.println(left);
                String leftResponse = scanner.nextLine();
                System.out.println(right);
                String rightResponse = scanner.nextLine();

                if (leftResponse.equals(rightResponse)) {
                    data[left - 1] = 'S';
                    data[right - 1] = 'S';
                } else {
                    data[left - 1] = 'D';
                    data[right - 1] = 'D';
                }

                if (left == 1) {
                    first = leftResponse.charAt(0);
                }

                left++;
                right--;
            }

            char firstCurrent = 'X';
            char[] result = new char[B];

            for (int i = B / 2 - 1; i >= 0; i--) {
                System.out.println(i + 1);
                String response = scanner.nextLine();
                char responseChar = response.charAt(0);

                if (responseChar == '0') {
                    result[i] = '0';
                    result[B - i - 1] = (data[i] == 'S') ? '0' : '1';
                } else if (responseChar == '1') {
                    result[i] = '1';
                    result[B - i - 1] = (data[i] == 'S') ? '1' : '0';
                }

                if (i == 0) {
                    firstCurrent = responseChar;
                }
            }

            if (first != firstCurrent) {
                for (int i = 5; i < B / 2; i++) {
                    result[i] = (result[i] == '0') ? '1' : '0';
                    result[B - i - 1] = (result[B - i - 1] == '0') ? '1' : '0';
                }
            }

            System.out.println(new String(result));
            String check = scanner.nextLine();
        }

        scanner.close();
        System.exit(0);
    }
}