
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javafx.util.Pair;

public class Expert {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = in.nextInt();
            int[][] z = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    z[i][j] = in.nextInt();
                }
            }
            int r = 0;
            int k = 0;
            int c = 0;
            int idx = 0;
            for (int i = 0; i < n; i++) {
                k += z[i][idx++];
            }
            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet<Integer>();
                for (int j = 0; j < n; j++) {
                    set.add(z[i][j]);
                }
                if (set.size() != n) {
                    r++;
                }
            }
            for (int cl = 0; cl < n; cl++) {
                HashSet<Integer> set = new HashSet<Integer>();
                for (int row = 0; row < n; row++) {
                    set.add(z[row][cl]);
                }
                if (set.size() != n) {
                    c++;
                }
            }
            System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
        }
    }

}
