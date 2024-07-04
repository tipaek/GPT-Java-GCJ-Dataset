import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            char[] data = new char[bitLength];
            int left = 0;
            int right = bitLength - 1;

            while (left < right) {
                System.out.println(left + 1);
                String leftResponse = scanner.nextLine();
                System.out.println(right + 1);
                String rightResponse = scanner.nextLine();

                if (leftResponse.equals(rightResponse)) {
                    data[left] = 'S';
                    data[right] = 'S';
                } else {
                    data[left] = 'D';
                    data[right] = 'D';
                }

                left++;
                right--;
            }

            char[] result = new char[bitLength];
            for (int i = 0; i < bitLength / 2; i++) {
                System.out.println(i + 1);
                String response = scanner.nextLine();

                if (response.equals("0")) {
                    result[i] = '0';
                    result[bitLength - i - 1] = (data[i] == 'S') ? '0' : '1';
                } else if (response.equals("1")) {
                    result[i] = '1';
                    result[bitLength - i - 1] = (data[i] == 'S') ? '1' : '0';
                }
            }

            System.out.println(new String(result));
            scanner.nextLine();
        }

        scanner.close();
    }
}