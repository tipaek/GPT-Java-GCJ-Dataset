
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        //Scanner sc = new Scanner("input.txt");
        Scanner sc = new Scanner(System.in);
        int TEST_CASE = sc.nextInt();
        boolean[] check = new boolean[600001];
        ArrayList<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= 600000; i++) {
            if (check[i]) continue;
            prime.add(i);
            int cnt = 2;
            while (i * cnt <= 600000) {
                check[i * cnt] = true;
                cnt++;
            }
        }
        for (int t = 1; t <= TEST_CASE; t++) {
            pw.print("Case #" + t + ": ");
            solve(pw, sc, prime);
            pw.println();
        }
        pw.close();
    }

    public static void solve(PrintWriter pw, Scanner sc, ArrayList<Integer> prime) throws IOException {
        int n = sc.nextInt();
        int d = sc.nextInt();
        int min = d - 1;
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextLong();
        }

        Arrays.sort(array);
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            int dd = 0;
            for (int j = 0; j < n; j++) {
                if (array[j] % array[i] == 0) {
                    long div = array[j] / array[i];
                    if (dd + div > d) {
                        cnt += d - dd;
                        dd = d;
                    } else {
                        dd += div;
                        cnt += div - 1;
                    }
                }
                if (dd == d) {
                    break;
                }
            }
            if (dd == d)
                min = Math.min(cnt, min);
        }

        for (int i = 0; i < prime.size(); i++) {
            int cnt = 0;
            int dd = 0;
            int v = prime.get(i);
            for (int j = 0; j < n; j++) {
                if (array[j] % v == 0) {
                    long div = array[j] / v;
                    if (dd + div > d) {
                        cnt += d - dd;
                        dd = d;
                    } else {
                        dd += div;
                        cnt += div - 1;
                    }
                }
                if (dd == d) {
                    break;
                }
            }
            if (dd == d)
                min = Math.min(cnt, min);
        }
        pw.print(min);
        return;
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
