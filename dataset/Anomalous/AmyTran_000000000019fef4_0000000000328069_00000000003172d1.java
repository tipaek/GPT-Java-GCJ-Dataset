import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();

        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int slides = scanner.nextInt();
            int dishes = scanner.nextInt();
            long[] degrees = new long[slides];
            for (int j = 0; j < slides; j++) {
                degrees[j] = scanner.nextLong();
            }
            System.out.println("Case #" + (i + 1) + ": " + solve(slides, dishes, degrees));
        }
    }

    public static String solve(int slides, int dishes, long[] degrees) {
        Map<Long, Integer> degreeCount = new HashMap<>();
        for (long degree : degrees) {
            degreeCount.put(degree, degreeCount.getOrDefault(degree, 0) + 1);
            if (degreeCount.get(degree) >= dishes) {
                return "0";
            }
        }

        int minCuts = Integer.MAX_VALUE;
        for (long target : degreeCount.keySet()) {
            int cuts = 0;
            for (long degree : degrees) {
                if (degree != target) {
                    cuts += (degree % target == 0) ? (degree / target - 1) : (degree / target);
                }
                if (cuts >= dishes - degreeCount.get(target)) {
                    break;
                }
            }
            if (cuts != 0) {
                minCuts = Math.min(minCuts, cuts);
            }
        }

        return String.valueOf(minCuts == Integer.MAX_VALUE ? dishes - 1 : minCuts);
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String fileName) {
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
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