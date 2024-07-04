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
            c.trace=s.nextInt();
            c.mat=new int[n][n];

            boolean ans=c.recur();
            if (!ans){
                System.out.println("Case #"+t+": "+"IMPOSSIBLE");
            }
            else{
                System.out.println("Case #"+t+": "+"POSSIBLE");
                for (int[] row:c.mat){
                    for (int a:row){
                        System.out.print(a+" ");
                    }
                    System.out.println();
                }
            }
        }
    }

    private int[][] mat;
    private int trace;

    boolean isValid(int r, int c, int val){
        int n=mat.length;
        for (int i=0;i<n;i++){
            if (mat[r][i] == val){
                return false;
            }
        }

        for (int i=0;i<n;i++){
            if (mat[i][c] == val){
                return false;
            }
        }

        return true;
    }
    
    boolean found(){
        int n=mat.length;
        int t=0;
        for (int i=0;i<n;i++){
            t+=mat[i][i];
        }

        return t == trace;
    }

    boolean recur(){
        int n=mat.length;

        int r=-1, c=-1;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (mat[i][j] == 0){
                    r=i;
                    c=j;
                    break;
                }
            }
        }

        if (r == -1){
            return found();
        }

        for (int i=1;i<=n;i++){
            if (isValid(r, c, i)){
                mat[r][c]=i;
                if (!recur()){
                    mat[r][c]=0;
                }
                else return true;
            }
        }

        return false;
    }
}
