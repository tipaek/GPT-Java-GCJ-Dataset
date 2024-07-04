import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class Task {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.write("Case #"+testNumber+": ");

        int N = in.nextInt();
        int[][] a = new int[N][N];

        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                a[i][j] = in.nextInt();
            }
        }

        int k = 0;
        for (int i=0;i<N;i++) k+=a[i][i];

        int r = 0, c = 0;

        int[] found = new int[N];

        cycle:for (int i=0;i<N;i++) {
            Arrays.fill(found, 0);
            for (int j=0;j<N;j++){
                if (found[a[i][j]-1] > 0) {
                    r++;
                    continue cycle;
                }
                found[a[i][j]-1]++;
            }
        }

        cycle:for (int i=0;i<N;i++) {
            Arrays.fill(found, 0);
            for (int j=0;j<N;j++){
                if (found[a[j][i]-1] > 0) {
                    c++;
                    continue cycle;
                }
                found[a[j][i]-1]++;
            }
        }

        out.write(k+" "+r+" "+c+"\n");
    }
}
