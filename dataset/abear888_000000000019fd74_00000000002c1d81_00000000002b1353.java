import java.io.*;
import java.util.*;

// public class B {
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int cases = 1; cases <= t; cases++) {
             int n = sc.nextInt();
             boolean even = (n % 2 == 0);
             String bin = Integer.toBinaryString(n);
             boolean left = true;
             ArrayList<Integer> r = new ArrayList<Integer>();
             ArrayList<Integer> c = new ArrayList<Integer>();
             int extra = 0;
             while (n > 0) {
                 if (n == 1) {
                     r.add(1); c.add(1);
                     n = 0;
                 } else if (bin.charAt(0) == '1') {
                    // Check if remaining is enough to get to top.
                    int remaining = n - (int) Math.pow(2, bin.length() - 1);
                    if (remaining < bin.length() - 1) {
                        r.add(bin.length());
                        if (left) c.add(1);
                        if (!left) c.add(bin.length());
                        extra = n - ((int)Math.pow(2, bin.length() - 1));
                        n = (int)Math.pow(2, bin.length() - 1) - 1;
                        bin = Integer.toBinaryString(n);
                    } else {
                        for (int i = 0; i < bin.length(); i++) {
                            r.add(bin.length());
                            if (left) c.add(i+1);
                            if (!left) c.add(bin.length() - i);
                        }
                        left = !left;
                        n -= Math.pow(2, bin.length() - 1);
                        bin = bin.substring(1, bin.length());
                    }
                 } else {
                     r.add(bin.length());
                     if (left) c.add(1);
                     if (!left) c.add(bin.length());
                     n -= 1;
                     bin = Integer.toBinaryString(n);
                 }

             }
             System.out.println ("Case #" + cases + ":");
            for (int i = r.size() - 1; i >= 0; i--) {
                System.out.println(r.get(i) + " " + c.get(i));
            }
            int last_row = r.get(0);
            for (int i = 1; i <= extra; i++) {
                System.out.println(last_row + i + " " + 1);
            }
        }
    }
}

