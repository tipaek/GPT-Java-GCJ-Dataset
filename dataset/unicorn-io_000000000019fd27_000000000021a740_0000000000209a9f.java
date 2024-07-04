import java.util.*;

public class Solution {

    private static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int tcases = scn.nextInt();
        int tcpy = tcases;
        scn.nextLine();
        while (tcases-- > 0) {
            String s = scn.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            Stack<Character> stk = new Stack<>();
            int degree = 0;
            for (int i = 0; i < s.length(); i++) {
                int curr = s.charAt(i) - '0';
                while (degree != curr) {
                    if (degree > curr) {
                        stringBuilder.append(")");
                        degree--;
                    } else if (degree < curr) {
                        stringBuilder.append("(");
                        degree++;
                    }
                }
                stringBuilder.append(curr);
                if (i == s.length() - 1) {
                    while (degree != 0 && degree > 0) {
                        stringBuilder.append(")");
                        degree--;
                    }
                }
            }
            System.out.printf("Case #%d: %s\n", tcpy-tcases,stringBuilder.toString());
        }
    }
}