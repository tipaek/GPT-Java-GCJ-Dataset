import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = Integer.parseInt(in.nextLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(in.nextLine());
            List<String> list = new ArrayList<>();
            String longest = "";
            String ans = "";
            for (int n = 1; n <= N; n++) {
                String p = in.nextLine();
                int pLen = p.length();
                if (pLen > longest.length()) {
                    longest = p.replace("*", "");
                    if (pLen <= 10000)
                        ans = longest;
                }
                list.add(p);
            }
            if (solve(list, longest)) {
                System.out.println("Case #" + t + ": " + ans);
            } else {
                System.out.println("Case #" + t + ": *");
            }
        }
    }

    private static boolean solve(List<String> list, String longest) {
        for (String s : list) {
            if (s.charAt(0) == '*') {
                s = s.substring(1);
                int index = s.length()-1;
                int lIndex = longest.length()-1;
                boolean matches = true;
                while (index >= 0 && matches) {
                    matches = s.charAt(index) == longest.charAt(lIndex);
                    index--;
                    lIndex--;
                }
                if (!matches)
                    return false;
            } else if (s.charAt(s.length()-1) == '*') {
                s = s.substring(0, s.length()-1);
                int index = 0;
                boolean matches = true;
                while (index < s.length() && matches) {
                    matches = s.charAt(index) == longest.charAt(index);
                    index++;
                }
                if (!matches)
                    return false;
            } else {
                String[] m = s.split("\\*");
                if (m.length == 2) {
                    String s1 = m[0];
                    String s2 = m[1];

                    int index = 0;
                    boolean matches = true;
                    while (index < s1.length() && matches) {
                        matches = s1.charAt(index) == longest.charAt(index);
                        index++;
                    }
                    if (!matches)
                        return false;

                    index = s2.length()-1;
                    int lIndex = longest.length()-1;
                    while (index >= 0 && matches) {
                        matches = s2.charAt(index) == longest.charAt(lIndex);
                        index--;
                        lIndex--;
                    }
                    if (!matches)
                        return false;
                }
            }


        }
       return true;
    }
}
