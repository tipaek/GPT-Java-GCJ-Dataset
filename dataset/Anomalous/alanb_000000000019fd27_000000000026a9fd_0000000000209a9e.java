import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    static Scanner scanner;

    public static void main(String[] args) throws FileNotFoundException {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int testCase = 0; testCase < testCases; testCase++) {
            int[] bits = new int[bitLength];
            
            // Initial request to fill half of the bits array
            for (int index = 0; index < 5; index++) {
                bits[index] = requestBit(index + 1);
                bits[bitLength - index - 1] = requestBit(bitLength - index);
            }

            int[] checkIndices = new int[3];
            int[] previousCheck = new int[3];

            // Determine initial valid check indices
            for (int bitmask = 7; bitmask <= 28; bitmask++) {
                if (Integer.bitCount(bitmask) != 3) continue;

                int[] bits0 = new int[5];
                int[] bits1 = new int[5];
                int count = 0;

                for (int position = 0; position < 5; position++) {
                    if ((bitmask & (1 << position)) >= 1) {
                        bits0[position] = bits[position];
                        bits1[position] = bits[bitLength - position - 1];
                        checkIndices[count++] = position;
                    }
                }

                if (!((bits0[0] == bits1[0] && bits0[1] == bits1[1] && bits0[2] == bits1[2]) || 
                      (bits0[0] != bits1[0] && bits0[1] != bits1[1] && bits0[2] != bits1[2]))) {
                    previousCheck = bits0;
                    break;
                }
            }

            int[] newCheck = new int[3];
            int filledBits = 5;

            // Continue requesting bits and checking conditions
            for (int requestCount = 10; requestCount < 150 && filledBits < bitLength - 5; requestCount++) {
                if (requestCount % 10 < 3) {
                    newCheck[requestCount % 10] = requestBit(checkIndices[requestCount % 10] + 1);
                }

                if (requestCount % 10 == 3) {
                    if (Arrays.equals(newCheck, previousCheck)) {
                        continue;
                    } else if (newCheck[0] != previousCheck[0] && newCheck[1] != previousCheck[1] && newCheck[2] != previousCheck[2]) {
                        invertBits(bits);
                        previousCheck = Arrays.copyOf(newCheck, 3);
                    } else if (newCheck[0] == previousCheck[2] && newCheck[1] == previousCheck[1] && newCheck[2] == previousCheck[1]) {
                        reflectBits(bits);
                        previousCheck = Arrays.copyOf(newCheck, 3);
                    } else if (newCheck[0] != previousCheck[2] && newCheck[1] != previousCheck[1] && newCheck[2] != previousCheck[1]) {
                        reflectAndInvertBits(bits);
                        previousCheck = Arrays.copyOf(newCheck, 3);
                    }
                }

                if (requestCount % 10 >= 3) {
                    bits[filledBits] = requestBit(filledBits + 1);
                    filledBits++;
                }
            }

            for (int bit : bits) {
                System.out.print(bit);
            }
            System.out.println();
        }

        scanner.close();
    }

    public static int requestBit(int position) {
        System.out.println(position);
        return scanner.nextInt();
    }

    private static void invertBits(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            bits[i] = bits[i] == 0 ? 1 : 0;
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

    private static void reflectAndInvertBits(int[] bits) {
        reflectBits(bits);
        invertBits(bits);
    }
}