import java.io.*;
import java.util.*;
import java.util.zip.Adler32;

public class Solution {
    static int[]get(int i,int j,int[][]a){
        int[] ret = new int[4];
        for (int k =i+1;k<a.length;k++){
            if (a[k][j]!=0){
                ret[0]=a[k][j];
                break;
            }
        }
        for (int k =j+1;k<a[0].length;k++){
            if (a[i][k]!=0){
                ret[1]=a[i][k];
                break;
            }
        }for (int k =i-1;k>=0;k--){
            if (a[k][j]!=0){
                ret[2]=a[k][j];
                break;
            }
        }for (int k =j-1;k>=0;k--){
            if (a[i][k]!=0){
                ret[3]=a[i][k];
                break;
            }
        }
        return ret;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t =sc.nextInt();
        for (int k=1;k<=t;k++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][]a = new int[n][m];
            long sum =0;
            for (int i =0;i<n;i++){
                for (int j =0;j<m;j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            boolean change =true;
            while (change) {
                change=false;
                int[][]nxt = new int[n][m];
                for (int i = 0; i < n; i++){
                    for (int j =0;j<m;j++){
                        if (a[i][j]==0)
                            continue;
                        sum+=a[i][j];
                        int[]ne= get(i,j,a);
                        int c =0;
                        int s=0;
                        for (int x:ne){
                            s+=x;
                            if (x!=0)
                                c++;
                        }
                        if (c==0)
                            continue;

                        if (a[i][j]*c<s){
                            nxt[i][j]=0;
                            change=true;
                        }
                        else nxt[i][j]=a[i][j];
                    }
                }
                a=nxt;
                if (!change)
                    break;
            }
            pw.println("Case #"+k +": "+sum);
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