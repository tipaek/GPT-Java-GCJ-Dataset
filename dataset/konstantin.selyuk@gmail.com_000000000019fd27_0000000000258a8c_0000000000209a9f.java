import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            String s = scanner.nextLine();
            StringBuilder res = processDigit(s, 0);
            System.out.println("Case #" + (i + 1) + ": " + res);
        }
    }

    public static StringBuilder processDigit(String s, int d) { //, int countOFParentheses
        StringBuilder sb1 = new StringBuilder(), sbDigit = new StringBuilder();
        ArrayList<StringBuilder> parts1 = new ArrayList<>(), partsDigit = new ArrayList<>();
        int count = 0;
        while (count < s.length()) {
            if (s.charAt(count) - '0' == d) {
                if (sb1.length() != 0) {
                    parts1.add(sb1);
                    sb1 = new StringBuilder();
                }
                sbDigit.append(s.charAt(count));
            } else {
                if (sbDigit.length() != 0) {
                    partsDigit.add(sbDigit);
                    sbDigit = new StringBuilder();
                }
                sb1.append(s.charAt(count));
            }
            count++;
        }
        if (sb1.length() != 0) {parts1.add(sb1);}
        if (sbDigit.length() != 0) {partsDigit.add(sbDigit);}
        for (int i = 0; i < parts1.size(); i++) {
            int dd = isAllEqual(parts1.get(i));
            if (dd != -1) {
                int cc = dd - d;
                for (int j = 0; j < cc; j++) {
                    parts1.get(i).insert(0, "(");
                    parts1.get(i).append( ")");
                }
            } else {
                dd = getMin(parts1.get(i));
                StringBuilder newSb = processDigit(parts1.get(i).toString(), dd);
                parts1.get(i).setLength(0);
                parts1.get(i).append(newSb);
                int cc = dd - d;
                for (int j = 0; j < cc; j++) {
                    parts1.get(i).insert(0, "(");
                    parts1.get(i).append( ")");
                }
            }
        }

        return (s.charAt(0) - '0' == d) ? merge(partsDigit, parts1) : merge(parts1, partsDigit);
    }

    public static StringBuilder merge(ArrayList<StringBuilder> first, ArrayList<StringBuilder> second) {
        StringBuilder sb = new StringBuilder();
        int len = Math.min(first.size(), second.size());
        for (int i = 0; i < len; i++) {
            sb.append(first.get(i));
            sb.append(second.get(i));
        }
        if (first.size() != len) {
            sb.append(first.get(len));
        }
        return sb;
    }

    public static int isAllEqual(StringBuilder sb) {
        char ch1 = sb.charAt(0);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != ch1) {
                return -1;
            }
        }
        return ch1 - '0';
    }

    public static int getMin(StringBuilder sb) {
        int min = sb.charAt(0) - '0';
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) - '0' < min) {
                min = sb.charAt(i) - '0';
            }
        }
        return min;
    }
}
