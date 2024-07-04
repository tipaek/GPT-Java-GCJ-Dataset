import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            long l = in.nextLong();
            long r = in.nextLong();
            long diff = Math.abs(l - r);
            long sqrt = (long)Math.floor(Math.sqrt(2. * (double)diff + .25) - .5);
            long res = sqrt;
            if (l >= r) {
                l-=((sqrt + 1) * sqrt )/ 2;
            } else {
                r-=((sqrt + 1) * sqrt )/ 2;
            }
            if (l >= r) {
                long extraL = (long)Math.floor(Math.sqrt((double)l + (double)res * (double)res / 4.) - .5 * res);
                l -= extraL*extraL + res*extraL;
                long extraR = (long)Math.floor(Math.sqrt((double)r+ (double)(res + 1) * (double)(res + 1) / 4.) - .5 * (double)(res+1));
                r -= extraR*extraR + (res+1)*extraR;
                res+=extraL+extraR;
            } else {
                long extraR = (long)Math.floor(Math.sqrt((double)r + (double)res * (double)res / 4.) - .5 * res);
                r -= extraR*extraR + res*extraR;
                long extraL = (long)Math.floor(Math.sqrt((double)l+ (double)(res + 1) * (double)(res + 1) / 4.) - .5 * (double)(res+1));
                l -= extraL*extraL + (res+1)*extraL;
                res+=extraL+extraR;
            }

            System.out.println("Case #" + i + ": " + res + " " + l + " " + r);
        }
        in.close();
    }
}