import java.util.*;

class SolutionBF{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int i=1; i<=t; i++){
      int N = in.nextInt();
      Interval[] intervals = new Interval[N];
      for(int j=0; j<N; j++){
        int start = in.nextInt();
        int end = in.nextInt();
        intervals[j] = new Interval(start,end);
      }
      System.out.println("Case #"+i+": "+solve(intervals));
    }
  }

  private static String solve(Interval[] intervals){
    int N = intervals.length;
    Interval[] backup = Arrays.copyOf(intervals,intervals.length);
    HashMap<Interval,String> assignedIntervals = new HashMap<>(N);
    Arrays.sort(intervals);
    int currentC = 0;
    int currentJ = 0;

    for(int i=0; i<N;i++){
      if(intervals[i].start >= currentC){
        assignedIntervals.put(intervals[i], "C");
        currentC = intervals[i].end;
      } else if(intervals[i].start >= currentJ) {
        assignedIntervals.put(intervals[i], "J");
        currentJ = intervals[i].end;
      } else
        return "IMPOSSIBLE";
    }
    String res = "";
    for(int i=0; i<N; i++)
      res += assignedIntervals.get(backup[i]);
    return res;
  }

  static class Interval implements Comparable{
    int start;
    int end;

    Interval(int start, int end){
      this.start = start;
      this.end = end;
    }

    public boolean intersects(Interval biggerInterval){
      return this.end > biggerInterval.start;
    }

    @Override
    public int compareTo(Object other){
      if(other == null) return 1;
      else
      return this.start - ((Interval) other).start;
    }

    @Override
    public String toString(){
      return "["+start+":"+end+"]";
    }
  }
}
