import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    solve(in);
  }
  
  public static void solve(Scanner in) {
    int T = Integer.parseInt(in.nextLine()); // numTests
    for(int ks = 1; ks <= T; ks++) {
      StringBuilder result = new StringBuilder();
      
      int currDepth = 0;

      List<Integer> list = in.nextLine().chars()
          .map(c -> c - '0')
          .boxed()
          .collect(Collectors.toList());
      
      for (int i = 0; i < list.size(); i++) {
        
        int curr = list.get(i);
        currDepth = curr;
        int last = i > 0 ? list.get(i-1) : 0;
        if (curr > last) {
          append(result, '(', curr - last);
        } else if (curr < last) {
          append(result, ')', last - curr);
        } else if ( curr == last) {
          // noop
        }
        result.append(curr);
      }
      
      append(result, ')', currDepth);
      
      System.out.println("Case #"+ks+": "+result.toString());
    }
  }

  private static void append(StringBuilder result, char c, int i) {
    IntStream.range(0, i).forEach((n) -> result.append(c));
  }


}
