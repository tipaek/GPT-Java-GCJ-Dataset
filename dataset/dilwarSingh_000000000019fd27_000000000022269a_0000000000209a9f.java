import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        s.nextLine();
        for (int i = 0; i < t; i++) {
            String str = s.nextLine();
            char[] chars = str.toCharArray();
            int[] arr = new int[chars.length];
            for (int x = 0; x < chars.length; x++) arr[x] = ((int) chars[x]) - 48;
            String solve = solve(arr);
            System.out.println(solve);
        }

    }

    static int pendingBrace = 0;

    private static String solve(int[] arr) {
        StringBuilder sb = new StringBuilder();
        pendingBrace = 0;
        int prevValue = 0;
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            int brace = prevValue - val;
            if (i > 0 && brace > 0)
                removeBrace(sb, brace);

            //if (val == prevValue) sb.append(val);
            if (brace < 0) addBrace(sb, brace);
            sb.append(val);
            prevValue = val;
        }
        removeBrace(sb, pendingBrace);
        return sb.toString();
    }

    private static void addBrace(StringBuilder sb, int c) {
        for (int i = 0; i < Math.abs(c); i++) {
            sb.append("(");
            pendingBrace++;
        }
    }

    private static void removeBrace(StringBuilder sb, int c) {
        for (int i = 0; i < Math.abs(c); i++) {
            sb.append(")");
            pendingBrace--;
        }
    }


}
/*
4
021
312
4
221
*/


