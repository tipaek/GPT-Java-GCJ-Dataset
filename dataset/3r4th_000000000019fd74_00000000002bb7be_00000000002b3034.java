
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int numPat = in.nextInt();
            in.nextLine();
            String[][] patterns = readPat(numPat, in);
            System.out.println("Case #" + i + ": " + solve(patterns) );
        }
    }

    public static String[][] readPat(int numPat, Scanner in){
        String[][] patterns = new String[numPat][2];
        for (int i = 0; i < numPat; i++){
            String pattern = in.nextLine();
            if (pattern.substring(pattern.length()-1).equals("*")){
                pattern += "x";
                patterns[i] = pattern.split("\\*");
                int length = patterns[i].length;
                patterns[i][length - 1] = "";
            } else {
                patterns[i] = pattern.split("\\*");
            }
        }
        return patterns;
    }

    public static String solve(String[][] patterns){
        String[] maxLen = new String[2];
        maxLen[0] = "";
        maxLen[1] = "";
        for (int i = 0; i < patterns.length; i++){
            if (patterns[i][0].length() > maxLen[0].length()){
                maxLen[0] = patterns[i][0];
            }
            if (patterns[i][1].length() > maxLen[1].length()){
                maxLen[1] = patterns[i][1];
            }
        }
        for (int i = 0; i < patterns.length; i++){
            if (!patterns[i][0].equals("")){
                if (!(patterns[i][0].equals(maxLen[0].substring(0, patterns[i][0].length())))){
                    return "*";
                }
            }

            if (!patterns[i][1].equals("")){
                if (!(patterns[i][1].equals(maxLen[1].substring(maxLen[1].length() - patterns[i][1].length())))){
                    return "*";
                }
            }

        }
        return maxLen[0] + maxLen[1];
    }
}