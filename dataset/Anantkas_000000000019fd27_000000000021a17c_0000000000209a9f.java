import java.util.*;
import java.io.*;

public class Solution {

    private static String magic(String str) {
        str += "0";
        String newStr = "";
        int current = 0;

        for (int i = 0; i < str.length(); i++) {
            int depth = Integer.parseInt(str.charAt(i) + "");
            int diff = current - depth;

            for (int j = 0; j < Math.abs(diff); j++) {
                newStr += diff < 0 ? "(" : ")";
            }

            newStr += depth;
            current = depth;
        }

        return newStr.substring(0, newStr.length() -1 );

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();

        for (int i = 1; i <= t; ++i) {
            String str = in.nextLine();
            System.out.println("Case #" + i + ": " + magic(str));
        }
    }
}