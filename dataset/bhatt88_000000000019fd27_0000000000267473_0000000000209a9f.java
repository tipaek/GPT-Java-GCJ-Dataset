import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        for (int c = 0; c < cases; c++) {
            String line = br.readLine();
            line = "0" + line + "0";
            int len = line.length();
            String s = "";
            for (int i = 1; i < len; i++) {
                int cur = Integer.parseInt(line.charAt(i) + "");
                int prev = Integer.parseInt(line.charAt(i - 1) + "");
                if (cur != prev) {
                    char ch = (cur > prev) ? '(' : ')';
                    for (int x = 0; x < Math.abs(cur - prev); x++) {
                        s += ch;
                    }
                }
                if (i != len - 1) s += cur;
            }
            System.out.println("Case #" + (c + 1) + ": " + s);
        }
    }

}