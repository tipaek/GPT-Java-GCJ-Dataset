import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        int bytes = in.nextInt();

        // Solve each test case
        for (int i=1; i<cases+1; i++) {
            solve(i, in, bytes);
        }
    }

    public static void solve(int i, Scanner in, int bytes) {
        int number[] = new int[bytes];
        // B = 10 Case
        if (bytes == 10) {
            // Easy? Just query all
            for (int j=1; j<bytes+1; j++) {
                System.out.println(j); // Auto flushes
                number[j-1] = in.nextInt();
            }
            StringBuffer sb = new StringBuffer();

            for (Integer s : number) {
                sb.append(s);
            }
            String str = sb.toString();
            System.out.println(str);

            if (in.next().equals("Y")) {
                return;
            } else {
                System.exit();
            }
        }
    }
}