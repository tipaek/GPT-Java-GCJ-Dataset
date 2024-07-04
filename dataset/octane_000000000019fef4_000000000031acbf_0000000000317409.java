import java.io.*;
import java.util.*;

public class Solution{

    public static void main(String[] args) throws FileNotFoundException {
        FastReader in=new FastReader();
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        int mod=(int)Math.pow(10,9)+7;
        int t=in.nextInt(),Case=1;
        while(t-->0){
            String temp[]=in.nextLine().split(" ");
            int x=Integer.parseInt(temp[0]),y=Integer.parseInt(temp[1]);
            String s=temp[2];
            int n=s.length(),min=n+1;
            for(int i=0;i<n;i++){
                switch (s.charAt(i)){
                    case 'S':
                        y--;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
                if(i+1>=(Math.abs(x)+Math.abs(y)))
                {   min=i+1;
                    break;
                }
            }
            out.println("Case #"+(Case++)+": "+(min>n?"IMPOSSIBLE":min));
        }
        out.flush();

    }

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
}