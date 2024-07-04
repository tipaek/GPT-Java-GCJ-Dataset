import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    static boolean isLocal = true;

    private static final int N = 10000;

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
        if (set == null || set.isEmpty()) return "#";
        if (set.size() > 1) throw new RuntimeException();
        String ans = set.iterator().next();
        for (int j = i + 1; j <= 10; j++) {
            map.getOrDefault(j, Collections.emptySet()).remove(ans);
        }
        return ans;
    }

    private String findMissingCharacter(Map<Integer, Set<String>> map, String ans) {
        for (char c = 'A'; c <= 'Z'; c++) {
            if (!ans.contains(String.valueOf(c))) {
                for (Set<String> set : map.values()) {
                    if (set.stream().anyMatch(x -> x.contains(String.valueOf(c)))) {
                        return String.valueOf(c);
                    }
                }
            }
        }
        throw new RuntimeException();
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
        for (int i = 1; i < 10; i++) {
            ans.append(getAndDelete(map, i));
        }
        ans.insert(0, findMissingCharacter(map, ans.toString()));
        out.println(ans);
    }

    private void solve() throws Exception {
        int t = nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            processCase();
        }
    }

    private int[] sort(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    private class Seg implements Comparable<Seg> {
        int st, end;

        public Seg(int st, int end) {
            this.st = st;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Seg seg = (Seg) o;
            return st == seg.st && end == seg.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(st, end);
        }

        @Override
        public int compareTo(Seg seg) {
            return st != seg.st ? Integer.compare(st, seg.st) : Integer.compare(end, seg.end);
        }
    }

    private int[] readIntArray(int n) throws IOException {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = nextInt();
        return a;
    }

    private long[] readLongArray(int n) throws IOException {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = nextLong();
        return a;
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