import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = sc.nextInt();
        for (int x = 1; x <= T; x++) {
            int n = sc.nextInt();

            String str1 = "";
            String str2 = "";
            String str3 = "";
            boolean end=false;
            ArrayList<String> beginnings = new ArrayList<>();
            ArrayList<String> endings = new ArrayList<>();
            String maxBegin = "";
            String maxEnd = "";
            String[] s = new String[n];
            for (int i = 0; i < n; i++) {
                s[i] = sc.next();
            }
            for (int i = 0; i < n; i++) {
                char[] c = s[i].toCharArray();
                int index = 0;
                for (int j = 0; j < s[i].length(); j++) {
                    if (c[j] == '*') {
                        index = j;
                    }
                }
                beginnings.add(s[i].substring(0, index));
                endings.add(s[i].substring(index + 1));
                if (s[i].substring(0, index).length() > maxBegin.length())
                    maxBegin = s[i].substring(0, index);

                if (s[i].substring(index + 1).length() > maxEnd.length())
                    maxEnd = s[i].substring(index + 1);
                if (index != 0 && index != s[i].length() - 1)
                    end=true;
            }
            int begNot = 0;
            for (int i = 0; i < beginnings.size(); i++) {
                String check = beginnings.get(i);
                String parent = maxBegin.substring(0, maxBegin.length() - (maxBegin.length() - check.length()));
                if (!check.equals(parent))
                    begNot = 1;
            }

            int endNot = 0;
            for (int i = 0; i < endings.size(); i++) {
                String check = endings.get(i);
                String parent = maxEnd.substring(maxEnd.length() - check.length());
                if (!check.equals(parent))
                    endNot = 1;
            }
            if (endNot == 0 && begNot == 0) {
                str1 = maxBegin;
                if (end)
                    str2="ABC";
                str3 = maxEnd;
                System.out.println("Case #" + x + ": " + (str1 + str2 + str3));
            } else
                System.out.println("Case #" + x + ": *");
        }
        sc.close();
    }
}