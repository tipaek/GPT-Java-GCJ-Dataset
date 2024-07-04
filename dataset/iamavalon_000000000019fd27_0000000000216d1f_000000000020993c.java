import java.io.*;
import java.util.*;
 
public class Solution {
    
 
    private void solve() throws Exception {
        int T = nextInt();
        for(int tt = 1; tt <= T; tt++) {
            int N = nextInt();
            int[][] M = new int[N][N];
            for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) M[i][j] = nextInt();
            long trace = 0L;
            for(int i = 0; i < N; i++) trace += M[i][i];
            int r = 0;
            for(int i = 0; i < N; i++) {
                int[] nums = new int[N];
                for(int j = 0; j < N; j++) {
                    nums[M[i][j]-1]++;
                }
                boolean good = true;
                for(int j = 0; j < N; j++) {
                    if(nums[j] > 1) {
                        good = false;
                        break;
                    }
                }
                if(!good) r++;
            }
            int c = 0;
            for(int i = 0; i < N; i++) {
                int[] nums = new int[N];
                for(int j = 0; j < N; j++) {
                    nums[M[j][i]-1]++;
                }
                boolean good = true;
                for(int j = 0; j < N; j++) {
                    if(nums[j] > 1) {
                        good = false;
                        break;
                    }
                }
                if(!good) c++;
            }
            out.println("Case #" + tt + ": " + trace + " " + r + " " +c);
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