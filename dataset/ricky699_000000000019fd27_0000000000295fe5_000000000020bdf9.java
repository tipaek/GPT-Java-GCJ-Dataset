import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    
  public static class Interval{
      int start;
      int end;
      
      public Interval(int start, int end){
          this.start = start;
          this.end = end;
      }
  }
  
  static class IntervalComparator implements Comparator<Interval>{
      public int compare(Interval i1, Interval i2)
     {
         return i1.start - i2.start;
     }
  }
  
  public static String assignActivities(List<Interval> inputIntervals){
      Interval jamieInterval = inputIntervals.get(0);
      Interval cameronInterval = inputIntervals.get(1);
      
      int i=2;
      StringBuilder sb = new StringBuilder("JC");
      while(i<inputIntervals.size()){
          if(isOverlap(jamieInterval, inputIntervals.get(i)) && isOverlap(cameronInterval, inputIntervals.get(i))){
              return "IMPOSSIBLE";
          }else if(isOverlap(jamieInterval, inputIntervals.get(i)) && !isOverlap(cameronInterval, inputIntervals.get(i))){
              sb.append("C");
          }else{
              sb.append("J");
          }
          i++;
      }
      return sb.toString();
  }
  
  public static boolean isOverlap(Interval i1, Interval i2){
      return i1.end > i2.start;
  }
    
  public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            
            List<Interval> inputIntervals = new ArrayList<> ();
            for(int j=0;j<n;j++){
                inputIntervals.add(new Interval(in.nextInt(), in.nextInt()));
            }
            
            Collections.sort(inputIntervals, new IntervalComparator());
            
            System.out.println("Case #"+i+": "+assignActivities(inputIntervals));
        }
    }
}