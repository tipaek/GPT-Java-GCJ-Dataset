import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] t = s.nextLine().split(" ");
        int tests = Integer.parseInt(t[0]);
        int r = Integer.parseInt(t[1]);
        for (int q = 0; q < tests; q++) {
            interact(1000000000 - r);
        }
    }
    public static void interact(int p) {
        int move = p / 5;
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
        for (int x = 1000000000-p-move; x <= 1000000000-p+move; x++) {
            for (int i = 1000000000-p-move; i <= 1000000000-p+move; i++) {
                System.out.println((left + x)+" "+(bottom + i));
                System.out.flush();
                r = s.nextLine();
                if (r.equals("CENTER")) {
                    return;
                }
                if (r.equals("WRONG")) {
                    System.exit(1);
                }
            }
        }
        System.exit(1);
    }
}