import java.util.Scanner;
import java.util.Vector;

class TaskScheduler{
    public static schedule impo=new schedule();

    public static boolean overlap(task a, task b){
        if(a.start>b.start&&a.end<b.end)return true;
        else if(a.start<b.start&&a.end>b.end)return true;
        else if(a.start<b.start&&b.start<a.end)return true;
        else if(b.start<a.start&&a.start<b.end)return true;
        else return false;
    }

    public static schedule createSch(Vector<task> tasks, int pos, String ans){
        for(int i=pos;i<tasks.size();i++){
            boolean[] over=new boolean[i];
            boolean imp=false;
            int p=-1;
            for(int j=0;j<i;j++){
                over[j]=overlap(tasks.elementAt(i), tasks.elementAt(j));
                if(over[j])p=j;
            }
            for(int j=0;j<i;j++)for(int k=j+1;k<i;k++)if(over[j]&&over[k]&&ans.charAt(k)!=ans.charAt(j))imp=true;
            if(imp)return impo;
            else{
                if(p>-1){
                    if(ans.charAt(p)=='J')ans+="C";
                    else ans+="J";
                }else{
                    schedule sc1=createSch(tasks, i+1, ans+"C"),sc2=createSch(tasks, i+1, ans+"J");
                    if(sc1.equals(impo)&&sc2.equals(impo))return impo;
                    else if(!(sc1.equals(impo))){
                        i=sc1.pos;
                        ans=sc1.result;
                    }else{
                        i=sc2.pos;
                        ans=sc2.result;
                    }
                }
            }
        }
        schedule finSchedule=new schedule();
        finSchedule.pos=tasks.size();
        finSchedule.result=ans;
        return finSchedule;
    }
    
    public static Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {
        int tc;
        impo.pos=0;
        impo.result="IMPOSSIBLE";
        tc=scan.nextInt();
        for(int c=0;c<tc;c++){
            int n=scan.nextInt();
            Vector<task> tasks=new Vector<task>();
            for(int i=0;i<n;i++){
                task tmp=new task();
                tmp.start=scan.nextInt();
                tmp.end=scan.nextInt();
                tasks.add(tmp);
            }
            System.out.print("Case #"+(c+1)+": "+createSch(tasks,0,"").result+"\n");
        }
    }
}

class task{
    public int start,end;
    task(){
        start=0;
        end=1440;
    }
}
class schedule{
    public String result;
    public int pos;
    schedule(){
        result="";
        pos=0;
    }
}