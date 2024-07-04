import java.io.*;
import java.util.*;

public class Solution{

    public static void main(String[] args) {
        FastReader in = new FastReader();

        int t = in.nextInt();
        int tt = 1;
        while(tt <= t){
            int n = in.nextInt();
            int mat[][] = new int[n][n];

            for(int i = 0; i < n; ++i){
                for(int j = 0; j < n; ++j)
                    mat[i][j] = in.nextInt();
            }

            int trace  = 0;
            for(int i = 0; i < n; ++i){
                trace  += mat[i][i];
            }

            int dupRows = 0, dupCols = 0;
            for(int i = 0; i < n; ++i){
                Set<Integer> set = new HashSet<Integer>();
                for(int j = 0; j < n; ++j){
                    if(!set.add(mat[i][j])){
                        ++dupRows;
                        break;
                    }                        
                }
            }

            for(int j = 0; j < n; ++j){
                Set<Integer> set = new HashSet<Integer>();
                for(int i = 0; i < n; ++i){
                    if(!set.add(mat[i][j])){
                        ++dupCols;
                        break;
                    }                        
                }
            }

            System.out.println("Case #" +tt++ +": "+ trace +" " + dupRows +" " + dupCols);


        }

    }


}


class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                String s = br.readLine();
                if (s == null || s.length() == 0)
                    return null;
                st = new StringTokenizer(s);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        // return Integer.parseInt(next());
        String s = next();
        // System.out.println("inputed s ::" + s);
        if (s == null)
            return -1;
        else
            return Integer.parseInt(s);

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
            if (str == null || str.length() == 0)
                return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}