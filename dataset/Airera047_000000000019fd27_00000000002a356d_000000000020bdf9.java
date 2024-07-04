import java.util.*;
import java.io.*;
import java.util.stream.IntStream; 
import java.util.stream.Collectors;

public class Solution{
  
  public static void main(String[] args) throws IOException {
    Solution fd = new Solution();
    Scanner input= new Scanner(System.in);
    int testN = input.nextInt();
    for(int i = 0; i < testN; i++){
      int intervalN = input.nextInt();
      ArrayList<Interval> intervals= new ArrayList<Interval>();
      for(int j = 0; j < intervalN; j++){
        Interval interval = new Interval(input.nextInt(),input.nextInt(),j);
        intervals.add(interval);
      }
      Collections.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval i1, Interval i2) {
            Integer x1 = i1.startT;
            Integer x2 = i2.startT;
            return x1.compareTo(x2);
    }});
   
      String output = "";
      Boolean check = false;
      StringBuilder str = new StringBuilder();
      List<Integer> J = IntStream.rangeClosed(0, 1440).boxed().collect(Collectors.toList());
      List<Integer> C = IntStream.rangeClosed(0, 1440).boxed().collect(Collectors.toList());
      int jend = 0;
      int cend = 0;
      
      for(int k = 0; k < intervalN; k++){
        if(check(J,intervals.get(k)) && check(C,intervals.get(k))){
          if(jend >= cend){
            intervals.get(k).assign = "J";
            int s = J.indexOf(intervals.get(k).startT);
            int e = J.indexOf(intervals.get(k).endT);     
            for(int l = s; l < e; l++){  
              J.remove(s);
            }
            jend = intervals.get(k).endT;
            continue;
          }
          else{
            intervals.get(k).assign = "C";
            int s = C.indexOf(intervals.get(k).startT);
            int e = C.indexOf(intervals.get(k).endT);     
            for(int l = s; l < e; l++){  
              C.remove(s);
            }
            cend = intervals.get(k).endT;
            continue; 
          }
        }
        else if(check(J,intervals.get(k))){
          intervals.get(k).assign = "J";
            int s = J.indexOf(intervals.get(k).startT);
            int e = J.indexOf(intervals.get(k).endT);     
            for(int l = s; l < e; l++){  
              J.remove(s);
            }
            jend = intervals.get(k).endT;
            continue;
        }
        else if(check(C,intervals.get(k))){
          intervals.get(k).assign = "C";
            int s = C.indexOf(intervals.get(k).startT);
            int e = C.indexOf(intervals.get(k).endT);     
            for(int l = s; l < e; l++){  
              C.remove(s);
            }
            cend = intervals.get(k).endT;
            continue;
        }
        else{
          output = "IMPOSSIBLE";
          check = true;
          break;        
        }
        
      }
      int test = i + 1;
      if(check == true){
        System.out.println("Case #" + test + ": "  + output);
      }
      else{
        Collections.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval i1, Interval i2) {
            Integer x1 = i1.orgIndex;
            Integer x2 = i2.orgIndex;
            return x1.compareTo(x2);
    }});
        for(int m = 0; m < intervalN; m++){
          str.append(intervals.get(m).assign);   
        }
        output = str.toString();    
        System.out.println("Case #" + test + ": "  + output);
      }
    }
  }
  
  public static boolean check(List<Integer> arr, Interval it){
    if(!arr.contains(it.startT)){
      return false;
    }
    if(!arr.contains(it.endT)){
      return false;
    }
    if(arr.indexOf(it.endT) - arr.indexOf(it.startT) == it.endT - it.startT){
      return true;
    }
    else{
      return false;
    }
  }
  
  private static class Interval{
    public int startT;
    public int endT;
    public int orgIndex;
    public String assign = "";
    public Interval(int start, int end, int index){
      this.startT = start;
      this.endT = end;
      this.orgIndex = index;
    }
  }
}

