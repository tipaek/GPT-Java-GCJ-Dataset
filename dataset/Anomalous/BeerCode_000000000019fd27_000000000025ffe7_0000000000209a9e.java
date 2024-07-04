import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitCount = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            char[] data = new char[bitCount];
            int left = 1;
            int right = bitCount;

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

                left++;
                right--;
            }

            char[] result = new char[bitCount];
            for (int i = 0; i < bitCount / 2; i++) {
                System.out.println(i + 1);
                System.out.flush();
                String response = scanner.nextLine();
                char bit = response.charAt(0);

                result[i] = bit;
                if (data[i] == 'S') {
                    result[bitCount - i - 1] = bit;
                } else {
                    result[bitCount - i - 1] = (bit == '0') ? '1' : '0';
                }
            }

            System.out.println(new String(result));
            System.out.flush();
            scanner.nextLine();
        }

        scanner.close();
    }
}