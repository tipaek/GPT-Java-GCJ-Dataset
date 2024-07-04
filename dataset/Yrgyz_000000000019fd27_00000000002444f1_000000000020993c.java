import java.util.*;
import java.io.*;

public class TaskA {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = 0, r = 0, c = 0;
            Set<Integer> horizontal = new HashSet<Integer>();
            Map<Integer, Set<Integer>> vertical = new HashMap<Integer, Set<Integer>>();
            int[][] a = new int[n][n];
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    a[x][y] = in.nextInt();
                    horizontal.add(a[x][y]);
                    if (x == y) k += a[x][y];
                    if (x == 0) {
                        vertical.put(y, new HashSet<Integer>( Arrays.asList(a[x][y]) ));
                    } else {
                        vertical.get(y).add(a[x][y]);
                        if (x == n-1) {
                            if (vertical.get(y).size() != n) {
                                c++;
                            }
                        }
                    }
                }
                if (horizontal.size() != n) r++;
                horizontal.clear();
            }

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}
    