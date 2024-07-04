import java.util.*;

class Point {
    public int r;
    public int k;

    public Point(int r, int k) {
        this.r = r;
        this.k = k;
    }

    @Override
    public boolean equals(Object o) {  
        if (!(o instanceof Point)) { 
            return false; 
        } 
        Point p = (Point) o; 
        return p.r == r && p.k == k;
    } 

    @Override
    public int hashCode() {
        return Objects.hash(r, k);
    }
}

public class Solution {
    public static Map<Point, Integer> seen = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testNum = Integer.parseInt(input.nextLine());
        
        for(int i = 0; i < testNum; i++) {
            int n = Integer.parseInt(input.nextLine());
            Point[] A = new Point[500];
            seen = new HashMap<>();
            if(walk(1, 1, n, 0, A) == 0) {
                System.out.println("Case #" + (i+1) + ": ");
                for(int j = 0; j < 500; j++) {
                    Point p = A[j];
                    if(p == null) break;
                    System.out.println(p.r + " " + p.k);
                }
            } else {
                System.out.println("oh no");
            }
        }
    }

    public static int fact(int n) {
        int res = 1;
        for(int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }
    
    public static int findVal(int n, int k) {
        return (fact(n-1)) / (fact(k-1) * fact(n - k));
    }

    public static Point[] getMoves(int r, int k) {
        Point[] P = new Point[6];
        P[0] = new Point(r - 1, k - 1);
        P[1] = new Point(r - 1, k);
        P[2] = new Point(r, k - 1);
        P[3] = new Point(r, k + 1);
        P[4] = new Point(r + 1, k);
        P[5] = new Point(r + 1, k + 1);
        return P;
    }
    
    public static int walk(int r, int k, int sum, int i, Point[] A) {
        if(i >= 500 || sum < 0) return -1;
        if(r <= 0 || k <= 0 || k > r) return -1;
        int currVal = findVal(r, k);
        Point currP = new Point(r, k);
        // System.out.println(r + " " + k + " " + (sum - currVal));
        if(sum-currVal == 0) {
            A[i] = currP;
            return 0;
        }
        Point[] P = getMoves(r, k);
        seen.put(currP, sum - currVal);
        for (Point p : P) 
        {
            if(seen.get(p) != null) {
                continue;
            }
            // seen.put(p, sum - currVal);
            if(walk(p.r, p.k, sum - currVal, i+1, A) == 0) {
                A[i] = new Point(r, k);
                return 0;
            } 
        }
        seen.remove(currP);
        return -1;
    }
}