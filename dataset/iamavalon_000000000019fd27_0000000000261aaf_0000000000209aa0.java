import java.io.*;
import java.util.*;
 
public class Solution {
    
 
    private void solve() throws Exception {
        int T = nextInt();
        for(tt = 1; tt <= T; tt++) {
            N = nextInt();
            K = nextInt();
            //sums = new TreeSet<Integer>();
            finished = false;
            doit(1,0,new boolean[N+1][N], new int[N][N]);
      //      for(int x : sums) System.out.println(x);
            if(!finished) System.out.println("Case #" + tt + ": IMPOSSIBLE");
        }
    }
    
    //TreeSet<Integer> sums;
    
    int N;
    int K;
    boolean finished;
    int tt;
    
    void doit(int idx, int row, boolean[][] P, int[][] state) {
        if(finished) return;
        if(idx == N+1) {
            int sum = 0;
            for(int i = 0; i < N; i++) {
                sum += state[i][i];
//                for(int j = 0; j < N; j++) {
////                    System.out.print(state[i][j] + " ");
//                }
//                System.out.println();
            }
            if(sum == K) {
                System.out.println("Case #" + tt + ": POSSIBLE");
                for(int i = 0; i < N; i++) {
                    for(int j = 0; j < N; j++) {
                        System.out.print(state[i][j] + " ");
                    }
                    System.out.println();
                }
                finished = true;
            }
        //    sums.add(sum);
//            System.out.println(sum);
//            System.out.println();
        } else if(row == N){
            doit(idx+1, 0, P, state);
        } else {
            for(int i = 0; i < N; i++) {
                if(state[row][i] == 0 && !P[idx][i]) {
                    P[idx][i] = true;
                    state[row][i] = idx;
                    doit(idx, row+1, P, state);
                    P[idx][i] = false;
                    state[row][i] = 0;
                }
            }
        }
    }
    
//    char[] ans;
//    int count = 0;
//    
//    int testPos = -1;
//    
//    
    
    
    
    
    
    
    char receiveValue() throws IOException {
        return (char)(nextInt()+'0');
        
        
        
        
//        return ans[testPos-1];
    }
    
    int query;
    void askForValueAtIndex(int i) {
        
        
        
        
        
        
        
//        if(count%10 == 0) {
//            double rnd = Math.random();
//            if(rnd <= .25) {
//                invert();
//            }else if(rnd <= .5) {
//                complement();
//            }else if(rnd <= .75) {
//                invert();
//                complement();
//            }
//        }
//        count++;
//        testPos = i+1;
//        
//        
        
        System.out.println(i+1);
        
        
        
        
        query++;
    }
    
//    void invert() {
//        char[] other = new char[ans.length];
//        for(int i = 0; i < ans.length; i++) {
//            other[i] = ans[ans.length-1-i];
//        }
//        ans =  other;
//    }
//    
//    void complement() {
//        for(int i = 0; i < ans.length; i++) {
//            ans[i] = (char)(1-ans[i]+'0'+'0') ;
//        }
//    }
//    
    
    char[] res;
    int[] equals;
    
    void change(int type) {
        for(int i = 0; i < res.length; i++) if(equals[i] == type) res[i] = (char)(1-res[i]+'0'+'0');
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