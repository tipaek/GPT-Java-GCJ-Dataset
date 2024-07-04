import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt(), x = 0;

        while (x++ < t) {
            int N = in.nextInt();
            int arr[][] = new int[N][2];
            int copy[][] = new int[N][2];

            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
                copy[i][0] = arr[i][0];
                copy[i][1] = arr[i][1];
            }

            int flag = 1;
//            int val[] = new int[24 * 60 + 2];
//            for (int i = 0; i < N; i++) {
//                int a = arr[i][0], b = arr[i][1];
//                val[a]++;
//                val[b]--;
//            }
//
//            for (int i = 1; i < val.length; i++) {
//                val[i] += val[i - 1];
//            }
//            for (int i = 0; i < val.length; i++) {
//                if (val[i] > 2) flag = -1;
//            }

            out.print("Case #" + x + ": ");


            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    int val = Integer.compare(o1[1], o2[1]);
                    if (val != 0)
                        return Integer.compare(o1[0], o2[0]);
                    return val;
                }
            });

            int J = 0, C = 0;
            char ans[] = new char[N];
            int check = 0;
            for (int i = 0; i < N; i++) {

                int a = arr[i][0], b = arr[i][1];

                int index = 0;
                for (int p = 0; p < N; p++) {
                    if (a == copy[p][0] && b == copy[p][1]) {
                        index = p;
                        break;
                    }
                }

                //    System.out.println(index);
                if (b > J && a >= J) {
                    J = b;
                    check = 0;
                } else if (b > C && a >= C) {
                    C = b;
                    check = 1;
                } else {
                    flag = -1;
                }

                if (check == 1)
                    ans[index] = 'C';
                else
                    ans[index] = 'J';

            }

            if (flag == -1) {
                out.println("IMPOSSIBLE");
            } else {
                for (int i = 0; i < N; i++)
                    out.print(ans[i]);
                out.println();
            }
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

