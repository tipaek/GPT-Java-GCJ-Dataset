
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.*;
import java.io.*;

public class Solution {
    public static int maxCol = 0;

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
            if(patterns[i].length > maxCol){
                maxCol = patterns[i].length;
            }
        }
        return patterns;
    }

    public static String solve(String[][] patterns){
        //XD
        String[] maxLen = new String[2];
        maxLen[0] = "";
        maxLen[1] = "";
        String[] innerCol = new String[maxCol - 2];
        String inner = "";
        //XD
        for (int i = 0; i < patterns.length; i++){
            if (patterns[i][0].length() > maxLen[0].length()){
                maxLen[0] = patterns[i][0];
            }
            int patDex = patterns[i].length -1;
            if (patterns[i][patDex].length() > maxLen[1].length()){
                maxLen[1] = patterns[i][patDex];
            }
            for (int x = 1; x < patterns[i].length - 1;x++){
                inner += patterns[i][x];
            }
        }
        for (int i = 0; i < patterns.length; i++){
            if (!patterns[i][0].equals("")){
                if (!(patterns[i][0].equals(maxLen[0].substring(0, patterns[i][0].length())))){
                    return "*";
                }
            }
            int patDex = patterns[i].length -1;
            if (!patterns[i][patDex].equals("")){
                if (!(patterns[i][patDex].equals(maxLen[1].substring(maxLen[1].length() - patterns[i][patDex].length())))){
                    return "*";
                }
            }

        }
        return maxLen[0] + inner + maxLen[1];
    }
}