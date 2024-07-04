import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String args[]){
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int test = in.nextInt();
    for(int a=1; a<=test; ++a){
      int acts = in.nextInt();
      int mtxActs[][] = new int[acts][2];
      int C = 0;
      int J = 0;
      int index=0;
      String sched = "";
      for(int i=0; i<acts; ++i){
        mtxActs[i][0] = in.nextInt();
        mtxActs[i][1] = in.nextInt();
      };
      while(index < mtxActs.length-1){
        int temp[];
        if(mtxActs[index][0] == mtxActs[index][0] && mtxActs[index][1]<mtxActs[index][1]){
          temp = mtxActs[index];
          mtxActs[index] = mtxActs[index+1];
          mtxActs[index+1] = temp;
          index = 0;
        };
        if(mtxActs[index][0]>mtxActs[index+1][0]){
          temp = mtxActs[index];
          mtxActs[index] = mtxActs[index+1];
          mtxActs[index+1] = temp;
          index = 0;
          continue;
        };
        index += 1;
      };
      for(int i=0; i<mtxActs.length; ++i){
        if(C > mtxActs[i][0] && J>mtxActs[i][0]){
          sched = "IMPOSSIBLE";
          break;
        };
        if(C <= mtxActs[i][0]){
          C = mtxActs[i][1];
          sched += "C";
          continue;
        };
        if(J <= mtxActs[i][0] && C>=mtxActs[i][0]){
          J = mtxActs[i][1];
          sched += "J";
          continue;
        };
      };
      for (int i=0; i<mtxActs.length; ++i){
        System.out.println(mtxActs[i][0]+" "+mtxActs[i][1]);
      };
      System.out.println("Case #"+a+": "+sched);
    };
  };
}