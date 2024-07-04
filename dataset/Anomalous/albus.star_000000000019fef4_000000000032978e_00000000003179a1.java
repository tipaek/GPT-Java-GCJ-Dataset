import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int t = 1; t <= testCases; t++) {
            pw.print("Case #" + t + ": ");
            solve(pw, sc);
            pw.println();
        }
        pw.close();
    }

    public static void solve(PrintWriter pw, Scanner sc) throws IOException {
        int U = sc.nextInt();
        int[] test = new int[26];
        boolean[] check2 = new boolean[26];
        boolean[] check3 = new boolean[26];

        Arrays.fill(test, 9);
        for (int i = 0; i < 10000; i++) {
            long Q = sc.nextLong();
            int count = getCount(Q);
            String R = sc.next();
            for (int j = 0; j < R.length(); j++) {
                check2[R.charAt(j) - 'A'] = true;
            }

            if (R.length() >= 2 || R.length() == 1) {
                check3[R.charAt(0) - 'A'] = true;
            }

            if (count == R.length() && count >= 2) {
                check3[R.charAt(0) - 'A'] = true;
                test[R.charAt(0) - 'A'] = Math.min(test[R.charAt(0) - 'A'], getFirst(Q));
            }
        }

        boolean[] check = new boolean[26];
        for (int i = 0; i <= 9; i++) {
            int min = 10;
            int index = -1;
            for (int j = 0; j < 26; j++) {
                if (check[j] || !check2[j] || (i == 0 && check3[j])) continue;
                if (test[j] >= i && min > test[j] - i) {
                    min = test[j] - i;
                    index = j;
                }
            }
            check[index] = true;
            pw.print((char) (index + 'A'));
        }
    }

    public static int getCount(long number) {
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    public static int getFirst(long number) {
        while (number >= 10) {
            number /= 10;
        }
        return (int) number;
    }

    public static class Scanner {
        private BufferedReader bufferedReader;
        private StringTokenizer stk;

        public Scanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public Scanner(String path) throws FileNotFoundException {
            bufferedReader = new BufferedReader(new FileReader(path));
        }

        public int nextInt() throws IOException {
            ensureTokens();
            return Integer.parseInt(stk.nextToken());
        }

        public long nextLong() throws IOException {
            ensureTokens();
            return Long.parseLong(stk.nextToken());
        }

        public String next() throws IOException {
            ensureTokens();
            return stk.nextToken();
        }

        private void ensureTokens() throws IOException {
            if (stk == null || !stk.hasMoreTokens()) {
                stk = new StringTokenizer(bufferedReader.readLine());
            }
        }
    }

    public static class Pair<T, V> {
        private final T key;
        private final V value;

        public Pair(T key, V value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}