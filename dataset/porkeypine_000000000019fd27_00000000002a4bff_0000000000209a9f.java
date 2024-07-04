import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] in = new String[t];
        String[] out = new String[t];
        for (int i = 0; i < t; i++) {
            in[i] = sc.next();
        }
        for (int i = 0; i < t; i++) {
            char[] curr = in[i].toCharArray();
            // Stack<Integer> stack = new Stack<Integer>();
            String s = "";
            int no = Character.getNumericValue(curr[0]);
            for (int j = 0; j < no; j++) {
                s += "(";
            }
            s += no;
            for (int c = 1; c < curr.length; c++) {
                int diff = Character.getNumericValue(curr[c]) - Character.getNumericValue(curr[c - 1]);
                if (diff < 0) {
                    for (int j = 0; j < -diff; j++) {
                        s += ")";
                    }
                } else if (diff > 0) {
                    for (int j = 0; j < diff; j++) {
                        s += "(";
                    }
                }
                s += curr[c];
            }
            int no2 = Character.getNumericValue(curr[curr.length - 1]);
            for (int j = 0; j < no2; j++) {
                s += ")";
            }
            out[i] = s;
        }
        for (int i = 0; i < t; i++) {
            System.out.println(String.format("Case #%d: %s",
                    i + 1, out[i]));
        }
    }
}