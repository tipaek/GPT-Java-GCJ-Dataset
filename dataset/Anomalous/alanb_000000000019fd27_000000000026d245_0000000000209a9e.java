import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class QuantumBits {
    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        int bitLength = scan.nextInt();
        
        for (int testCase = 0; testCase < testCases; testCase++) {
            int[] bits = new int[bitLength];
            
            for (int j = 0; j < 5; j++) {
                bits[j] = requestBit(j + 1);
                bits[bitLength - j - 1] = requestBit(bitLength - j);
            }

            int[] checkIndices = new int[3];
            int[] previousCheck = new int[3];
            
            for (int j = 7; j <= 28; j++) {
                if (Integer.bitCount(j) != 3) continue;
                
                int[] b0 = new int[5];
                int[] b1 = new int[5];
                int count = 0;
                
                for (int k = 0; k < 5; k++) {
                    if ((j & (1 << k)) >= 1) {
                        b0[k] = bits[k];
                        b1[k] = bits[bitLength - k - 1];
                        checkIndices[count++] = k;
                    }
                }
                
                if (!Arrays.equals(b0, b1) && !Arrays.equals(invertBits(b0), b1)) {
                    previousCheck = b0;
                    break;
                }
            }

            int[] newCheck = new int[3];
            int filledBits = 5;
            
            for (int j = 10; j < 150 && filledBits < bitLength - 5; j++) {
                if (j % 10 < 3) {
                    newCheck[j % 10] = requestBit(checkIndices[j % 10] + 1);
                }
                
                if (j % 10 == 3) {
                    if (Arrays.equals(newCheck, previousCheck)) {
                        continue;
                    } else if (Arrays.equals(invertBits(newCheck), previousCheck)) {
                        invertArray(bits);
                        previousCheck = Arrays.copyOf(newCheck, 3);
                    } else if (Arrays.equals(reflectBits(newCheck), previousCheck)) {
                        reflectArray(bits);
                        previousCheck = Arrays.copyOf(newCheck, 3);
                    } else if (Arrays.equals(invertBits(reflectBits(newCheck)), previousCheck)) {
                        reflectArray(bits);
                        invertArray(bits);
                        previousCheck = Arrays.copyOf(newCheck, 3);
                    }
                }
                
                if (j % 10 >= 3) {
                    bits[filledBits] = requestBit(filledBits + 1);
                    filledBits++;
                }
            }
            
            for (int bit : bits) {
                System.out.print(bit);
            }
            System.out.println();
            scan.nextLine();
            if (scan.nextLine().contains("N")) break;
        }
        scan.close();
    }

    private static int requestBit(int index) {
        System.out.println(index);
        return scan.nextInt();
    }

    private static int[] invertBits(int[] bits) {
        int[] inverted = new int[bits.length];
        for (int i = 0; i < bits.length; i++) {
            inverted[i] = bits[i] == 0 ? 1 : 0;
        }
        return inverted;
    }

    private static int[] reflectBits(int[] bits) {
        int[] reflected = new int[bits.length];
        for (int i = 0; i < bits.length; i++) {
            reflected[i] = bits[bits.length - i - 1];
        }
        return reflected;
    }

    private static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
    }

    private static void reflectArray(int[] array) {
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = temp;
        }
    }
}