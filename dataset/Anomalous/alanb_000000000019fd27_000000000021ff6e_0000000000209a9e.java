import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    static Scanner scanner;

    public static void main(String[] args) throws FileNotFoundException {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int bitSize = scanner.nextInt();
            int[] bits = new int[bitSize];

            // Initialize the first 5 and last 5 bits
            for (int j = 0; j < 5; j++) {
                bits[j] = requestBit(j);
                bits[bitSize - j - 1] = requestBit(bitSize - j - 1);
            }

            // Check all possible combinations of three bits
            int[] checkIndices = new int[3];
            int[] previousCheck = new int[3];

            for (int combination = 7; combination <= 28; combination++) {
                if (Integer.bitCount(combination) != 3) continue;

                int[] bits0 = new int[5];
                int[] bits1 = new int[5];
                int count = 0;

                for (int k = 0; k < 5; k++) {
                    if ((combination & (1 << k)) != 0) {
                        bits0[k] = bits[k];
                        bits1[k] = bits[bitSize - k - 1];
                        checkIndices[count++] = k;
                    }
                }

                if (!(bits0[0] == bits1[0] && bits0[1] == bits1[1] && bits0[2] == bits1[2]) &&
                    !(bits0[0] != bits1[0] && bits0[1] != bits1[1] && bits0[2] != bits1[2])) {
                    previousCheck = bits0;
                    break;
                }
            }

            int[] newCheck = new int[3];
            int count = 5;

            for (int j = 10; j < 150 && count < bitSize - 5; j++) {
                if (j % 10 < 3) {
                    newCheck[j % 10] = requestBit(checkIndices[j % 10]);
                }

                if (j % 10 == 3) {
                    if (Arrays.equals(newCheck, previousCheck)) {
                        continue;
                    } else if (newCheck[0] != previousCheck[0] && newCheck[1] != previousCheck[1] && newCheck[2] != previousCheck[2]) {
                        invertBits(bits);
                        previousCheck = Arrays.copyOf(newCheck, 3);
                    } else if (newCheck[0] == previousCheck[2] && newCheck[1] == previousCheck[1] && newCheck[2] == previousCheck[0]) {
                        reflectBits(bits);
                        previousCheck = Arrays.copyOf(newCheck, 3);
                    } else if (newCheck[0] != previousCheck[2] && newCheck[1] != previousCheck[1] && newCheck[2] != previousCheck[0]) {
                        reflectBits(bits);
                        invertBits(bits);
                        previousCheck = Arrays.copyOf(newCheck, 3);
                    }
                }

                if (j % 10 >= 3) {
                    bits[count] = requestBit(count);
                    count++;
                }
            }

            for (int bit : bits) {
                System.out.print(bit);
            }
            System.out.println();
        }
        scanner.close();
    }

    public static int requestBit(int index) {
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
            bits[i] = bits[length - 1 - i];
            bits[length - 1 - i] = temp;
        }
    }
}