import java.io.*;
import java.util.*;

public class Solution {

    private static BufferedReader in;
    private static PrintWriter out;
    private static StringTokenizer tok;
    private static final boolean isLocal = true;

    private static final int N = 10000;

    private void addToMap(Map<Integer, Set<String>> map, int key, String value) {
        map.computeIfAbsent(key, k -> new HashSet<>()).add(value);
    }

    private void printMap(Map<Integer, Set<String>> map) {
        map.forEach((key, valueSet) -> {
            out.print(key + ": ");
            valueSet.forEach(value -> out.print(value + " "));
            out.println();
        });
    }

    private String getAndDelete(Map<Integer, Set<String>> map, int key) {
        Set<String> set = map.get(key);
        if (set == null || set.size() != 1) return "#";
        String result = set.iterator().next();
        for (int j = key + 1; j <= 10; j++) {
            Set<String> nextSet = map.get(j);
            if (nextSet != null) {
                nextSet.remove(result);
            }
        }
        return result;
    }

    private String findMissingCharacter(Map<Integer, Set<String>> map, String ans) {
        for (char c = 'A'; c <= 'Z'; c++) {
            if (!ans.contains(String.valueOf(c))) {
                for (Set<String> valueSet : map.values()) {
                    for (String value : valueSet) {
                        if (value.contains(String.valueOf(c))) {
                            return String.valueOf(c);
                        }
                    }
                }
            }
        }
        throw new RuntimeException("Missing character not found");
    }

    private void processCase() throws IOException {
        int u = nextInt();
        int[] q = new int[N];
        String[] r = new String[N];
        Map<Integer, Set<String>> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            q[i] = nextInt();
            r[i] = next();
            addToMap(map, q[i], r[i]);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            ans.append(getAndDelete(map, i));
        }
        for (char c : ans.toString().toCharArray()) {
            if (c != '#') {
                out.print(c);
            } else {
                out.print(findMissingCharacter(map, ans.toString()));
            }
        }
        out.println();
    }

    private void solve() throws Exception {
        int t = nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            processCase();
        }
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    private String next() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    public static void main(String[] args) throws Exception {
        try {
            if (isLocal) {
                in = new BufferedReader(new FileReader("src/tests/sol.in"));
                out = new PrintWriter(new BufferedWriter(new FileWriter("src/tests/sol.out")));
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(new OutputStreamWriter(System.out));
            }
            new Solution().solve();
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(1);
        }
    }
}