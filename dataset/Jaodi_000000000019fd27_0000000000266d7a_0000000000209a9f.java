import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String str = in.nextLine();
            String[] strs = str.split("");
            int[] ints = new int[strs.length];
            for (int j = 0; j < ints.length; j++) {
                ints[j] = Integer.parseInt(strs[j]);
            }
            int current = 0;
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] > current) {
                    for (int j2 = 0; j2 < ints[j] - current; j2++) {
                        sb.append("(");
                    }
                    current = ints[j];
                } else if (ints[j] < current) {
                    for (int j2 = 0; j2 < current - ints[j]; j2++) {
                        sb.append(")");
                    }
                    current = ints[j];
                }
                sb.append(ints[j]);
            }
            for (int j2 = 0; j2 < current; j2++) {
                sb.append(")");
            }
            System.out.println("Case #" + i + ": " + sb.toString());
        }
        in.close();
    }
}