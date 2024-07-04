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

            boolean flag = false;

            String s[] = buff.readLine().split(" ");
            int x2 = Integer.parseInt(s[0]);
            int y2 = Integer.parseInt(s[1]);
            String tour = s[2];

            int dist = Math.abs(x2) + Math.abs(y2);

            int cdist = dist;

            int i = 0;
            while (i < tour.length()) {
                if (tour.charAt(i) == 'N') {
                    y2++;
                } else if (tour.charAt(i) == 'S') {
                    y2--;
                } else if (tour.charAt(i) == 'E') {
                    x2++;
                } else if (tour.charAt(i) == 'W') {
                    x2--;
                }

                cdist = Math.abs(x2) + Math.abs(y2) - (i + 1);
                if (cdist <= 0) {
                    flag = true;
                    break;
                }
                i++;
            }

            if (flag) {
                System.out.println("Case #" + tnum + ":" + " " + (i + 1));
            } else {
                System.out.println("Case #" + tnum + ":" + " " + "IMPOSSIBLE");

            }
            tnum++;

        }
    }
}
