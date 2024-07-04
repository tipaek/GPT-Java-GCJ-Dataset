import java.util.*;
import java.io.*;

public class Solution{

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
      int[] jtime = new int[1440];
      int[] ctime = new int[1440];
      for(int j=1;j<=n;++j){
        int start = in.nextInt();
        int end = in.nextInt();
        if(hasPlace(jtime,start,end) && result!="IMPOSSIBLE"){
          result += "J";
          for(int i=start;i<end;++i){
      jtime[i]= -1;
    }
        }
        else if(hasPlace(ctime,start,end) && result!="IMPOSSIBLE"){
          result += "C";
          for(int i=start;i<end;++i){
      ctime[i]= -1;
    }
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
