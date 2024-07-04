import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        int C = 1;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(in.readLine());
            int[][] m = new int[N][N];
            for (int i = 0; i < N; ++i) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; ++j) {
                    m[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int sum = 0;
            for (int i = 0; i < N; ++i)
                sum += m[i][i];

            int colsR = 0;
            int rowsR = 0;
            for (int i = 0; i < N; ++i) {
                Set<Integer> s = new TreeSet<>();
                for(int j=0;j<N;++j){
                    s.add(m[i][j]);
                }
                if(s.size() != N)
                    rowsR++;

                s = new TreeSet<>();
                for(int j=0;j<N;++j){
                    s.add(m[j][i]);
                }
                if(s.size() != N){
                    colsR++;
                }
            }
            sb.append("Case #" + (C++) + ": " + sum + " " + rowsR + " " + colsR + "\n");
        }
        System.out.print(new String(sb));

    }
}
