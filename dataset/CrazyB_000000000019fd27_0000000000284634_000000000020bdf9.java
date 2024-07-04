import java.util.*;

public class Solution{

    private static class task implements Comparable<task>{
        public int s;
        public int e;
        public char CJ;

        public int compareTo(task t){
            return this.s-t.s;
        }

        task(int s, int e){
            this.s=s;
            this.e=e;
        }
    }

    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        int  t = in.nextInt();

        for (int i=1;i<=t;i++ ){
            int n = in.nextInt();
            String ans="";
            int ca=-1;
            int ja=-1;
            ArrayList<task> orig = new ArrayList<task>();
            ArrayList<task> tasks = new ArrayList<task>();
            for (int j=0;j<n;j++){
                task z= new task(in.nextInt(),in.nextInt());
                tasks.add(z);
                orig.add(z);
            }
            Collections.sort(tasks);
            for(task job:tasks){
                if(ca<=job.s){
                    ca=job.e;
                    job.CJ='C';
                    continue;
                }
                if(ja<=job.s){
                    ja=job.e;
                    job.CJ='J';
                    continue;
                }
                ans="IMPOSSIBLE";
                break;
            }
            if (ans=="") {
                for (task job : orig) {
                    ans = ans + job.CJ;
                }
            }

            System.out.println("Case #"+ i +": "+ans );
        }
    }
}