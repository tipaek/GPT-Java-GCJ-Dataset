import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

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

            int a = Integer.parseInt(buff.readLine().trim());
            char ans[] = new char[a];
            Integer mat[][] = new Integer[a][3];
            for (int i = 0; i < a; i++) {
                String s[] = buff.readLine().trim().split(" ");
                mat[i][0] = Integer.parseInt(s[0]);
                mat[i][1] = Integer.parseInt(s[1]);
                mat[i][2] = i;
            }

            Arrays.sort(mat, Comparator.comparingInt(o -> o[0]));

            int jend = 0;
            int cend = 0;
            boolean flag = true;
            for (int i = 0; i < mat.length && flag; i++) {
                int astart = mat[i][0];
                int aend = mat[i][1];

                if (cend <= astart) {
//                    sb.append("C");
                    ans[mat[i][2]] = 'C';
                    cend = aend;
                } else if (jend <= astart) {
//                    sb.append("J");
                    ans[mat[i][2]] = 'J';
                    jend = aend;
                } else {
//                    sb = new StringBuilder("IMPOSSIBLE");
                    flag = false;
                }
            }

            if (flag) {
                String te = String.copyValueOf(ans);
                System.out.println("Case #" + tnum + ":" + " " + te);
            } else {
                System.out.println("Case #" + tnum + ":" + " " + "IMPOSSIBLE");

            }
            tnum++;

        }
    }
}
