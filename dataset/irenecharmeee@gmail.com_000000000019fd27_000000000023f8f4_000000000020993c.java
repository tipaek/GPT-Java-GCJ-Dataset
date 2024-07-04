import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class p1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int T = Integer.parseInt(input);
        for (int i = 0; i < T; i++){
            int N = Integer.parseInt(reader.readLine());
            int rr = 0, cr = 0;
            int a[][] = new int[N][N];
            for (int j = 0; j < N; j++) {
                input = reader.readLine();
                StringTokenizer st = new StringTokenizer(input);
                int k = 0;
                while (st.hasMoreTokens()){
                    a[j][k++] = Integer.parseInt(st.nextToken());
                }

            }
            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2;
            for(int l = 0; l < a.length;l++){
                set1 = new HashSet<>();
                set2 = new HashSet<>();
                boolean rowDup = false;
                boolean colDup = false;
                for(int m = 0; m < a.length;m++){
                    if (!rowDup && set1.add(a[l][m]) == false){
                        rowDup = true;
                    }
                    if (!colDup && set2.add(a[m][l]) == false) {
                        colDup = true;
                    }
                }
                if (colDup) {
                    cr++;
                }
                if (rowDup) {
                    rr++;
                }

            }
            int diag = getD(a);
            System.out.println("Case #" + (i + 1) + ": " + diag + " " + rr +" " + cr);

        }
    }


    private static int getD(int[][] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++){
            sum += a[i][i];
        }
        return sum;
    }
}
