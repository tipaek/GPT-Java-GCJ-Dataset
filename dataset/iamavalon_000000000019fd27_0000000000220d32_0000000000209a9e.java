import java.io.*;
import java.util.*;
 
public class Solution {
    
 
    private void solve() throws Exception {
        int T = nextInt();
        int B = nextInt();
        for(int tt = 1; tt <= T; tt++) {
            res = new char[B];
            int equalVerifyIndex = - 1;
            int differentVerifyIndex = - 1;
            int idx = 0;
            equals = new int[B];
            Arrays.fill(equals, -1);
            for(int i = 0; i < 150 && idx < B/2; i++) {
                if(i > 0 && i%10 == 0) {
                    if(equalVerifyIndex >= 0) {
                        askForValueAtIndex(equalVerifyIndex);
                        char val = receiveValue();
                        if(val != res[equalVerifyIndex]) changeEquals();
                    }
                    if(differentVerifyIndex >= 0) {
                        askForValueAtIndex(differentVerifyIndex);
                        char val = receiveValue();
                        if(val != res[differentVerifyIndex]) changeDistinct();
                    }
                }                
                askForValueAtIndex(idx);
                res[idx] = receiveValue();
                askForValueAtIndex(B-idx-1);
                res[B-idx] = receiveValue();
                if(res[idx] == res[B-idx-1]) {
                    equals[idx] = 1;
                    equals[B-idx-1] = 1;
                    if(equalVerifyIndex < 0) equalVerifyIndex = idx;
                } else {
                    equals[idx] = 0;
                    equals[B-idx-1] = 0;
                    if(differentVerifyIndex < 0) differentVerifyIndex = idx;
                }
                idx++;
            }
            System.out.println(new String(res));
            if(nextToken().equals("N")) return;
            
        }
    }
    
    char receiveValue() throws IOException {
        return (char)(nextInt()+'0');
    }
    
    void askForValueAtIndex(int i) {
        System.out.println(i+1);
    }
    
    char[] res;
    int[] equals;
    
    void changeDistinct() {
        char[] other = new char[res.length];
        for(int i = 0; i < res.length; i++) {
            if(equals[i] == 0) other[i] = (char)(1-res[i]+'0'+'0');
        }
        res = other;
    }
    
    void changeEquals() {
        for(int i = 0; i < res.length; i++) {
            if(equals[i] == 1) res[i] = (char)(1-res[i]+'0'+'0');
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