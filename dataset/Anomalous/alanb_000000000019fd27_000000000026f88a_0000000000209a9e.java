import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    static Scanner scanner;

    public static void main(String[] args) throws FileNotFoundException {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int[] bits = new int[bitLength];

            for (int j = 0; j < 5; j++) {
                bits[j] = requestBit(j + 1);
                bits[bitLength - j - 1] = requestBit(bitLength - j);
            }

            int[] checkIndices = new int[3];
            int[] previousCheck = new int[3];

            for (int j = 7; j <= 28; j++) {
                if (Integer.bitCount(j) != 3) continue;

                int[] bit0 = new int[5];
                int[] bit1 = new int[5];
                int count = 0;

                for (int k = 0; k < 5; k++) {
                    if ((j & (1 << k)) >= 1) {
                        bit0[k] = bits[k];
                        bit1[k] = bits[bitLength - k - 1];
                        previousCheck[count] = bits[k];
                        checkIndices[count++] = k;
                    }
                }

                if (!(bit0[0] == bit1[0] && bit0[1] == bit1[1] && bit0[2] == bit1[2]) &&
                    !(bit0[0] != bit1[0] && bit0[1] != bit1[1] && bit0[2] != bit1[2])) {
                    break;
                }
            }

            int[] newCheck = new int[3];
            int filledCount = 5;

            for (int j = 10; j < 150 && filledCount < bitLength - 5; j++) {
                if (j % 10 < 3) {
                    newCheck[j % 10] = requestBit(checkIndices[j % 10] + 1);
                }

                if (j % 10 == 3) {
                    if (Arrays.equals(newCheck, previousCheck)) {
                        continue;
                    } else if (newCheck[0] != previousCheck[0] && newCheck[1] != previousCheck[1] && newCheck[2] != previousCheck[2]) {
                        invertBits(bits);
                    } else if (newCheck[0] == bits[bitLength - 1 - checkIndices[0]] &&
                               newCheck[1] == bits[bitLength - 1 - checkIndices[1]] &&
                               newCheck[2] == bits[bitLength - 1 - checkIndices[2]]) {
                        reflectBits(bits);
                    } else if (newCheck[0] != bits[bitLength - 1 - checkIndices[0]] &&
                               newCheck[1] != bits[bitLength - 1 - checkIndices[1]] &&
                               newCheck[2] != bits[bitLength - 1 - checkIndices[2]]) {
                        reflectBits(bits);
                        invertBits(bits);
                    }

                    previousCheck = Arrays.copyOf(newCheck, 3);
                    bits[checkIndices[0]] = newCheck[0];
                    bits[checkIndices[1]] = newCheck[1];
                    bits[checkIndices[2]] = newCheck[2];
                }

                if (j % 10 >= 3) {
                    bits[filledCount] = requestBit(filledCount + 1);
                    filledCount++;
                }
            }

            for (int bit : bits) {
                System.out.print(bit);
            }
            System.out.println();

            scanner.nextLine();
            if (scanner.nextLine().contains("N")) break;
        }

        scanner.close();
    }

    public static int requestBit(int index) {
        System.out.println(index);
        return scanner.nextInt();
    }

    private static void invertBits(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = bits[i] == 0 ? 1 : 0;
        }
    }

    private static void reflectBits(int[] bits) {
        for (int i = 0; i < bits.length / 2; i++) {
            int temp = bits[i];
            bits[i] = bits[bits.length - 1 - i];
            bits[bits.length - 1 - i] = temp;
        }
    }
}