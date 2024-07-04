import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            if (bitLength == 10) {
                System.out.println(generateBitString());
                System.out.flush();
                scanner.nextLine(); // Consume newline
                String response = scanner.nextLine().trim();
                if (!response.equals("Y")) {
                    break;
                }
            }
        }
    }

    private static String generateBitString() {
        int[] bits = new int[10];
        for (int i = 0; i < 10; i++) {
            bits[i] = readBitAtPosition(i);
        }

        StringBuilder bitString = new StringBuilder();
        for (int bit : bits) {
            bitString.append(bit);
        }
        return bitString.toString();
    }

    private static int readBitAtPosition(int position) {
        System.out.println(position + 1);
        System.out.flush();
        return scanner.nextInt();
    }
}