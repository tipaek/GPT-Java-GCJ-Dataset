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
	// in = new FastScanner("input.txt");
	int t = in.nextInt();
	for (int tt = 1; tt <= t; tt++) {
	    out.print("Case #" + tt + ": ");
	    int n = in.nextInt();
	    Schedule[] schedule = new Schedule[n];
	    for (int i = 0; i < n; i++) {
		int start = in.nextInt();
		int end = in.nextInt();
		schedule[i] = new Schedule(start, end, i);
	    }
	    Arrays.sort(schedule, (s1, s2) -> (s1.start - s2.start));
	    int cTime = -1, jTime = -1;
	    boolean ok = true;
	    char[] ans = new char[n];
	    for (Schedule s : schedule) {
		int start = s.start, end = s.end;
		if (start < cTime && start < jTime) {
		    ok = false;
		    break;
		}
		if (start >= cTime) {
		    cTime = end;
		    ans[s.index] = 'C';
		} else {
		    jTime = end;
		    ans[s.index] = 'J';
		}
	    }
	    if (ok)
		out.println(String.valueOf(ans));
	    else
		out.println("IMPOSSIBLE");
	}
	out.close();
    }
}

class Schedule {
    int start;
    int end;
    int index;

    public Schedule(int start, int end, int index) {
	this.start = start;
	this.end = end;
	this.index = index;
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