import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author daksh
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(buff.readLine());
        int tnum = 1;
        while (t-- > 0) {
            int trace = 0;
            int r = 0;
            int c = 0;
            int n = Integer.parseInt(buff.readLine());
            int mat[][] = new int[n][n];

            ArrayList<Set<Integer>> colSet = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Set<Integer> s = new HashSet<Integer>();
                colSet.add(s);
            }
            for (int i = 0; i < n; i++) {

                String s[] = buff.readLine().split(" ");
                Set<Integer> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Integer.parseInt(s[j]);
                    set.add(mat[i][j]);
                    Set<Integer> cs = colSet.get(j);
                    cs.add(mat[i][j]);
                    if (i == j) {
                        trace = trace + mat[i][j];
                    }
                }
                if (set.size() < n) {
                    r++;
                }
            }

            for (int i = 0; i < n; i++) {
                Set<Integer> cs = colSet.get(i);
                if (cs.size() < n) {
                    c++;
                }
            }

            System.out.println("Case #" + tnum + ":" + " " + trace + " " + r + " " + c);
            tnum++;
        }

    }
}
