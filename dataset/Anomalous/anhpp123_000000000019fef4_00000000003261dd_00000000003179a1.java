import java.io.*;
import java.util.*;

public class Solution {
    private static final HashMap<Character, Integer> directionMap = new HashMap<>();
    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static final long MOD = 1000000007L;
    private static final int OFFSET = -1000000000;

    static {
        directionMap.put('N', 0);
        directionMap.put('E', 1);
        directionMap.put('S', 2);
        directionMap.put('W', 3);
    }

    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int testCases = scanner.nextInt();
        Solution solution = new Solution();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String result = solution.solve(scanner);
            out.println("Case #" + caseNumber + ": " + result);
        }

        out.close();
    }

    public String solve(MyScanner scanner) {
        int n = scanner.nextInt();
        int count = 0;
        String[] matrix = new String[10000];
        String[] strings = new String[10000];
        HashMap<Character, Integer> letterMap = new HashMap<>();
        HashSet<Character> impossibleZero = new HashSet<>();
        int[] positionStart = new int[10];
        Arrays.fill(positionStart, 10);

        for (int i = 0; i < 10000; i++) {
            matrix[i] = scanner.next();
            String temp = scanner.next();
            for (char c : temp.toCharArray()) {
                letterMap.putIfAbsent(c, count++);
            }
            strings[i] = temp;
        }

        char[] result = new char[10];
        for (int i = 0; i < 10000; i++) {
            int position = letterMap.get(strings[i].charAt(0));
            positionStart[position]++;
        }

        int[] sortedPositions = positionStart.clone();
        Arrays.sort(sortedPositions);

        for (char tmp = 'A'; tmp <= 'Z'; tmp++) {
            if (letterMap.containsKey(tmp)) {
                for (int j = 0; j < 10; j++) {
                    if (positionStart[letterMap.get(tmp)] == sortedPositions[j]) {
                        result[(10 - j) % 10] = tmp;
                    }
                }
            }
        }

        return new String(result);
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