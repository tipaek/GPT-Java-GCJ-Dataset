import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // long startTime = System.nanoTime();
        /////////////////////////////////////////////////////
        int numCases = sc.nextInt();

        for (int caseNo = 1; caseNo <= numCases; ++caseNo) {
            String in = sc.next();
            StringBuilder sb = new StringBuilder(in);
            int d = 0;
            for (int i = 0; i < sb.length(); ++i) {
                char c = sb.charAt(i);
                if (!Character.isDigit(c)) {
                    continue;
                }
                int v = Integer.parseInt("" + c);
                if (d == v) {
                    continue;
                }
                while (d < v) {
                    sb.insert(i, "(");
                    ++d;
                }
                while (d > v) {
                    sb.insert(i, ")");
                    --d;
                }
            }
            while (d > 0) {
                sb.append(")");
                --d;
            }
            System.out.println("Case #" + caseNo + ": " + sb.toString());
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