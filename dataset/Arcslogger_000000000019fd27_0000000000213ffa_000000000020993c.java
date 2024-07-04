import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class p1 {

    public static void main(String[] args) {

        FastReader read = new FastReader ();

        int T = read.nextInt();
        for(int i = 0; i < T; i++) {

            int N = read.nextInt();
            int [][] map = new int [N][N];
            
            int rowCount = 0, colCount = 0, trace = 0;;

            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) map[j][k] = read.nextInt();
            }
            
            for(int j = 0; j < N; j++) {
                LinkedList <Integer> rowVals = new LinkedList <Integer> (), colVals = new LinkedList <Integer> ();
                boolean visitedR = false, visitedC = false;
                for(int k = 0; k < N; k++) {
                    if(rowVals.contains(map[j][k]) && !visitedR) {
                        rowCount++; 
                        visitedR = true;
                    }
                    if(colVals.contains(map[k][j]) && !visitedC) {
                        colCount++; 
                        visitedC = true;
                    }
                    rowVals.add(map[j][k]);
                    colVals.add(map[k][j]);
                    if(k == j) trace += map[j][k];
                }
            }

            

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowCount + " " + colCount);

        }
        
    }

    public static class FastReader {
    BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
            String str = null;
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}