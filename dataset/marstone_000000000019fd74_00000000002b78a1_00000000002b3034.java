import java.util.*;

/**
 * Pattern Matching (5pts, 5pts, 18pts)
 */
public class Solution {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            String[] P = new String[N];
            for(int i = 0; i < N; i++) {
                P[i] = in.next();
            }

            String[] PR = new String[N];
            String[] PL = new String[N];
            for(int i = 0; i < N; i++) {
                String p = P[i];
                int index = p.indexOf('*');
                PR[i] = p.substring(index);
                PL[i] = p.substring(0, index);
            }

            String right = matchRight(PR);
            String left = null;
            if(null != right) {
                left = matchLeft(PL);
            }
            System.out.format("Case #%d: %s\n", t, (null != right && null != left) ? left + right : "*");
        }
    }

    /**
     * for all "*XXXX" pattern
     */
    private static String matchRight(String[] P) {
        String max = "";
        for (String p : P) {
            int diff = p.length() - max.length() - 1;
            if (diff > 0) {
                if (!p.substring(diff + 1).equals(max)) {
                    return null;
                }
                max = p.substring(1);
            } else if (diff == 0) {
                if (!p.substring(1).equals(max)) {
                    return null;
                }
            } else {
                if (!p.substring(1).equals(max.substring(-diff))) {
                    return null;
                }
            }
        }
        return max;
    }


    private static String matchLeft(String[] P) {
        String max = "";
        for (String p : P) {
            if(p.length() > max.length()) {
                if(!p.startsWith(max)) {
                    return null;
                }
                max = p;
            } else {
                if(!max.startsWith(p)) {
                    return null;
                }
            }
        }
        return max;
    }

}
