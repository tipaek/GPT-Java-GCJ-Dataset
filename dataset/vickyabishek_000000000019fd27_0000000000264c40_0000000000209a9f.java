import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
            for (int tc = 1; tc <= t; ++tc) {
                String digits = in.next();
                String result = "";
                String currentCache = String.valueOf( digits.charAt(0) );
                int cacheValue = Integer.parseInt(currentCache);

                // 54443255
                for(int i=1; i<digits.length(); i++ ) {
                    String currentValue = String.valueOf(digits.charAt(i));

//                    get chars and store
//                    if stored char doesnt match with current char
//                            append existin char
                    if( !String.valueOf(cacheValue).equals(currentValue) ) {
                        //when there is a new character, we are appending the existing chars
                        result += getParenthesised( currentCache, cacheValue );
                        currentCache = currentValue;
                        cacheValue = Integer.parseInt(currentCache);
                    } else {
                        // when there is an continuous characters
                        currentCache += currentValue;
                        cacheValue = Integer.parseInt(currentValue);
                    }
                }
                result += getParenthesised( currentCache, cacheValue );
                System.out.println("Case #" + tc + ": " + result);
            }
    }

    public static String getParenthesised(String s, int n) {
        if( n == 0 ) return s;
        String openingBraces = "", closingBraces = "";
        for(int i=0; i<n; i++) {
            openingBraces += "(";
            closingBraces += ")";
        }
        return openingBraces + s + closingBraces;
    }

}

//        1