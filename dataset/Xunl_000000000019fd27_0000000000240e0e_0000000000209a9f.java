import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; ++i) {
            insertParen(i, in.nextLine());
        }
    }

    public static void insertParen(int x, String s) {
        StringBuilder sb = new StringBuilder();
        int openNum = 0;
        for (char c : s.toCharArray()) {
            int dig = Character.getNumericValue(c);
            if (openNum < dig) {
                for (int i = openNum; i < dig; ++i) {
                    sb.append('(');
                }
                openNum = dig;
            }
            if (openNum > dig) {
                for (int i = openNum; i > dig; --i) {
                    sb.append(')');
                }
                openNum = dig;
            }
            sb.append(c);
        }
        for (int i = openNum; i > 0; --i) {
            sb.append(')');
        }
        System.out.println("Case #" + x +": " + sb.toString());
    }
}