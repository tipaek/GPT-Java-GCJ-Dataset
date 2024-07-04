import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            long l = in.nextLong();
            long r = in.nextLong();
            long c = 1;
            while (true) {
                if (c > l && c > r) {
                    c--;
                    if (c == 0) c = 1;
                    break;
                }
                if (r > l) {
                    r -= c;
                } else {
                    l -= c;
                }
                c++;
            }
            System.out.println("Case #" + i + ": " + c + " " + l + " " + r);
        }
    }
}