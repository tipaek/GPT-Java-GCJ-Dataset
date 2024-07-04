import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution{
        public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();
        int z = 1;
        while (t-->0){
            int n = input.nextInt();
            int mat[][]=new int[n][n];
            HashSet<Integer> setRow = new HashSet<>();
            HashSet<Integer> setCol = new HashSet<>();
            setRow.clear();setCol.clear();
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    mat[i][j] = input.nextInt();
                }
            }
            int trace = 0;
            int repeatedRow=0;
            int repeatedCol=0;
            for (int i=0;i<n;i++){
               trace+=mat[i][i];
            }

            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    setRow.add(mat[i][j]);
                    setCol.add(mat[j][i]);
                }
                if (setRow.size() != n)repeatedRow++;
                if (setCol.size() != n) repeatedCol++;
                setCol.clear();
                setRow.clear();
            }

            System.out.println("Case #"+z+": "+trace+" "+repeatedRow+" "+repeatedCol);
            z++;
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
    }
}