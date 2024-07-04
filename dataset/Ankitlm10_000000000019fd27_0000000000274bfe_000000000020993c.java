import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Soln {


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
        FastReader sc = new FastReader();
        int tcs = sc.nextInt();
        Random random = new Random();
        for (int p = 0; p < tcs; p++) {
            int n = sc.nextInt();
            int a[][] = new int[n][n];
            int rowDuplicate = 0;
            int trace = 0;
            for (int i = 0; i < n; i++) {
                HashMap<Integer, Integer> hashMap = new HashMap<>();
                boolean duplicate = false;
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                    if (j == 0)
                        hashMap.put(a[i][j], 1);
                    else {
                        int k = hashMap.getOrDefault(a[i][j], 0);
                        if (k != 0)
                            duplicate = true;
                        hashMap.put(a[i][j], 1);
                    }
                    if (i == j)
                        trace += a[i][j];

                }
                if (duplicate)
                    rowDuplicate++;
            }

            int colDuplicate = 0;
            for (int i = 0; i < n; i++) {
                HashMap<Integer, Integer> hashMap = new HashMap<>();
                boolean duplicate = false;
                for (int j = 0; j < n; j++) {

                    if (j == 0)
                        hashMap.put(a[j][i], 1);
                    else {
                        int k = hashMap.getOrDefault(a[j][i], 0);
                        if (k != 0) {
                            duplicate = true;
                            break;
                        }
                        hashMap.put(a[j][i], 1);
                    }

                }
                if (duplicate) colDuplicate++;
            }
            System.out.println("Case #"+(p+1)+": "+trace+" "+rowDuplicate+"  "+colDuplicate);

        }

    }
}