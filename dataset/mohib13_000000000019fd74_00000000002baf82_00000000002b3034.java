import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            String[] patterns = new String[n];
            String longest="";
            for (int j = 0; j < n; ++j) {
                patterns[j] = in.next();
                if(patterns[j].length() > longest.length()){
                    longest = patterns[j];
                }
                patterns[j] = patterns[j].substring(1, patterns[j].length());
            }
            longest = longest.substring(1, longest.length());

            String ans = longest;
            for(int j = 0; j < n; ++j) {
                if(!longest.contains(patterns[j])){
                    ans = "*";
                    break;
                }
            }
            int index = 0;

            index = longest.indexOf("*");

            System.out.println("Case #" + i + ": " + ans);
        }
    }
}