import java.io.*;
import java.util.*;
class Solution {

    public static void getAnswer(int n, int m, int ct) {        
        if(m % n == 0) {
            System.out.println("Case #" + ct + ": POSSIBLE" );
            int r = m / n;

            for(int i = 1; i <= n; i++) {
                int s = r;
                ArrayList<Integer> temp = new ArrayList<>();
                for(int k = 1; k <= n; k++) {
                    temp.add(s);
                    s++;
                    if(s > n) {
                        s = 1;
                    }
                }
                // System.out.println(temp);
                for(int t:temp) {
                    System.out.print(t + " ");
                }
                System.out.println();
                r--;
                if(r == 0) r = n;
            }
        }
        else {
            System.out.println("Case #" + ct + ": IMPOSSIBLE" );
        }

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = scn.nextInt();

        int ct = 1;
        while(ct <= t) {
            int n = scn.nextInt();
            int m = scn.nextInt();

            getAnswer(n, m, ct);
            ct++;
        }
    }
}