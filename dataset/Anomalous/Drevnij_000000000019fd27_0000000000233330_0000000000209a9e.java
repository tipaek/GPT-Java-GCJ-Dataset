import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        int b = scanner.nextInt();
        
        for (int test = 1; test <= t; test++) {
            int currentQuery = 1;
            int knownBits = 0;
            boolean[] result = new boolean[b];
            
            while (knownBits < b) {
                if (knownBits > 0 && currentQuery % 10 == 1) {
                    boolean[] original = Arrays.copyOf(result, knownBits);
                    boolean[] complement = new boolean[knownBits];
                    boolean[] reversed = new boolean[knownBits];
                    boolean[] complementReversed = new boolean[knownBits];
                    
                    for (int i = 0; i < knownBits; i++) {
                        complement[i] = !result[i];
                        reversed[i] = result[knownBits - i - 1];
                        complementReversed[i] = !result[knownBits - i - 1];
                    }
                    
                    boolean isComplementSame = Arrays.equals(original, complement);
                    boolean isReversedSame = Arrays.equals(original, reversed);
                    boolean isComplementReversedSame = Arrays.equals(original, complementReversed);
                    
                    if (!isReversedSame && !isComplementSame) {
                        isReversedSame = Arrays.equals(complement, reversed);
                    }
                    
                    if (!isComplementReversedSame && !isComplementSame) {
                        isComplementReversedSame = Arrays.equals(complement, complementReversed);
                    }
                    
                    if (!isComplementReversedSame && !isReversedSame) {
                        isComplementReversedSame = Arrays.equals(reversed, complementReversed);
                    }
                    
                    if (isComplementSame && isComplementReversedSame && isReversedSame) {
                        knownBits++;
                        System.out.println(knownBits);
                        result[knownBits - 1] = scanner.nextInt() == 1;
                        currentQuery++;
                    } else {
                        handleQuery(scanner, currentQuery, knownBits, result, original, complement, reversed, complementReversed, isComplementSame, isReversedSame, isComplementReversedSame);
                    }
                } else {
                    knownBits++;
                    System.out.println(knownBits);
                    result[knownBits - 1] = scanner.nextInt() == 1;
                    currentQuery++;
                }
            }
            
            StringBuilder output = new StringBuilder();
            for (boolean bit : result) {
                output.append(bit ? '1' : '0');
            }
            System.out.println(output);
            
            if (!scanner.next().equals("Y")) {
                break;
            }
        }
    }

    private static void handleQuery(Scanner scanner, int currentQuery, int knownBits, boolean[] result, boolean[] original, boolean[] complement, boolean[] reversed, boolean[] complementReversed, boolean isComplementSame, boolean isReversedSame, boolean isComplementReversedSame) {
        if (isComplementSame && isComplementReversedSame) {
            int bitIndex = findOneBit(original, reversed);
            queryAndUpdate(scanner, currentQuery, knownBits, result, original, reversed, bitIndex);
        } else if (isComplementSame && isReversedSame) {
            int bitIndex = findOneBit(original, complementReversed);
            queryAndUpdate(scanner, currentQuery, knownBits, result, original, complementReversed, bitIndex);
        } else if (isComplementReversedSame && isReversedSame) {
            int bitIndex = findOneBit(original, complement);
            queryAndUpdate(scanner, currentQuery, knownBits, result, original, complement, bitIndex);
        } else if (isComplementReversedSame) {
            int[] bitIndices = findTwoBits(original, complement, reversed);
            queryAndUpdateTwoBits(scanner, currentQuery, knownBits, result, original, complement, reversed, bitIndices);
        } else if (isComplementSame) {
            int[] bitIndices = findTwoBits(original, complementReversed, reversed);
            queryAndUpdateTwoBits(scanner, currentQuery, knownBits, result, original, complementReversed, reversed, bitIndices);
        } else if (isReversedSame) {
            int[] bitIndices = findTwoBits(original, complementReversed, complement);
            queryAndUpdateTwoBits(scanner, currentQuery, knownBits, result, original, complementReversed, complement, bitIndices);
        } else {
            int[] bitIndices = findTwoBits(original, complementReversed, complement, reversed);
            queryAndUpdateTwoBits(scanner, currentQuery, knownBits, result, original, complementReversed, complement, reversed, bitIndices);
        }
    }

    private static void queryAndUpdate(Scanner scanner, int currentQuery, int knownBits, boolean[] result, boolean[] original, boolean[] comparison, int bitIndex) {
        int queryIndex = bitIndex + 1;
        System.out.println(queryIndex);
        boolean response = scanner.nextInt() == 1;
        currentQuery++;
        if (response != original[bitIndex]) {
            System.arraycopy(comparison, 0, result, 0, knownBits);
        }
    }

    private static void queryAndUpdateTwoBits(Scanner scanner, int currentQuery, int knownBits, boolean[] result, boolean[] original, boolean[] comparison1, boolean[] comparison2, int[] bitIndices) {
        int queryIndex1 = bitIndices[0] + 1;
        System.out.println(queryIndex1);
        boolean response1 = scanner.nextInt() == 1;
        currentQuery++;
        
        int queryIndex2 = bitIndices[1] + 1;
        System.out.println(queryIndex2);
        boolean response2 = scanner.nextInt() == 1;
        currentQuery++;
        
        if (response1 != original[bitIndices[0]] || response2 != original[bitIndices[1]]) {
            if (response1 == comparison1[bitIndices[0]] && response2 == comparison1[bitIndices[1]]) {
                System.arraycopy(comparison1, 0, result, 0, knownBits);
            } else {
                System.arraycopy(comparison2, 0, result, 0, knownBits);
            }
        }
    }

    private static void queryAndUpdateTwoBits(Scanner scanner, int currentQuery, int knownBits, boolean[] result, boolean[] original, boolean[] comparison1, boolean[] comparison2, boolean[] comparison3, int[] bitIndices) {
        int queryIndex1 = bitIndices[0] + 1;
        System.out.println(queryIndex1);
        boolean response1 = scanner.nextInt() == 1;
        currentQuery++;
        
        int queryIndex2 = bitIndices[1] + 1;
        System.out.println(queryIndex2);
        boolean response2 = scanner.nextInt() == 1;
        currentQuery++;
        
        if (response1 != original[bitIndices[0]] || response2 != original[bitIndices[1]]) {
            if (response1 == comparison1[bitIndices[0]] && response2 == comparison1[bitIndices[1]]) {
                System.arraycopy(comparison1, 0, result, 0, knownBits);
            } else if (response1 == comparison2[bitIndices[0]] && response2 == comparison2[bitIndices[1]]) {
                System.arraycopy(comparison2, 0, result, 0, knownBits);
            } else {
                System.arraycopy(comparison3, 0, result, 0, knownBits);
            }
        }
    }

    private static int findOneBit(boolean[] a1, boolean[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return i;
            }
        }
        return 0;
    }

    private static int[] findTwoBits(boolean[] a1, boolean[] a2, boolean[] a3) {
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1.length; j++) {
                if (!Arrays.equals(new boolean[]{a1[i], a1[j]}, new boolean[]{a2[i], a2[j]}) &&
                    !Arrays.equals(new boolean[]{a1[i], a1[j]}, new boolean[]{a3[i], a3[j]}) &&
                    !Arrays.equals(new boolean[]{a2[i], a2[j]}, new boolean[]{a3[i], a3[j]})) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 1};
    }

    private static int[] findTwoBits(boolean[] a1, boolean[] a2, boolean[] a3, boolean[] a4) {
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1.length; j++) {
                if (!Arrays.equals(new boolean[]{a1[i], a1[j]}, new boolean[]{a2[i], a2[j]}) &&
                    !Arrays.equals(new boolean[]{a1[i], a1[j]}, new boolean[]{a3[i], a3[j]}) &&
                    !Arrays.equals(new boolean[]{a1[i], a1[j]}, new boolean[]{a4[i], a4[j]}) &&
                    !Arrays.equals(new boolean[]{a2[i], a2[j]}, new boolean[]{a3[i], a3[j]}) &&
                    !Arrays.equals(new boolean[]{a2[i], a2[j]}, new boolean[]{a4[i], a4[j]}) &&
                    !Arrays.equals(new boolean[]{a3[i], a3[j]}, new boolean[]{a4[i], a4[j]})) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 1};
    }
}