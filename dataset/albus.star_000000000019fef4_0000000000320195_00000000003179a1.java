
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner("input.txt");
        //Scanner sc = new Scanner(System.in);
        int TEST_CASE = sc.nextInt();
        for (int t = 1; t <= TEST_CASE; t++) {
            pw.print("Case #" + t + ": ");
            solve(pw, sc);
            pw.println();
        }
        pw.close();
    }

    public static void solve(PrintWriter pw, Scanner sc) throws IOException {
        int U = sc.nextInt();
        int[] test = new int[26];
        Arrays.fill(test, 9);
        for (int i = 0; i < 10000; i++) {
            long Q = sc.nextLong();
            int count = getCount(Q);
            String R = sc.next();
            //System.out.println(R + " " + Q + " " + count);
            if (Q == -1) {

            } else {
                //알 수 �는건 ~보다 �다
                //ABPDO
                //15342
                if (U == 2) {

                }
                if (count == R.length()) {
                    test[R.charAt(0) - 'A'] = Math.min(test[R.charAt(0) - 'A'], getFirst(Q));
                }
                //0123456789
                //TPFOXLUSHB
            }
        }
        boolean[] check = new boolean[26];
        for (int i = 0; i <= 9; i++) {
            int min = 10;
            int index = -1;
            for (int j = 0; j < 26; j++) {
                if (check[j]) continue;
                if (test[j] >= i) {
                    if (min > test[j] - i) {
                        min = test[j] - i;
                        index = j;
                    }
                }
            }
            if (index == -1) {
                continue;
            }
            check[index] = true;
            pw.print((char) (index + 'A'));
        }
    }//TPFOXLUSHB

    public static int getCount(long number) {
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    public static int getFirst(long number) {
        while (number > 10) {
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
