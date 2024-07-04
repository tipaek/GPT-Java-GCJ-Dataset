import java.util.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in); 

    int numT = in.nextInt(); 
    for(int t=0; t<numT; t++) {
      char[] digits = in.next().toCharArray();

      // Time for a greedy
      int depth = 0;
      ArrayList<Character> ans = new ArrayList<>();
      for(int ind=0; ind<digits.length; ind++) {
        int curVal = (int)(digits[ind] - '0');
        while(depth < curVal) {
          ans.add('(');
          depth++;
        }
        while(depth > curVal) {
          ans.add(')');
          depth--;
        }
        ans.add(digits[ind]);
      }
      while(depth > 0) {
        ans.add(')');
        depth--;
      }

      System.out.printf("Case #%d: ", t+1);
      for(int i=0; i<ans.size(); i++) {
        System.out.print(ans.get(i));
      }
      System.out.println();

    }
  }
}
/* 

4
0000
101
111000
1

Case #1: 0000
Case #2: (1)0(1)
Case #3: (111)000
Case #4: (1)


*/