import java.util.*;
import java.io.*;
public class Solution{
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }
        public FastReader(File file) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(file));
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
    public static void main(String[]abc){
        FastReader in=new FastReader();
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        int t=in.nextInt(),Case=1;
        while(t-->0){
            String s=in.nextLine(),ans="";
            int previous=0,n=s.length();
            for(int i=0;i<n;i++){
                int diff=s.charAt(i)-'0'-previous;
                previous+=diff;
                while(diff!=0){
                    if(diff<0){
                        ans+=')';
                        diff++;
                    }else{
                        ans+='(';
                        diff--;
                    }
                }
                ans+=s.charAt(i);
            }
            while(previous!=0){
                ans+=')';
                previous--;
            }
            out.println("Case #"+(Case++)+": "+ans);
        }
        out.flush();
    }
}