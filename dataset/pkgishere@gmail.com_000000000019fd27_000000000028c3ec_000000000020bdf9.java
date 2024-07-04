import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {

    private static boolean check(int[] before, int[] after) {
        if(before == null || after == null) return true;
        return (before[1]<=after[0] && before[0]<after[0]);
    }

    
    
    public static void main(String args[]){

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int test_cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= test_cases; ++i) {
      StringBuilder sb = new StringBuilder();
      int intervals = in.nextInt();
      TreeSet<int[]> cameron = new TreeSet<>((a,b)-> Integer.compare(a[0], b[0]));
      TreeSet<int[]> james = new TreeSet<>((a,b)-> Integer.compare(a[0], b[0]));
      for(int interval =0; interval < intervals; interval++){
          int[] current = new int[2];
          current[0] = in.nextInt();
          current[1] = in.nextInt();
          
          //check cameron 
          boolean flag = true;
          if(check(cameron.floor(current),current) && check(current,cameron.ceiling(current))){
              cameron.add(current);
              sb.append("C");
              flag=false;
          }else if(check(james.floor(current),current) && check(current,james.ceiling(current))){
              james.add(current);
              sb.append("J");
              flag=false;
          }
          if(flag){
              sb = new StringBuilder("IMPOSSIBLE");
              break;
          }
      }
      System.out.println("Case #" + i + ": " + sb.toString());
    }
  }
}