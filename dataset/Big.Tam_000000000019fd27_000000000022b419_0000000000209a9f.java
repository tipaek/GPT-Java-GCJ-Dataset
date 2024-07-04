import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int index = 1; index <= t; ++index) {
            String s = in.next();
            StringBuilder sb = new StringBuilder();

            int i = 0;
            while(i < s.length())
            {
                if(s.charAt(i) == '0') {
                    sb.append(s.charAt(i));
                }
                else if(s.charAt(i) == '1')
                {
                    int start = i;
                    while(i < s.length() && s.charAt(i) == '1')
                        i++;

                    sb.append("(" + s.substring(start, i) + ")");
                    i--;
                }
                i++;

            }



            System.out.println("Case #" + index + ": " + sb.toString());
        }
    }
}