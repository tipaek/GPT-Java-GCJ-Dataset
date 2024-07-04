
import java.io.*;
import java.util.*;


class Solution {

    public static void main(String[] args) {

        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt(), l = 0;

        while (t-- > 0) {

            out.print("Case #" + (++l) + ": ");

            int N = in.nextInt(), x = in.nextInt(), max = 0;
            HashMap<Double, Integer> map = new HashMap<>();
            double arr[] = new double[N];

            for (int i = 0; i < N; i++) {
                arr[i] = in.nextDouble();
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                max = Math.max(max, map.get(arr[i]));
            }

            if (max >= x) {
                out.println(0);
                continue;
            }

            // D==2
            if (x == 2) {
                out.println(1);
                continue;
            }

            if (N == 1) {
                out.println(2);
                continue;
            }

            int flag = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] % 2 == 0) {
                    if (map.containsKey(arr[i] / 2))
                        flag = 1;
                }
            }

            if (flag == 1) {
                out.println(1);
                continue;
            }

            if (N == 2) {
                out.println(2);
                continue;
            }

            flag = 0;
            double min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                if (map.get(arr[i]) == 2) {
                    min = Math.min(min, arr[i]);
                }
            }

            if (min < Integer.MAX_VALUE) {
                for (int i = 0; i < N; i++) {
                    if (arr[i] > min)
                        flag = 1;
                }
            }

            if (flag == 1)
                out.println(1);
            else
                out.println(2);
        }
        out.close();

    }


    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public int[] shuffle(int[] arr) {
            Random r = new Random();
            for (int i = 1, j; i < arr.length; i++) {
                j = r.nextInt(i);
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];
            }
            return arr;
        }

        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public char nextChar() {
            return next().charAt(0);
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }


    }

}
