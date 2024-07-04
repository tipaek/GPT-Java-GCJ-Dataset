import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) throws Exception{
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      Map<Integer, Set<String>> hm = new HashMap<>();
      for (int j = 0; j < 10000; j++) {
        int a = in.nextInt();
        String ch = in.next();
        if (hm.containsKey(a)) {
          Set<String> lst = hm.get(a);
          lst.add(ch);
          hm.put(a, lst);
        } else {
          Set<String> lst = new HashSet<>();
          lst.add(ch);
          hm.put(a, lst);
        }
      }
      Stack<String> stk = new Stack<>();
      Set<String> res = new HashSet<>();;
      for(int j=1;j<=10;j++){
        for(String ch : hm.get(j)){
          if(!stk.isEmpty()) {
            if(!res.contains(ch)) {
              stk.push(ch);
              res.add(ch);
            }
          } else {
            stk.push(ch);
            res.add(ch);
          }
        }
      }
      StringBuilder sb = new StringBuilder();
      char[] temp = stk.pop().toCharArray();
      for(String s : stk)
        sb.append(s);
      for(char ch : temp){
        if(sb.indexOf(ch+"")==-1) {
          sb.insert(0,ch);
          break;
        }
      }
      System.out.println("Case #" + i + ": "+sb.toString());
    }
  }
}