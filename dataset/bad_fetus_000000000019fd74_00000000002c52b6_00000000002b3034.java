import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(sc.nextLine());
        for (int testCase = 0; testCase < testCount; testCase++) {
            int patternCount = Integer.parseInt(sc.nextLine());
            Patterns patterns = new Patterns();
            for (int patternNo = 0; patternNo < patternCount; patternNo++) {
                patterns.add(sc.nextLine());
            }

            System.out.println("Case #" + (testCase + 1) + ": " + patterns.solution());

        }
        sc.close();
    }

    static class Patterns{
        List<String> patternList = new ArrayList<>();
        int longestPatternIndex = 0;
        int longestPatternLength = -1;

        void add(String pattern){
            patternList.add(pattern);
            if(pattern.length() > longestPatternLength){
                longestPatternLength = pattern.length();
                longestPatternIndex = patternList.size()-1;
            }
        }

        String solution(){
            String longestPattern = patternList.get(longestPatternIndex).substring(1);
            for(String string: patternList){
                if(!longestPattern.contains(string.substring(1))){
                    return ("*");
                }
            }
            return longestPattern;
        }
    }
}
