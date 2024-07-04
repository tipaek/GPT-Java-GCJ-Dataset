import java.util.Scanner;

class Solution {
    public static void main(String[] commands) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= T; t++) {
            char[] data = new char[B];
            int left = 1;
            int right = B;

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
                left++;
                right--;
            }

            char[] result = new char[B];
            for (int i = 0; i < B / 2; i++) {
                System.out.println(i + 1);
                String response = scanner.nextLine();

                result[i] = response.charAt(0);
                if (data[i] == 'S') {
                    result[B - i - 1] = response.charAt(0);
                } else {
                    result[B - i - 1] = response.charAt(0) == '0' ? '1' : '0';
                }
            }

            System.out.println(new String(result));
            String finalResponse = scanner.nextLine();
        }

        scanner.close();
        System.exit(0);
    }
}