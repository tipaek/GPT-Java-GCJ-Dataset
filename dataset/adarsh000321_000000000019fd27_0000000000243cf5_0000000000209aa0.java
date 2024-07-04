import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        StringBuilder ans = new StringBuilder();
        for (int tst = 1; tst <= t; tst++) {
            StringBuilder sb=new StringBuilder();
            int n=sc.nextInt();
            int k=sc.nextInt();
            sb.append("Case #"+tst+": ");
            if (k%n!=0)sb.append("IMPOSSIBLE");
            else {
                sb.append("POSSIBLE\n");
                int arr[][]=new int[n][n];
                for (int i=0;i<n;i++){
                    for (int j=0;j<n;j++){
                        arr[i][i]=k/n;
                    }
                }
                for (int i=0;i<n;i++){
                    int c=0;
                    for (int j=(i+1)%n;j!=i;j=(j+1)%n){
                        c++;
                        if (c==k/n)c++;
                        arr[i][j]=c;
                    }
                }
                for (int i=0;i<n;i++){
                    for (int j=0;j<n;j++)sb.append(arr[i][j]+" ");
                    sb.append("\n");
                }

            }
            System.out.print(sb);

        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
}