import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    static class Solar {
        int tid;
        Solar(int t){
            tid = t;
        }


        public void solve(){
            Long l, r;
            l = in.nextLong();
            r = in.nextLong();
            long eater = 0;
            long i;
            for(i=1;;i++) {
                if(l >=r) {
                    l -= i;
                } else {
                    r -= i;
                }
                if(i>=l && i>=r) break;
            }

            System.out.println("Case #" + tid + ": " + i + " " + l + " " + r) ;
        }
    }

    public static void main(String[] args) {
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            Solar s = new Solar(i);
            s.solve();
        }
    }
}
