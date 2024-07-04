import java.util.*;
import java.io.*;

public class Solution {

    static boolean isIntersect(int[] st, int[] en, int k, int j) {

        return (!(st[k] >= en[j] || st[j] >= en[k]));
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

//        Scanner s = null;
//        try {
//            s = new Scanner (new File("test.in"));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace ();
//        }
//        if (s == null)
//            return;

        int t = s.nextInt();
        for (int i = 1; i <= t; ++i) {

            int n = s.nextInt();

            int[] st = new int[n];
            int[] en = new int[n];

            for (int j = 0; j < n; j++) {
                st[j] = s.nextInt();
                en[j] = s.nextInt();
            }

            String r = "C";

            for (int j = 1; j < n; j++) {
                boolean intersect = false;
                for (int k = 0; k < j; k++) {
                    if (r.charAt(k) == 'C' && isIntersect(st, en, k, j)) {
                        intersect = true;
                        break;
                    }
                }
                if (!intersect)
                    r += 'C';
                else {
                    intersect = false;
                    for (int k = 0; k < j; k++) {
                        if (r.charAt(k) == 'J' && isIntersect(st, en, k, j)) {
                            intersect = true;
                            break;
                        }
                    }
                    if (!intersect)
                        r += 'J';
                    else {
                        r = "IMPOSSIBLE";
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + r);
        }
    }
}

