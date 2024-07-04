import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testsCount = sc.nextInt();
        sc.nextLine();
        //
        for (int i = 1; i <= testsCount; i++) {
            String s = sc.nextLine();
            System.out.println("Case #" + i + ": " + modifyString(s));
        }
        //
        sc.close();
    }

    private static String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        //
        int d = s.charAt(0) - '0';
        insertMany(sb, 0, '(', d);
        int depth = d;
        int sbPos = d;
        sb.insert(sbPos, s.charAt(0));
        sbPos++;
        //
        for (int i = 1; i < s.length(); i++) {
            d = s.charAt(i) - '0';
            if (d > depth) {
                insertMany(sb, sbPos, '(', d - depth);
                sbPos += (d - depth);
            } else if (d < depth) {
                insertMany(sb, sbPos, ')', depth - d);
                sbPos += (depth - d);
            }
            depth = d;
            sb.insert(sbPos, s.charAt(i));
            sbPos++;
        }
        //
        insertMany(sb, sbPos, ')', depth);
        //
        return sb.toString();
    }

    private static StringBuilder insertMany(StringBuilder sb, int offset, char c, int count) {
        for (int i = 0; i < count; i++) {
            sb.insert(offset + i, c);
        }
        return sb;
    }
}