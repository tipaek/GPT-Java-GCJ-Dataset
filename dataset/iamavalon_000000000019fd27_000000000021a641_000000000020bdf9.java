import java.io.*;
import java.util.*;
 
public class Solution {
    
 
    private void solve() throws Exception {
        int T = nextInt();
        for(int tt = 1; tt <= T; tt++) {
            int N = nextInt();
            Activity[] act = new Activity[N];
            for(int i = 0; i < N; i++) {
                act[i] = new Activity(i, nextInt(), nextInt());
            }
            bad = false;
            adj = new ArrayDeque[N];
            for(int i = 0; i < N; i++) adj[i] = new ArrayDeque<>();
            for(int i = 0; i < N; i++) {
                for(int j = i+1; j < N; j++) {
                    if(!act[i].isCompatible(act[j])) {
                        adj[i].add(j);
                        adj[j].add(i);
                    }
                }
            }
            partition = new int[N];
            Arrays.fill(partition, -1);
            done = new boolean[N];
            for(int i = 0; i < N; i++) {
                if(!done[i]) {
                    partition[i] = 0;
                    dfs(i);
                }
            }
            
            
            char[] res = new char[N];
            for(int i = 0; i < N; i++) {
                res[i] = partition[act[i].idx]==0?'J':'C';
            }
            System.out.println("Case #" + tt + ": " + (bad?"IMPOSSIBLE":(new String(res))));
        }
    }
    
    ArrayDeque<Integer>[] adj;
    
    boolean bad;
    
    void dfs(int u) {
        done[u] = true;
        for(int v : adj[u]) {
            if(!done[v]) {
                partition[v] = 1-partition[u];
                dfs(v);
            } else if(partition[v] == partition[u]) bad = true;
        }
    }
    
    int[] partition;
    boolean[] done;
    
    class Activity{
        int idx;
        int S;
        int E;
        
        public Activity(int idx, int S, int E) {
            this.idx = idx;
            this.S = S;
            this.E = E;
        }
        
        boolean isCompatible(Activity other) {
            return this.E <= other.S || this.S >= other.E;
        }
    }

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                new Solution().run();
            }
        }, "1", 1 << 27).start();
    }

    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer tokenizer;

    public void run() {
        try {
            //in = new BufferedReader(new FileReader("fossil_fuels.txt"));
            in = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            //out = new PrintWriter(new File("outputPQ.txt"));
            out = new PrintWriter(System.out);
            solve();
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private float nextFloat() throws IOException {
        return Float.parseFloat(nextToken());
    }

    private String nextLine() throws IOException {
        return new String(in.readLine());
    }

    private String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(in.readLine());
        }
        return tokenizer.nextToken();
    }
 
}