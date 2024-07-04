import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    static class Solar {
        int tid;
        Solar(int t){
            tid = t;
        }

        class Point {
            long x, y;
            Point(long x, long y) {
                this.x=x;
                this.y=y;
            }
        }

        class Fraction {
            long x, y;
            Fraction(long x, long y) {
                if(y==0){
                    this.x = 0;
                    this.y=0;
                } else {
                    long g = calculateGCD(x,y);
                    this.x = x/g;
                    this.y = y/g;
                }
            }
            long calculateGCD(long xx, long yy) {
                if (xx % yy == 0) {
                    return yy;
                }
                return calculateGCD(yy, xx % yy);
            }
            public String toString(){
                return x + "/" + y;
            }
        }

        public void solve(){
            HashMap<String, Long> counts = new HashMap<>();
            int n = in.nextInt();
            Point[] points = new Point[n];
            for(int i=0;i<n;i++){
                long x = in.nextLong();
                long y = in.nextLong();
                points[i] = new Point(x,y);
            }
            Arrays.sort(points, Comparator.comparing(p->p.x));

            HashSet<Pair<String, Point>> f = new HashSet<>();
            for(int i=0;i<n;i++) {
                for(int j=i+1;j<n;j++){
                    String fra = new Fraction(points[j].y - points[i].y, points[j].x - points[i].x).toString();
                    Pair<String, Point> key1 = new Pair(fra, points[i]);
                    Pair<String, Point> key2 = new Pair(fra, points[j]);
                    if(!f.contains(key1) && !f.contains(key2)){
                        f.add(key1);
                        f.add(key2);
                        counts.put(fra, counts.getOrDefault(fra, 0L) + 1);
                    }
                }
            }
            long max = 0;
            for(Long a: counts.values()) {
                max = Long.max(a, max);
            }
            long ans;
            if(max > 1) ans = n;
            else ans = n-1;
            System.out.println("Case #" + tid + ": " + ans) ;
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
