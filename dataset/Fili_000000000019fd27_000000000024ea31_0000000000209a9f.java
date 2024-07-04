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
                sb.append(")".repeat(Math.max(0, previous - next)));
                sb.append("(".repeat(Math.max(0, next - previous)));
                sb.append(S.charAt(j));
                previous = next;
            }
            sb.append(")".repeat(Math.max(0, previous)));
            System.out.println("Case #" + i + ": " + sb.toString());
        }
    }
}
