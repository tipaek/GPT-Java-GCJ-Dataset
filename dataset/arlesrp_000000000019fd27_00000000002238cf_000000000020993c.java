
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Arles
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int cases = 1;
        while (cases <= T) {
            int N = Integer.parseInt(br.readLine());
            int[][] M = new int[N][N];

            int sumdiag = 0;

            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    M[i][j] = Integer.parseInt(line[j]);
                    if (i == j) {
                        sumdiag += M[i][j];
                    }
                }
            }

            int countF = 0;
            for (int fil = 0; fil < N; fil++) {
                int[] cFil = new int[N+1];
                for (int col = 0; col < N; col++) {
                    if (cFil[M[fil][col]] == 0) {
                        cFil[M[fil][col]] = 1;
                    }else{
                        countF++;
                        break;
                    }
                }
            }

            
            int countC = 0;
            for (int col = 0; col < N; col++) {
                int[] cCol = new int[N+1];
                for (int fil = 0; fil < N; fil++) {
                    if (cCol[M[fil][col]] == 0) {
                        cCol[M[fil][col]] = 1;
                    }else{
                        countC++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + cases + ": " + sumdiag + " " + countF + " " + countC);
            cases++;
        }

    }

}
