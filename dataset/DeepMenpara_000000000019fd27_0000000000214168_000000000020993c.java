import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


 class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int testcase = sc.nextInt();
        for(int test = 0; test < testcase; test++){
            int n = sc.nextInt();
            int[][] mat = new int[n][n];
            int[] temp = new int[n];
            int[] trial = new int[n];
            int sum = 0;
            int unirow = 0;
            int unicol = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    mat[i][j] = sc.nextInt();
                    temp[j] = mat[j][i];
                    if(i == j){
                        sum += mat[i][j];
                    }
                }
                if(unique(mat[i])){
                    unirow++;
                }
            }
            for(int j = 0; j < n; j++){
                for(int i = 0; i < n; i++){
                    temp[i] = mat[i][j];
                }
                if(unique(temp)){
                    unicol++;
                }
            }
            System.out.println("Case #"+(test+1)+": "+sum+" "+unirow+" "+unicol);
        }
    }


    private static boolean unique(int[] inp) {
        HashSet<Integer> set = new HashSet<Integer>();
        boolean flag = false;
        for (int element : inp)
        {
            if( ! set.add(element))
            {
                flag = true;
                break;
            }
        }
        return flag;
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
                catch (IOException e)
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