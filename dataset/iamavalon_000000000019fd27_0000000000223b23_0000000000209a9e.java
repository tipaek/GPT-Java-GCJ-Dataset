import java.io.*;
import java.util.*;
 
public class Solution {
    
 
    private void solve() throws Exception {
        int T = nextInt();
        int B = nextInt();
        for(int tt = 1; tt <= T; tt++) {
            
            
            
            
            
            
//            ans = new char[B];
//            for(int i = 0; i < B; i++) {
//                ans[i] = Math.random()<.5?'0':'1';
//            }
//            count = 0;
//            testPos = 0;
            
            
            
            
            
            
            
            
            res = new char[B];
            int equalVerifyIndex = - 1;
            int differentVerifyIndex = - 1;
            int idx = 0;
            equals = new int[B];
            Arrays.fill(equals, -1);
            query = 0;
            for(; query < 150 && idx < B/2; ) {
                if(query%10 == 0) {
                    if(equalVerifyIndex >= 0) {
                        askForValueAtIndex(equalVerifyIndex);
                        char val = receiveValue();
                        if(val != res[equalVerifyIndex]) change(1);
                    } else {
                        askForValueAtIndex(0);
                        receiveValue();
                    }
                    if(differentVerifyIndex >= 0) {
                        askForValueAtIndex(differentVerifyIndex);
                        char val = receiveValue();
                        if(val != res[differentVerifyIndex]) change(0);
                    } else {
                        askForValueAtIndex(0);
                        receiveValue();
                    }
                }                
                askForValueAtIndex(idx);
                res[idx] = receiveValue();
                askForValueAtIndex(B-idx-1);
                res[B-idx-1] = receiveValue();
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
//            System.out.println(new String(ans));
            if(nextToken().equals("N")) return;
            
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