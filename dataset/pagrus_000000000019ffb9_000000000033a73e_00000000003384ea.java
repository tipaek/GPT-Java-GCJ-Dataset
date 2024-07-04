import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = s.nextInt();
        s.nextLine();
        for (int t = 1; t <= testCases; t++) {
            long l = s.nextLong();
            long r = s.nextLong();

            Result res = solve(l, r);
            System.out.format("Case #%d: %d %d %d\n", t, res.n, res.l, res.r);
        }
    }

    private static Result solve(long l, long r) {
        long max = 0;
        long min = 0;
        long n=1;
        while(l>=n || r >=n) {
            if(l>= r) {
                l-=n;
            } else {
                r-=n;
            }
            n++;
        }
        return new Result(n-1, l, r);
    }

    static class Result {
        long n;
        long l;
        long r;

        public Result(long n, long l, long r) {
            this.n = n;
            this.l = l;
            this.r = r;
        }
    }

}