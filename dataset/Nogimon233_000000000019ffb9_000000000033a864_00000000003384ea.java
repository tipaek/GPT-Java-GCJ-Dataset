import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        //.out.println("codejam");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String temp = in.nextLine();

        for (int i = 1; i <= t; ++i) {
            String line = in.nextLine();
            String[] ss = line.split(" ");
            long l = Long.parseLong(ss[0]);
            long r = Long.parseLong(ss[1]);

            String ans = solve(l, r);
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static String solve(long l, long r) {
        boolean leftLarge = (l >= r);
        long large;
        long small;
        if (leftLarge) {
            large = l;
            small = r;
        } else {
            large = r;
            small = l;
        }

        long pan = 1;

        long lc = 0, sc = 0;
        //let large and small match
        long n1 = binary(large - small, pan, 1);
        long an = pan + (n1-1);
        long sum = (pan + an) * n1 / 2;

        pan = an+1;
        large = large - sum;
        lc += n1;

        if (large == small && !leftLarge) {
            leftLarge = true;
        }

        //deduct large and small
        long n2 = binary(large, pan, 2);
        an = pan + (n2-1)*2;
        sum = (pan + an) * n2 / 2;
        large = large - sum;
        lc += n2;

        long n3 = binary(small, pan+1, 2);
        an = pan+1 + (n3-1)*2;
        sum = (pan+1 + an) * n3 / 2;
        small = small - sum;
        sc += n3;

        if (leftLarge)
            return String.valueOf(lc+sc) + " " + String.valueOf(large) + " " + String.valueOf(small);
        else
            return String.valueOf(lc+sc) + " " + String.valueOf(small) + " " + String.valueOf(large);



    }

    //number deduct how many pan to be still positive
    private static long binary(long number, long pan, int d) {
        if (number == 0) {
            return 0;
        }
        long low = 1, high = number / pan+1;
        while(low < high) {
            long mid = low + (high-low)/2;

            long an = pan + (mid-1)*d;
            long sum = (pan + an) * mid / 2;

            if (sum > 0 && sum <= number) {
                low++;
            } else {
                high = mid;
            }
        }

        long n = low-1;
        return n;

    }





}




class TrieNode{
    char c;
    int count;
    TrieNode[] next;
    public TrieNode(char _c){
        c = _c;
        next = new TrieNode[26];
        count = 0;
    }
}
