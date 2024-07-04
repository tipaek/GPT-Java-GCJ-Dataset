import java.util.*;
import java.io.*;

/*
4
0000
101
111000
1

 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= cases; ++i) {
            String s = in.next();
            String result = getResult(s);

            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String getResult(String s) {
        String result = "";
        int count = 0;
        for(int x = 0;x < s.length();x++){
            char c = s.charAt(x);
            if(c == '0'){
                if(count > 0) {
                    result += "(";
                    for (int i = 0; i < count; i++) {
                        result += '1';
                    }
                    result += ")";
                    count = 0;
                }
                result += c;
            }
            else{
                count++;
            }
        }
        if(count > 0){
            result += "(";
            for(int i = 0;i < count;i++){
                result += '1';
            }
            result += ")";
        }

        return result;
    }
}
