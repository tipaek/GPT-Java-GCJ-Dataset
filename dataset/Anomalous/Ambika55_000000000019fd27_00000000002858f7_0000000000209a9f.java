import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();

        for (int i = 1; i <= t; i++) {
            String s = scn.next();
            StringBuilder ans = new StringBuilder();

            for (int j = 0; j < s.length(); ) {
                if (s.charAt(j) == '1') {
                    int onesCount = 1;
                    while (j + onesCount < s.length() && s.charAt(j + onesCount) == '1') {
                        onesCount++;
                    }
                    ans.append("(").append(s, j, j + onesCount).append(")");
                    j += onesCount;
                } else {
                    ans.append(s.charAt(j));
                    j++;
                }
            }

            System.out.println("Case #" + i + ": " + ans.toString());
        }
    }
}