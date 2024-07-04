import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {

        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int y = s.nextInt();

        for (int j = 0; j < y; j++) {

            int t = s.nextInt();

            int[] start = new int[t];
            int[] end = new int[t];

            for (int i = 0; i < t; i++) {
                start[i] = s.nextInt();
                end[i] = s.nextInt();

            }
            String ans = parentSchedule(start, end);
            System.out.println("Case #" + (j + 1) + ": " + ans);
        }
                    s.close();
    }

    static boolean[] c = new boolean[1441];
    static boolean[] j = new boolean[1441];

    public static String parentSchedule(int[] start, int[] end) {

        int length = start.length;
        String ans = "";

        for (int i = 0; i < 1441; i++) {
            c[i] = true;
            j[i] = true;
        }

        for (int i = 0; i < length; i++) {

            if (c[start[i]] == true) {
                ans = ans + "C";

                for (int k = start[i]; k < end[i]; k++) {
                    c[k] = false;
                }
            } else if (j[start[i]] == true) {
                ans = ans + "J";

                for (int k = start[i]; k < end[i]; k++) {
                    j[k] = false;
                }
            } else {
                return "IMPOSSSIBLE";
            }
        }

        return ans;
    }
}