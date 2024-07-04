import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    private static String stringify(BitSet bitset, int bitCount) {
        StringBuilder sb = new StringBuilder(bitCount);
        for (int i = 0; i < bitCount; i++) {
            sb.append(bitset.get(i) ? '1' : '0');
        }
        return sb.toString();
    }
    
    private static BitSet flip(BitSet bitset, int bitCount) {
        BitSet result = new BitSet(bitCount);
        for (int i = 0; i < bitCount; i++) {
            result.set(i, !bitset.get(i));
        }
        return result;
    }

    private static BitSet reverse(BitSet bitset, int bitCount) {
        BitSet result = new BitSet(bitCount);
        for (int i = 0; i < bitCount; i++) {
            result.set(bitCount - i - 1, bitset.get(i));
        }
        return result;
    }
    
    private static boolean readBit(Scanner scanner, int bitIndex) {
        System.out.println(bitIndex + 1);
        System.out.flush();
        return scanner.next().charAt(0) == '1';
    }

    private static boolean runTest(int bitCount, Scanner scanner) {
        BitSet bitset = new BitSet(bitCount);
        int oppositeBitIndex = -1;
        int specularBitIndex = -1;
        int bitIndex = 0;
        int queryIndex = 0;
        while (bitIndex < bitCount / 2) {
            if (queryIndex > 0 && queryIndex % 10 == 0) {
                boolean oppositeChanged = false;
                boolean specularChanged = false;
                if (oppositeBitIndex >= 0) {
                    boolean bit = readBit(scanner, oppositeBitIndex);
                    oppositeChanged = bit != bitset.get(oppositeBitIndex);
                } else {
                    readBit(scanner, 0);
                }
                if (specularBitIndex >= 0) {
                    boolean bit = readBit(scanner, specularBitIndex);
                    specularChanged = bit != bitset.get(specularBitIndex);
                } else {
                    readBit(scanner, 0);
                }
                if (oppositeChanged && !specularChanged) {
                    bitset = reverse(bitset, bitCount);
                } else if (!oppositeChanged && specularChanged) {
                    bitset = flip(reverse(bitset, bitCount), bitCount);
                } else if (oppositeChanged && specularChanged) {
                    bitset = flip(bitset, bitCount);
                }
            } else {
                boolean leftBit = readBit(scanner, bitIndex);
                boolean rightBit = readBit(scanner, bitCount - bitIndex - 1);
                if (leftBit != rightBit && oppositeBitIndex < 0)
                    oppositeBitIndex = bitIndex;
                if (leftBit == rightBit && specularBitIndex < 0)
                    specularBitIndex = bitIndex;
                bitset.set(bitIndex, leftBit);
                bitset.set(bitCount - bitIndex - 1, rightBit);
                bitIndex++;
            }
            queryIndex += 2;
        }
        String stringResult = stringify(bitset, bitCount);
        System.out.println(stringResult);
        System.out.flush();
        char response = scanner.next().charAt(0);
        if (response == 'Y') {
            System.err.println("Correct: " + stringResult);
            return true;
        } else {
            System.err.println("Wrong: " + stringResult);
            return false;
        }
    }
        
    public static void main(String[] args) {
        long beginTime = System.nanoTime();
        try (Scanner scanner = new Scanner(System.in)) {
            int testCount = scanner.nextInt();
            int bitCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                if (!runTest(bitCount, scanner)) break;
            }
        }
        System.err.println( "Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}