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
            for(int i = 0; i < num; i++) {
                strs[i] = sc.nextLine();
                if(longest.length() < strs[i].length()) {
                    longest = strs[i];
                }
            }
            longest = longest.replace("*", "");
            boolean isMatched = true;
            for(int i = 0; i < num; i++) {
                strs[i] = strs[i].replace("*", ".*");
                boolean matches = Pattern.matches(strs[i], longest);
                if(matches == false) {
                    isMatched = false;
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