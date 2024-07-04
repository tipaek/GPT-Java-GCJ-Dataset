import java.io.*;
import java.util.*;

public class Solution {
    static class Pair {
        int start, end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int u = scanner.nextInt();
            String result = (u == 2) ? solveCase1(scanner) : solveCase2(scanner);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    static String solveCase1(FastScanner scanner) {
        Map<Character, Pair> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int m = scanner.nextInt();
            String r = scanner.next();
            int length = r.length();

            updateMap(map, r.charAt(0), m, length == 1 ? 1 : m / 10, 1);

            if (length > 1) {
                updateMap(map, r.charAt(1), m, Math.min(m, 9), 0);
            }
        }

        return createResultString(map);
    }

    static String solveCase2(FastScanner scanner) {
        Map<Character, Pair> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            String m = scanner.next();
            String r = scanner.next();
            int lengthR = r.length();
            int lengthM = m.length();

            for (int j = 0; j < lengthR; j++) {
                char ch = r.charAt(j);
                int end = (j < lengthM) ? m.charAt(j) - '0' : 9;
                updateMap(map, ch, end, end, j == 0 ? 1 : 0);
            }
        }

        return createResultString(map);
    }

    static void updateMap(Map<Character, Pair> map, char ch, int m, int end, int start) {
        map.putIfAbsent(ch, new Pair(start, end));
        Pair p = map.get(ch);
        p.end = Math.min(p.end, end);
        p.start = start;
    }

    static String createResultString(Map<Character, Pair> map) {
        char[] arr = new char[10];
        for (Map.Entry<Character, Pair> entry : map.entrySet()) {
            char ch = entry.getKey();
            Pair p = entry.getValue();
            arr[p.start == 0 ? 0 : p.end] = ch;
        }
        return String.valueOf(arr);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
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
            return Integer.parseInt(next());
        }
    }
}