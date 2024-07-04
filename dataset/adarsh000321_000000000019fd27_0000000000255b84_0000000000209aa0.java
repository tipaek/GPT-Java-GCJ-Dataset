
import java.awt.*;
import java.io.*;
import java.util.*;

public class Solution {
    static int n,k;
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        for (int tst = 1; tst <= t; tst++) {
            StringBuilder sb = new StringBuilder();
            sb.append("Case #" + tst + ": ");
            n=sc.nextInt();k=sc.nextInt();
            arr=new int[n][n];
            if (dfs(0,0)){
                sb.append("POSSIBLE\n");
                for (int i=0;i<n;i++){
                    for (int j=0;j<n;j++){
                        sb.append(arr[i][j]+" ");
                    }
                    sb.append("\n");
                }
            }else sb.append("IMPOSSIBLE\n");
            System.out.print(sb);
        }
    }
    static int arr[][];
    static boolean ok(){
        int sum=0;
        for (int i=0;i<n;i++){
            boolean done[]=new boolean[n+1];
            for (int j=0;j<n;j++){
                if (i==j)sum+=arr[i][j];
                if (done[arr[i][j]])return false;
                done[arr[i][j]]=true;
            }
        }
        for (int i=0;i<n;i++){
            boolean done[]=new boolean[n+1];
            for (int j=0;j<n;j++){
                if (done[arr[j][i]])return false;
                done[arr[j][i]]=true;
            }
        }
        return sum==k;
    }
    static boolean dfs(int i,int j){
        if (i==n-1 && j==n-1){
            for (int l=1;l<=n;l++){
                arr[i][j]=l;
                if (ok())return true;
            }
            return false;
        }
        for (int a=1;a<=n;a++){
            arr[i][j]=a;
            if (j==n-1){
                if (dfs(i+1,0))return true;
            }else if (dfs(i,j+1))return true;
        }
        return false;
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