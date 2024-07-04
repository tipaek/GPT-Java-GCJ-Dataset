import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= T; t++) {
            char[] data = new char[B];
            int left = 1;
            int right = B;
            char initialChar = 'X';

            while (left < right) {
                System.out.println(left);
                System.out.flush();
                String leftResponse = scanner.nextLine();
                
                System.out.println(right);
                System.out.flush();
                String rightResponse = scanner.nextLine();

                if (leftResponse.equals(rightResponse)) {
                    data[left - 1] = 'S';
                    data[right - 1] = 'S';
                } else {
                    data[left - 1] = 'D';
                    data[right - 1] = 'D';
                }

                if (left == 1) {
                    initialChar = leftResponse.charAt(0);
                }

                left++;
                right--;
            }

            char currentFirstChar = 'X';
            char[] result = new char[B];

            for (int i = B / 2 - 1; i >= 0; i--) {
                System.out.println(i + 1);
                System.out.flush();
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
                    currentFirstChar = responseChar;
                }
            }

            if (initialChar != currentFirstChar) {
                for (int i = B / 2; i < B; i++) {
                    result[i] = (result[i] == '0') ? '1' : '0';
                    result[B - i - 1] = (result[B - i - 1] == '0') ? '1' : '0';
                }
            }

            System.out.println(new String(result));
            System.out.flush();
            scanner.nextLine(); // Read the check response
        }

        scanner.close();
    }
}