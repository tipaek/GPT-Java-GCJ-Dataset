import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static Scanner scanner;

    public static void main(String[] args) throws FileNotFoundException {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int[] bits = new int[bitLength];

            for (int i = 0; i < 5; i++) {
                bits[i] = requestBit(i + 1);
                bits[bitLength - i - 1] = requestBit(bitLength - i);
            }

            int[] checkIndices = new int[3];
            int[] previousCheck = new int[3];
            for (int i = 7; i <= 28; i++) {
                if (Integer.bitCount(i) != 3) continue;

                int[] b0 = new int[5];
                int[] b1 = new int[5];
                int count = 0;

                for (int j = 0; j < 5; j++) {
                    if ((i & (1 << j)) >= 1) {
                        b0[j] = bits[j];
                        b1[j] = bits[bitLength - j - 1];
                        previousCheck[count] = bits[j];
                        checkIndices[count++] = j;
                    }
                }

                if (!(b0[0] == b1[0] && b0[1] == b1[1] && b0[2] == b1[2]) &&
                    !(b0[0] != b1[0] && b0[1] != b1[1] && b0[2] != b1[2])) {
                    break;
                }
            }

            int[] newCheck = new int[3];
            int count = 5;

            for (int i = 10; i < 150 && count < bitLength - 5; i++) {
                if (i % 10 < 3) {
                    newCheck[i % 10] = requestBit(checkIndices[i % 10] + 1);
                }

                if (i % 10 == 3) {
                    if (Arrays.equals(newCheck, previousCheck)) {
                        continue;
                    } else if (newCheck[0] != previousCheck[0] && newCheck[1] != previousCheck[1] && newCheck[2] != previousCheck[2]) {
                        invertBits(bits);
                    } else if (newCheck[0] == previousCheck[2] && newCheck[1] == previousCheck[1] && newCheck[2] == previousCheck[1]) {
                        reflectBits(bits);
                    } else if (newCheck[0] != previousCheck[2] && newCheck[1] != previousCheck[1] && newCheck[2] != previousCheck[1]) {
                        reflectBits(bits);
                        invertBits(bits);
                    }

                    previousCheck = Arrays.copyOf(newCheck, 3);
                    bits[checkIndices[0]] = newCheck[0];
                    bits[checkIndices[1]] = newCheck[1];
                    bits[checkIndices[2]] = newCheck[2];
                }

                if (i % 10 >= 3) {
                    bits[count] = requestBit(count + 1);
                    count++;
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

    private static int requestBit(int index) {
        System.out.println(index);
        return scanner.nextInt();
    }

    private static void invertBits(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = (bits[i] == 0) ? 1 : 0;
        }
    }

    private static void reflectBits(int[] bits) {
        int length = bits.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = bits[i];
            bits[i] = bits[length - i - 1];
            bits[length - i - 1] = temp;
        }
    }
}