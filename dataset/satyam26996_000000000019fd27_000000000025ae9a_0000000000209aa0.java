import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Solution {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int T = fr.nextInt();
        int N,K;

        for (int i = 1; i <= T; i++) {
            N = fr.nextInt();
            K = fr.nextInt();
            solve(N,K,i);
        }
    }

    static void solve(int N,int K, int T){
        if(!isPossible(N,K)){
            System.out.println("Case #"+T+": "+"IMPOSSIBLE");
        } else {
            System.out.println("Case #"+T+": "+"POSSIBLE");
            int mat [][] = fillArray(N,K);
            printMatrix(mat);
        }


    }
    static void printMatrix(int [][]mat){
        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j <mat.length ; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int[][] fillArray(int n,int k){
        int []input = generate(n,k);
        int [][]mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            mat[i][i]=input[i];
        }
        for (int i = 0; i < n; i++) {
            int t=i+1;
            int last=0;
            while(t<n){
                last=mat[i][t-1];
                mat[i][t++]=next(last,n);
            }
            last=mat[i][n-1];
            t=0;
            while(t<i){
                mat[i][t]=next(last,n);
                last=mat[i][t];
                t++;
            }
        }


        return mat;
    }
    static int next(int cur,int n){
        cur++;
        cur=cur%n;
        if(cur==0)
            cur=n;
        return cur;
    }
    static boolean isPossible(int n,int k){
        int sum = (n*(n+1))/2;
        if( k%n==0) {
            if(n==2 && (k!=2 && k!=4))
                return false;

            return true;
        }
        return false;
    }
    static int[] generate(int n,int k){
        int sum = (n*(n+1))/2;
        int []in = new int[n];
        if(k%n==0 ){
            if(k%n==0) {
                for (int i = 0; i < n; i++) {
                    in[i] = k/n;
                }
            } else{
                int q=n;
                for (int i = 0; i < n; i++) {
                    in[i]=q--;
                }
            }
        }
        return in;
       /* int []in = new int[n];
        int i=1;
        while(n*i<=k){
            i++;
        }
        i-=1;
        for (int j = 0; j <n ; j++) {
            in[j]=i;
        }
        int diff=k-(n*i);
        for (int j = 0; j <diff ; j++) {
            in[j]++;
        }
        return in;
*/    }
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}



