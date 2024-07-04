import java.util.*;
import java.io.*;
class Task {
    int start;
    int end;
    int pos;
    public Task(int s,int e,int p){
        this.start = s;
        this.end = e;
        this.pos = p;
    }
}
public class Solution {
    public static void main(String[] args)throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        for(int l=0;l<t;l++) {
            int n = Integer.parseInt(in.readLine());
            ArrayList<Task> tasks = new ArrayList<>();
            for(int i=0;i<n;i++) {
                String input[] = in.readLine().split(" ");
                Task task = new Task(Integer.parseInt(input[0]),Integer.parseInt(input[1]),i);
                tasks.add(task);
            }
            String str="";
            for(int i=0;i<n;i++) {
                str+="C";
            }
            Collections.sort(tasks,new Comparator<Task>(){
                public int compare(Task t1,Task t2) {
                    if(t1.start>t2.start) return 1;
                    else return -1;
                }
            });
            int Cstart=tasks.get(0).start,Cend=tasks.get(0).end;
            int Jstart=-1,Jend=-1;
            boolean flag = false;
            StringBuilder sb = new StringBuilder(str);
            for(int i=1;i<n;i++) {
                if(tasks.get(i).start>=Cstart && tasks.get(i).start<Cend) {
                    if(tasks.get(i).start>=Jstart && tasks.get(i).start<Jend) {
                        System.out.printf("Case #%d: IMPOSSIBLE\n",l+1);
                        flag = true;
                        break ;
                    } else {
                        Jstart = tasks.get(i).start;
                        Jend = tasks.get(i).end;
                        sb.setCharAt(tasks.get(i).pos,'J');
                    }
                } else {
                    Cstart = tasks.get(i).start;
                    Cend = tasks.get(i).end;
                    str+="C";
                }
            }
            if(!flag)
            System.out.printf("Case #%d: %s\n",l+1,sb.toString());
        }
    }
}