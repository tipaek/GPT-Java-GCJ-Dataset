import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(in.nextLine());
            String[] strs = new String[N];
            for (int i = 0; i < N; i++) {
                strs[i] = in.nextLine();
            }

            String left = helperLeft(strs);
            String right = helperRight(strs);
            String res = "";
            if (!left.equals("-") && !right.equals("-")) {
                StringBuilder sb = new StringBuilder();
                sb.append(left);
                for (String str: strs) {
                    String[] temp = str.split("\\*");
                    for (int i = 1; i < temp.length - 1; i++) sb.append(temp[i]);
                    if (temp.length != 1 && str.charAt(str.length() - 1) == '*') sb.append(temp[temp.length-1]);
                }
                sb.append(right);
                res = sb.toString();
            }

            if (!res.equals(""))  System.out.println("Case #" + t + ": " + res);
            else System.out.println("Case #" + t + ": *");
        }
    }

    public static String helperLeft(String[] strs) {
        int[] ptrs = new int[strs.length];
        String longestLeft = "";
        int status = 0;
        while (status == 0) {
            boolean doneAll = true;
            char prevChar = '0';
            for (int i = 0; i < strs.length; i++) {
                if (ptrs[i] >= strs[i].length()) continue;
                else if (strs[i].charAt(ptrs[i]) == '*') continue;
                else if (prevChar != '0' && prevChar != strs[i].charAt(ptrs[i])) status = -1;
                else if (prevChar == '0') prevChar = strs[i].charAt(ptrs[i]);

                ptrs[i] ++;
                doneAll = false;
            }
            if (prevChar != '0') longestLeft += prevChar;
            if (doneAll) status = 1;
        }
        if (status == 1) return longestLeft;
        else return "-";
    }

    public static String helperRight(String[] strs) {
        int[] ptrs = new int[strs.length];
        for (int i = 0; i < strs.length; i++)
            ptrs[i] = strs[i].length() - 1;
        int status = 0;
        StringBuilder sb = new StringBuilder();

        while (status == 0) {
            boolean doneAll = true;
            char prevChar = '0';
            for (int i = 0; i < strs.length; i++) {
                if (ptrs[i] < 0) continue;
                else if (strs[i].charAt(ptrs[i]) == '*') continue;
                else if (prevChar != '0' && prevChar != strs[i].charAt(ptrs[i])) status = -1;
                else if (prevChar == '0') prevChar = strs[i].charAt(ptrs[i]);

                ptrs[i] --;
                doneAll = false;
            }
            if (prevChar != '0') sb.append(prevChar);
            if (doneAll) status = 1;
        }
        if (status == 1) return sb.reverse().toString();
        else return "-";
    }
}