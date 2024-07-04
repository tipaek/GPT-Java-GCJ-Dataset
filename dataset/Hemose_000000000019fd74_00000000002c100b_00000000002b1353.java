import java.io.*;
import java.util.*;
import java.util.zip.Adler32;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t =sc.nextInt();
        for (int k=1;k<=t;k++){
            int n = sc.nextInt();
            HashSet<Integer>taken = new HashSet<>();
            int max=1;
            boolean found=false;
            for (int b =30;b>0;b--){
                if (!found&&n-(1<<b)-b>=0){
                    max=b+1;
                    taken.add(b+1);
                    n-=b;
                    n-=1<<b;
                    found=true;
                }
                else if (found&&n-(1<<b)+1>=0){
                    taken.add(b+1);
                    n-=1<<b;
                    n++;
                }
            }
            pw.println("Case #"+k+":");
            pw.println(1+" "+1);
            if (max==1)
                n--;
            int i =2;
            int cure=1;
            while (i<=max){
                if (cure==1){
                    pw.println(i+" "+1);
                }
                else pw.println(i+" "+i);
                if (taken.contains(i)){
                    if (cure==1){
                        cure=0;
                        for (int j =2;j<=i;j++)
                            pw.println(i+" "+j);
                    }
                    else {
                        cure=1;
                        for (int j =i-1;j>=1;j--)
                            pw.println(i+" "+j);
                    }
                }
                i++;
            }
            while (n>0){
                if (cure==0)
                    pw.println(i+" "+i);
                else pw.println(i+" "+1);
                i++;
                n--;
            }
        }
        pw.flush();
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }

}