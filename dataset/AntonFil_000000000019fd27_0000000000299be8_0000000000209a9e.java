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
            readTest(bitsCount, sc);
            sc.nextLine();
        }
        sc.close();
    }

    private static void readTest(int totalCount, Scanner sc) {
        bits = new StringBuilder(totalCount);
        notEqualInversedBlocksFound = false;
        equalBitPos = 0;
        notEqualBitPos = 0;
        inversedBlocksFound = false;
        firstInversedBitPos = 0;
        equalBlocksFound = false;
        firstEqualBitPos = 0;
        //
        readBlocks(1, 5, totalCount, sc);
        int i = 6;
        for (; bits.length() < totalCount - 8; i += 4) {
            readBlocks(i, 4, totalCount, sc);
        }
        //
        int restCount = totalCount - bits.length();
        if (restCount >= 1) {
            StringBuilder s = readBitsRange(i, i + restCount - 1, sc);
            int mid = bits.length() / 2;
            bits.insert(mid, s);
        }
        //
        System.out.println(bits);
        System.out.flush();
    }

    private static void readBlocks(int start, int count, int totalCount, Scanner sc) {
        StringBuilder s1 = readBitsRange(start, start + count - 1, sc);
        StringBuilder s2 = readBitsRange(totalCount - start + 1, totalCount - start - count + 2, sc);
        //
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
        //
        int mid = bits.length() / 2;
        bits.insert(mid, s1.append(rotateBits(s2)));
        //System.out.println(bits);//debug
        //
        Operation op = notEqualInversedBlocksFound
                ? getOperationByNotEqualInversedBlocks(sc)
                : getOperationByEqualInversedBlocks(sc);
        //System.out.println(op);//debug
        //
        transformBits(bits, op);
        //System.out.println(bits);//debug
    }

    private static Operation getOperationByNotEqualInversedBlocks(Scanner sc) {
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

    private static Operation getOperationByEqualInversedBlocks(Scanner sc) {
        boolean inverse = false;
        boolean rotate = false;
        //
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
            readBit(1, sc); //just a redundant read
        } else if (inversedBlocksFound) {
            char c = readBit(firstInversedBitPos, sc);
            if (c != bits.charAt(firstInversedBitPos - 1)) {
                inverse = true;
            }
            readBit(1, sc); //just a redundant read
        }
        //
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
        int bitsCount = start < end ? end - start + 1 : start - end + 1;
        int inc = start < end ? 1 : -1;
        StringBuilder sb = new StringBuilder(bitsCount);
        //
        for (int i = start; true; i += inc) {
            System.out.println(i);
            System.out.flush();
            char bit = sc.nextLine().charAt(0);
            sb.append(bit);
            if (i == end) {
                break;
            }
        }
        //
        return sb;
    }

    private static void transformBits(StringBuilder bits, Operation op) {
        switch (op) {
            case INVERSE: inverseBits(bits);
                          break;
            case ROTATE: rotateBits(bits);
                         break;
            case ROTATE_AND_INVERSE: inverseBits(bits);
                                     rotateBits(bits);
                                     break;
        }
    }

    private static char inverseChar(char c) {
        return (c == '0') ? '1' : '0';
    }

    private static StringBuilder inverseBits(StringBuilder bits) {
        for (int i = 0; i < bits.length(); i++) {
            char c = inverseChar(bits.charAt(i));
            bits.setCharAt(i, c);
        }
        return bits;
    }

    private static StringBuilder rotateBits(StringBuilder bits) {
        int length = bits.length();
        int half = bits.length() / 2;
        for (int i = 0; i < half; i++) {
            char c = bits.charAt(i);
            bits.setCharAt(i, bits.charAt(length - i - 1));
            bits.setCharAt(length - i - 1, c);
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
