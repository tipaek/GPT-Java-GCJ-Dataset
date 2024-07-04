import java.io.*;
import java.util.*;

public class Solution {

    private static final int N = 10000;
    private static BufferedReader in;
    private static PrintWriter out;
    private static StringTokenizer tok;
    private static boolean isLocal = true;

    private void addToMap(Map<Integer, Set<String>> map, int q, String r) {
        map.computeIfAbsent(q, k -> new HashSet<>()).add(r);
    }

    private void printMap(Map<Integer, Set<String>> map) {
        map.forEach((key, value) -> {
            out.print(key + ": ");
            value.forEach(x -> out.print(x + " "));
            out.println();
        });
    }

    private String getAndDelete(Map<Integer, Set<String>> map, int i) {
        Set<String> set = map.get(i);
        if (set == null || set.size() != 1) return "#";
        String ans = set.iterator().next();
        for (int j = i + 1; j <= 10; j++) {
            Set<String> nextSet = map.get(j);
            if (nextSet != null) nextSet.remove(ans);
        }
        return ans;
    }

    private Map<Integer, Set<String>> reformat(Map<Integer, Set<String>> map, String ans) {
        Map<Integer, Set<String>> tmp = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            if (ans.charAt(i) != '#') {
                for (Map.Entry<Integer, Set<String>> entry : map.entrySet()) {
                    int key = entry.getKey();
                    for (String x : entry.getValue()) {
                        if (x.length() == String.valueOf(key).length() && x.contains(String.valueOf(ans.charAt(i)))) {
                            String replaced = x.replaceAll(String.valueOf(ans.charAt(i)), String.valueOf(i));
                            for (int j = 0; j < 10; j++) {
                                if (ans.charAt(j) != '#') {
                                    replaced = replaced.replaceAll(String.valueOf(ans.charAt(j)), String.valueOf(j));
                                }
                            }
                            tmp.computeIfAbsent(key, k -> new TreeSet<>()).add(replaced);
                        }
                    }
                }
            }
        }
        return tmp;
    }

    private String caseMissing(Map<Integer, Set<String>> map, String ans) {
        for (char c = 'A'; c <= 'Z'; c++) {
            if (!ans.contains(String.valueOf(c))) {
                for (Set<String> set : map.values()) {
                    for (String x : set) {
                        if (x.contains(String.valueOf(c))) {
                            return String.valueOf(c);
                        }
                    }
                }
            }
        }
        throw new RuntimeException("Missing case not found");
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

        map = reformat(map, ans.toString());
        for (char c : ans.toString().toCharArray()) {
            if (c != '#') {
                out.print(c);
            } else {
                out.print(caseMissing(map, ans.toString()));
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