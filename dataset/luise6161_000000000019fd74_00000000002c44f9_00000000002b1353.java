import java.util.*;
import java.io.*;

public class Solution {
    private static Scanner in;
    private static final long maxLong = (long) 1000000001;
    private static long getPascal(long r, long k){
        if(k >= 1 && k <= r) {
            k = Long.min(k, r+1-k);
            long ans = 1;
            for(long i=1;i<k;i++) {
                ans = ans * (r-i) / i;
                if(ans > maxLong){
                    return maxLong;
                }
            }
            return ans;
        } else {
            return maxLong;
        }
    }
    static class Position{
        int r, k;
        Position(int r, int k) {
            this.r = r;
            this.k = k;
        }

        long getValue(){
            return Solution.getPascal(r, k);
        }
    }

    private static LinkedHashSet<Position> path = new LinkedHashSet<>();
    private static boolean roam(Position c, long n){
        path.add(c);
        if(n==0){
            return true;
        }
        if(path.size()>=500) {
            path.remove(c);
            return false;
        }

        List<Position> a = new ArrayList<Position>();
        a.add(new Position(c.r+1, c.k));
        a.add(new Position(c.r+1, c.k+1));
        a.add(new Position(c.r, c.k+1));
        a.add(new Position(c.r, c.k-1));
        a.add(new Position(c.r-1, c.k));
        a.add(new Position(c.r-1, c.k-1));
        a.sort(Comparator.comparingLong(Position::getValue).reversed());

        for(Position p: a) {
            if(!path.contains(p) && p.getValue() <= n) {
                if(roam(p, n-p.getValue())){
                    return true;
                }
            }
        }
        path.remove(c);
        return false;
    }

    public static void solve(){
        long n = in.nextLong();
        path.clear();
        roam(new Position(1, 1), n-1);
        for(Position p: path) {
            System.out.println(p.r + " " + p.k);
        }
    }

    public static void main(String[] args) {
        in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ":");
            solve();
        }
    }
}