
import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = sc.nextInt();
    for (int k = 1; k <= t; k++) {
      int n = sc.nextInt();
      ArrayList<Time> arr = new ArrayList<Time>();
      //System.out.println(t+" "+n);
      for(int i = 0 ; i < n; i++){
          int t1 = sc.nextInt();
          int t2 = sc.nextInt();
          arr.add(new Time(t1,t2));
        //System.out.println(arr.get(i).s +" "+arr.get(i).e);
      }
      arr.sort(new CustomSort());
      String output = "";
      int c_end_time = 0;
      int j_end_time = 0;
      for(int i = 0; i < n; i++){
        if(arr.get(i).s >= c_end_time){
          output+="C";
          c_end_time = arr.get(i).e;
        }
        else if(arr.get(i).s >= j_end_time){
          output+="J";
          j_end_time = arr.get(i).e;
        }
        else{
          output = "IMPOSSIBLE";
          break;
        }
      }
      System.out.println("Case #" + k + ": " + output);
    }
  }
}

class Time{
  int s;
  int e;
  Time(int s,int e){
      this.s = s;
      this.e = e;
  }
}

class CustomSort implements Comparator<Time>{
  public int compare(Time t1,Time t2){
      return t1.s-t2.s;
  }
}