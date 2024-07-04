

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        int r = in.nextInt(); // 10^9 - 5
        r = in.nextInt();
        for (int i = 1; i <= t; i++) {
            solve(i, in, r);
        }
    }

    private static void solve(int caseNum, Scanner in, int r) {
        for (int x = -5; x <= 5; x++) {
            for (int y = -5; y <= 5; y++) {
                System.out.println(x + " " + y);
                System.out.flush();
                String result = in.nextLine();
                if (result.equals(""))
                    result = in.nextLine();
                if (result.equals("CENTER"))
                    return;
            }
        }
    }
}
