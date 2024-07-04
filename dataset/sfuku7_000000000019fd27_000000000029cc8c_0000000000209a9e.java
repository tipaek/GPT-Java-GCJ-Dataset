import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();
        int B = sc.nextInt();
        for (int t = 1; t <= T; t++) {

            int[] ans = new int[B];
            int pos = 1;
            for (int i = 1; i <= 150 && pos <= B; i++) {
                System.out.println(pos);
                ans[pos-1] = sc.nextInt();
                pos++;
            }
            //System.err.println(Arrays.toString(ans));
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < B; i++) {
                s.append(ans[i]);
            }
            System.out.println(s.toString());
            String res = sc.next();
            if (res.equals("N")) {
                return;
            }
        }
    }
}

