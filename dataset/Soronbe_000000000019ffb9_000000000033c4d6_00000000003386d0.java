import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // Now 2 stacks are +- even and the orders will alternate between stacks
        // every 2 order the order size increases by 2, but the difference in stacksize increases by 1

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            System.out.print(String.format("Case #%d: ", i));
            solve(in);
        }

    }

    public static void solve(Scanner sc) {
        int N = sc.nextInt();

        Hole[] holes = new Hole[N];
        for (int i = 0; i < N; ++i) {
            holes[i] = new Hole(sc.nextInt(), sc.nextInt());
        }

        if (N <= 3) {
            // 3 is always possible if sufficient holes exist
            System.out.println(N);
            return;
        }

        Set<Hole> vertical = new HashSet<>();
        Set<Hole> horizontal = new HashSet<>();

        Map<Integer, Map<Integer, Set<Hole>>> holesGroupedBySlope = new HashMap<>();
        for (Hole hole1 : holes) {
            for (Hole hole2 : holes) {
                if (hole1 == hole2) {
                    continue;
                }

                if (hole1.getY() == hole2.getY()) {
                    vertical.add(hole1);
                    vertical.add(hole2);
                    continue;
                }

                if (hole1.getX() == hole2.getX()) {
                    horizontal.add(hole1);
                    horizontal.add(hole2);
                    continue;
                }

                int slopeNum = hole1.getY() - hole2.getY();
                int slopeDen = hole1.getX() - hole2.getX();
                // Normalize and simplify slope fraction
                if (slopeDen < 0 && slopeNum < 0) {
                    slopeDen = -slopeDen;
                    slopeNum = -slopeNum;
                }

                int gcd = gcd(Math.abs(slopeNum), Math.abs(slopeDen));

                slopeNum /= gcd;
                slopeDen /= gcd;

                if (!holesGroupedBySlope.containsKey(slopeNum)) {
                    holesGroupedBySlope.put(slopeNum, new HashMap<>());
                }

                Map<Integer, Set<Hole>> foundMap = holesGroupedBySlope.get(slopeNum);


                if (!foundMap.containsKey(slopeDen)) {
                    foundMap.put(slopeDen, new HashSet<>());
                }

                Set<Hole> holeSet = foundMap.get(slopeDen);
                holeSet.add(hole1);
                holeSet.add(hole2);
            }
        }

        int maxGroup = Math.max(horizontal.size(), vertical.size());

        for (Map<Integer, Set<Hole>> foundMap : holesGroupedBySlope.values()) {
            for (Set<Hole> holeSet : foundMap.values()) {
                maxGroup = Math.max(maxGroup, holeSet.size());
            }
        }

        maxGroup = Math.min(N, maxGroup+2);

        System.out.println(maxGroup);


    }

    // Source: https://introcs.cs.princeton.edu/java/23recursion/Euclid.java.html
    // non-recursive implementation
    public static int gcd(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

    static class Hole {
        final int x;
        final int y;


        Hole(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }


}
  