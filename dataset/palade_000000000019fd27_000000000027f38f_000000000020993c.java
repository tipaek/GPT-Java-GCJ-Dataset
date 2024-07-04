import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {

    public static String solveMatrix(int[][] m) {
        int t = 0;
        int r = 0;
        int c = 0;

        for (int i = 0; i < m.length; i++) {
            boolean skipR = false;
            boolean skipC = false;
            int[] emr = new int[m.length];
            int[] emc = new int[m.length];
            for (int j = 0; j < m.length; j++) {
                int vr = m[i][j] - 1;
                emr[vr] += 1;
                if (emr[vr] > 1 && !skipR) {
                    r += 1;
                    skipR = true;
                }

                int vc = m[j][i] - 1;
                emc[vc] += 1;
                if (emc[vc] > 1 && !skipC) {
                    c += 1;
                    skipC = true;
                }
            }
            t += m[i][i];
        }

        return t + " " + r + " " + c;
    }

    public static void main(String[] args) {
        
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int tests = in.nextInt();
        for (int t = 1; t <= tests; t++) {
            int mSize = in.nextInt();
            int[][] m = new int[mSize][mSize];
            for (int i = 0; i < mSize; i++) {
                for (int j = 0; j < mSize; j++) {
                    m[i][j] = in.nextInt();
                }
            }
            
            System.out.println("Case #" + t + ": " + solveMatrix(m));        
        }            
    }
}
