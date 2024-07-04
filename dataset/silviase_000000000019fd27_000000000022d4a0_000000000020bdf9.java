import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Comparator;
import java.util.ArrayList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author silviase
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        solver.solve(1, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, Scanner in, PrintWriter out) {

            int numOfTestCase = in.nextInt();
            for (int i = 1; i <= numOfTestCase; i++) {
                int n = in.nextInt();
                ArrayList<Vec3i> v = new ArrayList<>();
                boolean valid = true;
                char[] ans = new char[n];
                int timeC = 0;
                int timeJ = 0;

                for (int j = 0; j < n; j++) {
                    v.add(new Vec3i(j, in.nextInt(), in.nextInt()));
                }

                v.sort(Comparator.comparing(t -> t.z));
                for (int j = 0; j < v.size(); j++) {
                    Vec3i vec = v.get(j);

                    if (timeJ <= timeC) {
                        if (timeC <= vec.y) {
                            ans[vec.x] = 'C';
                            timeC = vec.z;
                        } else if (timeJ <= vec.y) {
                            ans[vec.x] = 'J';
                            timeJ = vec.z;
                        } else {
                            valid = false;
                            break;
                        }
                    } else {
                        if (timeJ <= vec.y) {
                            ans[vec.x] = 'J';
                            timeJ = vec.z;
                        } else if (timeC <= vec.y) {
                            ans[vec.x] = 'C';
                            timeC = vec.z;
                        } else {
                            valid = false;
                            break;
                        }
                    }

                }

                if (valid) {
                    out.printf("Case #%d: %s\n", i, new String(ans));
                } else {
                    out.printf("Case #%d: %s\n", i, "IMPOSSIBLE");
                }
            }


        }

    }

    static class Vec3i {
        public int x;
        public int y;
        public int z;

        public Vec3i(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public String toString() {
            return "Vec3i{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }

    }
}

