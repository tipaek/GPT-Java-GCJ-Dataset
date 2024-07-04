import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
            for (int tc = 1; tc <= t; ++tc) {
                String digits = in.next();
                String result = "";
                String temp = null;
                for(int i=0; i<digits.length(); i++ ) {
                    if( digits.charAt(i) == '1' ) {
                        if ( temp == null )
                            temp = "1";
                        else
                            temp += "1";
                    } else if ( digits.charAt(i) == '0' ) {
                        if ( temp != null ) {
                            result += getParanthetised(temp);
                            temp = null;
                        }
                        result += "0";
                    }
                }
                if( temp != null ) {
                    result += getParanthetised(temp);
                    temp = null;
                }
              System.out.println("Case #" + tc + ": " + result);


            }
    }

    public static String getParanthetised(String s) {
        return "(" + s + ")";
    }
}
