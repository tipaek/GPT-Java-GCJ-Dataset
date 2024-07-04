import java.util.*;
import java.io.*;
public class Solution {
    static boolean debug = true;
    static Set<Coord> memo;
    static ArrayList<Coord> path;
    static int[][] dirs = {{1,1}, {0,1}, {1,0}, {0,-1}, {-1,0}, {-1,-1}};

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            System.out.println("Case #" + i + ":");
            compute(n);
        }
    }

    public static void compute(int n) {
        memo = new HashSet<>();
        path = new ArrayList<>();
        Coord cur = new Coord(1, 1);
        rc(n, cur);
        path.iterator().forEachRemaining(i -> System.out.println(i));
    }

    public static void rc(int n, Coord prev) {
        if (n == 0) return;
        memo.add(prev);
        path.add(prev);
        List<Coord> adj = surround(prev);
        Coord best = null;
        for (int i = 0; i < adj.size(); i++) {
            Coord cur = adj.get(i);
            if (cur.value() <= (n + 1)/2 && (best == null || best.value() < cur.value())) {
                best = cur;
            }
        }
        rc(n - best.value(), best);
    }

    public static List<Coord> surround(Coord cur) {
        List<Coord> res = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Coord next = new Coord(cur.r + dirs[i][0], cur.c + dirs[i][1]);
            if (!memo.contains(next)) {
                res.add(next);
            }
        }
        return res;
    }
}

class Coord {
    int r, c;
    int val = -1;
    Coord(int row, int col) {
        r = row;
        c = col;
    }
    public int value() 
    { 
        if (val != -1) return val;
        int n = r - 1;
        int k = c - 1;
        int res = 1; 
      
        // Since C(n, k) = C(n, n-k) 
        if ( k > n - k ) 
            k = n - k; 
      
        // Calculate value of [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1] 
        for (int i = 0; i < k; ++i) 
        { 
        res *= (n - i); 
        res /= (i + 1); 
        } 
      
        this.val = res;
        return res; 
    }

    public boolean equals(Object o) {
        return r == ((Coord) o).r && c == ((Coord) o).c;
    }

    public int hashCode() {
        return Arrays.hashCode(new int[]{r, c});
    }

    public String toString() {
        return r + " " + c;
    }
}