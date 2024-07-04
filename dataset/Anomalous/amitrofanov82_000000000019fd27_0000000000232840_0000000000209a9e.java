import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

    private static Scanner sc;

    public static void main(String[] args) throws Exception {
        if (System.getProperty("user.name").equals("Alexey")) {
            sc = new Scanner(new FileInputStream("input.txt"));
            System.err.println("development mode, reading from file");
        } else {
            sc = new Scanner(System.in);
        }

        String[] input = sc.nextLine().split(" ");
        int testCases = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        for (int i = 0; i < testCases; i++) {
            processTestCase(B);
            System.out.flush();
            String response = sc.nextLine();
            if (response.equals("N")) {
                break;
            }
        }
        sc.close();
    }

    private static void processTestCase(int B) {
        boolean[] bitSet = new boolean[B];
        int bCounter = 0;

        for (int i = 0; i < 10; i++) {
            if (bCounter == B) {
                getBit(0);
                continue;
            }
            if (i % 2 == 0) {
                bitSet[bCounter / 2] = getBit(bCounter / 2);
            } else {
                bitSet[B - 1 - (bCounter / 2)] = getBit(B - 1 - (bCounter / 2));
            }
            bCounter++;
        }

        if (bCounter == B) {
            printBitSet(bitSet);
            return;
        }

        for (int i = 0; i < 14; i++) {
            if (onlyEqualBitsLeftAndRight(bitSet, bCounter)) {
                if (bitSet[0] != getBit(0)) {
                    complement(bitSet);
                }
                getBit(0);
            } else if (onlyDifferentBitsLeftAndRight(bitSet, bCounter)) {
                if (bitSet[0] == getBit(0)) {
                    getBit(0);
                } else {
                    complement(bitSet);
                    getBit(0);
                }
            } else {
                int equalIndex = findEqualBit(bitSet, bCounter);
                int diffIndex = findDifferentBit(bitSet, bCounter);
                boolean newEqualVal = getBit(equalIndex);
                boolean newDiffVal = getBit(diffIndex);

                if (newEqualVal == bitSet[equalIndex]) {
                    if (newDiffVal != bitSet[diffIndex]) {
                        swap(bitSet);
                    }
                } else {
                    if (newDiffVal != bitSet[diffIndex]) {
                        complement(bitSet);
                    } else {
                        swap(bitSet);
                        complement(bitSet);
                    }
                }
            }

            for (int j = 0; j < 8; j++) {
                if (bCounter == B) {
                    getBit(0);
                    continue;
                }
                if (j % 2 == 0) {
                    bitSet[bCounter / 2] = getBit(bCounter / 2);
                } else {
                    bitSet[B - 1 - (bCounter / 2)] = getBit(B - 1 - (bCounter / 2));
                }
                bCounter++;
            }
        }

        printBitSet(bitSet);
    }

    private static void printBitSet(boolean[] bitSet) {
        StringBuilder result = new StringBuilder();
        for (boolean bit : bitSet) {
            result.append(bit ? 1 : 0);
        }
        System.out.println(result);
    }

    private static void swap(boolean[] bitSet) {
        int length = bitSet.length;
        for (int i = 0; i < length / 2; i++) {
            boolean temp = bitSet[i];
            bitSet[i] = bitSet[length - 1 - i];
            bitSet[length - 1 - i] = temp;
        }
    }

    private static int findDifferentBit(boolean[] bitSet, int bCounter) {
        for (int i = 0; i < bCounter / 2; i++) {
            if (bitSet[i] != bitSet[bitSet.length - 1 - i]) {
                return i;
            }
        }
        return -1;
    }

    private static int findEqualBit(boolean[] bitSet, int bCounter) {
        for (int i = 0; i < bCounter / 2; i++) {
            if (bitSet[i] == bitSet[bitSet.length - 1 - i]) {
                return i;
            }
        }
        return -1;
    }

    private static void complement(boolean[] bitSet) {
        for (int i = 0; i < bitSet.length; i++) {
            bitSet[i] = !bitSet[i];
        }
    }

    private static boolean onlyDifferentBitsLeftAndRight(boolean[] bitSet, int bCounter) {
        for (int i = 0; i < bCounter / 2; i++) {
            if (bitSet[i] == bitSet[bitSet.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean onlyEqualBitsLeftAndRight(boolean[] bitSet, int bCounter) {
        for (int i = 0; i < bCounter / 2; i++) {
            if (bitSet[i] != bitSet[bitSet.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean getBit(int i) {
        System.out.println(i + 1);
        System.out.flush();
        return sc.nextLine().equals("1");
    }
}