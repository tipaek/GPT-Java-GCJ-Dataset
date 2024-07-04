
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        FastReader fd = new FastReader();
        int t = fd.nextInt();
        for(int test = 0; test < t; test++){
            int n = fd.nextInt();
            int[][] data = new int[n][n];
            int[] temp = new int[n];
            int colInd = 0;
            int sum = 0;
            int row = 0;
            int col = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    data[i][j] = fd.nextInt();
                    temp[j] = data[j][i];
                    if(i == j){
                        sum += data[i][j];
                    }
                }
                if(findDuplicates(data[i]) > 0){
                    row++;
                }
            }
            for(int j = 0; j < n; j++){
                for(int i = 0; i < n; i++){
                    temp[i] = data[i][j];
                }
                if(findDuplicates(temp) > 0){
                    col++;
                }
            }

            System.out.println("Case #"+(test+1)+": "+sum+" "+row+" "+col);
        }
    }

    private static int findDuplicates(int[] inputArray)
    {
        Set<Integer> uniqueElements = new HashSet<>();
        int duplicateCount =  Arrays.stream(inputArray)
                .filter(i -> !uniqueElements.add(i))
                .boxed()
                .collect(Collectors.toSet()).size();
        return duplicateCount;
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
