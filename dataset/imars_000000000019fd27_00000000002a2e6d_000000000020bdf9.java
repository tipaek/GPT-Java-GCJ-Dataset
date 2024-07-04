import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String args[]){
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int test = in.nextInt();
    for(int a=1; a<=test; ++a){
      int acts = in.nextInt();
      int mtxActs[][] = new int[acts][2];
      ArrayList<int[]> arrC = new ArrayList<int[]>();
      ArrayList<int[]> arrD = new ArrayList<int[]>();
      int overlap=0;
      String sched = "";
      for(int i=0; i<acts; ++i){
        mtxActs[i][0] = in.nextInt();
        mtxActs[i][1] = in.nextInt();
      };
      for(int i=0; i<mtxActs.length; ++i){
        if(arrC.size()==0){
          arrC.add(mtxActs[i]);
          sched += "C";
          continue;
        }
        for(int x=0; x<arrC.size(); ++x){
          if(arrC.get(x)[1]>mtxActs[i][0]&&mtxActs[i][1]>arrC.get(x)[0]){
            overlap +=1;
            break;
          };
        };
        if(overlap==0){
          arrC.add(mtxActs[i]);
          sched += "C";
          continue;
        } 
        if(arrD.size()==0) {
          arrD.add(mtxActs[i]);
          overlap = 0;
          sched += "J";
          continue;
        };
        for(int x=0; x<arrD.size();++x){
          if(arrD.get(x)[1]>mtxActs[i][0]&&mtxActs[i][1]>arrD.get(x)[0]){
            overlap +=1;
            break;
          };
        };
        if(overlap==1){
        arrD.add(mtxActs[i]);
          sched += "J";
          overlap = 0;
          continue;
        };
        if(overlap > 1){
          sched = "IMPOSSIBLE";
          break;
        };
      };
      System.out.println("Case #"+a+": "+sched);
    };
  };
}