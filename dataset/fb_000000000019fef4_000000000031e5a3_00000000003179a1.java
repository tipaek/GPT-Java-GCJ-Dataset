
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int T = s.nextInt();
        for(int i = 0; i < T; i++) {
            solve(i+1, s);
        }

    }

    private static void solve(int cid, Scanner in) {

        Map<Character, Integer> count = new TreeMap<Character, Integer>();

        int U = in.nextInt();

        for(int i = 0; i < 10000; i++) {
            String Q = in.next();
            String R = in.next();
            char c = R.charAt(0);
            for(int j = 0; j < R.length(); j++) {
                if(!count.containsKey(R.charAt(j))) {
                    count.put(R.charAt(j), 0);
                }
            }
            count.put(c, count.get(c) + 1);
        }

        String D = "";
        for(int i = 0; i < 10; i++) {
            char best = '?';
            int best_count = -1;
            for(char c : count.keySet()) {
                if(count.get(c) > best_count) {
                    best = c;
                    best_count = count.get(c);
                }
            }
            D += best;
            count.remove(best);
        }

        D = D.charAt(D.length()-1) + D.substring(0, D.length()-1);

        System.out.println("Case #" + cid + ": " + D);

    }

}
