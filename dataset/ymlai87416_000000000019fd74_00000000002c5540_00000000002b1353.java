import java.io.File;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;

public class Solution {
    static String   FILENAME;
    static Scanner sc;
    static String   IN;
    static String   OUT;
    static PrintStream out;

    static{
        try{
            /*
            FILENAME = "Solution-large";
            IN = FILENAME + ".in";
            OUT = FILENAME + ".out";
            sc = new Scanner(new File(IN));
            out      = new PrintStream(
                    new FileOutputStream(OUT, false));
                    */

            //IN = "C:\\GitProjects\\algorithm_practice\\java\\src\\main\\java\\GoogleCodeJam\\Y2020\\RoundA\\B\\B-test.in";
            IN = null;
            if(IN == null)
                sc = new Scanner(System.in);
            else
                sc = new Scanner(new File(IN));
            out = new PrintStream(System.out);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    static long nCr(int n, int r) {

        // p holds the value of n*(n-1)*(n-2)...,
        // k holds the value of r*(r-1)...
        long p = 1, k = 1;

        // C(n, r) == C(n, n-r),
        // choosing the smaller value
        if (n - r < r) {
            r = n - r;
        }

        if (r != 0) {
            while (r > 0) {
                p *= n;
                k *= r;

                // gcd of p, k
                long m = __gcd(p, k);

                // dividing by gcd, to simplify product
                // division by their gcd saves from the overflow
                p /= m;
                k /= m;

                n--;
                r--;
            }

            // k should be simplified to 1
            // as C(n, r) is a natural number
            // (denominator should be 1 ) .
        } else {
            p = 1;
        }

        // if our approach is correct p = ans and k =1
        return p;
    }

    static long __gcd(long n1, long n2) {
        long gcd = 1;

        for (int i = 1; i <= n1 && i <= n2; ++i) {
            // Checks if i is factor of both integers
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }


    HashMap<Integer,Set> visited;
    int[] rd = {-1, -1, 0, 0, 1, 1};
    int[] kd = {-1, 0, -1, 1, 0, 1};

    private Stack<int[]> solve(long N, int r, int k, Stack<int[]> trace){

        //System.out.format("debug: %d %d %d\n", N, r, k);
        if(trace.size() > 500) return null;

        long ncr = nCr(r-1, k-1);
        long left = N-ncr;

        if(left < 0) return null;

        if(visited.get(r) == null){
            HashSet<Integer> hs = new HashSet<>();
            hs.add(k);
            visited.put(r, hs);
        }
        else
            visited.get(r).add(k);

        trace.push(new int[]{r, k});


        if(left == 0) return trace;

        //do nothing
        for(int i=0; i<6; ++i){
            int nr = r+rd[i];
            int nk = k+kd[i];
            if(nr <= 0) continue;
            if(nk <= 0 || nk > nr) continue;
            if(visited.get(nr) != null && visited.get(nr).contains(nk))
                continue;

            Stack<int[]> temp =  solve(left, nr, nk, trace);
            if(temp != null)
                return temp;
        }

        trace.pop();
        visited.get(r).remove(k);

        return null;
    }

    private void run() throws Exception {
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= t; i++) {
            out.println("Case #" + i + ": ");

            long N = sc.nextLong();
            visited = new HashMap<>();

            Stack<int[]> result = solve(N, 1, 1, new Stack<>());
            for(int j=0; j<result.size(); ++j)
                out.format("%d %d\n", result.get(j)[0], result.get(j)[1]);
        }
        sc.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }
}
