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
            c.nestDepth(t, s.nextLine().trim());
        }
    }

    void nestDepth(int t, String s){
        int n=s.length();
        StringBuilder sb=new StringBuilder();

        sb.append(paren(Character.getNumericValue(s.charAt(0))));
        for (int i=0;i<n-1;i++){
            int a=Character.getNumericValue(s.charAt(i));
            int b=Character.getNumericValue(s.charAt(i+1));
            sb.append(s.charAt(i));
            sb.append(paren(b-a));
        }
        sb.append(s.charAt(n-1));
        sb.append(paren(-1*Character.getNumericValue(s.charAt(n-1))));

        System.out.println("Case #"+t+": "+sb.toString());
    }

    String paren(int n){
        StringBuilder sb=new StringBuilder();
        if (n<0){
            n=-n;
            while (n-->0){
                sb.append(")");
            }
        }
        else {
            while (n-->0){
                sb.append("(");
            }
        }
        return sb.toString();
    }
}
