import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            char[] bitData = new char[bitLength];
            int leftIndex = 0;
            int rightIndex = bitLength - 1;

            while (leftIndex < rightIndex) {
                System.out.println(leftIndex + 1);
                String leftResponse = scanner.nextLine();
                System.out.println(rightIndex + 1);
                String rightResponse = scanner.nextLine();

                if (leftResponse.equals(rightResponse)) {
                    bitData[leftIndex] = 'S';
                    bitData[rightIndex] = 'S';
                } else {
                    bitData[leftIndex] = 'D';
                    bitData[rightIndex] = 'D';
                }

                leftIndex++;
                rightIndex--;
            }

            char[] result = new char[bitLength];
            for (int i = 0; i < bitLength / 2; i++) {
                System.out.println(i + 1);
                String response = scanner.nextLine();

                if (response.equals("0")) {
                    result[i] = '0';
                    result[bitLength - i - 1] = (bitData[i] == 'S') ? '0' : '1';
                } else if (response.equals("1")) {
                    result[i] = '1';
                    result[bitLength - i - 1] = (bitData[i] == 'S') ? '1' : '0';
                }
            }

            System.out.println(new String(result));
            scanner.nextLine();
        }

        scanner.close();
    }
}