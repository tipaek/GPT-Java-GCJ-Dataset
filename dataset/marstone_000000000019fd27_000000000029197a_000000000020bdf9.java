import java.util.Scanner;

/**
 * Parenting Partnering Returns (7pts, 12pts)
 */
public class Solution {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int[] S = new int[N];
            int[] E = new int[N];
            for(int i = 0; i < N; i++) {
                S[i] = in.nextInt();
                E[i] = in.nextInt();
            }
            String result = assign("", 'C', N, S, E);
            if(null == result) {
                result = assign("", 'J', N, S, E);
            }
            System.out.format("Case #%d: %s\n", t, null == result ? "IMPOSSIBLE" : result);
        }
    }

    private static String assign(String A, char person, int N, int[] S, int[] E) {
        int l = A.length();
        int s = S[l];
        int e = E[l];
        // check overlap
        for(int i = 0; i < l; i++) {
            if(A.charAt(i) == person) {
                int si = S[i];
                int ei = E[i];
                if(!((s <= si && e <= si) || (s >= ei && e >= ei))) {
                    return null;
                }
            }
        }
        // no overlap, try next
        if(l + 1 < N) {
            String result = assign(A + person, 'C', N, S, E);
            if(null == result) {
                result = assign(A + person, 'J', N, S, E);
            }
            return result;
        } else {
            return A + person;
        }
    }

}
