import java.util.Scanner;

public class Solution {

    private static StringBuilder bits = new StringBuilder();

    private static boolean notEqualInversedBlocksFound = false;
    private static int equalBitPos = 0;
    private static int notEqualBitPos = 0;

    private static boolean inversedBlocksFound = false;
    private static int firstInversedBitPos = 0;

    private static boolean equalBlocksFound = false;
    private static int firstEqualBitPos = 0;

    private enum Operation {
        ROTATE,
        INVERSE,
        ROTATE_AND_INVERSE,
        NONE
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testsCount = sc.nextInt();
        int bitsCount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < testsCount; i++) {
            processTest(bitsCount, sc);
            sc.nextLine();
        }
        sc.close();
    }

    private static void processTest(int totalCount, Scanner sc) {
        bits.setLength(0);
        resetFlagsAndPositions();
        readAndProcessBlocks(1, 5, totalCount, sc);
        for (int i = 6; bits.length() < totalCount - 8; i += 4) {
            readAndProcessBlocks(i, 4, totalCount, sc);
        }
        handleRemainingBits(totalCount, sc);
        System.out.println(bits);
        System.out.flush();
    }

    private static void resetFlagsAndPositions() {
        notEqualInversedBlocksFound = false;
        equalBitPos = 0;
        notEqualBitPos = 0;
        inversedBlocksFound = false;
        firstInversedBitPos = 0;
        equalBlocksFound = false;
        firstEqualBitPos = 0;
    }

    private static void readAndProcessBlocks(int start, int count, int totalCount, Scanner sc) {
        StringBuilder s1 = readBitsRange(start, start + count - 1, sc);
        StringBuilder s2 = readBitsRange(totalCount - start + 1, totalCount - start - count + 2, sc);

        updateFlagsAndPositions(start, s1, s2);

        int mid = bits.length() / 2;
        bits.insert(mid, s1.append(rotateBits(s2)));

        Operation operation = notEqualInversedBlocksFound
                ? determineOperationByNotEqualInversedBlocks(sc)
                : determineOperationByEqualInversedBlocks(sc);

        transformBits(bits, operation);
    }

    private static void updateFlagsAndPositions(int start, StringBuilder s1, StringBuilder s2) {
        if (!equal(s1, s2) && !inversed(s1, s2)) {
            if (!notEqualInversedBlocksFound) {
                equalBitPos = start + getEqualBitPos(s1, s2);
                notEqualBitPos = start + getNotEqualBitPos(s1, s2);
                notEqualInversedBlocksFound = true;
            }
        } else if (inversed(s1, s2)) {
            if (!inversedBlocksFound) {
                firstInversedBitPos = start;
                inversedBlocksFound = true;
            }
        } else if (equal(s1, s2)) {
            if (!equalBlocksFound) {
                firstEqualBitPos = start;
                equalBlocksFound = true;
            }
        }
    }

    private static void handleRemainingBits(int totalCount, Scanner sc) {
        int remainingBits = totalCount - bits.length();
        if (remainingBits >= 1) {
            StringBuilder remainingBitsRange = readBitsRange(bits.length() + 1, bits.length() + remainingBits, sc);
            int mid = bits.length() / 2;
            bits.insert(mid, remainingBitsRange);
        }
    }

    private static Operation determineOperationByNotEqualInversedBlocks(Scanner sc) {
        boolean inverse = false;
        boolean rotate = false;
        char c = readBit(equalBitPos, sc);
        if (c != bits.charAt(equalBitPos - 1)) {
            inverse = true;
        }
        c = readBit(notEqualBitPos, sc);
        if (!inverse) {
            if (c != bits.charAt(notEqualBitPos - 1)) {
                rotate = true;
            }
        } else {
            if (c == bits.charAt(notEqualBitPos - 1)) {
                rotate = true;
            }
        }
        return determineOperation(inverse, rotate);
    }

    private static Operation determineOperationByEqualInversedBlocks(Scanner sc) {
        boolean inverse = false;
        boolean rotate = false;

        if (inversedBlocksFound && equalBlocksFound) {
            char c1 = readBit(firstEqualBitPos, sc);
            char c2 = readBit(firstInversedBitPos, sc);
            if (c1 != bits.charAt(firstEqualBitPos - 1)) {
                inverse = true;
            }
            if (!inverse) {
                if (c2 != bits.charAt(firstInversedBitPos - 1)) {
                    rotate = true;
                }
            } else {
                if (c2 == bits.charAt(firstInversedBitPos - 1)) {
                    rotate = true;
                }
            }
        } else if (equalBlocksFound) {
            char c = readBit(firstEqualBitPos, sc);
            if (c != bits.charAt(firstEqualBitPos - 1)) {
                inverse = true;
            }
            readBit(1, sc); // redundant read
        } else if (inversedBlocksFound) {
            char c = readBit(firstInversedBitPos, sc);
            if (c != bits.charAt(firstInversedBitPos - 1)) {
                inverse = true;
            }
            readBit(1, sc); // redundant read
        }

        return determineOperation(inverse, rotate);
    }

    private static Operation determineOperation(boolean inverse, boolean rotate) {
        if (inverse && rotate) {
            return Operation.ROTATE_AND_INVERSE;
        } else if (inverse) {
            return Operation.INVERSE;
        } else if (rotate) {
            return Operation.ROTATE;
        } else {
            return Operation.NONE;
        }
    }

    private static char readBit(int pos, Scanner sc) {
        System.out.println(pos);
        System.out.flush();
        return sc.nextLine().charAt(0);
    }

    private static StringBuilder readBitsRange(int start, int end, Scanner sc) {
        int bitsCount = Math.abs(end - start) + 1;
        int increment = start < end ? 1 : -1;
        StringBuilder sb = new StringBuilder(bitsCount);

        for (int i = start; ; i += increment) {
            System.out.println(i);
            System.out.flush();
            sb.append(sc.nextLine().charAt(0));
            if (i == end) break;
        }

        return sb;
    }

    private static void transformBits(StringBuilder bits, Operation op) {
        switch (op) {
            case INVERSE:
                inverseBits(bits);
                break;
            case ROTATE:
                rotateBits(bits);
                break;
            case ROTATE_AND_INVERSE:
                inverseBits(bits);
                rotateBits(bits);
                break;
            default:
                break;
        }
    }

    private static char inverseChar(char c) {
        return c == '0' ? '1' : '0';
    }

    private static StringBuilder inverseBits(StringBuilder bits) {
        for (int i = 0; i < bits.length(); i++) {
            bits.setCharAt(i, inverseChar(bits.charAt(i)));
        }
        return bits;
    }

    private static StringBuilder rotateBits(StringBuilder bits) {
        int length = bits.length();
        for (int i = 0; i < length / 2; i++) {
            char temp = bits.charAt(i);
            bits.setCharAt(i, bits.charAt(length - i - 1));
            bits.setCharAt(length - i - 1, temp);
        }
        return bits;
    }

    private static boolean inversed(StringBuilder sb1, StringBuilder sb2) {
        for (int i = 0; i < sb1.length(); i++) {
            if (sb1.charAt(i) != inverseChar(sb2.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean equal(StringBuilder sb1, StringBuilder sb2) {
        for (int i = 0; i < sb1.length(); i++) {
            if (sb1.charAt(i) != sb2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static int getEqualBitPos(StringBuilder sb1, StringBuilder sb2) {
        for (int i = 0; i < sb1.length(); i++) {
            if (sb1.charAt(i) == sb2.charAt(i)) {
                return i;
            }
        }
        return -1;
    }

    private static int getNotEqualBitPos(StringBuilder sb1, StringBuilder sb2) {
        for (int i = 0; i < sb1.length(); i++) {
            if (sb1.charAt(i) != sb2.charAt(i)) {
                return i;
            }
        }
        return -1;
    }
}