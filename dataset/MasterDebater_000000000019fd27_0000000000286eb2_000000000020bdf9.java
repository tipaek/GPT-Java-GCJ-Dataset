import java.io.*;
import java.util.*;

class Solution{
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new PrintStream(System.out));

        int t=Integer.parseInt(in.readLine());
        for(int test=1;test<=t;test++){
            int n=Integer.parseInt(in.readLine());
            int totalSchedules=2*n;
            PriorityQueue<schedule>pq=new PriorityQueue<>();
            for(int i=0;i<n;i++){
                StringTokenizer st=new StringTokenizer(in.readLine());
                int start=Integer.parseInt(st.nextToken());
                int end=Integer.parseInt(st.nextToken());
                pq.add(new schedule(start,0,i*2));
                pq.add(new schedule(end,1,i*2));
            }

            String[]ansArr=new String[n];
            int cameron=-1;
            int jamie=-1;
            out.print("Case #"+(test)+": ");
            for(int i=0;i<totalSchedules;i++){
                schedule currentTime=pq.poll();
                if(cameron!=-1 && jamie!=-1 && currentTime.startOrEnd==0){
                    Arrays.fill(ansArr,"");
                    out.print("IMPOSSIBLE");
                    break;
                }
                boolean done=false;
                if(currentTime.startOrEnd==0 && -1==cameron){
                    ansArr[currentTime.idx/2]="C";
                    cameron=currentTime.idx;
                    done=true;
                }
                if(currentTime.startOrEnd==0 && -1==jamie && !done){
                    ansArr[currentTime.idx/2]="J";
                    jamie=currentTime.idx;
                }
                done=false;
                if(currentTime.startOrEnd==1 && currentTime.idx==cameron){
                    cameron=-1;
                    done=true;
                }
                if(currentTime.startOrEnd==1 && !done){
                    jamie=-1;
                }

            }
            String ans="";
            for(int i=0;i<n;i++){
                ans+=ansArr[i];
            }
            out.println(ans);
        }

        in.close();
        out.close();
    }
}
class schedule implements Comparable <schedule>{
    int a;
    int startOrEnd;
    int idx;

    schedule(int Pa, int PstartOrEnd, int pIdx)
    {
        a=Pa;
        startOrEnd=PstartOrEnd;
        idx=pIdx;
    }
    public int compareTo(schedule otherSchedule)
    {
        if(this.a== otherSchedule.a){
            return otherSchedule.startOrEnd-this.startOrEnd;
        }
        else{
            return this.a- otherSchedule.a;
        }
    }
}