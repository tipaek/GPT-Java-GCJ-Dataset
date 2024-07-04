import java.util.*;


public class Solution{

    private static class task implements Comparable<task>{
        public int s;
        public int e;

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
            ArrayList<task> tasks = new ArrayList<task>();
            for (int j=0;j<n;j++){
                tasks.add(new task(in.nextInt(),in.nextInt()));
            }
            Collections.sort(tasks);
            for(task job:tasks){
                if(ca<=job.s){
                    ca=job.e;
                    ans=ans+"C";
                    continue;
                }
                if(ja<=job.s){
                    ja=job.e;
                    ans=ans+"J";
                    continue;
                }
                ans="IMPOSSIBLE";
                break;
            }
            System.out.println("Case #"+ i +": "+ans );
        }
    }
}