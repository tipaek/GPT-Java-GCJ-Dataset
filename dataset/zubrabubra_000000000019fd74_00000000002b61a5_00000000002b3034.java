import java.util.Scanner;
import java.util.Arrays;
//...


class Solution {

    static String endS = null;
    static String startS = null;

    public static boolean addS(String s) {
        String[] p = s.split("\\*");
        int t = p.length - 1;

        // check starts
        if (p[0].length() > 0) {
            if (startS == null) {
                startS = p[0];
            } else {
                if (startS.length() >= p[0].length() && !startS.startsWith(p[0])) {
                    //System.out.println("?*" + startS + "*" + p[0]);
                    return false;
                }
                if (startS.length() <= p[0].length() && !p[0].startsWith(startS)) {
                    //System.out.println("?*" + startS + "*" + p[0]);
                    return false;
                }
                if (startS.length() < p[0].length()) {
                    startS = p[0];
                }
            }
        }

        // check last
        if (p[t].length() > 0 && t > 0) {
            if (endS == null) {
                endS = p[t];
            } else {
                if (endS.length() >= p[t].length() && !endS.endsWith(p[t])) {
                    //System.out.println("!*" + endS + "?*" + p[t]);
                    return false;
                }
                if (endS.length() <= p[t].length() && !p[t].endsWith(endS)) {
                    //System.out.println("!*" + endS + "!*" + p[t]);
                    return false;
                }
                if (endS.length() < p[t].length()) {
                    endS = p[t];
                }
            }
        }

        //System.out.println(startS +  "*" + endS + "    " + t + " " + p[0] + "*" + p[t]);

        return true;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int it = 0; it < t; it++) {
            int n = in.nextInt();
            in.nextLine();
            boolean can = true;
            startS = null;
            endS = null;
            for (int i = 0; i < n; i++) {
                String a = in.nextLine();
                //System.out.println("Case X" + a);
                can = can && addS(a);
            }
            if (can) {
                if (startS == null) {
                    startS = "A";
                }
                if (endS == null) {
                    endS = "C";
                }
                System.out.println("Case #" + (it+1) + ": " + startS + endS);
            } else {
                System.out.println("Case #" + (it+1) + ": " + '*');
            }
        }
    }
}
