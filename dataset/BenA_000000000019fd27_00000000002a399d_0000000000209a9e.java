import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String r;
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = Integer.parseInt(s.nextLine().split(" ")[0]);
        for (int q = 0; q < tests; q++) {
            String ans = "";
            for (int x = 1; x <= 10; x++) {
                System.out.println(x);
                r = s.nextLine();
                if (r.equals("N")) {
                    System.exit(1);
                }
                ans += r;
                System.out.flush();
            }
            System.out.println(ans);
            r = s.nextLine();
            if (r.equals("N")) {
                System.exit(1);
            }
            System.out.flush();
        }
    }
}