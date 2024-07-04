import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            String[] patterns = new String[n];
            String longest = "";
            String smallest = "";
            int small = Integer.MAX_VALUE;
            

            for (int j = 0; j < n; ++j) {
                patterns[j] = in.next();
                if(patterns[j].length() > longest.length()){
                    longest = patterns[j];
                }
                if(patterns[j].length() < small){
                    smallest = patterns[j];
                    small = smallest.length();
                }
                patterns[j] = patterns[j].substring(1, patterns[j].length());
            }


            int index = smallest.indexOf("*");
            smallest = smallest.substring(0, index) +  ".*" + smallest.substring(index + 1, smallest.length());

            String ans = longest;
            for(int j = 0; j < n; ++j) {
                boolean b3 = Pattern.matches(smallest, patterns[j]);
                if(b3 == false){
                    ans = "*";
                    break;
                }
            }

            if(ans!= "*") {
                int index2 = longest.indexOf("*");
                ans = longest.substring(0, index2) + longest.substring(index2 + 1, longest.length());
            }
            System.out.println("Case #" + i + ": " + ans);
        }
    }
}