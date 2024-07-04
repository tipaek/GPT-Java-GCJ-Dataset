import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int tc = t;

        while (t > 0) {
            String s = scn.next();
            int currentOpen = 0;
            StringBuilder ans = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                int digit = Character.getNumericValue(s.charAt(i));
                int requiredOpen = digit - currentOpen;

                if (requiredOpen > 0) {
                    ans.append("(".repeat(requiredOpen));
                    currentOpen += requiredOpen;
                } else if (requiredOpen < 0) {
                    ans.append(")".repeat(-requiredOpen));
                    currentOpen += requiredOpen;
                }

                ans.append(digit);
            }

            ans.append(")".repeat(currentOpen));

            System.out.println("Case #" + (tc - t + 1) + ": " + ans);
            t--;
        }
    }
}