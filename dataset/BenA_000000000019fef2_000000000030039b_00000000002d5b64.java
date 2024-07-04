import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(s.nextLine());
        String[] nums;
        for (int q = 1; q <= cases; q++) {
            nums = s.nextLine().split(" ");
            System.out.print("Case #"+q+": ");
            decks(Integer.parseInt(nums[0]),Integer.parseInt(nums[1]));
        }
    }
    public static void decks(int r, int s) {
        System.out.println(((r-1)*(s-1)));
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