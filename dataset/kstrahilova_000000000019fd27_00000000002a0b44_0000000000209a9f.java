import java.util.*;
import java.io.*;
//import org.apache.commons.lang3.StringUtils;
//import java.lang.Object.*;//.org.apache.commons.lang3.StringUtils;
public class Solution {

    /*public String sPrime(String s) {
        String result = "";
        String help = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < Integer.valueOf(s.charAt(i)); j++) {
                result += "(";

            }
        }
    }*/

    public String sPrime9(String s) {
        int open = 0;
        int closed = 0;
        String result = "";
        char[] p1;
        char[] p2;
        for (int i = 0; i < s.length(); i++) {
            int elementi = new Integer(s.substring(i,i+1));
            int n = elementi - (open - closed);
            if (n > 0) { //if elementi > open open more parenteses
                p1 = new char[n];
                Arrays.fill(p1, '(');
                result += new String(p1);
                open += p1.length;
                result += elementi;
            } else if (n < 0){
                p2 = new char[-n];
                Arrays.fill(p2, ')');
                result += new String(p2);
                closed += p2.length;
                result += elementi;
            } else {
                result += elementi;
            }
        }

        if (open > closed) {
            int n = open - closed;
            p2 = new char[n];
            Arrays.fill(p2, ')');
            result += new String(p2);
        }
        return result;
    }

    public String sPrime(String old, String s) {
        System.out.println(s);
        if (s.length() == 0) {
            return "";
        }
        if (old == null) {
            int element1 = new Integer(s.substring(0,1));
            char[] p1 = new char[element1];
            char[] p2 = new char[element1];
            Arrays.fill(p1, '(');
            Arrays.fill(p2, ')');
            return new String(p1) + element1 +  sPrime(s.substring(0,1), s.substring(1)) + new String(p2);
        } else if (s.substring(0,1).equals(old)) {
            return s.substring(0,1) + sPrime(s.substring(0,1), s.substring(1));
        } else  {
            int element1 = new Integer(s.substring(0,1));
            char[] p1 = new char[element1];
            char[] p2 = new char[element1];
            Arrays.fill(p1, '(');
            Arrays.fill(p2, ')');
            return new String(p1) + element1 + sPrime(s.substring(0,1), s.substring(1)) + new String(p2);
        }
    }
    public static void main(String[] args) {
        Solution instance = new Solution();
        String result = "";
        Scanner in = new Scanner(System.in);//new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();

        for (int i = 1; i <= t; ++i) {
            String s = in.nextLine();
            String[] split;
            //only needed with the strictly 0 1 version
            /*if (s.contains("0")) {
                split = s.split("0", -1);
                for (int j = 0; j < split.length; j++) {
                    split[j] = instance.sPrime(null, split[j]);
                }
                result = String.join("0", split);
            } else {
                result = instance.sPrime(null, s);
            }*/
            result = instance.sPrime9(s);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}