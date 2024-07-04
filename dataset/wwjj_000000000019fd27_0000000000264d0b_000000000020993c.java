import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF {

    public static void main(String[] args) throws Exception {
        try (BufferedInputStream in = new BufferedInputStream(System.in);
             PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out))) {

            Scanner sc = new Scanner(in);

            int T = sc.nextInt();
            for (int t = 0; t < T; t++) {
                int n = sc.nextInt();
                int[][] m = new int[n][n];

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        m[j][i] = sc.nextInt();
                    }
                }

                int trace = 0;
                for (int i = 0; i < n; i++) trace += m[i][i];

                int r = 0;
                int c = 0;
                Set<Integer> seen = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    seen.clear();
                    for (int j = 0; j < n; j++) {
                        int val = m[i][j];
                        if (seen.contains(val)) {
                            r++;
                            break;
                        }
                        seen.add(val);
                    }
                }

                for (int j = 0; j < n; j++) {
                    seen.clear();
                    for (int i = 0; i < n; i++) {
                        int val = m[i][j];
                        if (seen.contains(val)) {
                            c++;
                            break;
                        }
                        seen.add(val);
                    }
                }

                out.println(String.format("Case %d#: %s %s %s", t + 1, trace, r, c));
            }
        }
    }

}
