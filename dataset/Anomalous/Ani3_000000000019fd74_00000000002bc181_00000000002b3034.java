import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            String res = solve(in.nextInt(), in);
            System.out.println("Case #" + i + ": " + res);
        }
    }

    static String solve(int N, FastReader in) {
        String[] arr = new String[N];
        int max = 0;
        int pos = -1;
        boolean flag = true;

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextLine();
            if (i >= 1 && max < arr[i].length()) {
                max = arr[i].length();
                pos = i;
            }
        }

        for (int i = 0; i < N; i++) {
            String sub = arr[i].substring(1);
            if (flag && !arr[pos].contains(sub)) {
                flag = false;
                break;
            }
        }

        if (flag) {
            return arr[pos].substring(1);
        }
        return "*";
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}