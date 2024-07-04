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
                    boolean[][] transformations = new boolean[4][known];
                    for (int i = 0; i < known / 2; i++) {
                        transformations[0][i] = result[i];
                        transformations[0][known - i - 1] = result[b - i - 1];
                    }
                    if (known % 2 == 1) transformations[0][known / 2] = result[known / 2];
                    
                    for (int i = 0; i < known; i++) {
                        transformations[1][i] = !transformations[0][i];
                        transformations[2][i] = transformations[0][known - i - 1];
                        transformations[3][i] = !transformations[0][known - i - 1];
                    }
                    
                    boolean[] isSame = new boolean[4];
                    isSame[0] = checkEquality(transformations[1], transformations[0]);
                    isSame[1] = checkEquality(transformations[2], transformations[0]) || checkEquality(transformations[2], transformations[1]);
                    isSame[2] = checkEquality(transformations[3], transformations[0]) || checkEquality(transformations[3], transformations[1]) || checkEquality(transformations[3], transformations[2]);
                    
                    if (isSame[0] && isSame[1] && isSame[2]) {
                        processQuery(in, b, result, known);
                        known++;
                        cur++;
                    } else {
                        int[] bits = determineBits(transformations, isSame);
                        processTwoQueries(in, b, result, known, transformations, bits);
                        cur += 2;
                    }
                    
                } else {
                    processQuery(in, b, result, known);
                    known++;
                    cur++;
                }
            }
            
            printResult(in, result, known);
        }
    }
    
    private static void processQuery(Scanner in, int b, boolean[] result, int known) {
        int index = known % 2 == 0 ? known / 2 + 1 : b - (known / 2);
        System.out.println(index);
        int bit = in.nextInt();
        result[index - 1] = (bit == 1);
    }
    
    private static void processTwoQueries(Scanner in, int b, boolean[] result, int known, boolean[][] transformations, int[] bits) {
        for (int i = 0; i < 2; i++) {
            int index = bits[i] < known / 2 || (bits[i] == known / 2 && known % 2 == 1) ? bits[i] + 1 : bits[i] + b - known + 1;
            System.out.println(index);
            boolean res = in.nextInt() == 1;
            if (res != transformations[0][bits[i]]) {
                for (int j = 0; j < known / 2; j++) {
                    result[j] = transformations[i + 1][j];
                    result[b - j - 1] = transformations[i + 1][known - j - 1];
                }
                if (known % 2 == 1) result[known / 2] = transformations[i + 1][known / 2];
            }
        }
    }
    
    private static int[] determineBits(boolean[][] transformations, boolean[] isSame) {
        if (isSame[0] && isSame[1]) {
            return findTwoBit(transformations[0], transformations[2]);
        } else if (isSame[0] && isSame[2]) {
            return findTwoBit(transformations[0], transformations[3]);
        } else if (isSame[1] && isSame[2]) {
            return findTwoBit(transformations[0], transformations[1]);
        } else {
            return findTwoBit(transformations[0], transformations[1], transformations[2], transformations[3]);
        }
    }
    
    private static void printResult(Scanner in, boolean[] result, int known) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < known; i++) {
            output.append(result[i] ? "1" : "0");
        }
        System.out.println(output);
        String answer = in.next();
        if (!"Y".equals(answer)) System.exit(0);
    }
    
    private static boolean checkEquality(boolean[] a1, boolean[] a2) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }
    
    private static int[] findTwoBit(boolean[]... arrays) {
        int[] result = new int[2];
        for (int i = 0; i < arrays[0].length; i++) {
            for (int j = i + 1; j < arrays[0].length; j++) {
                String s1 = "" + arrays[0][i] + arrays[0][j];
                boolean valid = true;
                for (int k = 1; k < arrays.length; k++) {
                    String s2 = "" + arrays[k][i] + arrays[k][j];
                    if (s1.equals(s2)) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}