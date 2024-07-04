import java.io.*;
import java.util.*;

class Solution {
    static class Pair {
        int start, end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int u = sc.nextInt();
            String result = (u == 2) ? solveCase1(sc) : solveCase2(sc);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    static String solveCase1(FastScanner sc) {
        Map<Character, Pair> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int m = sc.nextInt();
            String r = sc.next();
            int n = r.length();
            processCharacter(map, m, r, n, 0);
            if (n > 1) {
                processCharacter(map, m, r, n, 1);
            }
        }
        return buildResult(map);
    }

    static String solveCase2(FastScanner sc) {
        Map<Character, Pair> map = new HashMap<>();
        for (int j = 0; j < 10000; j++) {
            String m = sc.next();
            String r = sc.next();
            int n = r.length();
            int x = m.length();
            for (int i = 0; i < n; i++) {
                char ch = r.charAt(i);
                int end = (i == 0 || n != x) ? 9 : m.charAt(i) - '0';
                if (map.containsKey(ch)) {
                    Pair p = map.get(ch);
                    p.end = Math.min(p.end, end);
                    if (i == 0) p.start = 1;
                } else {
                    map.put(ch, new Pair(i == 0 ? 1 : 0, end));
                }
            }
        }
        return buildResult(map);
    }

    static void processCharacter(Map<Character, Pair> map, int m, String r, int n, int index) {
        char ch = r.charAt(index);
        int end = (index == 0 && n == 1) ? Math.min(m, 9) : m / 10;
        if (map.containsKey(ch)) {
            Pair p = map.get(ch);
            p.end = Math.min(p.end, end);
            if (index == 0) p.start = 1;
        } else {
            map.put(ch, new Pair(index == 0 ? 1 : 0, end));
        }
    }

    static String buildResult(Map<Character, Pair> map) {
        char[] arr = new char[10];
        for (char ch : map.keySet()) {
            arr[map.get(ch).end] = ch;
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