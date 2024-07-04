
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int patternCount = in.nextInt();
            String possibleMatch = "*";
            for (int j = 1; j <= patternCount; ++j) {
                String current = in.next();
                if (j == 1) {
                    possibleMatch =current;
                }else{
                    String[] possibleMatchSubs = possibleMatch.split("\\*");
                    String[] currentSubs = current.split("\\*");
                    boolean notPossible = false;
                    boolean isFound = false;
                    if (current.length() < possibleMatch.length() + 1){
                        for (String p : possibleMatchSubs){
                            for (String c : currentSubs){
                                if (p.contains(c) && (!c.equals("") && !p.equals(""))) {
                                    isFound = true;
                                    break;
                                }
                            }
                        }
                        if (!isFound) {
                            notPossible = true;
                        }
                    }else {
                        for (String c : currentSubs){
                            for (String p : possibleMatchSubs){
                                if (c.contains(p) && (!c.equals("") && !p.equals(""))) {
                                    isFound = true;
                                    possibleMatch = current.replace("*","");
                                    break;
                                }
                            }
                        }
                        if (!isFound) {
                            notPossible = true;
                        }
                    }
                    if (notPossible) {
                        possibleMatch = "*";
                    }
                }
            }

            System.out.println("Case #"+ i + ": " + possibleMatch);
        }
    }
}

