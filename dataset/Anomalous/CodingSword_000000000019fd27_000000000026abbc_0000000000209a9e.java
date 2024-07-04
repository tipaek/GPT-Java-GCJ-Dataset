import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static int queryCount = 0;
    static int bitLength;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            queryCount = 0;
            bitLength = scanner.nextInt();

            int[] bits = new int[bitLength];
            boolean[] same = new boolean[bitLength / 2 + 1];
            boolean sameFlipped = false, oppFlipped = false;

            int i = 0;
            int lowerHalf = (bitLength - 1) / 2;

            int firstOpposite = -1, firstSame = -1;

            while (i <= lowerHalf) {
                if (queryCount % 10 == 0) {
                    verifyBits(firstSame, firstOpposite, bits, same, scanner, i - 1);
                }

                retrieveBits(i, bits, same, scanner);
                if (firstOpposite == -1 && !same[i]) {
                    firstOpposite = i;
                } else if (firstSame == -1 && same[i]) {
                    firstSame = i;
                }

                if (i == lowerHalf) {
                    StringBuilder result = new StringBuilder();
                    for (int j = 0; j < bitLength; j++) {
                        result.append(bits[j]);
                    }

                    System.out.println(result.toString());
                    System.out.flush();

                    scanner.nextLine();
                    char response = scanner.nextLine().charAt(0);
                    if (response == 'N') {
                        return;
                    }
                    break;
                }

                i++;
            }
        }
    }

    public static void retrieveBits(int i, int[] bits, boolean[] same, Scanner scanner) {
        int bit1 = queryBit(i, scanner);
        int bit2 = queryBit(bitLength - i - 1, scanner);

        bits[i] = bit1;
        bits[bitLength - (i + 1)] = bit2;

        same[i] = bit1 == bit2;
    }

    public static void verifyBits(int firstSame, int firstOpposite, int[] bits, boolean[] same, Scanner scanner, int maxBit) {
        if (firstSame < 0 && firstOpposite < 0) {
            return;
        }

        boolean sameFlipped = false, oppFlipped = false;
        if (firstSame >= 0) {
            int tempBit = queryBit(firstSame, scanner);
            if (tempBit != bits[firstSame]) {
                sameFlipped = true;
            }
        }

        if (firstOpposite >= 0) {
            int tempBit = queryBit(firstOpposite, scanner);
            if (tempBit != bits[firstOpposite]) {
                oppFlipped = true;
            }
        }

        if (firstOpposite < 0 || firstSame < 0) {
            queryBit(0, scanner);
        }

        if (!oppFlipped && !sameFlipped) {
            return;
        }

        for (int i = 0; i <= maxBit; i++) {
            if ((same[i] && sameFlipped) || (!same[i] && oppFlipped)) {
                bits[i] = (bits[i] + 1) % 2;
                bits[bitLength - i - 1] = (bits[bitLength - i - 1] + 1) % 2;
            }
        }
    }

    public static int queryBit(int index, Scanner scanner) {
        System.out.println(index + 1);
        System.out.flush();
        queryCount++;

        return scanner.nextInt();
    }
}