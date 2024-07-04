import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static BufferedReader br;
    private static StringTokenizer st;

    private static void solve() throws IOException {
    	int t = readInt();
    	for (int i = 1; i <= t; ++i) {
    		int n = readInt();
    		String[] strs = new String[n];
    		for (int j = 0; j < n; j++)
    			strs[j] = readLine();
    		String beg = "";
    		String end = "";
    		ArrayList<String> middle = new ArrayList<>();
    		boolean good = true;
			for (int j = 0; j < n; j++) {
				String[] comps = strs[j].split("\\*");
				if (!strs[j].startsWith("*")) {
					String start = comps[0];
					if (!beg.startsWith(start))
						if (start.startsWith(beg) || beg.equals("")) beg = start;
						else {
							System.out.println("Case #" + i + ": *");
							good = false;
							break;
						}
				} if (!strs[j].endsWith("*")) {
					String fin = comps[comps.length-1];
					if (!end.endsWith(fin))
						if (fin.endsWith(end) || end.equals("")) end = fin;
						else {
							System.out.println("Case #" + i + ": *");
							good = false;
							break;
						}
				}
				for (int k = 0; k < comps.length; ++k)
					if ((strs[j].startsWith("*") || k != 0) && (strs[j].endsWith("*") || k != comps.length - 1))
						middle.add(comps[k]);
			}
			if (good) {
				System.out.println("Case #" + i + ": " + beg + middle.toString().substring(1, middle.toString().length()-1).replace(", ", "") + end);
			}
		}
    }

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        solve();
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }

    private static class Pair<A, B> {
        private A first;
        private B second;

        Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        public A getFirst() {
            return first;
        }

        public B getSecond() {
            return second;
        }

        public void setFirst(A first) {
            this.first = first;
        }

        public void setSecond(B second) {
            this.second = second;
        }
    }

    private static class UndirectedGraph {
        HashMap<Integer, ArrayList<Integer>> g;

        UndirectedGraph() {
            g = new HashMap<>();
        }

        void connect(int node1, int node2) {
            if (!g.containsKey(node1)) g.put(node1, new ArrayList<>());
            if (!g.containsKey(node2)) g.put(node2, new ArrayList<>());

            g.get(node1).add(node2);
            g.get(node2).add(node1);
        }

        ArrayList<Integer> dfs(int n) {
            Stack<Integer> s = new Stack<>();
            ArrayList<Integer> v = new ArrayList<>();
            s.push(n);
            while (!s.empty()) {
                int curr = s.pop();
                if (g.get(curr) == null)
                    return new ArrayList<>();
                if (!v.contains(curr)) {
                    v.add(curr);
                    s.addAll(g.get(curr));
                }
            }
            return v;
        }

        Set<Integer> getNodes() {
            return g.keySet();
        }
    }

    private static class DisjointUnionSets {
        int[] rank, parent;
        int n;

        public DisjointUnionSets(int n) {
            rank = new int[n];
            parent = new int[n];
            this.n = n;
            makeSet();
        }

        void makeSet() {
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);

            return parent[x];
        }

        void union(int x, int y) {
            int xRoot = find(x), yRoot = find(y);

            if (xRoot != yRoot) {
                if (rank[xRoot] < rank[yRoot])
                    parent[xRoot] = yRoot;

                else if (rank[yRoot] < rank[xRoot])
                    parent[yRoot] = xRoot;

                else {
                    parent[yRoot] = xRoot;
                    rank[xRoot] = rank[xRoot] + 1;
                }
            }
        }
    }
}
