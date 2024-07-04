import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

class Solution {
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
    public static void main(String[] args) {

        FastReader fr = new FastReader();
        int tCase=fr.nextInt();
        for(int t=1;t<=tCase;t++){
            int n = fr.nextInt();
            int[][] arr = new int[n][n];

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=fr.nextInt();
                }
            }

            int trace = 0;
            int numOfColums = 0;
            int numOfRows = 0;

            HashSet<Integer> rowDuplicates = new HashSet<>();
            HashSet<Integer> colDuplicates = new HashSet<>();


            boolean row = false;
            boolean col = false;

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j){ //calculating trace
                        trace+=arr[i][j];
                    }

                    if(rowDuplicates.contains(arr[i][j]) && !row){
                        row=true;
                        numOfRows++;
                    }
                    rowDuplicates.add(arr[i][j]);
                    if(colDuplicates.contains(arr[j][i]) && !col){
                        col=true;
                        //System.out.println(arr[j][i]);
                        numOfColums++;
                    }
                    colDuplicates.add(arr[j][i]);
                }
                rowDuplicates.clear();
                colDuplicates.clear();

                row=false;
                col=false;
            }



            System.out.println("Case #"+t+": "+trace+" "+numOfRows+" "+numOfColums);

        }

    }
}
