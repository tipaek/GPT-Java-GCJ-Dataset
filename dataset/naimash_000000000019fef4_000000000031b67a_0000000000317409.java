import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        final FastScanner s = new FastScanner();
        int T = s.nextInt();

        for (int t = 1; t <= T; t++) {
            System.out.println("Case #" + t + ": " + solve(s));
        }
    }

    static String solve(FastScanner s) {
        int X = s.nextInt();
        int Y = s.nextInt();
        char[] arr = s.nextToken().toCharArray();

        Integer ans = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            final char ch = arr[i];
            switch (ch) {
                case 'N':
                    ++Y;
                    break;
                case 'S':
                    --Y;
                    break;
                case 'E':
                    ++X;
                    break;
                case 'W':
                    --X;
                    break;
            }
            int t = i + 1;
            int move = Math.abs(X) + Math.abs(Y);
            if(t >= move) {
                ans = Math.min(ans, t);
            }

        }
        return ans == Integer.MAX_VALUE ? "IMPOSSIBLE" : String.valueOf(ans);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(){
            init();
        }

        public FastScanner(String name) {
            if("naik".equalsIgnoreCase(System.getenv("USER"))){
                init(name);
            } else {
                init();
            }
        }

        public FastScanner(boolean isOnlineJudge){
            if(!isOnlineJudge || System.getProperty("ONLINE_JUDGE") != null){
                init();
            } else {
                init("input.txt");
            }
        }

        private void init(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private void init(String name){
            try {
                br = new BufferedReader(new FileReader(name));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public String nextToken(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(nextToken());
        }

        public long nextLong(){
            return Long.parseLong(nextToken());
        }

        public double nextDouble(){
            return Double.parseDouble(nextToken());
        }

    }
}
