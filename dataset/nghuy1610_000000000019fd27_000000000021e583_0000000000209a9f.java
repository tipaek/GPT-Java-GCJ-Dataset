
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.InputStreamReader;


public class Solution {

    static String addParenthesis(String s) {
        if (s.equals("")) {return "";}
        if (s.equals("0")) {return "0";}
        StringBuilder sb = new StringBuilder();
        int idx;
        if ((idx = s.indexOf('0')) != -1) {
            String subString = s.substring(0, idx);
            sb.append(addParenthesis(subString));
            s = s.substring(idx+1);
            idx = s.indexOf('0');
            while (idx != -1) {
                sb.append("0" + addParenthesis(s.substring(0, idx)));
                s = s.substring(idx+1);
                idx = s.indexOf("0");
            }
            sb.append("0" + addParenthesis(s));
        } else {
            int min = 10;
            int pos = -1;
            for (char c : s.toCharArray()) {
                if (c - '0' < min) {
                    min = c - '0';
                }
            }
            StringBuilder strBuilder = new StringBuilder();
            for (char c : s.toCharArray()) {
                strBuilder.append((char)(c - min));
            }
            for (int i = 0; i < min; i++) {
                sb.append("(");
            }
            sb.append(addParenthesis(strBuilder.toString()));
            for (int i = 0; i < min; i++) {
                sb.append(")");
            }
        }
        return sb.toString();
    }

    static String nestingDepth(String s) {
        StringBuilder sb = new StringBuilder(addParenthesis(s));
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, s.charAt(count));
                count++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int round = scanner.nextInt();
        for (int i = 0; i < round; i++) {
            String s = scanner.next();
            System.out.printf("Case #%d: %s\n", i + 1, nestingDepth(s));
        }
    }
}
