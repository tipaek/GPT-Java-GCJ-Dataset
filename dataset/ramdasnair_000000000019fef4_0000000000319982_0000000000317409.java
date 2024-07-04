import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int t = input.nextInt();

        for(int u=0; u < t; u++) {

            int x = input.nextInt();
            int y = input.nextInt();

            int xSub = x;
            int ySub = y;
            String m = input.next();

            int[] dist = new int[m.length() + 1];

            dist[0] = xSub + ySub;
            boolean found = false;
            int i=0;
            for(; i< m.length(); i++) {
                if (m.charAt(i) == 'N') {
                    ySub++;
                } else if (m.charAt(i) == 'S') {
                    ySub--;
                } else if (m.charAt(i) == 'E') {
                    xSub++;
                } else if (m.charAt(i) == 'W') {
                    xSub--;
                }
                dist[i+1] = Math.abs(xSub) + Math.abs(ySub);

                if (dist[i+1] <= i+1) {
                    found = true;
                    break;
                }
            }

            String out = "";

            if (found) {
                out = (i+1) + "";
            } else {
                out = "IMPOSSIBLE";
            }

            println("Case #" + (u+1) + ": " + out);
        }
    }

    private static void print(Object s) {
        System.out.print(s);
    }

    private static void println(Object s) {
        System.out.println(s);
    }

}