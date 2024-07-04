
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int patternCount = in.nextInt();
            boolean notPossible = false;
            String possibleMatch = "*";
            for (int j = 1; j <= patternCount; ++j) {
                String current = in.next();
                if (j == 1) {
                    possibleMatch =current;
                }else{
                    String[] possibleMatchSubs = possibleMatch.split("\\*");
                    String[] currentSubs = current.split("\\*");
                    boolean isFound = false;
                    if (current.length() < possibleMatch.length() + 1){
                        for (int pIndex = 0; pIndex < possibleMatchSubs.length; pIndex++){
                            for (int cIndex = 0; cIndex < currentSubs.length; cIndex++){
                                if (possibleMatchSubs[pIndex].contains(currentSubs[cIndex]) &&
                                        (!currentSubs[cIndex].equals("") && !possibleMatchSubs[pIndex].equals(""))
                                        && pIndex == cIndex) {
                                    isFound = true;
                                    break;
                                }
                            }
                        }
                        if (!isFound) {
                            notPossible = true;
                        }
                    }else {
                        for (int cIndex = 0; cIndex < currentSubs.length; cIndex++){
                            for (int pIndex = 0; pIndex < possibleMatchSubs.length; pIndex++){
                                if (currentSubs[cIndex].contains(possibleMatchSubs[pIndex])
                                        && (!currentSubs[cIndex].equals("") && !possibleMatchSubs[pIndex].equals(""))
                                && pIndex == cIndex) {
                                    isFound = true;
                                    possibleMatch = current;
                                    break;
                                }
                            }
                        }
                        if (!isFound) {
                            notPossible = true;
                        }
                    }
                }
            }
            if (notPossible) {
                possibleMatch = "*";
            }else
                possibleMatch = possibleMatch.replace("*","");
            System.out.println("Case #"+ i + ": " + possibleMatch);
        }
    }
}

