import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;


public class Solution {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    static boolean isLocal = true;

    int N = 10000;

    void addToMap(Map<Integer, Set<String>> map, int q, String r) {
        Set<String> set = map.get(q);
        if (set == null) set = new HashSet<>();
        set.add(r);
        map.put(q, set);
    }

    void printMap(Map<Integer, Set<String>> map) {
        for (int key : map.keySet()) {
            out.print(key + ": ");
            for (String x : map.get(key)) out.print(x + " ");
            out.println();
        }
    }

    private String getAndDelete(Map<Integer, Set<String>> map, int i) {
        Set<String> set = map.get(i);
        if (set == null || set.size() != 1) return "#";
        String ans = (String) set.toArray()[0];
        for (int j = i + 1; j <= 10; j++)
            if (map.get(j).contains(ans)) map.get(j).remove(ans);
        return ans;
    }

    Map<Integer, Set<String>> reformat(Map<Integer, Set<String>> map, String ans) {
        Map<Integer, Set<String>> tmp = new TreeMap<>();
        for (int i = 0; i < 10; i++)
            if (ans.charAt(i) != '#') {
                for (int key : map.keySet()) {
                    for (String x : map.get(key))
                        if (x.length() == String.valueOf(key).length())
                            if (x.contains("" + ans.charAt(i))) {
                                Set<String> set = tmp.get(key);
                                if (set == null) set = new TreeSet<>();
                                x = x.replaceAll("" + ans.charAt(i), "" + i);
                                for (int j = 0; j < 10; j++) {
                                    if (ans.charAt(j) != '#') {
                                        x.replaceAll("" + ans.charAt(j), "" + j);
                                    }
                                }
                                set.add(x);
                                tmp.put(key, set);
                            }
                }
            }
        return tmp;
    }

    String CaseMissing(Map<Integer, Set<String>> map, String ans) {
        for (char c = 'A'; c <= 'Z'; c++)
            if (!ans.contains("" + c)) {
                for (int key : map.keySet()) {
                    for (String x : map.get(key)) if (x.contains("" + c)) return "" + c;
                }
            }
        throw new RuntimeException();
    }

    void Case() throws IOException {
        int u = nextInt();
        int q[] = new int[N];
        String[] r = new String[N];
        Map<Integer, Set<String>> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            q[i] = nextInt();
            r[i] = next();
            addToMap(map, q[i], r[i]);
        }
//        printMap(map);
        String ans = "";
        for (int i = 0; i < 10; i++) {
            ans += getAndDelete(map, i);
        }
        map = reformat(map, ans);
        for (char c : ans.toCharArray())
            if (c != '#')
                out.print(c);
            else
                out.print(CaseMissing(map, ans));
        out.println();
//        printMap(map);
    }


    void solve() throws Exception {
        int t = nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            Case();
        }
    }

    int min(int x, int y) {
        return Integer.min(x, y);
    }

    int max(int x, int y) {
        return Integer.max(x, y);
    }

    long min(long x, long y) {
        return Long.min(x, y);
    }

    long max(long x, long y) {
        return Long.max(x, y);
    }

    int[] sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    class Seg implements Comparable<Seg> {
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
            return st == seg.st &&
                    end == seg.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(st, end);
        }

        @Override
        public int compareTo(Seg seg) {
            return st == seg.st ? Integer.compare(end, seg.end) : Integer.compare(st, seg.st);
        }
    }

    private int[] na(int n) throws IOException {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = nextInt();
        return a;
    }

    private long[] nal(int n) throws IOException {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = nextLong();
        return a;
    }

    int nextInt() throws IOException {
        return parseInt(next());
    }

    long nextLong() throws IOException {
        return parseLong(next());
    }

    double nextDouble() throws IOException {
        return parseDouble(next());
    }

    String next() throws IOException {
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
//            long lStartTime = System.currentTimeMillis();
            new Solution().solve();
//            long lEndTime = System.currentTimeMillis();
//            out.println("Elapsed time in seconds: " + (double) (lEndTime - lStartTime) / 1000.0);
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(1);
        }
    }
}
