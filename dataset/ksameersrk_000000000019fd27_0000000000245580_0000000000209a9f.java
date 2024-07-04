import java.util.*;

public class Solution {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        int T = in.nextInt();
        in.nextLine();
        for (int t = 1; t <= T; t++) {
            String str = in.nextLine().trim();

            int currentDepth = 0;
            StringBuilder sb = new StringBuilder();

            for(char c : str.toCharArray()) {
                int num = Integer.parseInt(String.valueOf(c));
                int diff = num - currentDepth;
                currentDepth = num;
                char ch = diff > 0 ? '(' : ')';
                for(int i=0; i<Math.abs(diff); i++) sb.append(ch);
                sb.append(num);
            }
            for(int i=0; i<currentDepth; i++) sb.append(')');
            String res = sb.toString();
            System.out.println(String.format("Case #%d: %s", t,res));
        }
    }
}
