public class Parenting{

  public static void sortIt(int[][] time, int n){

    boolean isDone = true;
    while(isDone){
      isDone = false;
      for(int i=0;i<n-1;++i){
        if(time[i][0]>time[i+1][0]){
          int tempStart = time[i][0];
          int tempEnd = time[i][1];
          time[i][0] = time[i+1][0];
          time[i][1] = time[i+1][1];
          time[i+1][0] = tempStart;
          time[i+1][1] = tempEnd; 
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

  public static void assign(int[][] time, int cas,int n){
    int[] jtime = new int[1441];
    int[] ctime = new int[1441];
    int result = "";

    for(int i=0;i<n;++i){
      int start = time[i][0];
      int end = time[i][1];
      if(hasTime(ctime,start,end)){
        addTime(ctime,start,end);
        result += "C";
      }
      else if(hasTime(jtime,start,end)){
        addTime(jtime,start,end);
        result += "J";
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
      int[][] timetable = new int[n][2];
      for(int j=0;j<n;++j){
        int start = in.nextInt();
        int end = in.nextInt();
        timetable[j][0]= start;
        timetable[j][1]= end;
      }
      sortIt(timetable,n);
      assign(timetable,i,n);
      
    }
    
  }

}
