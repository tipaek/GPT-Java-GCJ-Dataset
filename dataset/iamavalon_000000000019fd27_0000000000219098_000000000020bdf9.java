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
            Arrays.sort(act, Comparator.comparing(a -> a.S));
            int J = 0;
            int C = 0;
            boolean bad = false;
            for(int i = 0; i < N ; i++) {
                if(act[i].S >= J) {
                    act[i].who = 0;
                    J = act[i].E;
                } else if(act[i].S >= C) {
                    act[i].who = 1;
                    C = act[i].E;
                } else {
                    bad = true;
                    break;
                }
            }
            char[] res = new char[N];
            for(int i = 0; i < N; i++) {
                res[i] = act[i].who==0?'J':'C';
            }
            System.out.println("Case #" + tt + ": " + (bad?"IMPOSSIBLE":(new String(res))));
        }
    }
    
    class Activity{
        int idx;
        int S;
        int E;
        int who;
        
        public Activity(int idx, int S, int E) {
            this.idx = idx;
            this.S = S;
            this.E = E;
            this.who = -1;
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