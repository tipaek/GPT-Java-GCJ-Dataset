import java.io.*;
import java.util.*;

public class Solution {
    private StringBuilder sb = new StringBuilder();
    private static final HashMap<Character, Integer> map = new HashMap<>();
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int offset = -1000000000;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        final long MOD = 1000000007;
        int testCases = scanner.nextInt();
        Solution solution = new Solution();

        for (int currentTest = 1; currentTest <= testCases; currentTest++) {
            int result = solution.solve(scanner);
            out.flush();
            out.println("Case #" + currentTest + ": " + result);
        }
        out.close();
    }

    public int solve(MyScanner scanner) {
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        Long[] array = new Long[n];
        int maxFrequency = 0;
        long maxElement = 0;
        long minPair = Long.MAX_VALUE;
        HashMap<Long, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLong();
            int count = frequencyMap.getOrDefault(array[i], 0) + 1;
            frequencyMap.put(array[i], count);
            maxFrequency = Math.max(maxFrequency, count);
            maxElement = Math.max(maxElement, array[i]);
            if (count >= 2) {
                minPair = Math.min(minPair, array[i]);
            }
        }

        if (d == 2) {
            return maxFrequency < 2 ? 1 : 0;
        } else if (d == 3) {
            if (maxFrequency >= 3) {
                return 0;
            }
            for (long value : array) {
                if (frequencyMap.containsKey(value * 2)) {
                    return 1;
                }
            }
            if (maxFrequency == 2 && minPair < maxElement) {
                return 1;
            }
            return 2;
        }

        for (int result = 0; result < d; result++) {
            boolean valid = false;
            if (valid) {
                return result;
            }
        }

        return d - 1;
    }

    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    //--------------------------------------------------------
}