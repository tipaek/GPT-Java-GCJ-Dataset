import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution {
    static Scanner scanner;

    public static void main(String[] args) throws FileNotFoundException {
        scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int bitLength = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int[] bits = new int[bitLength];
            
            // Initial bit fetching
            for (int j = 0; j < 5; j++) {
                bits[j] = requestBit(j + 1);
                bits[bitLength - j - 1] = requestBit(bitLength - j);
            }

            // Determine the pattern
            int[] checkIndices = new int[3];
            int[] previousCheckValues = new int[3];
            for (int j = 7; j <= 28; j++) {
                if (Integer.bitCount(j) != 3) continue;

                int[] bits0 = new int[5];
                int[] bits1 = new int[5];
                int count = 0;

                for (int k = 0; k < 5; k++) {
                    if ((j & (1 << k)) >= 1) {
                        bits0[k] = bits[k];
                        bits1[k] = bits[bitLength - k - 1];
                        previousCheckValues[count] = bits[k];
                        checkIndices[count++] = k;
                    }
                }

                if (!Arrays.equals(bits0, bits1) && !Arrays.equals(bits0, invertArray(bits1))) {
                    break;
                }
            }

            int[] newCheckValues = new int[3];
            int count = 5;

            for (int j = 10; j < 150 && count < bitLength - 5; j++) {
                if (j % 10 < 3) {
                    newCheckValues[j % 10] = requestBit(checkIndices[j % 10] + 1);
                }

                if (j % 10 == 3) {
                    if (Arrays.equals(newCheckValues, previousCheckValues)) {
                        continue;
                    } else if (Arrays.equals(newCheckValues, invertArray(previousCheckValues))) {
                        invertBits(bits);
                    } else if (Arrays.equals(newCheckValues, reflectArray(bits, checkIndices))) {
                        reflectBits(bits);
                    } else if (Arrays.equals(newCheckValues, invertArray(reflectArray(bits, checkIndices)))) {
                        reflectBits(bits);
                        invertBits(bits);
                    }

                    System.arraycopy(bits, checkIndices[0], previousCheckValues, 0, 3);
                }

                if (j % 10 >= 3) {
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

    public static int requestBit(int position) {
        System.out.println(position);
        return scanner.nextInt();
    }

    private static int[] invertArray(int[] array) {
        return Arrays.stream(array).map(bit -> bit == 0 ? 1 : 0).toArray();
    }

    private static int[] reflectArray(int[] array, int[] indices) {
        return Arrays.stream(indices).map(index -> array[array.length - 1 - index]).toArray();
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