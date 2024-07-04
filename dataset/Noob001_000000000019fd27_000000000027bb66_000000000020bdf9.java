import java.util.*;
import java.util.Comparator;
class Solution{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            task[] tasks=new task[n];
            for (int j=0;j<n;j++){
                int s=sc.nextInt();
                int e=sc.nextInt();
                tasks[j]=new task(s,e,j);
            }
            Arrays.sort(tasks,new Comp_time());
            int p1=-1;//C
            int p2=-1;//
            boolean poss=true;
            for (int j=0;j<n;j++){
                if(p1==-1){
                    p1=j;
                    tasks[p1].comp_by="C";
                }else{
                    if(p2==-1){
                        p2=j;
                        tasks[p2].comp_by="J";
                    }else{
                        if(tasks[p1].end<=tasks[p2].end){
                            if(tasks[p1].end<=tasks[j].start){
                                p1=j;
                                tasks[p1].comp_by="C";
                            }else{
                                poss=false;
                                break;
                            }
                        }else{
                            if(tasks[p2].end<=tasks[j].start){
                                p2=j;
                                tasks[p2].comp_by="J";
                            }else{
                                poss=false;
                                break;
                            }
                        }
                    }
                }
            }
            Arrays.sort(tasks,new Comp_index());
            String out="";
            if(poss) {
                for (int j = 0; j < n; j++) {
                    out+=tasks[j].comp_by;
                }
            }else{
                out="IMPOSSIBLE";
            }
            System.out.println("Case #"+(i+1)+": "+out);

        }
    }
}

class task{
    int start;
    int end;
    String comp_by;
    int index;
    task(int s,int e,int i){
        this.start=s;
        this.end=e;
        this.index=i;
    }

}

class Comp_time implements Comparator<task>{
    @Override
    public int compare(task t1, task t2){
        if(t1.start!=t2.start){
            return t1.start-t2.start;
        }else{
            return t1.end-t2.end;
        }
    }
}

class Comp_index implements Comparator<task>{
    @Override
    public int compare(task t1, task t2){
        return t1.index-t2.index;
    }
}