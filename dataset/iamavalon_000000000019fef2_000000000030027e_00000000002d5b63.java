import java.io.*;
import java.util.*;

import org.xml.sax.HandlerBase;
 
public class Solution {
    
    long MAX = 1000000000L;
    
    private void solve() throws Exception {
        int T = nextInt();
        long A = nextInt();
        long B = nextInt();
        for(int tt = 1; tt <= T; tt++) {
            bad = false;
            doit();
            if(bad)return;
        }
    }
    
    void doit() throws IOException {
        end = false;
        for(long x = -MAX+MAX/4L; x < MAX; x+=MAX/4L) {
            for(long y = -MAX+MAX/4L; y < MAX; y+=MAX/4L) {
                String ans = test(x, y);
                if(end || bad) return;
                if(ans.equals("HIT")) {
                    //up
                    long Rup = MAX+1;
                    long Lup = y;
                    while(Lup < Rup-1) {
                        long mid = (Lup+Rup)/2;
                        ans = test(x,mid); 
                        if(end || bad) return;
                        if(ans.equals("HIT")) Lup = mid;
                        else Rup = mid;
                    }
                    
                    //down                    
                    long Rdown = y;
                    long Ldown = -MAX-1;
                    while(Ldown < Rdown-1) {
                        long mid = (Ldown+Rdown)/2;
                        ans = test(x,mid); 
                        if(end || bad) return;
                        if(ans.equals("HIT")) Rdown = mid;
                        else Ldown = mid;
                    }
                    if(end) break;
                    if(bad) return;
                    
                    
                  //right
                    long Rright = MAX+1;
                    long Lright = x;
                    while(Lright < Rright-1) {
                        long mid = (Lright+Rright)/2;
                        ans = test(mid,y); 
                        if(end || bad) return;
                        if(ans.equals("HIT")) Lright = mid;
                        else Rright = mid;
                    }
                    //left                    
                    long Rleft = x;
                    long Lleft = -MAX-1;
                    while(Lleft < Rleft-1) {
                        long mid = (Lleft+Rleft)/2;
                        ans = test(mid,y); 
                        if(end || bad) return;
                        if(ans.equals("HIT")) Rleft = mid;
                        else Lleft = mid;
                    }
                    
                    
                    long X = (Lright+Rleft)/2;
                    long Y = (Lup+Rdown)/2;
                    
                    ans = test(X,Y);
                    if(end || bad) return;
                    
                } else if(ans.equals("MISS")) continue;
            }
        }
    }
    
    
    boolean end;
    boolean bad;
    
    String test(long X, long Y) throws IOException {
        System.out.println(X);
        System.out.println(Y);
        String ans = nextToken();
        if(ans.equals("CENTER")) end = true;
        else if(ans.equals("WRONG")) bad = true;
        return nextToken();
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
