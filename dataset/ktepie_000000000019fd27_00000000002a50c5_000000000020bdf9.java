import java.util.*;
import java.io.*;


public class Parenting{

  public static void sortIt(int[][] time, int n){

    boolean isDone = true;
    while(isDone){
      isDone = false;
      for(int i=0;i<n-1;++i){
        if(time[i][0]>time[i+1][0]){
          int tempStart = time[i][0];
          int tempEnd = time[i][1];
          int tempOrder = time[i][2];
          time[i][0] = time[i+1][0];
          time[i][1] = time[i+1][1];
          time[i][2] = time[i+1][2];
          time[i+1][0] = tempStart;
          time[i+1][1] = tempEnd;
          time[i+1][2] = tempOrder;
          isDone = true;
        }
      }
    }
  }

  public static boolean hasTime(int time[],int start, int end){
    for(int i=start;i<=end;++i){
      if(time[i]==-1 && i!=start) return false;
    }
    return true;
  }

  public static void addTime(int time[],int start, int end){
    for(int i=start;i<=end;++i){
      time[i] = -1;
    }
  }

  public static String replaceChar(String str, char ch, int index) {
    StringBuilder myString = new StringBuilder(str);
    myString.setCharAt(index, ch);
    return myString.toString();
}

  public static void assign(int[][] time, int cas,int n){
    int[] jtime = new int[1441];
    int[] ctime = new int[1441];
    String result = "";
    for(int i=0;i<n;++i){
      result += " ";
    }

    for(int i=0;i<n;++i){
      int start = time[i][0];
      int end = time[i][1];
      int order = time[i][2];
      if(hasTime(ctime,start,end)){
        addTime(ctime,start,end);
        result = replaceChar(result, 'C',order);
      }
      else if(hasTime(jtime,start,end)){
        addTime(jtime,start,end);
        result = replaceChar(result, 'J',order);
      }
      else result = "IMPOSSIBLE";
    }
    System.out.println("Case #" + cas + ": " + result);
  }


  public static void main(final String[] args){
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for(int i=1;i<=t;++i){
      int n = in.nextInt();
      int[][] timetable = new int[n][3];
      for(int j=0;j<n;++j){
        int start = in.nextInt();
        int end = in.nextInt();
        timetable[j][0]= start;
        timetable[j][1]= end;
        timetable[j][2]= j;
      }
      sortIt(timetable,n);
      assign(timetable,i,n);

    }

  }

}
