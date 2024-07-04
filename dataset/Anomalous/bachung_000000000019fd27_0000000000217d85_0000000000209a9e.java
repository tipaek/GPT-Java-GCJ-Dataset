import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int T = Integer.parseInt(tokenizer.nextToken());
        int B = Integer.parseInt(tokenizer.nextToken());
        int solved = 0;
        while (solved++ < T && solve(reader, B)) {}
    }

    static int queryCount = 0;

    static int emit(int i, BufferedReader reader) throws Exception {
        System.out.println(i + 1);
        int result = Integer.parseInt(reader.readLine());
        return result == 1 ? 2 : 1;
    }

    static void printModel(int[] nums) {
        // Placeholder for potential debugging output
    }

    static boolean solve(BufferedReader reader, int B) throws Exception {
        int[][] possibilities = new int[4][B];
        int[] model = new int[B];
        Set<Integer> possible = new LinkedHashSet<>(Arrays.asList(0));
        int idx = 0;
        queryCount = 0;

        while (idx < B) {
            int sent = 0;
            if (possible.size() > 1) {
                refinePossibilities(reader, possibilities, possible, B);
                int possIdx = possible.iterator().next();
                System.arraycopy(possibilities[possIdx], 0, model, 0, B);
            }

            while (sent < 10 && idx < B) {
                int realIdx = findNextIndex(model, B, idx);
                model[realIdx] = emit(realIdx, reader);
                idx++;
                sent++;
            }
            if (idx == B) break;
            fillPossibilities(model, possibilities, B);
            possible = new LinkedHashSet<>(Arrays.asList(0, 1, 2, 3));
        }

        printAndValidateModel(reader, model, B);
        return "Y".equals(reader.readLine());
    }

    static void refinePossibilities(BufferedReader reader, int[][] possibilities, Set<Integer> possible, int B) throws Exception {
        int[] poss1, poss2;
        boolean found;

        for (int[] pair : new int[][]{{0, 2}, {1, 3}}) {
            poss1 = possibilities[pair[0]];
            poss2 = possibilities[pair[1]];
            found = false;
            for (int i = 0; i < B; i++) {
                if (poss1[i] != poss2[i] && poss1[i] != 0 && poss2[i] != 0) {
                    int bitVal = emit(i, reader);
                    if (poss1[i] == bitVal) {
                        possible.remove(pair[1]);
                    } else {
                        possible.remove(pair[0]);
                    }
                    found = true;
                    break;
                }
            }
            if (!found) possible.remove(Math.random() > 0.5 ? pair[1] : pair[0]);
        }

        Iterator<Integer> iterator = possible.iterator();
        int i1 = iterator.next(), i2 = iterator.next();
        poss1 = possibilities[i1];
        poss2 = possibilities[i2];
        found = false;
        for (int i = 0; i < B; i++) {
            if (poss1[i] != poss2[i] && poss1[i] != 0 && poss2[i] != 0) {
                int bitVal = emit(i, reader);
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
    }

    static int findNextIndex(int[] model, int B, int idx) {
        for (int i = 0; i < B; i++) {
            if (model[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    static void printAndValidateModel(BufferedReader reader, int[] model, int B) throws IOException {
        char[] cc = new char[B];
        for (int i = 0; i < B; i++) {
            cc[i] = model[i] == 1 ? '0' : '1';
        }
        System.out.println(new String(cc));
    }

    static int flip(int bval) {
        return bval == 0 ? 0 : bval == 1 ? 2 : 1;
    }

    static void fillPossibilities(int[] model, int[][] possibilities, int B) {
        for (int i = 0; i < B; i++) {
            possibilities[0][i] = model[i];
            possibilities[1][i] = model[B - i - 1];
            possibilities[2][i] = flip(model[i]);
            possibilities[3][i] = flip(possibilities[1][i]);
        }
    }
}