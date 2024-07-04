import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int c = 0; c < t; c++) {

            String S = in.nextLine();
            String partial = addPar(S);
            // System.err.println("Partial " + partial);
            String sol = replace(S, partial);

            System.out.println("Case #" + (c + 1) + ": " + sol);
        }
    }

    public static String replace(String original, String partial) {
        StringBuilder sb = new StringBuilder();
        int pointer = 0;

        for (char c : partial.toCharArray()) {
            if (c == '0') {
                sb.append(original.charAt(pointer));
                pointer++;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String addPar(String S) {
        // System.err.println("S " + S);
        char[] sChar = S.toCharArray();
        if (sChar.length == 1 && sChar[0] == '0') {
            return new String(sChar);
        }

        ArrayList<String> list = new ArrayList<String>();
        String temp = "";
        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] != '0') {
                char valChar = sChar[i];
                int newValue = (int) valChar - 1;
                temp += newValue - '0';
                // System.err.println("temp " + temp);
            } else {
                if (temp.length() > 0) {
                    list.add(temp);
                }
                list.add("*");
                temp = "";
            }
        }
        if (!temp.equals("")) {
            list.add(temp);
        }

        String result = "";
        // System.err.println("list " + list);

        for (String sub : list) {
            String piece = "";
            if (!sub.equals("*")) {
                piece = '(' + addPar(sub) + ')';
            } else {
                piece = addPar("0");
            }
            result += piece;
        }

        return result;
    }
}
