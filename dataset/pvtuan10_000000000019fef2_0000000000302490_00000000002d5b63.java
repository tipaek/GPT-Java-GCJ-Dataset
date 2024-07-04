import java.io.*;
import java.util.*;

public class Solution {
    static FastScanner in;
    static PrintWriter out;
    static final long MOD = 1000000007;
    static final int SIZE = 1000000001;
    static int min;
    static String ans;

    public static void main(String[] args) throws IOException {
        // Scanner in = new Scanner(new File("input.txt"));
        // Scanner in = new Scanner(System.in);
        // System.setOut(new PrintStream(new BufferedOutputStream(new
        // FileOutputStream("output.txt")), true));
        out = new PrintWriter(System.out);
        in = new FastScanner(System.in);
//        in = new FastScanner("/home/pvtuan10/IdeaProjects/CompetitiveProgramming/src/input.txt");
        String line = in.nextLine();
        String[] nums = line.split("\\s+");
        int t = Integer.parseInt(nums[0]);
        int a = Integer.parseInt(nums[1]);
        int b = Integer.parseInt(nums[2]);
        int size = 1000000000;
        int da = size - a;
        for (int tt = 1; tt <= t; tt++) {
            int leftX = 0, rightX = 0, botY = 0, topY = 0;
            for (int x = -50;x < 0;x++) {
                System.out.println(x + " " + (size - da * 2));
                String ans = in.next();
                if (ans.equals("HIT")) {
                    leftX++;
                }
            }
            for (int x = 1;x <= 50;x++) {
                System.out.println(x + " " + (size - da * 2));
                String ans = in.next();
                if (ans.equals("HIT")) {
                    rightX++;
                }
            }
            for (int y = -50;y < 0;y++) {
                System.out.println((size - da * 2) + " " + y);
                String ans = in.next();
                if (ans.equals("HIT")) {
                    botY++;
                }
            }
            for (int y = 1;y <= 50;y++) {
                System.out.println((size - da * 2) + " " + y);
                String ans = in.next();
                if (ans.equals("HIT")) {
                    topY++;
                }
            }
            int x = (rightX - leftX) / 2;
            int y = (topY - botY) / 2;
            System.out.println(x + " " + y);
            in.next();
        }
        out.close();
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