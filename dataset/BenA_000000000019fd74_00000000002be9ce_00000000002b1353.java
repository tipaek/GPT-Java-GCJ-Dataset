import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(s.nextLine());
        for (int q = 1; q <= cases; q++) {
            System.out.println("Case #" + q + ":");
            walk(Integer.parseInt(s.nextLine()));
        }
    }
    public static void walk(long n) {
        if (n <= 500) {
            for (long x = 1; x <= n; x++) {
                System.out.println(x + " 1");
                return;
            }
        }
        int s = 4;
        long last = 10;
        long tot = 10;
        while (tot < n) {
            last = tot;
            tot = tot + 1 + ((s*(s-1))/2);
            s++;
        }
        s--;
        tot = last;
        System.out.println("1 1");
        System.out.println("2 2");
        for (int x = 3; x <= s; x++) {
            System.out.println(x + " 3");
        }
        System.out.println(s + " 2");
        System.out.println(s + " 1");
        while (tot < n) {
            s++;
            System.out.println(s + " 1");
            tot++;
        }
    }
}