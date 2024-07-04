
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

        long L = in.nextInt();
        long R = in.nextInt();

        long i = 0;
        while(true) {
            long cost = i+1;
            if(L >= R) {
                if(cost > L) {
                    break;
                }
                L -= cost;
            } else {
                if(cost > R) {
                    break;
                }
                R -= cost;
            }
            i++;
        }

        System.out.println("Case #" + cid + ": " + i + " " + L + " " + R);

    }

}
