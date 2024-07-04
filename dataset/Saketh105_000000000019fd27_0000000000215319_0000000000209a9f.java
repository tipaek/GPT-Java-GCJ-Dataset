import java.io.*;
import java.util.*;

 class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            String s = scan.next();
            String sol = solve(s);
            System.out.println("Case #" + (i + 1) + ": " + sol);
        }
    }

    public static String solve(String s) {
        StringBuilder a = new StringBuilder(s.length());
        int lastNumNeeded = Integer.parseInt(s.substring(0, 0 + 1));
        for (int k = 0; k < lastNumNeeded; k++) {
            a.insert(0, "(");
        }
        a.append(s.substring(0, 0 + 1));
        for (int i = 1; i < s.length(); i++) {
            int numNeeded = Integer.parseInt(s.substring(i, i + 1));
            if (lastNumNeeded != numNeeded) {
                if (lastNumNeeded > numNeeded) {
                    int difference = lastNumNeeded - numNeeded;
                    for (int k = 0; k < difference; k++) {
                        a.append(")");
                    }
                } else {
                    int difference = numNeeded - lastNumNeeded;
                    for (int k = 0; k < difference; k++) {
                        a.append("(");
                    }
                }
            }
            lastNumNeeded = numNeeded;
            a.append(s.substring(i, i + 1));

        }
        for (int i = 0; i < lastNumNeeded; i++) {
            a.append(")");
        }
        return a.toString();
    }
}