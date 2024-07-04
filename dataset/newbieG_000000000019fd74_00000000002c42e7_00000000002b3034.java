import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static ArrayList<String> patternList = new ArrayList<>();

    public static void main(String[] args) {
        int testCase;
        int numberOfPattern;
        String[] result;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        testCase = Integer.parseInt(in.nextLine().trim());
        result = new String[testCase];
        for(int i=0; i<testCase; i++){
            int smallestLength = -1;
            String smallestPattern = null;
            int smallestIndex = -1;
            int largestIndex = -1;
            int largestLength = -1;
            String largestPattern = null;
            numberOfPattern = Integer.parseInt(in.nextLine().trim());
            for (int j=0; j<numberOfPattern; j++) {
                String inputString = in.nextLine().trim();
                patternList.add(inputString);
                if(inputString.length() < smallestLength || smallestLength == -1) {
                    smallestLength= inputString.length();
                    smallestPattern = inputString;
                    smallestIndex = j;
                }
                if(largestLength < inputString.length()) {
                    largestLength = inputString.length();
                    largestPattern = inputString;
                    largestIndex = j;
                }
            }
            result[i] = matchPattern(smallestPattern, smallestIndex, largestPattern, largestIndex);
        }
        for (int i = 0; i < testCase; i++) {
            if(result[i] == null)
                System.out.println("Case #" + (i + 1) + ": *");
            else
                System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }
    private static String matchPattern(String smallestPattern, int smallestIndex, String largestPattern, int largestIndex) {
            for(String pattern : patternList) {
                if(!pattern.endsWith(smallestPattern.substring(1,smallestPattern.length()))) {
                    patternList.clear();
                    return null;
                }
                if(!largestPattern.endsWith(pattern.substring(1))){
                    patternList.clear();
                    return null;
                }
            }
            patternList.clear();
        return largestPattern.substring(1,largestPattern.length());
    }
}
