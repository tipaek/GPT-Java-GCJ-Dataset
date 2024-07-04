import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        
        for (int cs = 1; cs <= cases; cs++) {
            int n = in.nextInt();
            in.nextLine();
            String[] patterns = new String[n];

            for (int i = 0; i < n; i++) {
                patterns[i] = in.nextLine();
            }

            //System.out.println(Arrays.toString(patterns));
            System.out.println("Case #" + cs + ": " + (possible(patterns) ? getLongestString(patterns).substring(1) : "*"));
        }
    }
public static String getLongestString(String[] array) {
      int maxLength = 0;
      String longestString = null;
      for (String s : array) {
          if (s.length() > maxLength) {
              maxLength = s.length();
              longestString = s;
          }
      }
      return longestString;
  }

    static boolean possible(String[] patterns) {
        for (int i = 0; i < patterns.length; i++) {
            String pattern = patterns[i].substring(1);
            for (int j = 0; j < patterns.length; j++) {
                if (i == j) break;
                String pattern2 = patterns[j].substring(1);

                //System.out.println(pattern + " " + pattern2);

                if (!(pattern.endsWith(pattern2) || pattern2.endsWith(pattern))) return false;
            }
        }

        return true;
    }
}