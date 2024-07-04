import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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
    public static void main(String[] args) {
        int T;
        FastReader keyboard = new FastReader();
        T = keyboard.nextInt();
        for (int i = 0; i < T; i++)
        {
            int N = keyboard.nextInt();
            int[][] arr = new int[N][N];
            for (int j = 0; j < N; j++)
            {
                for (int k = 0; k < N; k++)
                    arr[j][k] = keyboard.nextInt();
            }
            System.out.print("Case #"+(i + 1) +" ");
            // tr(A)
            int sum = 0;
            for (int j = 0; j < N; j++)
                sum+=arr[j][j];
            System.out.print(sum + " ");
            // rrepeat(A)
            // crepeat(A)
            int rrepeat = 0;
            int crepeat = 0;
            for (int j = 0; j < N; j++)
            {
                HashSet<Integer> hs = new HashSet<>();
                HashSet<Integer> hs2 = new HashSet<>();
                for (int k = 0; k < N; k++)
                {
                    hs.add(arr[j][k]);
                    hs2.add(arr[k][j]);
                }
                if (hs.size() != N)
                    rrepeat++;
                if (hs2.size() != N)
                    crepeat++;
            }
            System.out.println(rrepeat + " " + crepeat);
        }
    }
}
