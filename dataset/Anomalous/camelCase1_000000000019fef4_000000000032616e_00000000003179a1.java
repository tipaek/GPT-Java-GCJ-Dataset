import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br;
    static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = nextInt();
        int caseNumber = 1;
        PrintWriter out = new PrintWriter(System.out);

        while (t-- > 0) {
            int u = nextInt();
            boolean[][] limit = new boolean[26][10];
            for (boolean[] c : limit) {
                Arrays.fill(c, true);
            }
            int[] frequency = new int[26];
            boolean[] used = new boolean[26];

            for (int i = 0; i < 10000; i++) {
                char[] q = next().toCharArray();
                char[] arr = next().toCharArray();
                limit[arr[0] - 'A'][0] = false;

                if (q[0] != '-' && arr.length == q.length) {
                    for (int j = 0; j < q.length; j++) {
                        for (int k = q[j] - '0' + 1; k < 10; k++) {
                            limit[arr[j] - 'A'][k] = false;
                        }
                        int possibleDigit = checkPossibility(limit, arr[j]);
                        if (possibleDigit == -1 || possibleDigit != q[j] - '0') {
                            break;
                        }
                    }
                }

                frequency[arr[0] - 'A']++;
                for (char c : arr) {
                    used[c - 'A'] = true;
                }
            }

            StringBuilder result = new StringBuilder();
            for (int j = 0; j < 9; j++) {
                int largest = 0;
                for (int i = 1; i < 26; i++) {
                    if (frequency[i] > frequency[largest]) {
                        largest = i;
                    }
                }
                used[largest] = false;
                frequency[largest] = 0;
                result.append((char) (largest + 'A'));
            }

            for (int i = 0; i < 26; i++) {
                if (used[i]) {
                    result.insert(0, (char) (i + 'A'));
                    break;
                }
            }

            for (int i = 0; i < 26; i++) {
                int possibleDigit = checkPossibility(limit, (char) ('A' + i));
                if (possibleDigit != -1) {
                    int idx = result.indexOf(Character.toString((char) ('A' + i)));
                    if (idx != -1) {
                        result.setCharAt(possibleDigit, result.charAt(idx));
                        result.setCharAt(idx, (char) ('A' + i));
                    }
                }
            }

            for (int i = 0; i < 10; i++) {
                if (!limit[result.charAt(i) - 'A'][i]) {
                    for (int j = 0; j < 10; j++) {
                        if (limit[result.charAt(j) - 'A'][i] && limit[result.charAt(i) - 'A'][i]) {
                            char temp = result.charAt(i);
                            result.setCharAt(i, result.charAt(j));
                            result.setCharAt(j, temp);
                            break;
                        }
                    }
                }
            }

            out.println("Case #" + (caseNumber++) + ": " + result);
        }
        out.close();
    }

    public static int checkPossibility(boolean[][] limit, char c) {
        int digit = -1;
        for (int i = 0; i < 10; i++) {
            if (limit[c - 'A'][i]) {
                if (digit == -1) {
                    digit = i;
                } else {
                    return -1;
                }
            }
        }
        return digit;
    }

    public static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                throw new IOException();
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}