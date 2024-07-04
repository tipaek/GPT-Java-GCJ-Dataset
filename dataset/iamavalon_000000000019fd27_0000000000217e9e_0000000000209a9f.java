import java.io.*;
import java.util.*;
 
public class Solution {
    
 
    private void solve() throws Exception {
        int T = nextInt();
        for(int tt = 1; tt <= T; tt++) {
            StringBuilder s = new StringBuilder(nextToken());
            for(int d = 1; d <= 9; d++) {
                int n = s.length();
                for(int i = n-1; i >= 0; i--) {
                    int r = i;
                    while(i >= 0 && s.charAt(i)-'0' >= d) {
                        i--;
                    }
                    int l = i;
                    if(l < r) {
                        s.insert(r+1, ')');
                        s.insert(l+1, '(');
                    }
                }
            }
            out.println("Case #" + tt + ": " + s.toString());
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