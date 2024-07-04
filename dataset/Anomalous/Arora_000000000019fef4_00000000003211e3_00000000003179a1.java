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
            String result = "";
            if (u == 2) {
                result = solveCase(scanner);
            }
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    static String solveCase(FastScanner scanner) {
        Map<Character, Pair> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int m = scanner.nextInt();
            String r = scanner.next();
            int length = r.length();

            if (length == 1) {
                char ch = r.charAt(0);
                if (map.containsKey(ch)) {
                    Pair p = map.get(ch);
                    int end = Math.min(9, m);
                    p.end = Math.min(p.end, end);
                    p.start = 1;
                } else {
                    int end = Math.min(9, m);
                    map.put(ch, new Pair(1, end));
                }
            } else {
                char firstChar = r.charAt(0);
                updateMap(map, firstChar, 1, m / 10);

                char secondChar = r.charAt(1);
                updateMap(map, secondChar, 0, Math.min(9, m));
            }
        }

        char[] resultArray = new char[10];
        for (Map.Entry<Character, Pair> entry : map.entrySet()) {
            char ch = entry.getKey();
            Pair p = entry.getValue();
            if (p.start == 0) {
                resultArray[0] = ch;
            } else {
                resultArray[p.end] = ch;
            }
        }
        return String.valueOf(resultArray);
    }

    private static void updateMap(Map<Character, Pair> map, char ch, int start, int end) {
        if (map.containsKey(ch)) {
            Pair p = map.get(ch);
            p.end = Math.min(p.end, end);
            p.start = start;
        } else {
            map.put(ch, new Pair(start, end));
        }
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