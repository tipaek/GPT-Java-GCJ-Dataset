// Working program with FastReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
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
        FastReader fr = new FastReader();
        int T = fr.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = fr.nextInt();
            int arr[][] = new int[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    arr[i][j] = fr.nextInt();
            Set<Integer> r = new HashSet<>();
            Set<Integer> c = new HashSet<>();
            int countr = 0, countc = 0;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                r.clear();
                c.clear();
                for (int j = 0; j < N; j++) {
                    r.add(arr[i][j]);
                    c.add(arr[j][i]);
                    if (i == j)
                        sum += arr[i][j];
                }
                if(r.size() != N)
                    countr++;
                if(c.size() != N)
                    countc++;
            }
            System.out.println("Case #"+t+": "+sum+" "+countr+" "+countc+" ");
        }
    }
}
