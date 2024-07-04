
import java.io.File;
import java.util.*;

public class Solution {

//    static int[] DP = new int[100100];
//    static int[] DP2 = new int[100100];

    static void solve(int testCase, Scanner in){
        int N = in.nextInt();

        long[] xs = new long[N];
        long[] ys = new long[N];

        for (int i = 0; i < N; i++) {
            xs[i] = in.nextLong();
            ys[i] = in.nextLong();
        }

        long best = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                long x1 = xs[i];
                long x2 = xs[j];

                long y1 = ys[i];
                long y2 = ys[j];

                Map<Long, Long> dists = new HashMap<>();

                for (int k = 0; k < N; k++) {
                    long x0 = xs[k];
                    long y0 = ys[k];

                    // dist
                    long dist = (y2-y1)*x0 - (x2-x1)*y0 + x2*y1 - y2*x1;

                    dists.put(dist, dists.getOrDefault(dist, 0L) + 1);
                }

                best = Math.max(best, getBest(new ArrayList<>(dists.values())));

            }
        }

        if (N==1){
            best = 1;
        }

        System.out.println("Case #" + testCase + ": " + best);
    }

    static long getBest(List<Long> counts){
        long best = 0;

        for (int i = 0; i < counts.size(); i++) {
            counts.set(i, counts.get(i) - 1);

            {
                long res = 1;

                long odds = 0;
                boolean seenOne = false;
                for (Long count : counts) {
                    if (count != 1) {
                        res += count;
                        if (count % 2 == 1) {
                            odds++;
                        }
                    } else {
                        seenOne = true;
                    }
                }

                // if there was an even num of odds, we can do one of the ones if exists.
                if (odds % 2 == 0) {
                    if (seenOne) {
                        res++; // might as well do it, we can
                    }
                }

                best = Math.max(best, res);
            }

            counts.set(i, counts.get(i) + 1);
        }

        return best;
    }


    public static void main(String[] args) throws Exception{
        Scanner in;
        if (args.length != 0){
            in = new Scanner(new File(args[0]));
        } else {
            in = new Scanner(System.in);
        }
        int T = in.nextInt();
        for (int t =1; t< T+1; t++){
            solve(t, in);
        }
    }

    public static class MyRun{
        public static void main(String[] args) throws Exception{
            Solution.main(new String[]{"in.txt"});
        }
    }

}
