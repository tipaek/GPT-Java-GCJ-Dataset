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
                    boolean[] orig = Arrays.copyOf(result, known);
                    boolean[] comp = negateArray(orig);
                    boolean[] rev = reverseArray(orig);
                    boolean[] compRev = negateArray(rev);
                    
                    boolean isCompSame = Arrays.equals(comp, orig);
                    boolean isRevSame = Arrays.equals(rev, orig);
                    boolean isCRSame = Arrays.equals(compRev, orig);
                    
                    if (!isRevSame && !isCompSame) {
                        isRevSame = Arrays.equals(rev, comp);
                    }
                    
                    if (!isCRSame && !isCompSame) {
                        isCRSame = Arrays.equals(compRev, comp);
                    }
                    
                    if (!isCRSame && !isRevSame) {
                        isCRSame = Arrays.equals(compRev, rev);
                    }
                    
                    if (isCompSame && isCRSame && isRevSame) {
                        known++;
                        System.out.println(known);
                        result[known - 1] = in.nextInt() == 1;
                        cur++;
                    } else {
                        handleComplexCases(in, orig, comp, rev, compRev, result, known, cur);
                    }
                } else {
                    known++;
                    System.out.println(known);
                    result[known - 1] = in.nextInt() == 1;
                    cur++;
                }
            }
            
            String output = buildOutput(result, known);
            System.out.println(output);
            
            if (!"Y".equals(in.next())) break;
        }
    }
    
    private static boolean[] negateArray(boolean[] array) {
        boolean[] result = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = !array[i];
        }
        return result;
    }
    
    private static boolean[] reverseArray(boolean[] array) {
        boolean[] result = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[array.length - i - 1];
        }
        return result;
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
                String[] pairStrings = new String[arrays.length];
                for (int k = 0; k < arrays.length; k++) {
                    pairStrings[k] = "" + arrays[k][i] + arrays[k][j];
                }
                if (Arrays.stream(pairStrings).distinct().count() == arrays.length) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }
    
    private static void handleComplexCases(Scanner in, boolean[] orig, boolean[] comp, boolean[] rev, boolean[] compRev, boolean[] result, int known, int cur) {
        if (Arrays.equals(comp, orig) && Arrays.equals(compRev, orig)) {
            int bit = findOneBit(orig, rev);
            handleBitCheck(in, orig, rev, result, known, cur, bit);
        } else if (Arrays.equals(comp, orig) && Arrays.equals(rev, orig)) {
            int bit = findOneBit(orig, compRev);
            handleBitCheck(in, orig, compRev, result, known, cur, bit);
        } else if (Arrays.equals(compRev, orig) && Arrays.equals(rev, orig)) {
            int bit = findOneBit(orig, comp);
            handleBitCheck(in, orig, comp, result, known, cur, bit);
        } else if (Arrays.equals(compRev, orig)) {
            handleTwoBitCheck(in, orig, comp, rev, result, known, cur);
        } else if (Arrays.equals(comp, orig)) {
            handleTwoBitCheck(in, orig, compRev, rev, result, known, cur);
        } else if (Arrays.equals(rev, orig)) {
            handleTwoBitCheck(in, orig, compRev, comp, result, known, cur);
        } else {
            handleTwoBitCheck(in, orig, compRev, comp, rev, result, known, cur);
        }
    }
    
    private static void handleBitCheck(Scanner in, boolean[] orig, boolean[] candidate, boolean[] result, int known, int cur, int bit) {
        int index = bit + 1;
        System.out.println(index);
        boolean res = in.nextInt() == 1;
        cur++;
        if (res != orig[bit]) {
            System.arraycopy(candidate, 0, result, 0, known);
        }
    }
    
    private static void handleTwoBitCheck(Scanner in, boolean[]... arrays) {
        int[] bits = findTwoBit(arrays);
        int index1 = bits[0] + 1;
        int index2 = bits[1] + 1;
        
        System.out.println(index1);
        boolean res1 = in.nextInt() == 1;
        
        System.out.println(index2);
        boolean res2 = in.nextInt() == 1;
        
        if (res1 != arrays[0][bits[0]] || res2 != arrays[0][bits[1]]) {
            for (boolean[] array : arrays) {
                if (res1 == array[bits[0]] && res2 == array[bits[1]]) {
                    System.arraycopy(array, 0, arrays[0], 0, arrays[0].length);
                    break;
                }
            }
        }
    }
    
    private static String buildOutput(boolean[] result, int known) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < known; i++) {
            output.append(result[i] ? "1" : "0");
        }
        return output.toString();
    }
}