import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static int queryCount = 0;
    static int bitLength;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        bitLength = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            queryCount = 0;

            int[] bits = new int[bitLength];
            boolean[] sameBits = new boolean[bitLength / 2 + 1];
            int firstSameIndex = -1, firstOppIndex = -1;

            for (int i = 0; i <= (bitLength - 1) / 2; i++) {
                if (queryCount % 10 == 0) {
                    checkBits(firstSameIndex, firstOppIndex, bits, sameBits, scanner, i - 1);
                }

                getBits(i, bits, sameBits, scanner);

                if (firstOppIndex == -1 && !sameBits[i]) {
                    firstOppIndex = i;
                } else if (firstSameIndex == -1 && sameBits[i]) {
                    firstSameIndex = i;
                }

                if (i == (bitLength - 1) / 2) {
                    StringBuilder result = new StringBuilder();
                    for (int bit : bits) {
                        result.append(bit);
                    }

                    System.out.println(result);
                    System.out.flush();

                    scanner.nextLine();
                    char response = scanner.nextLine().charAt(0);
                    if (response == 'N') {
                        return;
                    }
                    break;
                }
            }
        }
    }

    public static void getBits(int i, int[] bits, boolean[] sameBits, Scanner scanner) {
        int bit1 = ask(i, scanner);
        int bit2 = ask(bitLength - i - 1, scanner);

        bits[i] = bit1;
        bits[bitLength - i - 1] = bit2;

        sameBits[i] = bit1 == bit2;
    }

    public static void checkBits(int firstSameIndex, int firstOppIndex, int[] bits, boolean[] sameBits, Scanner scanner, int maxBit) {
        if (firstSameIndex < 0 && firstOppIndex < 0) {
            return;
        }

        boolean sameFlipped = false, oppFlipped = false;

        if (firstSameIndex >= 0) {
            int tempBit = ask(firstSameIndex, scanner);
            if (tempBit != bits[firstSameIndex]) {
                sameFlipped = true;
            }
        }

        if (firstOppIndex >= 0) {
            int tempBit = ask(firstOppIndex, scanner);
            if (tempBit != bits[firstOppIndex]) {
                oppFlipped = true;
            }
        }

        if (firstOppIndex < 0 || firstSameIndex < 0) {
            ask(0, scanner);
        }

        if (!oppFlipped && !sameFlipped) {
            return;
        }

        for (int i = 0; i <= maxBit; i++) {
            if ((sameBits[i] && sameFlipped) || (!sameBits[i] && oppFlipped)) {
                bits[i] = (bits[i] + 1) % 2;
                bits[bitLength - i - 1] = (bits[bitLength - i - 1] + 1) % 2;
            }
        }
    }

    public static int ask(int index, Scanner scanner) {
        System.out.println(index + 1);
        System.out.flush();
        queryCount++;
        return scanner.nextInt();
    }
}