import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTest = Integer.parseInt(sc.nextToken());

        for (int i = 0; i < numberOfTest; i++) {
            // Input
            int N = Integer.parseInt(sc.nextToken());
            List<String> patterns = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                patterns.add(sc.nextToken());
            }

            // Solve
            String res = solve(patterns);
            System.out.println("Case #" + (i+1) + ": " + res);
        }
    }

    private static String solve(List<String> patterns) {
        String maxPattern = patterns.get(0);
        for (int i = 1; i < patterns.size(); i++) {
            String p = patterns.get(i);
            if (p.length() > maxPattern.length()) {
                maxPattern = p;
            }
        }

        for (int i = 0; i < patterns.size(); i++) {
            String p = patterns.get(i).replace("*", "");
            String cleanMaxP = maxPattern.replace("*", "");
            if (!cleanMaxP.equals(p) && !cleanMaxP.contains(p))
                return "*";
        }

        return maxPattern.replace("*", "A");
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