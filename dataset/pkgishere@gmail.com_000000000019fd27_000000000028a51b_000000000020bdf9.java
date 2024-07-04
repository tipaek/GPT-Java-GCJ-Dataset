import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {

    private static boolean check(DataStructure before, DataStructure after) {
        if(before == null || after == null) return true;
        return (before.end<=after.start && before.start<after.start) ;
    }

    static class DataStructure{
        int start;
        int end;
    } 
    
    public static void main(String args[]){

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int test_cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.Pare  
    for (int i = 1; i <= test_cases; ++i) {
      StringBuilder sb = new StringBuilder();
      int intervals = in.nextInt();
      TreeSet<DataStructure> cameron = new TreeSet<>((a,b)-> Integer.compare(a.start, b.start));
      TreeSet<DataStructure> james = new TreeSet<>((a,b)-> Integer.compare(a.start, b.start));
      for(int interval =0; interval < intervals; interval++){
          DataStructure current = new DataStructure();
          current.start = in.nextInt();
          current.end = in.nextInt();
          
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
