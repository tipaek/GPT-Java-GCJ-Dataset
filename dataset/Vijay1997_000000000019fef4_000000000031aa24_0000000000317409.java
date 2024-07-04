import java.io.*;
import java.util.*;

public class Solution {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    private static FastReader s;
    public static void main(String[] args) {
        s = new FastReader();
        Solution c=new Solution();

        int T=s.nextInt();
        for (int t=1; t<=T; t++){
            c.solve(t);
        }
    }
    //System.out.println("Case #"+t+": "+ans);

    void solve(int t){
        String[] xystr = s.nextLine().trim().split(" ");
        int x = Integer.parseInt(xystr[0]);
        int y = Integer.parseInt(xystr[1]);
        String dir = xystr[2];

        int ans = 10000;
        int time = 1;
        int currTime;
        for (char c : dir.toCharArray()){
            if (c == 'N'){
                y++;
            }
            if (c == 'S'){
                y--;
            }
            if (c == 'E'){
                x++;
            }
            if (c == 'W'){
                x--;
            }
            currTime = Math.abs(x) + Math.abs(y);
            if (time >= currTime){
                ans = Math.min(ans,time);
            }
            time ++;
        }

        if (ans == 10000){
            System.out.println("Case #"+t+": "+"IMPOSSIBLE");
        }
        else {
            System.out.println("Case #"+t+": "+ans);
        }
    }
}
