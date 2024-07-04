import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
    
      int patCount = in.nextInt();
      List<String> patterns = new ArrayList();
      List<String> leftPattern = new ArrayList();
      List<String> rightPattern = new ArrayList();
      for (int j = 0; j < patCount; j++) {

        String pattern = in.next();

        patterns.add(pattern);
        String[] split = pattern.split("\\*");

        leftPattern.add(split[0]);
        if (split.length > 1) {
            rightPattern.add(split[1]);
        }
      }
      
      String left = commonString(leftPattern);
      String right = commonString(rightPattern);
      
      String match = left + "X" + right;
     
     if (match.equals("")) {
        System.out.println("Case #" + i + ": " + "*");
     } else {
        System.out.println("Case #" + i + ": " + match);
     }

    }
  }
    
    private static String commonString(List<String> list) {
        int largestStringIndex = 0;
        boolean notCommon = false;
        for (int i = 0; i< list.size(); i++) {
            String s = list.get(i);
            if (s.length() > list.get(largestStringIndex).length()) {
                largestStringIndex = i;
            }
        }
        
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(largestStringIndex).contains(list.get(i))) {
                notCommon = true;
                break;
            }
        }
        
        return notCommon ? "" : list.get(largestStringIndex);
    }
}