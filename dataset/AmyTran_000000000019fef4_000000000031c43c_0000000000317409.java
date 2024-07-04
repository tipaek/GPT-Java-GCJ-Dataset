import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTest = Integer.parseInt(sc.nextToken());

        for (int i = 0; i < numberOfTest; i++) {
            // Input
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String pathStr = sc.nextToken();
            System.out.println("Case #" + (i + 1) + ": " + solve(X, Y, pathStr));
        }
    }

    public static String solve(int x, int y, String path) {
        int peppurrX = x, peppurrY = y;
        for (int i = 0 ; i < path.length(); i++) {
            if (path.charAt(i) == 'N') {
                peppurrY ++;
            } else if (path.charAt(i) == 'E'){
                peppurrX ++;
            } else if (path.charAt(i) == 'S') {
                peppurrY --;
            } else {
                peppurrX ++;
            }
            if (Math.abs(peppurrX) + Math.abs(peppurrY) <= i + 1) {
                return (i + 1) + "";
            }
        }
        return "IMPOSSIBLE";
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
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
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
