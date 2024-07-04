import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(s.nextLine());
        String ans;
        String[] dirs;
        for (int q = 1; q <= cases; q++) {
            dirs = s.nextLine().split(" ");
            ans = ihop(Integer.parseInt(dirs[0]),Integer.parseInt(dirs[1]));
            System.out.println("Case #"+q+": "+ans);
        }
    }
    public static String ihop(int left, int right) {
        return ihop(left,right,1);
    }
    public static String ihop(int left, int right, int cus) {
        if (right > left) {
            if (cus > right) {
                return cus-1 + " " + left + " " + right;
            }
            return ihop(left,right-cus,cus+1);
        }
        else {
            if (cus > left) {
                return cus-1 + " " + left + " " + right;
            }
            return ihop(left-cus,right,cus+1);
        }
    }
}