import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(new
                    FileReader("system.in"));
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
    public static void main(String[] args)
            throws IOException {
//        FastReader scanFile = new FastReader();
//        Path path = Paths.get("system.out");
        Scanner scanFile = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanFile.nextInt();
        for(int q =0; q < t; q++){
            int n= scanFile.nextInt();
            int k = 0;
            int r = 0;
            int c = 0;
            int[][] x = new int[n][n];
            for(int i =0; i< n; i++){
                HashSet<Integer> s = new HashSet<Integer>();
                for(int j = 0; j < n; j++) {
                    int curr = scanFile.nextInt();
                    x[i][(j)] = curr;
                    s.add(curr);
                    if (j == n-1) {
                        if (s.size() != n) {
                            r++;
                        }
                    }
                }
            }
            for(int i= 0; i < n; i++){
                HashSet<Integer> s = new HashSet<Integer>();
                for(int j = 0; j < n; j++) {
                    int curr = x[j][i];
                    s.add(curr);
                    if (j == n-1) {
                        if (s.size() != n) {
                            c++;
                        }
                    }
                }
            }
            for(int i =0 ; i < n; i++){
                int sum = x[i][i];
                k = k+ sum;
            }
            System.out.println("Case #" + (q + 1) + ":  " + k + " " + r + " " + c);
//
        }
    }
}
