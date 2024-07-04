
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int caseCnt = s.nextInt();
        s.nextLine();

        for (int i = 0; i < caseCnt; i++) {
            int size = s.nextInt();
            s.nextLine();
            List<String> patterns = new ArrayList<>();
            int max = 0;
            String ans = "";
            for (int p = 0; p < size; p++) {
                String curr = s.nextLine();
                if (curr.length() > max) {
                    max = curr.length();
                    ans = curr;
                }
                patterns.add(curr);
            }
            boolean match = true;
            for (int p = 0; p < size; p++) {
                String curr = patterns.get(p);
                if (ans.equals(curr)) continue;
                String sub = ans.substring(max - curr.length() + 1);
                String currSub = curr.substring(1);
//                System.out.println("sub: " +  sub);
//                System.out.println("currSub: " +  currSub);
                if (!sub.equals(currSub)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                System.out.println("Case #" + (i + 1) + ": " + ans.substring(1));
            } else {
                System.out.println("Case #" + (i + 1) + ": " + "*");
            }

        }
    }
}
