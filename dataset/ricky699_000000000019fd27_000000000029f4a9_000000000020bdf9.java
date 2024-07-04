import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    
  public static class Interval{
      int index;
      int start;
      int end;
      
      public Interval(int start, int end, int index){
          this.start = start;
          this.end = end;
          this.index = index;
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
      Map<Integer, String> ansMap = new TreeMap<> ();
      ansMap.put(inputIntervals.get(0).index, "J");
      ansMap.put(inputIntervals.get(1).index, "C");
      /*System.out.println("Printing inputIntervals-----------------");
      for(Interval interval: inputIntervals){
          System.out.println("["+interval.start+","+interval.end+"]"+ " index: " + interval.index);
      }*/
      while(i<inputIntervals.size()){
          if(isOverlap(jamieInterval, inputIntervals.get(i)) && isOverlap(cameronInterval, inputIntervals.get(i))){
              return "IMPOSSIBLE";
          }else if(isOverlap(jamieInterval, inputIntervals.get(i)) && !isOverlap(cameronInterval, inputIntervals.get(i))){
              cameronInterval = inputIntervals.get(i);
              ansMap.put(inputIntervals.get(i).index, "C");
          }else{
              jamieInterval = inputIntervals.get(i);
              ansMap.put(inputIntervals.get(i).index, "J");
          }
          i++;
      }
      
      StringBuilder sb = new StringBuilder();
      for(Map.Entry<Integer, String> e : ansMap.entrySet()){
          sb.append(e.getValue());
          //System.out.print(e.getKey() + " " + e.getValue());
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
                inputIntervals.add(new Interval(in.nextInt(), in.nextInt(), j));
            }
            
            Collections.sort(inputIntervals, new IntervalComparator());
            
            System.out.println("Case #"+i+": "+assignActivities(inputIntervals));
        }
    }
}