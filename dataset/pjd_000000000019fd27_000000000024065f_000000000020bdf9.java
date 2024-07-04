import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // long startTime = System.nanoTime();
        /////////////////////////////////////////////////////
        int numCases = sc.nextInt();

        for (int caseNo = 1; caseNo <= numCases; ++caseNo) {
            HashMap<Pair, Integer> hm = new HashMap<>();
            int n = sc.nextInt();
            Pair[] intervals = new Pair[n];
            for (int i = 0; i < n; ++i) {
                Pair p = new Pair(sc.nextInt(), sc.nextInt());
                intervals[i] = p;
                hm.put(p, i);
            }
            Comparator<Pair> comp = new Comparator<Pair>() {
                @Override
                public int compare(Pair a, Pair b) {
                    if (a.x == b.x) {
                        return a.y = b.y;
                    }
                    return a.x - b.x;
                }
            };

            Arrays.sort(intervals, comp);

            char[] ans = new char[n];
            int c = 0;
            int j = 0;
            boolean impossible = false;
            for (Pair pair : intervals) {
                if (pair.x >= c) {
                    ans[hm.get(pair)] = 'C';
                    c = pair.y;
                } else if (pair.x >= j) {
                    ans[hm.get(pair)] = 'J';
                    j = pair.y;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + caseNo + ": " + "IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNo + ": " + String.valueOf(ans));
            }
        }

        /////////////////////////////////////////////////////
        // long endTime = System.nanoTime();
        // System.out.printf("Executed in: %.2fms\n", ((double)endTime - startTime) /
        ///////////////////////////////////////////////////// 1000000);
        // sc.close();
    }

    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    static boolean isOdd(int n) {
        return n % 2 == 1;
    }

    static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        } else {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}

class Pair {
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        // System.out.println("inside equals");
        if (o == this) {
            return true;
        } else if (!(o instanceof Pair)) {
            return false;
        } else {
            Pair p = (Pair) o;
            return this.x == p.x && this.y == p.y;
        }
    }

    @Override
    public int hashCode() {
        // System.out.println("inside hashcode");
        return Arrays.hashCode(new int[] { this.x, this.y });
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}