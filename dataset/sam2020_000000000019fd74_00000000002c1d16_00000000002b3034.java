import java.util.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        int counter = 1;

        while(testCases -- > 0) {
            int num = Integer.parseInt(sc.nextLine());
            String[] strs = new String[num];
            String longest = "";
            String longestPattern = "";
            for(int i = 0; i < num; i++) {
                strs[i] = sc.nextLine();
                if(longest.length() < strs[i].length()) {
                    longest = strs[i];
                    longestPattern = longest;
                }
            }
            longest = longest.replace("*", "");
            boolean isMatched = true;
            for(int i = 0; i < num; i++) {
                String test = strs[i].replace("*", ".*");
                boolean matches = Pattern.matches(test, longest);
                if(matches == false) {
                    if((strs[i].indexOf('*') == 0 && longestPattern.indexOf('*') == longestPattern.length() - 1) || (strs[i].indexOf('*') == strs[i].length() - 1 && longestPattern.indexOf('*') == 0)) {
                        String tempL = longest + strs[i].replace("*", "");
                        String tempR = strs[i].replace("*", "") + longest;
                        boolean matchesL = Pattern.matches(test, tempL);
                        boolean matchesR = Pattern.matches(test, tempR);
                        if(matchesL == false && matchesR == false) {
                            isMatched = false;
                        }
                        if(matchesL == true) {
                            longest = tempL;
                        }
                        else if(matchesR == true) {
                            longest = tempR;
                        }
                    }
                    else {
                        isMatched = false;
                    }
                }
            }

            if(isMatched == true) {
                System.out.println("Case #"+counter+": "+longest);
            }
            else {
                System.out.println("Case #"+counter+": *");
            }
            
            counter++;
        }
    }
}