import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution{

  static class Work implements Comparable<Work>{
    int time;
    int value;

    public Work(int time, int value){
      this.time = time;
      this.value = value;
    }

    @Override
    public int compareTo(Work target){
      if(this.time > target.time)
        return 1;
      else if(this.time < target.time)
        return -1;
      else if(this.value > target.value)
        return 1;
      else if(this.value < target.value)
        return -1;
      return 0;
    }

    @Override
    public String toString(){
      return "time : "+this.time+" / value : "+value;
    }
  }

  public static void main(String[] args) throws Exception{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCaseNo = Integer.parseInt(br.readLine());

    for(int i = 1 ; i <= testCaseNo ; i++){
      // System.out.print("Case #"+i+":");
      int workNo = Integer.parseInt(br.readLine());

      PriorityQueue<Work> queue = new PriorityQueue<>();
      for(int j = 1 ; j<=workNo ; j++){
        String[] times = br.readLine().split(" ");

        int si = Integer.parseInt(times[0]);
        int ei = Integer.parseInt(times[1]);
        queue.offer(new Work(si,j));
        queue.offer(new Work(ei,j*-1));
      }

      int C = 0;
      int J = 0;
      String result = "";
      while(!queue.isEmpty()){
        Work work = queue.poll();
        if(work.value > 0){ //si
          if(C==0) {
            C=work.value;
            result+="C";
          }
          else if(J==0) {
            J=work.value;
            result+="J";
          }
          else{
            result="IMPOSSIBLE";
            break;
          }
        }else{ //ei
          if(C+work.value==0) C=0;
          else if(J+work.value==0) J=0;
        }
      }
      System.out.println(result);
    }
  }
}
