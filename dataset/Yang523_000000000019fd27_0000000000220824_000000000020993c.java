import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static class MyScanner {
        BufferedReader br;

        StringTokenizer st;


        public MyScanner() {
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

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        int numCases = scanner.nextInt();
        for (int i = 1; i <= numCases; i++) {
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = scanner.nextInt();
                    if (j == k) {
                        sum += arr[j][k];
                    }
                }
            }

            int r = 0, c = 0;
            for (int row = 0; row < n; row++) {
                Set<Integer> set = new HashSet();
                for (int col = 0; col < n; col++) {
                    set.add(arr[row][col]);
                }
                if (set.size() != n) r++;
            }

            for (int col = 0; col < n; col++) {
                Set<Integer> set = new HashSet<>();
                for (int row = 0; row < n; row++) {
                    set.add(arr[row][col]);
                }
                if (set.size() != n) c++;
            }

            System.out.format("Case #%d: %d %d %d\n", i, sum, r, c);
        }
    }
}
