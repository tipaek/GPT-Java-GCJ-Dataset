import java.io.*;
import java.util.*;

class Solution {

    static final long MOD = 1_000_000_007L;
    static final int MAX_N = 10_000;
    static final int ALPHABET_SIZE = 26;
    static final int MAX_DIGIT = 10;
    
    static PrintWriter out;
    static String[] Q, R;
    static long[] maxVal, isPresent;

    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(System.out);

        int testCases = scn.nextInt();

        for (int t = 1; t <= testCases; t++) {
            Q = new String[MAX_N + 5];
            R = new String[MAX_N + 5];
            maxVal = new long[ALPHABET_SIZE];
            isPresent = new long[ALPHABET_SIZE];
            Arrays.fill(maxVal, MAX_DIGIT);

            long u = scn.nextLong();
            for (int i = 0; i < MAX_N; i++) {
                Q[i] = scn.next();
                R[i] = scn.next();
            }

            processInput();
            String result = determineResult();
            out.println("Case #" + t + ": " + result);
        }

        out.close();
    }

    private static void processInput() {
        for (int i = 0; i < MAX_N; i++) {
            for (char c : R[i].toCharArray()) {
                isPresent[c - 'A'] = 1;
                maxVal[c - 'A'] = 9;
            }
        }

        for (int i = 0; i < MAX_N; i++) {
            if (Q[i].length() == 1 && Q[i].length() == R[i].length()) {
                maxVal[R[i].charAt(0) - 'A'] = Math.min(maxVal[R[i].charAt(0) - 'A'], Q[i].charAt(0) - '0');
            }
        }

        for (int sz = 2; sz <= MAX_DIGIT; sz++) {
            for (int i = 0; i < MAX_N; i++) {
                if (Q[i].equals("-1")) continue;
                if (Q[i].length() == sz && Q[i].length() == R[i].length()) {
                    processEqualSizedStrings(Q[i], R[i]);
                }
            }
        }
    }

    private static void processEqualSizedStrings(String q, String r) {
        int n = r.length();
        boolean allSame = true;
        for (int j = 1; j < n; j++) {
            if (r.charAt(j) != r.charAt(0)) {
                allSame = false;
                break;
            }
        }
        if (!allSame) return;

        for (char j = '9'; j >= '1'; j--) {
            boolean valid = true;
            for (int k = 0; k < q.length(); k++) {
                if (q.charAt(k) > j) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                maxVal[r.charAt(0) - 'A'] = Math.min(maxVal[r.charAt(0) - 'A'], j - '0');
                break;
            }
        }
    }

    private static String determineResult() {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < MAX_DIGIT; i++) {
            boolean found = false;
            for (int j = 0; j < ALPHABET_SIZE; j++) {
                if (maxVal[j] == i && isPresent[j] > 0) {
                    ans.append((char) ('A' + j));
                    found = true;
                    break;
                }
            }
            if (!found) {
                for (int k = 0; k < ALPHABET_SIZE; k++) {
                    if (maxVal[k] == 9 && isPresent[k] > 0) {
                        ans.append((char) ('A' + k));
                        maxVal[k] = i;
                        break;
                    }
                }
            }
        }
        return ans.toString();
    }
}