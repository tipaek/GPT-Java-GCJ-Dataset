import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int testCaseCount = sc.nextInt();
        final int bitCount = sc.nextInt();

        for (int i = 0; i < testCaseCount; i++) {
            int[] bits = new int[bitCount];

            for (int j = 0; j < 10; j++) {
                System.out.println(j + 1);
                bits[j] = sc.nextInt();
            }
            print(bits);
            if (!"Y".equals(sc.next())) {
                System.exit(1);
            }
        }
    }

    public static void complement(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = (bits[i] + 1) % 2;
        }
    }

    public static void reverse(int[] bits) {
        for (int i = 0; i < bits.length / 2; i++) {
            int temp = bits[i];
            bits[i] = bits[bits.length - 1 - i];
            bits[bits.length - 1 - i] = temp;
        }
    }

    public static void print(int[] bits) {
        StringBuilder sb = new StringBuilder(bits.length);
        for (int bit : bits) {
            sb.append(bit);
        }
        System.out.println(sb.toString());
    }
}
