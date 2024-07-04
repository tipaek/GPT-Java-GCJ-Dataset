import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws NumberFormatException,
            IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T, t = 1, i, j, N, ROW, COL, DIG;
        String [] vals;
        Set<Integer> matrix[];
        T = Integer.parseInt(br.readLine());
        while (t <= T) {
            N = Integer.parseInt(br.readLine());
            matrix = new HashSet[N * N];
            for(i=0; i<N; i++) {
            		matrix[i] = new HashSet();
                matrix[N + i] = new HashSet();
            }
            ROW = COL = DIG = 0;
            for(i=0; i<N; i++) {
                vals = br.readLine().split(" ");
                
                for(j=0; j<N; j++){
                    matrix[i].add(Integer.parseInt(vals[j]));
                    matrix[N + j].add(Integer.parseInt(vals[j]));
                    if ( i == j) {
                        DIG += Integer.parseInt(vals[j]);
                    }
                }
            }
            int SUM = N * (N + 1) / 2;
            for(i = 0; i< N; i++) {
                if (matrix[i].size() != N) ROW++;
                if (matrix[N + i].size() != N) COL++;
            }
            System.out.println(String.format("Case #%d: %d %d %d", t, DIG, ROW, COL));
            t++;
        }
    }
}