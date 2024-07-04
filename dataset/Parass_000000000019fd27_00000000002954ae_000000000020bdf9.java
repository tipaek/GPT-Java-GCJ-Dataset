
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{

    public static void main(String[] args) {

        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = in.nextInt(), x = 0;

        while (x++ < t) {
            int N = in.nextInt();
            int arr[][] = new int[N][3];

            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
                arr[i][2]=i;
            }

            int flag = 1;
            out.print("Case #" + x + ": ");

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    int val = Integer.compare(o1[0], o2[0]);
                    if (val == 0)
                        return Integer.compare(o1[1], o2[1]);
                    return val;
                }
            });

            int J = 0, C = 0;  char ans[] = new char[N];  int check = 1;
            for (int i = 0; i < N; i++) {
                
                int a = arr[i][0], b = arr[i][1],index = arr[i][2];

                if (b > J && a >= J) {
                    J = b;
                    check = 0;
                } else if (b > C && a >= C) {
                    C = b;
                    check = 1;
                } else
                    flag = -1;


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

