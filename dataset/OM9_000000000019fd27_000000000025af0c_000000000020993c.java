import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        FastReader s=new FastReader();
        int testCases = s.nextInt();
        for(int test = 1 ; test <= testCases ; test++) {
            int N = s.nextInt();
            List<String> input = new ArrayList<>();
            for(int k=0;k<N;k++){
                input.addAll(Arrays.asList(s.nextLine().split(" ")));
            }

            int trace = 0;
            int rowCount = -1;
            int duplicateRows = -1;
            int duplicateCols = 0;
            Set<String> duplicateRow = new HashSet<>();
            Map<Integer, Set<String>> duplicateCol = new HashMap<>();
            for (int i = 0; i < N * N; i++) {
                if (i % N == 0) {
                    if (duplicateRow.size() < N) {
                        duplicateRows++;
                    }
                    duplicateRow.clear();
                    rowCount++;
                }
                duplicateRow.add(input.get(i));
                if (i % N == rowCount) {
                    trace += Integer.parseInt(input.get(i));
                }
                if (duplicateCol.get(i % N) == null) {
                    Set<String> newColSet = new HashSet<>();
                    duplicateCol.put(i % N, newColSet);
                }
                duplicateCol.get(i % N).add(input.get(i));
            }

            duplicateRows = (duplicateRow.size() < N) ? duplicateRows + 1 : duplicateRows;
            duplicateCols = (int) duplicateCol.keySet().stream().filter(duplicateColId -> duplicateCol.get(duplicateColId).size() < N).count();
            System.out.println("Case #"+test+": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
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
