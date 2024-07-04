import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();
        
        for (int x = 1; x <= t; x++) {
            int cur = 1;
            int known = 0;
            boolean[] result = new boolean[b];
            
            while (known < b) {
                if (known > 0 && cur % 10 == 1) {
                    boolean[] orig = new boolean[known];
                    boolean[] comp = new boolean[known];
                    boolean[] rev = new boolean[known];
                    boolean[] compRev = new boolean[known];
                    
                    for (int i = 0; i < known / 2; i++) {
                        orig[i] = result[i];
                        orig[known - i - 1] = result[b - i - 1];
                    }
                    if (known % 2 == 1) orig[known / 2] = result[known / 2];
                    
                    for (int i = 0; i < known; i++) {
                        comp[i] = !orig[i];
                        rev[i] = orig[known - i - 1];
                        compRev[i] = !orig[known - i - 1];
                    }
                    
                    boolean isCompSame = areArraysEqual(orig, comp);
                    boolean isRevSame = areArraysEqual(orig, rev) || areArraysEqual(comp, rev);
                    boolean isCRSame = areArraysEqual(orig, compRev) || areArraysEqual(comp, compRev) || areArraysEqual(rev, compRev);
                    
                    if (isCompSame && isCRSame && isRevSame) {
                        processBit(in, result, b, known, cur);
                    } else if (isCompSame && isCRSame) {
                        processBitWithComparison(in, result, b, known, cur, orig, rev);
                    } else if (isCompSame && isRevSame) {
                        processBitWithComparison(in, result, b, known, cur, orig, compRev);
                    } else if (isCRSame && isRevSame) {
                        processBitWithComparison(in, result, b, known, cur, orig, comp);
                    } else if (isCRSame) {
                        processTwoBits(in, result, b, known, cur, orig, comp, rev);
                    } else if (isCompSame) {
                        processTwoBits(in, result, b, known, cur, orig, compRev, rev);
                    } else if (isRevSame) {
                        processTwoBits(in, result, b, known, cur, orig, compRev, comp);
                    } else {
                        processTwoBits(in, result, b, known, cur, orig, compRev, comp, rev);
                    }
                } else {
                    processBit(in, result, b, known, cur);
                }
            }
            
            printResult(in, result, known);
        }
    }
    
    private static boolean areArraysEqual(boolean[] a1, boolean[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }
    
    private static void processBit(Scanner in, boolean[] result, int b, int known, int cur) {
        int index = known % 2 == 0 ? known / 2 + 1 : b - (known / 2);
        System.out.println(index);
        result[index - 1] = in.nextInt() == 1;
        known++;
        cur++;
    }
    
    private static void processBitWithComparison(Scanner in, boolean[] result, int b, int known, int cur, boolean[] orig, boolean[] comp) {
        int bit = findOneBit(orig, comp);
        int index = bit < known / 2 || (bit == known / 2 && known % 2 == 1) ? bit + 1 : bit + b - known + 1;
        System.out.println(index);
        boolean res = in.nextInt() == 1;
        System.out.println(index);
        in.nextInt();
        cur += 2;
        if (res != orig[bit]) {
            updateResult(result, b, known, comp);
        }
    }
    
    private static void processTwoBits(Scanner in, boolean[] result, int b, int known, int cur, boolean[]... arrays) {
        int[] bitIndices = findTwoBit(arrays);
        int index1 = getIndex(bitIndices[0], known, b);
        System.out.println(index1);
        boolean res1 = in.nextInt() == 1;
        cur++;
        int index2 = getIndex(bitIndices[1], known, b);
        System.out.println(index2);
        boolean res2 = in.nextInt() == 1;
        cur++;
        
        if (res1 != arrays[0][bitIndices[0]] || res2 != arrays[0][bitIndices[1]]) {
            updateResult(result, b, known, getMatchingArray(res1, res2, arrays, bitIndices));
        }
    }
    
    private static int getIndex(int bit, int known, int b) {
        return bit < known / 2 || (bit == known / 2 && known % 2 == 1) ? bit + 1 : bit + b - known + 1;
    }
    
    private static void updateResult(boolean[] result, int b, int known, boolean[] newArray) {
        for (int i = 0; i < known / 2; i++) {
            result[i] = newArray[i];
            result[b - i - 1] = newArray[known - i - 1];
        }
        if (known % 2 == 1) result[known / 2] = newArray[known / 2];
    }
    
    private static boolean[] getMatchingArray(boolean res1, boolean res2, boolean[][] arrays, int[] bitIndices) {
        for (boolean[] array : arrays) {
            if (res1 == array[bitIndices[0]] && res2 == array[bitIndices[1]]) {
                return array;
            }
        }
        return arrays[0]; // Fallback to the original array if no match found
    }
    
    private static void printResult(Scanner in, boolean[] result, int known) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < known; i++) {
            output.append(result[i] ? '1' : '0');
        }
        System.out.println(output);
        if (!"Y".equals(in.next())) {
            System.exit(0);
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
    
    private static int[] findTwoBit(boolean[]... arrays) {
        for (int i = 0; i < arrays[0].length; i++) {
            for (int j = i + 1; j < arrays[0].length; j++) {
                if (areAllDifferent(arrays, i, j)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 1};
    }
    
    private static boolean areAllDifferent(boolean[][] arrays, int i, int j) {
        Set<String> combinations = new HashSet<>();
        for (boolean[] array : arrays) {
            combinations.add(array[i] + "" + array[j]);
        }
        return combinations.size() == arrays.length;
    }
}