import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            String s = in.nextLine();
            findSolution(i, s);
        }
    }

    public static void findSolution(int index, String s) {
        StringBuilder result = new StringBuilder();
        int pd = 0;
        int d = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            d = c - '0';
            for (int j = 0; j < pd - d; j++) {
                result.append(')');
            }
            for (int j = 0; j < d - pd; j++) {
                result.append('(');
            }
            result.append(c);
            pd = d;
        }
        d = 0;
        for (int i = 0; i < pd - d; i++) {
            result.append(')');
        }
        for (int i = 0; i < d - pd; i++) {
            result.append('(');
        }
        System.out.println("Case #" + index + ": " + result.toString());
    }
}
