import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < T; t++) {
            String line = scanner.nextLine();
            String[] xy = line.split(" ");
            int X = Integer.parseInt(xy[0]);
            int Y = Integer.parseInt(xy[1]);

            Solver solver = new Solver(X, Y);

            pw.println(String.format("Case %d: %s", t + 1, solver.solve()));
        }


        pw.flush();
        pw.close();
        scanner.close();

    }

    private static class Solver {
        private static final int shift = 8;
        private int X;
        private int Y;

        Solver(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }

        public String solve() {
            List<int[]> xpairs = new ArrayList<>();
            List<int[]> ypairs = new ArrayList<>();

            for (int i = 0; i < (1 << shift); i++) {
                for (int j =  0; j < (1 << shift); j++) {
                    if (j - i == X && (i & j) == 0) {
                        xpairs.add(new int[]{i, j});
                    }
                }
            }

            for (int i = 0; i < (1 << shift); i++) {
                for (int j = 0; j < (1 << shift); j++) {
                    if (j - i == Y && (i & j) == 0) {
                        ypairs.add(new int[]{i, j});
                    }
                }
            }

            if (xpairs.size() == 0 || ypairs.size() == 0) return "IMPOSSIBLE";
            
            int north = 0;
            int south = 0;
            int west = 0;
            int east = 0;

            outerloop:
            for (int i = 0; i < xpairs.size(); i++) {
                int[] xm = xpairs.get(i);
                for (int j = 0; j < ypairs.size(); j++) {
                    int[] ym = ypairs.get(j);

                    if (((xm[0] | xm[1]) & (ym[0] | ym[1])) == 0) {
                        west = xm[0];
                        east = xm[1];
                        south = ym[0];
                        north = ym[1];
                        break outerloop;
                    }
                }
            }

            StringBuilder path = new StringBuilder();
            for (int i = 0; i < 32; i++) {
                if ((north & ( 1 << i)) > 0) {
                    path.append('N');
                } else if ((south & ( 1 << i)) > 0) {
                    path.append('S');
                } else if ((east & ( 1 << i)) > 0) {
                    path.append('E');
                } else if ((west & ( 1 << i)) > 0) {
                    path.append('W');
                }
            }

            return path.length() == 0 ? "IMPOSSIBLE" : path.toString();
        }

    }

}
