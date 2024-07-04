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

    public static void main(String[] args) {
        FastReader s = new FastReader();
        Solution c=new Solution();
        int T=s.nextInt();
        for (int t=1;t<=T;t++){
            int n=s.nextInt();
            c.mat=new int[n][n];
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    c.mat[i][j]=s.nextInt();
                }
            }

            c.latinMat(t, n);
        }
    }

    private int[][] mat;
    void latinMat(int t, int n){
        Set<Integer> set;

        int trace=0;
        for (int i=0;i<n;i++){
            trace+=mat[i][i];
        }

        int rr=0;
        for (int i=0;i<n;i++){
            set=new HashSet<>();
            for (int j=0;j<n;j++){
                if (set.contains(mat[i][j])){
                    rr++;
                    break;
                }
                set.add(mat[i][j]);
            }
        }

        int cr=0;
        for (int i=0;i<n;i++){
            set=new HashSet<>();
            for (int j=0;j<n;j++){
                if (set.contains(mat[j][i])){
                    cr++;
                    break;
                }
                set.add(mat[j][i]);
            }
        }

        System.out.println("Case #"+t+": "+trace+" "+rr+" "+cr);
    }
}
