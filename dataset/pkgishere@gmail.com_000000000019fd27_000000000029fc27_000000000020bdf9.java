import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution{

    private static boolean check(DS before, DS after) {
        if(before == null || after == null) return true;
        return (before.end<=after.start && before.start<after.start);
    }

    static class DS{
        int start;
        int end;
        int index;
        char person;
    }
    
    public static void main(String args[]){

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int test_cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= test_cases; ++i) {
      StringBuilder sb = new StringBuilder();
      int intervals = in.nextInt();
      TreeSet<DS> cameron = new TreeSet<>((a,b)-> Integer.compare(a.start, b.start));
      TreeSet<DS> james = new TreeSet<>((a,b)-> Integer.compare(a.start, b.start));
      DS[] intervals_total = new DS[intervals];
      for(int interval =0; interval < intervals; interval++){
          DS current = new DS();
          current.start = in.nextInt();
          current.end = in.nextInt();
          current.index=interval;
          intervals_total[interval]=current;
      }
      boolean isPossible = true;
      Arrays.sort(intervals_total,(a,b)->Integer.compare(a.start,b.start));
      for(DS current: intervals_total){
          //check cameron 
          boolean flag = true;
          if(check(cameron.floor(current),current) && check(current,cameron.ceiling(current))){
              current.person='C';
              cameron.add(current);
              flag=false;
          }else if(check(james.floor(current),current) && check(current,james.ceiling(current))){
              current.person='J';
              james.add(current);
              flag=false;
          }
          if(flag){
              sb = new StringBuilder("IMPOSSIBLE");
              isPossible=false;
              break;
          }
      }
      if(isPossible){
          char[] sequence = new char[intervals];
          for(DS current: intervals_total){
              sequence[current.index]=current.person;
          }
          for(int seq=0;seq<sequence.length;seq++){
              sb.append(sequence[seq]+"");
          }
      }
      System.out.println("Case #" + i + ": " + sb.toString());
      
    }
  }
}