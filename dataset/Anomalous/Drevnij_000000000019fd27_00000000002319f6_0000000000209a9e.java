import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        int b = scanner.nextInt();

        for (int x = 1; x <= t; x++) {
            boolean[] result = new boolean[b];
            int knownBits = 0;
            int queryCount = 1;

            while (knownBits < b) {
                if (knownBits > 0 && queryCount % 10 == 1) {
                    // Determine the transformations
                    boolean[] original = Arrays.copyOf(result, knownBits);
                    boolean[] complement = new boolean[knownBits];
                    boolean[] reverse = new boolean[knownBits];
                    boolean[] complementReverse = new boolean[knownBits];

                    for (int i = 0; i < knownBits; i++) {
                        complement[i] = !result[i];
                        reverse[i] = result[knownBits - i - 1];
                        complementReverse[i] = !result[knownBits - i - 1];
                    }

                    boolean isComplementSame = Arrays.equals(original, complement);
                    boolean isReverseSame = Arrays.equals(original, reverse);
                    boolean isComplementReverseSame = Arrays.equals(original, complementReverse);

                    if (!isReverseSame && !isComplementSame) {
                        isReverseSame = Arrays.equals(complement, reverse);
                    }
                    if (!isComplementReverseSame && !isComplementSame) {
                        isComplementReverseSame = Arrays.equals(complement, complementReverse);
                    }
                    if (!isComplementReverseSame && !isReverseSame) {
                        isComplementReverseSame = Arrays.equals(reverse, complementReverse);
                    }

                    if (isComplementSame && isComplementReverseSame && isReverseSame) {
                        knownBits++;
                        System.out.println(knownBits);
                        result[knownBits - 1] = scanner.nextInt() == 1;
                        queryCount++;
                    } else {
                        handleQuery(original, complement, reverse, complementReverse, knownBits, scanner, result);
                        queryCount += 2;
                    }
                } else {
                    knownBits++;
                    System.out.println(knownBits);
                    result[knownBits - 1] = scanner.nextInt() == 1;
                    queryCount++;
                }
            }

            StringBuilder output = new StringBuilder();
            for (boolean bit : result) {
                output.append(bit ? "1" : "0");
            }

            System.out.println(output);
            if (!scanner.next().equals("Y")) {
                break;
            }
        }
    }

    private static void handleQuery(boolean[] original, boolean[] complement, boolean[] reverse, boolean[] complementReverse, int knownBits, Scanner scanner, boolean[] result) {
        if (isSame(original, complement) && isSame(original, complementReverse)) {
            int bit = findDifferingBit(original, reverse);
            int index = bit + 1;
            System.out.println(index);
            boolean res = scanner.nextInt() == 1;
            if (res != original[bit]) {
                System.arraycopy(reverse, 0, result, 0, knownBits);
            }
        } else if (isSame(original, complement) && isSame(original, reverse)) {
            int bit = findDifferingBit(original, complementReverse);
            int index = bit + 1;
            System.out.println(index);
            boolean res = scanner.nextInt() == 1;
            if (res != original[bit]) {
                System.arraycopy(complementReverse, 0, result, 0, knownBits);
            }
        } else if (isSame(original, complementReverse) && isSame(original, reverse)) {
            int bit = findDifferingBit(original, complement);
            int index = bit + 1;
            System.out.println(index);
            boolean res = scanner.nextInt() == 1;
            if (res != original[bit]) {
                System.arraycopy(complement, 0, result, 0, knownBits);
            }
        } else if (isSame(original, complementReverse)) {
            handleTwoBitQuery(original, complement, reverse, scanner, result, knownBits);
        } else if (isSame(original, complement)) {
            handleTwoBitQuery(original, complementReverse, reverse, scanner, result, knownBits);
        } else if (isSame(original, reverse)) {
            handleTwoBitQuery(original, complementReverse, complement, scanner, result, knownBits);
        } else {
            handleTwoBitQuery(original, complementReverse, complement, reverse, scanner, result, knownBits);
        }
    }

    private static void handleTwoBitQuery(boolean[] original, boolean[] arr1, boolean[] arr2, Scanner scanner, boolean[] result, int knownBits) {
        int[] bits = findTwoDifferingBits(original, arr1, arr2);
        int index1 = bits[0] + 1;
        System.out.println(index1);
        boolean res1 = scanner.nextInt() == 1;
        int index2 = bits[1] + 1;
        System.out.println(index2);
        boolean res2 = scanner.nextInt() == 1;

        if (res1 != original[bits[0]] || res2 != original[bits[1]]) {
            if (res1 == arr1[bits[0]] && res2 == arr1[bits[1]]) {
                System.arraycopy(arr1, 0, result, 0, knownBits);
            } else {
                System.arraycopy(arr2, 0, result, 0, knownBits);
            }
        }
    }

    private static boolean isSame(boolean[] arr1, boolean[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    private static int findDifferingBit(boolean[] arr1, boolean[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return i;
            }
        }
        return 0;
    }

    private static int[] findTwoDifferingBits(boolean[] arr1, boolean[] arr2, boolean[] arr3) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                String s1 = "" + arr1[i] + arr1[j];
                String s2 = "" + arr2[i] + arr2[j];
                String s3 = "" + arr3[i] + arr3[j];
                if (!s1.equals(s2) && !s1.equals(s3) && !s2.equals(s3)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }

    private static int[] findTwoDifferingBits(boolean[] arr1, boolean[] arr2, boolean[] arr3, boolean[] arr4) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                String s1 = "" + arr1[i] + arr1[j];
                String s2 = "" + arr2[i] + arr2[j];
                String s3 = "" + arr3[i] + arr3[j];
                String s4 = "" + arr4[i] + arr4[j];
                if (!s1.equals(s2) && !s1.equals(s3) && !s2.equals(s3) && !s2.equals(s4) && !s1.equals(s4) && !s4.equals(s3)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }
}