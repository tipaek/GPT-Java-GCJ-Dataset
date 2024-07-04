import static java.lang.System.*;

import java.util.*;
import java.lang.*;

public class SolutionTwo {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int caseNum = 1; caseNum <= t; caseNum++) {
      int u = in.nextInt();
      String result = "";
      Map<Character, Integer> countMap = new HashMap();
      for (int i = 0; i < 10000; i++) {
        String q = in.next();
        char[] answer = in.next().toCharArray();
        for (int j = 0; j < answer.length; j++) {
          char c = answer[j];
          if (countMap.containsKey(c)) {
            countMap.put(c, countMap.get(c) + 1);
          } else {
            countMap.put(c, 1);
          }
        }
      }

      int min = 20000;
      char firstChar = 'c';
      for(Map.Entry<Character, Integer> entry : countMap.entrySet()) {
        char c = entry.getKey();
        if (countMap.get(c) < min) {
          min = countMap.get(c);
          firstChar = c;
        }
      }

      result += firstChar;
      countMap.put(firstChar, -1);

      for (int i = 0; i < 9; i++) {
        int max = -1;
        char maxChar = 'c';
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()) {
          char c = entry.getKey();
          if (countMap.get(c) > max) {
            max = countMap.get(c);
            maxChar = c;
          }
        }
        result += maxChar;
        countMap.put(maxChar, -1);
      }
      out.println("Case #" + caseNum +": " + result);
    }
  }
}
