
import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int numPat = in.nextInt();
            in.nextLine();
            String[] patterns = readPat(numPat, in);
            for (int j = 0; j < patterns.length; j++){
                System.out.println(patterns[j]);
            }

            System.out.println("Case #" + i + ": " + solve(patterns) );
        }
    }

    public static String[] readPat(int numPat, Scanner in){
        String[] patterns = new String[numPat];
        for (int i = 0; i < numPat; i++){
            patterns[i] = in.nextLine();
            if (patterns[i].length() == 1){
                patterns[i] = "";
            } else {
                patterns[i] = patterns[i].substring(1);
            }
        }
        return patterns;
    }

    public static String solve(String[] patterns){
        String maxLen = "";
        for (int i = 0; i < patterns.length; i++){
            if (patterns[i].length() > maxLen.length()){
                maxLen = patterns[i];
            }
        }
        for (int i = 0; i < patterns.length; i++){
            if (patterns[i].equals("")){
                continue;
            }
            if (!(patterns[i].equals(maxLen.substring(maxLen.length() - patterns[i].length())))){
                return "*";
            }
        }
        return maxLen;
    }
}