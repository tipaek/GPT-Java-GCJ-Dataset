import java.util.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(in.nextLine());
            String pattern = in.nextLine().trim().replace("*", ".*");
            //System.out.println("First pattern: " + pattern);
            for (int i = 1; i < N; i++) {
                String p = in.nextLine().trim().replace("*", ".*");
                //System.out.println("Next pattern: " + p);
                if (Pattern.matches(pattern, p.replace(".*", ""))) {
                    pattern = p;
                } else {
                    //System.out.println("pattern: " + pattern);                
                    if (!(Pattern.matches(p, pattern.replace(".*", "")))) {
                        pattern = "*";
                        break;
                    }
                }
                //System.out.println("New pattern: " + pattern);
            }
            if (pattern.length() > 1) {
                pattern = pattern.replace(".*", "");
            }
            System.out.println("Case #" + t + ": " + pattern);   
        }
    }
}