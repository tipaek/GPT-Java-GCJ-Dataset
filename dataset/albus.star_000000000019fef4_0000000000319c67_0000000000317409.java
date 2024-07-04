
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        int TEST_CASE = sc.nextInt();
        for (int t = 1; t <= TEST_CASE; t++) {
            pw.print("Case #" + t + ": ");
            solve(pw, sc);
            pw.println();
        }
        pw.close();
    }

    public static void solve(PrintWriter pw, Scanner sc) throws IOException {
        int xx = sc.nextInt();
        int yy = sc.nextInt();
        String s = sc.next();
        int len = s.length();
        Pair<Integer, Integer>[] pairs = new Pair[len + 1];
        pairs[0] = new Pair<>(xx, yy);
        for (int i = 0; i < len; i++) {
            char d = s.charAt(i);
            int preX = pairs[i].getKey();
            int preY = pairs[i].getValue();
            if (d == 'W') {
                pairs[i + 1] = new Pair<>(preX - 1, preY);
            } else if (d == 'S') {
                pairs[i + 1] = new Pair<>(preX, preY - 1);
            } else if (d == 'N') {
                pairs[i + 1] = new Pair<>(preX, preY + 1);
            } else {
                pairs[i + 1] = new Pair<>(preX + 1, preY);
            }
        }
        for (int i = 0; i <= len; i++) {
            int abs = Math.abs(pairs[i].getKey()) + Math.abs(pairs[i].getValue());
            if (abs <= i) {
                pw.print(i);
                return;
            }
        }

        pw.print("IMPOSSIBLE");
    }

    public static class Scanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stk;

        public Scanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            nullOrGet();
            return Integer.parseInt(stk.nextToken());
        }

        public long nextLong() throws IOException {
            nullOrGet();
            return Long.parseLong(stk.nextToken());
        }

        public String next() throws IOException {
            nullOrGet();
            return stk.nextToken();
        }

        private StringTokenizer nullOrGet() throws IOException {
            if (stk == null || !stk.hasMoreTokens()) {
                stk = new StringTokenizer(bufferedReader.readLine());
            }
            return stk;
        }
    }

    public static class Pair<T, V> {
        private T key;

        public T getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        private V value;

        public Pair(T key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}