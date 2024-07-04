import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // long startTime = System.nanoTime();
        /////////////////////////////////////////////////////
        int numCases = sc.nextInt();
        int b = sc.nextInt();

        for (int caseNo = 1; caseNo <= numCases; ++caseNo) {
            String ans = "";
            for (int i = 1; i <= b; ++i) {
                System.out.println(i);
                System.out.flush();
                String response = sc.next();
                ans += response;
            }
            System.out.println(ans);
            String result = sc.next();
            if (result.equals("Y")) {
                continue;
            } else {
                return;
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
    public int z;

    public Pair(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
            return this.x == p.x && this.y == p.y && this.z == p.z;
        }
    }

    @Override
    public int hashCode() {
        // System.out.println("inside hashcode");
        return Arrays.hashCode(new int[] { this.x, this.y, this.z });
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}