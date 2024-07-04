import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args){

        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(br.readLine());
            for(int i=1;i<=t;i++){
                String[] ss=br.readLine().split(" ");
                long x=Long.parseLong(ss[0]);
                long y=Long.parseLong(ss[1]);
                String ans=bfs(x,y);

                System.out.println("Case #"+i+": "+ans);
            }


        }catch(Exception e){
            System.out.println("KKKK "+e.getMessage());
        }
    }
    static String bfs(long x,long y){
        HashMap<Integer,HashSet<Integer>> list=new HashMap<>();
        Queue<pair> q=new ArrayDeque<>();
        q.add(new pair(0,0,1,""));
        while(q.size()>0){
            pair p=q.poll();
            long a=p.x,b=p.y;
            long i=p.z;

            String str=p.str;
            if(a==x && b==y){
                return str;
            }
            if(i>=12){
                break;
            }
            long jump=(long)Math.pow(2,i-1);
            q.add(new pair(a+jump,b,i+1,str+"E"));
            q.add(new pair(a-jump,b,i+1,str+"W"));
            q.add(new pair(a,b+jump,i+1,str+"N"));
            q.add(new pair(a,b-jump,i+1,str+"S"));
        }
        return "IMPOSSIBLE";
    }

    static class pair{

        long x,y,z;
        String str;
        public pair(long x,long y,long z,String str){
            this.x=x;
            this.y=y;
            this.z=z;
            this.str=str;
        }
    }

    static void shuffle(int[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
}
