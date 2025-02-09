import java.io.*;
import java.util.*;

class Solution{

    public static void main(String args[]) {

        FastReader sc = new FastReader();

        int t = sc.nextInt();

        for(int i=1;i<=t;i++)
        {
            solve(sc,i);
        }

    }


    static void solve(FastReader sc, int testcase)
    {
        int n = sc.nextInt();
        int arrayone[][] = new int[n][n];

        int k = sc.nextInt();

        if(Calculate(arrayone,n,k))
        {
            System.out.println("Case #"+testcase+": POSSIBLE");
            Output(arrayone);
        }
        else
        {
            System.out.println("Case #"+testcase+": IMPOSSIBLE");

        }

    }

    static void Output(int arrayone[][])
    {
        for(int i[]:arrayone)
        {
            for(int j:i)
                System.out.print(j+" ");
            System.out.println();
        }
    }
    static boolean isPossible(int arrayone[][],int x,int row,int col,int k)
    {
        int sum = x;

        for(int i=0;i<arrayone.length;i++)
        {
            if(arrayone[i][col] ==x || arrayone[row][i]==x)
                return false;
            sum += arrayone[i][i];
        }

        if(row==col && row==arrayone.length-1)
        {
            if(sum!=k)
                return false;
        }
        if(row==col && sum>k)
            return false;

        return true;
    }

    static boolean Calculate(int arrayone[][],int n,int k)
    {
        boolean finished = true;
        int row = -1, col = -1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arrayone[i][j]==0)
                {
                    row = i;
                    col = j;
                    finished = false;
                    break;
                }
            }
            if(!finished)
                break;
        }
        if(finished)
            return true;

        for(int i=1;i<=n;i++)
        {
            if(isPossible(arrayone,i,row,col,k))
            {
                arrayone[row][col] = i;
                if(Calculate(arrayone,n,k))
                {
                    return true;
                }
                else
                {
                    arrayone[row][col] = 0;
                }
            }
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
