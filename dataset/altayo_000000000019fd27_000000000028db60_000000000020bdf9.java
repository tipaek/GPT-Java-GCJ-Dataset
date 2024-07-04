import java.util.*;
import java.awt.Point;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nCases = sc.nextInt();
        for (int a = 0; a < nCases; a++) {
            int nActivities = sc.nextInt();
            int cStartsAt = Integer.MAX_VALUE;
            int jStartsAt = Integer.MAX_VALUE;
            int cEndsAt = -1;
            int jEndsAt = -1;
            StringBuilder sb = new StringBuilder();
            String result = "";
            
            for (int b = 0; b < nActivities; b++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                if (cEndsAt <= start) {
                    cEndsAt = end;
                    sb.append('C');
                } else if (jEndsAt <= start) {
                    jEndsAt = end;
                    sb.append('J');
                } else {
                    System.out.println(cEndsAt + " " + jEndsAt);
                    result = "IMPOSSIBLE";
                }
            }
            
            if (result == "") result = sb.toString();
            
            System.out.println("Case #" + (a + 1) + ": " + result);
        }
    }
}