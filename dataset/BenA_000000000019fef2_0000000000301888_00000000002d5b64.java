import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(s.nextLine());
        String[] nums;
        int r;
        int su;
        for (int q = 1; q <= cases; q++) {
            nums = s.nextLine().split(" ");
            r = Integer.parseInt(nums[0]);
            su = Integer.parseInt(nums[1]);
            System.out.println("Case #"+q+": "+((r*su)-r-su+1));
            decks(r,su);
        }
    }
    public static void decks(int r, int s) {
        int sort = 1;
        int incr = r-1;
        while (incr > 0) {
            for (int i = 1; i < s; i++) {
                System.out.println((r*s-incr-sort)+" "+incr);
                sort++;
            }
            incr--;
            sort++;
        }
    }
}