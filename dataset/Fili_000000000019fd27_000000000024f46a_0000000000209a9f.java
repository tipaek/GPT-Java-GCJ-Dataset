import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 1; i <= T; i++) {
            String S = scanner.next();
            StringBuilder sb = new StringBuilder("");
            int previous = 0;
            for(int j = 0; j < S.length(); j++) {
                int next = Integer.parseInt(S.substring(j, j+1));
                for(int k = 0; k < previous - next; k++) {
                    sb.append(")");
                }
                for(int k = 0; k < next - previous; k++) {
                    sb.append("(");
                }
                sb.append(S.charAt(j));
                previous = next;
            }
            for(int j = 0; j < previous; j++) {
                sb.append(")");
            }
            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}
