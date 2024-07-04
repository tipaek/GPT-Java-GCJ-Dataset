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
            int N;

        for (int i = 1; i <= T; i++) {
            N = fr.nextInt();
            int [][]mat = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    mat[j][k] = fr.nextInt();
                }
            }
            solve(mat,N,i);
        }
    }

    static void solve(int mat[][], int N, int T){
        int k=0,r=0,c=0;
        ArrayList<HashSet<Integer>> row = new ArrayList<HashSet<Integer>>();
        ArrayList<HashSet<Integer>> column = new ArrayList<HashSet<Integer>>();
        for (int i = 0; i < N; i++) {
            row.add(new HashSet<Integer>());
            column.add(new HashSet<Integer>());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                row.get(i).add(mat[i][j]);
                column.get(j).add(mat[i][j]);
                if(i==j){
                    k+=mat[i][j];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if(row.get(i).size()!=N){
                r++;
            }
            if(column.get(i).size()!=N){
                c++;
            }
        }
        
        System.out.println("Case #"+T+": "+k+" "+r+" "+c);
    }
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

