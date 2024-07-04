import java.io.*;
import java.util.*;

public class Solution {
    static FastScanner in;
    static PrintWriter out;
    static final long MOD = 1000000007;
    static final int SIZE = 500;
    static double ans;

    public static void main(String[] args) throws IOException {
        // Scanner in = new Scanner(new File("input.txt"));
        // Scanner in = new Scanner(System.in);
        // System.setOut(new PrintStream(new BufferedOutputStream(new
        // FileOutputStream("output.txt")), true));
        out = new PrintWriter(System.out);
        in = new FastScanner(System.in);
//        in = new FastScanner("/home/pvtuan10/IdeaProjects/CompetitiveProgramming/src/input.txt");
        int t = in.nextInt();
        for (int tt = 1; tt <= t;tt++) {
            out.print("Case #" + tt + ": ");
            int n = in.nextInt();
            String[] arr = new String[n];
            String largest = "";
            int len = 0;
            for (int i = 0;i < n;i++) {
                arr[i] = in.next();
                if (arr[i].length() > len) {
                    len = arr[i].length();
                    largest = arr[i];
                }
            }
            boolean ok = true;
            String longestPrefix = "", longestSuffix = "";
            int lenPref = 0, lenSuff = 0;
            for (int i = 0;i < n;i++) {
                String pref = prefix(arr[i]);
                String suff = suffix(arr[i]);
                if (pref.length() > lenPref) {
                    longestPrefix = pref;
                    lenPref = pref.length();
                }
                if (suff.length() > lenSuff) {
                    longestSuffix = suff;
                    lenSuff = suff.length();
                }
            }
            for (String s : arr) {
                if (!matchPrefix(s, longestPrefix) || !matchSuffix(s, longestSuffix)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                StringBuilder sb = new StringBuilder();
                sb.append(longestPrefix);
                for (int i = 0;i < n;i++) {
                    sb.append(getMiddle(arr[i]));
                }
                sb.append(longestSuffix);
                out.println(sb.toString());
            } else {
                out.println("*");
            }
        }
        out.close();
    }

    static String getMiddle(String s) {
        int start = 0, end = s.length() - 1;
        for (int i = 0;i < s.length();i++) {
            if (s.charAt(i) == '*') {
                start = i + 1;
                break;
            }
        }
        for (int i = s.length() - 1;i >= 0;i--) {
            if (s.charAt(i) == '*') {
                end = i - 1;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start;i <= end;i++) {
            if (s.charAt(i) == '*') continue;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    static boolean matchPrefix(String s, String prefix) {
        int i1 = 0, i2 = 0;
        while (i1 < s.length() && i2 < prefix.length() && (s.charAt(i1) != '*' || prefix.charAt(i2) != '*')) {
            if (s.charAt(i1) != prefix.charAt(i2)) break;
            i1++;
            i2++;
        }
        return s.charAt(i1) == '*';
    }

    static boolean matchSuffix(String s, String suffix) {
        int i1 = s.length() - 1, i2 = suffix.length() - 1;
        while (i1 >= 0 && i2 >= 0 && (s.charAt(i1) != '*' || suffix.charAt(i2) != '*')) {
            if (s.charAt(i1) != suffix.charAt(i2)) break;
            i1--;
            i2--;
        }
        return s.charAt(i1) == '*';
    }

    static String prefix(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') break;
            sb.append(c);
        }
        return sb.toString();
    }

    static String suffix(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1;i >= 0;i--) {
            if (s.charAt(i) == '*') break;
            sb.append(s.charAt(i));
        }
        return sb.reverse().toString();
    }
}

class UF {
    private int[] parents;
    private int[] rank;

    public UF(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++)
            parents[i] = i;
        rank = new int[n];
    }

    private int find(int i) {
        if (parents[i] != i) {
            parents[i] = find(parents[i]);
        }
        return parents[i];
    }

    public boolean union(int i, int j) {
        int a = find(i), b = find(j);
        if (a == b)
            return false;
        if (rank[a] < rank[b]) {
            parents[a] = b;
        } else if (rank[a] > rank[b]) {
            parents[b] = a;
        } else {
            parents[a] = b;
            rank[b]++;
        }

        return true;
    }
}

class Pair implements Comparable<Pair> {
    int i;
    int j;
    int k;

    public Pair(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.i, other.i);
    }
}

class FastScanner {

    BufferedReader br;
    StringTokenizer tokenizer;

    FastScanner(String fileName) throws FileNotFoundException {
        this(new FileInputStream(new File(fileName)));
    }

    FastScanner(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is));
    }

    String nextLine() throws IOException {
        tokenizer = null;
        return br.readLine();
    }

    String next() throws IOException {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                return null;
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    char nextChar() throws IOException {
        return next().charAt(0);
    }
}