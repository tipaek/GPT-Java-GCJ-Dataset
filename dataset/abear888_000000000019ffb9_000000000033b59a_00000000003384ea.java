import java.io.*;
import java.util.*;

// public class A {
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int cases = 1; cases <= t; cases++) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            long n = l + r;
            long left = 0;
            long right = 1000 * 1000 * 1000 * 2;
            long mid = 0;
            while (left + 1 < right) {
                mid = (left + right) / 2;
                if (n >= (mid * (mid + 1)) / 2 + 2 * (mid + 1)) { // works
                    left = mid;
                } else {
                    right = mid;
                }
            }
            long total = left + 1; // takes us under 2 * total
            // System.out.println(total);
            boolean left_large = true;
            if (r > l) left_large = false;
            // calculate size of first block
            long diff = Math.max(l, r) - Math.min(l, r);
            left = 0;
            right = diff;
            while (left + 1 < right) {
                mid = (left + right) / 2;
                if ((mid * (mid + 1)) / 2 <= diff) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            long first_block = left;
            if (left_large) {
                l -= (first_block * (first_block + 1)) / 2;
            } else {
                r -= (first_block * (first_block + 1)) / 2;
            }
            // System.out.println(l + " " + r);
            // alternating phase
            long remaining = total - first_block;
            if (l == r) {
                left_large = true;
            }
            long num = remaining / 2;
            // System.out.println(num + " " + remaining + " " + left_large);
            first_block++; // Our starting
            if (left_large) {
                l -= (num * first_block + num * (num - 1));
                r -= (num * (first_block + 1) + num * (num - 1));
                if (remaining % 2 == 1) l -= total;
            } else {
                l -= (num * (first_block + 1) + num * (num - 1));
                r -= (num * first_block + num * (num - 1));
                if (remaining % 2 == 1) r -= total;
            }
            // System.out.println(l + " " + r);
            // Possibly one more
            if (l >= total + 1) {
                l -= total + 1;
                total++;
            } else if (r >= total + 1) {
                r -= total + 1;
                total++;
            }
            System.out.println("Case #" + cases + ": " + total + " " + l + " " + r);
        }
    }
}
