import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = Integer.parseInt(s.nextLine().split(" ")[0]);
        for (int q = 0; q < tests; q++) {
            interact();
        }
    }
    public static void interact() {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int left = -1000000001;
        int right = 1000000001;
        int bottom = -1000000001;
        int top = 1000000001;
        String r = "";
        while (!r.equals("HIT")) {
            left++;
            System.out.println(left + " 0");
            System.out.flush();
            r = s.nextLine();
            if (r.equals("WRONG")) {
                System.exit(1);
            }
        }
        r = "";
        while (!r.equals("HIT")) {
            bottom++;
            System.out.println("0 " + bottom);
            System.out.flush();
            r = s.nextLine();
            if (r.equals("WRONG")) {
                System.exit(1);
            }
        }
        for (int x = 999999994; x <= 999999996; x++) {
            for (int i = 999999994; i <= 999999996; i++) {
                System.out.println((left + x)+" "+(bottom + i));
                System.out.flush();
                if (s.nextLine().equals("CENTER")) {
                    return;
                }
            }
        }
    }
}