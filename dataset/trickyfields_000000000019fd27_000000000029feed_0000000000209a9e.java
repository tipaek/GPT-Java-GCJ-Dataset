import java.util.Scanner;

public class Solution {

    private static int offset;
    private static int readCount;
    private static int bitCount;
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        final int testCaseCount = sc.nextInt();
        bitCount = sc.nextInt();

        for (int i = 0; i < testCaseCount; i++) {
            offset = 0;
            readCount = 0;
            int[] bits = new int[bitCount];

            while (offset < bitCount / 2) {
                readUntilFluctuation(bits);
                correctBits(bits);
            }

            print(bits);
            if (!"Y".equals(sc.next())) {
                System.exit(1);
            }
        }
    }

    private static void readUntilFluctuation(int[] bits) {
        if (readCount % 2 == 1) {
            System.out.println(1);
            sc.nextInt();
            readCount++;
        }
        do {
            System.out.println(offset + 1);
            bits[offset] = sc.nextInt();

            System.out.println(bitCount - offset);
            bits[bitCount - 1 - offset] = sc.nextInt();

            offset++;
            readCount += 2;
        } while (readCount % 10 != 0);
    }

    public static void correctBits(int[] bits) {
        boolean complement = true;
        boolean reversal = true;
        boolean both = true;
        boolean nothing = true;

        for (int i = 0; i < bits.length / 2; i++) {
            if (bits[i] == bits[bits.length - 1 - i]) {
                System.out.println(i + 1);
                int newBit = sc.nextInt();
                if (newBit == bits[i]) {
                    complement = false;
                    both = false;
                } else {
                    reversal = false;
                    nothing = false;
                }
                readCount++;
                break;
            }
        }

        for (int i = 0; i < bits.length / 2; i++) {
            if (bits[i] != bits[bits.length - 1 - i]) {
                System.out.println(i + 1);
                int newBit = sc.nextInt();
                if (newBit != bits[i]) {
                    both = false;
                    nothing = false;
                } else {
                    reversal = false;
                    complement = false;
                }
                readCount++;
                break;
            }
        }

        if (!nothing) {
            if (reversal) {
                reverse(bits);
            } else if (complement) {
                complement(bits);
            } else if (both) {
                complement(bits);
                reverse(bits);
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
