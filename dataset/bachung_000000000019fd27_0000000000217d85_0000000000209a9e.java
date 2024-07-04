import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int T = Integer.parseInt(tokenizer.nextToken());
        int B = Integer.parseInt(tokenizer.nextToken());
        int solved = 0;
        while (solved++ < T && solve(reader, T, B)) {}
    }

    static int asdasd = 0;

    static int emit(int i, BufferedReader reader) throws Exception {
        System.out.println(i + 1);
        int result = Integer.parseInt(reader.readLine());
        // System.err.println(asdasd++ + " " + (i + 1) + " " + result);
        return result == 1 ? 2 : 1;
    }

    static void printModel(int nums[]) {
        // for (int a : nums) {
        //     System.err.print(a == 0 ? "?" : a == 1 ? "0" : "1");
        // }
        // System.err.println();
    }

    static boolean solve(BufferedReader reader, int T, int B) throws Exception {
        int[][] possibilities = new int[4][B];
        int[] model = new int[B];
        Set<Integer> possible = new LinkedHashSet<>(Arrays.asList(0));
        int idx = 0;
        asdasd = 0;
        
        while (idx < B) {
            int sent = 0;
            if (possible.size() > 1) {
                // for (int[] ppp : possibilities) {
                //     printModel(ppp);
                // }
                int[] poss1 = possibilities[0];
                int[] poss2 = possibilities[2];
                boolean found = false;
                for (int i = 0; i < B; i++) {
                    if (poss1[i] != poss2[i] && poss1[i] != 0 && poss2[i] != 0) {
                        int bitVal = emit(i, reader);
                        sent++;
                        if (poss1[i] == bitVal) {
                            possible.remove(2);
                        } else {
                            possible.remove(0);
                        }
                        found = true;
                        break;
                    }
                }
                if (!found) possible.remove(Math.random() > 0.5 ? 2 : 0);
                found = false;
                poss1 = possibilities[1];
                poss2 = possibilities[3];
                for (int i = 0; i < B; i++) {
                    if (poss1[i] != poss2[i] && poss1[i] != 0 && poss2[i] != 0) {
                        int bitVal = emit(i, reader);
                        sent++;
                        if (poss1[i] == bitVal) {
                            possible.remove(3);
                        } else {
                            possible.remove(1);
                        }
                        found = true;
                        break;
                    }
                }
                if (!found) possible.remove(Math.random() > 0.5 ? 3 : 1);
                Iterator<Integer> asdasd = possible.iterator();
                int i1 = asdasd.next(), i2 = asdasd.next();
                found = false;
                poss1 = possibilities[i1];
                poss2 = possibilities[i2];
                for (int i = 0; i < B; i++) {
                    if (poss1[i] != poss2[i] && poss1[i] != 0 && poss2[i] != 0) {
                        int bitVal = emit(i, reader);
                        sent++;
                        if (poss1[i] == bitVal) {
                            possible.remove(i2);
                        } else {
                            possible.remove(i1);
                        }
                        found = true;
                        break;
                    }
                }
                if (!found) possible.remove(Math.random() > 0.5 ? i2 : i1);
                int possIdx = possible.iterator().next();
                for (int i = 0; i < B; i++) {
                    model[i] = possibilities[possIdx][i];
                }
            }
            // printModel(model);
            while (sent < 10 && idx < B) {
                int realIdx = -1;
                for (int i = 0; i< B; i++) {
                    if (model[i] == 0) {
                        realIdx = i;
                        if (idx % 2 == 0) break;
                    }
                }
                // int realIdx = idx % 2 == 0 ? idx / 2 : (B - 1 - (idx / 2));
                model[realIdx] = emit(realIdx, reader);
                idx++;
                sent++;
            }
            // System.err.println("Sent: " + sent);
            if (idx == B) break;
            fillPossibilities(model, possibilities, B);
            possible = new LinkedHashSet<>(Arrays.asList(0, 1, 2, 3));
        }
        char[] cc = new char[B];
        for (int i = 0; i < B; i++) {
           cc[i] = model[i] == 1 ? '0' : '1'; 
        }
        printModel(model);
        System.out.println(new String(cc));
        String response = reader.readLine();
        return "Y".equals(response);
    }

    static int flip(int bval) {
        return bval == 0 ? 0 : bval == 1 ? 2 : 1;
    }

    static void fillPossibilities(int[] model, int[][] possibilities, int B) {
        for (int i = 0; i < B; i++) {
            // same
            possibilities[0][i] = model[i];
            // reverse
            possibilities[1][i] = model[B - i - 1];
            // flip
            possibilities[2][i] = flip(model[i]);
            // reverse + flip
            possibilities[3][i] = flip(possibilities[1][i]);
        }
    }
}