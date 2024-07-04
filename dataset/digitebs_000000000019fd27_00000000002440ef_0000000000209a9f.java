import java.util.*;
import java.io.*;
import java.util.stream.*;
public class Solution {
    
      public static String depth(String s){
    String res = "";
    int curr = Character.digit(s.charAt(0),10);
    res  = padOpen(curr)+ s.charAt(0);
    for(int i = 0; i < s.length()-1; i++){
      curr = Character.digit(s.charAt(i),10);
      int next = Character.digit(s.charAt(i+1),10);
      if(next > curr ) res += padOpen(next -curr) + next;
      else if(next == curr ) res += next;
      else res += padClose(curr-next) + next;
    }
    curr=  Character.digit(s.charAt(s.length()-1),10);
    res += padClose(curr);
    return res;
  }


  static String  padClose(int n){
    return IntStream.range(0,n).mapToObj(x->")").collect(Collectors.joining());
  }

  static String  padOpen(int n){
    return IntStream.range(0,n).mapToObj(x->"(").collect(Collectors.joining());
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      String r = depth(in.next());
      System.out.println("Case #" + i + ": " + r);
    }
  }
}