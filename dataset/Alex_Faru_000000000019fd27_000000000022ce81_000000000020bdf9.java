import java.util.*;
import java.io.*;

class Solution{
   public static void main(String args[])throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int counter = 1;
         
            int C = 0, J = 0;
            while(counter <= T){
               C = 0;
               J = 0;
               String ans = "";
               st = new StringTokenizer(br.readLine());
               int N = Integer.parseInt(st.nextToken());
               List<Interval> intervals = new ArrayList<>();
               for(int i = 0; i < N; i++){
                  st = new StringTokenizer(br.readLine());
                  int start = Integer.parseInt(st.nextToken());
                  int end = Integer.parseInt(st.nextToken());
                  Interval iT = new Interval(start,end,i);
                  intervals.add(iT);
               }
               
               Collections.sort(intervals, (a,b)->{
                  return a.start-b.start;
               });
               
               int index = 0;
               boolean imp = false;
               while(index < intervals.size()){
                  Interval cI = intervals.get(index++);
                  if(C <= cI.start){
                     C = cI.end;
                     cI.le = 'C';
                  }else if(J <= cI.start){
                     J = cI.end;
                     cI.le = 'J';
                  }else{
                     imp = true;
                     break;
                  }
               }
               
               if(imp){
                  bw.write("Case #"+counter+": IMPOSSIBLE\n");
                  bw.flush();
               }else{
                  ans = buildStr(intervals);
                  bw.write("Case #"+counter+": "+ans+"\n");
                  bw.flush();
               }
               
               
               counter++;
            }
            
            bw.close();
            br.close();
    }
     
    public static String buildStr(List<Interval> l){
      char [] w = new char [l.size()];
      for(int i = 0; i < l.size(); i++){
         Interval iT = l.get(i);
         w[iT.index] = iT.le;
      }
      return new String(w);
    }
  }
  
  class Interval{
      public int start;
      public int end;
      public int index;
      public char le;
      public Interval(int s, int e, int index){
         start = s;
         end = e;
         this.index = index;
         le = '?';
      }
   }
      