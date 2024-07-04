import java.util.*;
import java.io.*;
import java.util.HashMap;

public class sol{


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

  public static void assign(HashMap<Integer,Integer> timetable,int i){
    int[] jtime = new int[1440];
    int[] ctime = new int[1440];
    String result = "";

    for(int j:timetable.keySet()){
      if(hasPlace(ctime,j,timetable.get(j)) && result!="IMPOSSIBLE"){
        result += "C";
        addTime(ctime,j,timetable.get(j));
      }
      else if(hasPlace(jtime,j,timetable.get(j)) && result!="IMPOSSIBLE"){
        result += "J";
        addTime(jtime,j,timetable.get(j));
      }
      else result = "IMPOSSIBLE";
    }
    System.out.println("Case #" + i + ": " + result);
  }


  public static void main(String[] args){

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for(int i=1;i<=t;++i){
      int n = in.nextInt();
      HashMap<Integer,Integer> timer = new HashMap<Integer,Integer>();
      for(int j=0;j<n;++j){
        int start = in.nextInt();
        int end = in.nextInt();
        timer.put(start,end);
      }
      assign(timer,i);
    }
    in.close();

  }

}
