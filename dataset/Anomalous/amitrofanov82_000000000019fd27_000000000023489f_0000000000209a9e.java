import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

    private static Scanner sc;

    public static void main(String[] args) throws Exception {
        initializeScanner();
        String[] tbLine = sc.nextLine().split(" ");
        int testCases = Integer.parseInt(tbLine[0]);
        int B = Integer.parseInt(tbLine[1]);

        for (int i = 1; i <= testCases; i++) {
            processTestCase(B);
            System.out.flush();
            String response = sc.nextLine();
            if ("N".equals(response)) {
                break;
            }
        }
        sc.close();
    }

    private static void initializeScanner() throws Exception {
        if ("Alexey".equals(System.getProperty("user.name"))) {
            sc = new Scanner(new FileInputStream("input.txt"));
            System.err.println("development mode, reading from file");
        } else {
            sc = new Scanner(System.in);
        }
    }

    private static void processTestCase(int B) {
        boolean[] bitSet = new boolean[B];
        int bCounter = 0;

        for (int i = 1; i <= 10; i++) {
            fetchBit(bitSet, B, bCounter++);
            if (bCounter == B) {
                printBitSet(bitSet);
                return;
            }
        }

        for (int i = 1; i <= 14; i++) {
            adjustBitSet(bitSet, bCounter);
            for (int j = 1; j <= 8; j++) {
                fetchBit(bitSet, B, bCounter++);
                if (bCounter == B) {
                    printBitSet(bitSet);
                    return;
                }
            }
        }
    }

    private static void fetchBit(boolean[] bitSet, int B, int bCounter) {
        if (bCounter % 2 == 0) {
            bitSet[bCounter / 2] = getBit(bCounter / 2);
        } else {
            bitSet[B - 1 - (bCounter / 2)] = getBit(B - 1 - (bCounter / 2));
        }
    }

    private static void adjustBitSet(boolean[] bitSet, int bCounter) {
        if (onlyEqualBits(bitSet, bCounter)) {
            if (bitSet[0] != getBit(0)) {
                complement(bitSet);
            }
            getBit(0);
        } else if (onlyDifferentBits(bitSet, bCounter)) {
            if (bitSet[0] == getBit(0)) {
                getBit(0);
            } else {
                complement(bitSet);
                getBit(0);
            }
        } else {
            int eqB = findEqualBit(bitSet, bCounter);
            int diffB = findDifferentBit(bitSet, bCounter);
            boolean newEqVal = getBit(eqB);
            boolean newDiffVal = getBit(diffB);

            if (newEqVal == bitSet[eqB]) {
                if (newDiffVal != bitSet[diffB]) {
                    swap(bitSet);
                }
            } else {
                if (newDiffVal != bitSet[diffB]) {
                    complement(bitSet);
                } else {
                    swap(bitSet);
                    complement(bitSet);
                }
            }
        }
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

    private static boolean onlyDifferentBits(boolean[] bitSet, int bCounter) {
        for (int i = 0; i < bCounter / 2; i++) {
            if (bitSet[i] == bitSet[bitSet.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean onlyEqualBits(boolean[] bitSet, int bCounter) {
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
        return Byte.parseByte(sc.nextLine()) != 0;
    }
}