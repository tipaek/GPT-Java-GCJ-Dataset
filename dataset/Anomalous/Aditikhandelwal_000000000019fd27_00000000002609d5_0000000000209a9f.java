import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int tc = t;

        while (t != 0) {
            String s = scn.next();
            StringBuilder ans = new StringBuilder();
            int currentOpen = 0;

            for (int i = 0; i < s.length(); i++) {
                int currentDigit = Character.getNumericValue(s.charAt(i));
                int requiredOpen = currentDigit - currentOpen;

                if (requiredOpen > 0) {
                    ans.append("(".repeat(requiredOpen));
                    currentOpen += requiredOpen;
                } else if (requiredOpen < 0) {
                    ans.append(")".repeat(-requiredOpen));
                    currentOpen += requiredOpen;
                }

                ans.append(currentDigit);
            }

            ans.append(")".repeat(currentOpen));
            System.out.println("Case #" + (tc - t + 1) + ": " + ans);
            t--;
        }
    }
}