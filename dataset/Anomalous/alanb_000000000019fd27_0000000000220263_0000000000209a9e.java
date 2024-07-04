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
                bits[j] = requestBit(j);
                bits[bitLength - j - 1] = requestBit(bitLength - j - 1);
            }

            int[] checkIndices = new int[3];
            int[] previousCheck = new int[3];

            for (int j = 7; j <= 28; j++) {
                if (Integer.bitCount(j) != 3) continue;

                int[] b0 = new int[5];
                int[] b1 = new int[5];
                int count = 0;

                for (int k = 0; k < 5; k++) {
                    if ((j & (1 << k)) != 0) {
                        b0[k] = bits[k];
                        b1[k] = bits[bitLength - k - 1];
                        checkIndices[count++] = k;
                    }
                }

                if (!(b0[0] == b1[0] && b0[1] == b1[1] && b0[2] == b1[2]) &&
                    !(b0[0] != b1[0] && b0[1] != b1[1] && b0[2] != b1[2])) {
                    previousCheck = b0;
                    break;
                }
            }

            int[] newCheck = new int[3];
            int count = 5;

            for (int j = 10; j < 150 && count < bitLength - 5; j++) {
                if (j % 10 < 3) {
                    newCheck[j % 10] = requestBit(checkIndices[j % 10]);
                }

                if (j % 10 == 3) {
                    if (Arrays.equals(newCheck, previousCheck)) {
                        continue;
                    } else if (Arrays.equals(invert(newCheck), previousCheck)) {
                        invertArray(bits);
                        previousCheck = Arrays.copyOf(newCheck, 3);
                    } else if (Arrays.equals(reflect(newCheck), previousCheck)) {
                        reflectArray(bits);
                        previousCheck = Arrays.copyOf(newCheck, 3);
                    } else if (Arrays.equals(invert(reflect(newCheck)), previousCheck)) {
                        reflectArray(bits);
                        invertArray(bits);
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

    private static int[] invert(int[] array) {
        int[] inverted = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            inverted[i] = (array[i] == 0) ? 1 : 0;
        }
        return inverted;
    }

    private static int[] reflect(int[] array) {
        int[] reflected = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reflected[i] = array[array.length - i - 1];
        }
        return reflected;
    }

    private static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
    }

    private static void reflectArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
}