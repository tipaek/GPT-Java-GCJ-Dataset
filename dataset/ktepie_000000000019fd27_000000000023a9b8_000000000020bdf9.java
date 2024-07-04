import java.util.*;
import java.io.*;

public class Solution {

  public static boolean hasPlace(int[] time,int start,int end){
    for(int i=start;i<end;++i){
      if(time[i]==-1)return false;
    }
    return true;
  }

  public static void addTime(int[] time,int start,int end){
    for(int i=start;i<end;++i){
      time[i]= -1;
    }

  }


  public static void main(String[] args){

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for(int i=1;i<=t;++i){
      int n = in.nextInt();
      String result = "";
      int jcurtime = 0;
      int ccurtime = 0;
      int[] jtime = new int[1440];
      int[] ctime = new int[1440];
      for(int j=0;j<n;++j){
        int start = in.nextInt();
        int end = in.nextInt();
        if(hasPlace(ctime,start,end) && result!="IMPOSSIBLE"){
          result += "C";
          addTime(ctime,start,end);
        }
        else if(hasPlace(Jtime,start,end)&& result!="IMPOSSIBLE"){
          result += "J";
          addTime(jtime,start,end);
        }
        else{
          result = "IMPOSSIBLE";
        }
      }
      System.out.println("Case #" + i + ": " + result);
    }
    in.close();

  }

}
