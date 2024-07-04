import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author himanshugupta - created on 05/04/20
 */
public class Solution {

  static class IComparator implements Comparator<Interval>{

    @Override
    public int compare(Interval o1, Interval o2) {
      return o1.start - o2.start;
    }

  }

  static class Interval{

    public Interval() {
    }

    int start;
    int end;
    int index;

    @Override
    public String toString() {
      return "Interval{" + "start=" + start + ", end=" + end + ", index=" + index + '}';
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int tt = t;
    while(t--!=0){
      int n = sc.nextInt();
      Interval arr[] = new Interval[n];
      for(int i=0;i<n;i++){
        arr[i] = new Interval();
        arr[i].start = sc.nextInt();
        arr[i].end = sc.nextInt();
        arr[i].index = i;
      }
      Arrays.sort(arr, new IComparator());
      int cEnd = -1, jEnd = -1;
      char res[] = new char[n];
      boolean solExists = true;
      for (Interval interval : arr) {
        if(interval.start>=cEnd){
          res[interval.index] = 'C';
          cEnd = interval.end;
        } else if (interval.start >= jEnd){
          res[interval.index] = 'J';
          jEnd = interval.end;
        }else{
          solExists = false;
          break;
        }
      }
      System.out.print("Case #" + (tt - t) + ": ");
      if(solExists){
        for(char c:res){
          System.out.print(c);
        }
        System.out.println();
      }else{
        System.out.println("IMPOSSIBLE");
      }
/*      for(Interval interval:arr){
        System.out.println(interval);
      }*/
    }
  }
}
