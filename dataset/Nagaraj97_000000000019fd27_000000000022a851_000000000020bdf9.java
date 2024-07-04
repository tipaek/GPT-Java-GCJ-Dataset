
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
          arr.add(new Time(t1,t2,i));
        //System.out.println(arr.get(i).s +" "+arr.get(i).e);
      }
      arr.sort(new CustomSort());
      char output[] = new char[n];
      int c_end_time = 0;
      int j_end_time = 0;
      for(int i = 0; i < n; i++){
        if(arr.get(i).s >= c_end_time){
          output[arr.get(i).act_no] = 'C';
          c_end_time = arr.get(i).e;
        }
        else if(arr.get(i).s >= j_end_time){
          output[arr.get(i).act_no] = 'J';
          j_end_time = arr.get(i).e;
        }
        else{
          output = new String("IMPOSSIBLE").toCharArray();
          break;
        }
      }
      System.out.println("Case #" + k + ": " + String.valueOf(output));
    }
  }
}

class Time{
  int s;
  int e;
  int act_no;
  Time(int s,int e,int n){
      this.s = s;
      this.e = e;
      this.act_no = n;
  }
}

class CustomSort implements Comparator<Time>{
  public int compare(Time t1,Time t2){
      return t1.s-t2.s;
  }
}