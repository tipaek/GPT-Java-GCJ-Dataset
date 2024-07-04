import java.io.*;
import java.util.*;

public class Solution {
    private StringBuilder sb = new StringBuilder();
    private static final HashMap<Character, Integer> map = new HashMap<>();
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static final int OFFSET = -1000000000;
    private static final long MOD = 1000000007;

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        map.put('N', 0);
        map.put('E', 1);
        map.put('S', 2);
        map.put('W', 3);

        Solution solution = new Solution();
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String result = solution.solve(scanner);
            out.flush();
            out.println("Case #" + testCase + ": " + result);
        }
        out.close();
    }

    public String solve(MyScanner scanner) {
        int n = scanner.nextInt();
        int count = 0;
        String[] M = new String[10000];
        String[] str = new String[10000];
        HashMap<Character, Integer> letters = new HashMap<>();
        HashSet<Character> impossibleZero = new HashSet<>();
        int[] posStart = new int[10];
        Arrays.fill(posStart, 10);
        boolean isT3 = false;

        for (int i = 0; i < 10000; i++) {
            M[i] = scanner.next();
            if (M[i].equals("-1")) isT3 = true;
            String tmp = scanner.next();
            for (char c : tmp.toCharArray()) {
                letters.putIfAbsent(c, count++);
            }
            impossibleZero.add(tmp.charAt(0));
            str[i] = tmp;
        }

        char[] result = new char[10];
        if (!isT3) {
            for (int i = 0; i < 10000; i++) {
                if (M[i].length() == str[i].length()) {
                    int pos = letters.get(str[i].charAt(0));
                    posStart[pos] = Math.min(posStart[pos], M[i].charAt(0) - '0');
                }
            }
            for (int i = 0; i < 26; i++) {
                char tmp = (char) ('A' + i);
                if (letters.containsKey(tmp)) {
                    result[posStart[letters.get(tmp)] % 10] = tmp;
                }
            }
            return new String(result);
        } else {
            for (int i = 0; i < 10000; i++) {
                int pos = letters.get(str[i].charAt(0));
                posStart[pos]++;
            }
            int[] sorted = posStart.clone();
            Arrays.sort(sorted);

            for (int i = 0; i < 26; i++) {
                char tmp = (char) ('A' + i);
                if (letters.containsKey(tmp)) {
                    for (int j = 0; j < 10; j++) {
                        if (posStart[letters.get(tmp)] == sorted[j]) {
                            result[(10 - j) % 10] = tmp;
                        }
                    }
                }
            }
            return new String(result);
        }
    }

    public static class MyScanner {
        private final BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
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
}