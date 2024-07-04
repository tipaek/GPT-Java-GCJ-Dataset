import java.util.*;
import java.io.*;
import java.lang.*;


class Solution{
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        int x=1;
            
       while(x<=test){
        int n=sc.nextInt();
        ArrayList<job> arrJam=new ArrayList<job>();
        ArrayList<job> arrCam=new ArrayList<job>();
        String ans="";
        job check;
        for(int i=0;i<n;i++){
            int flag=0;
            int begin=sc.nextInt();
            int comp=sc.nextInt();
            
            for(int ii=0;ii<arrJam.size();ii++){
                check=arrJam.get(ii);
                if(Math.max(check.start , begin)<Math.min(check.end,comp)){
                    flag=1;
                    break;
                }
            }
            
            if(flag==0){
                arrJam.add(new job(begin, comp));
                ans+="J";
                continue;
            }

            for(int gtr=0;gtr<arrCam.size();gtr++){
                check=arrCam.get(gtr);
                if(Math.max(check.start , begin)<Math.min(check.end,comp)){
                    flag=0;
                    break;
                }
            }
            if(flag==1){
                arrCam.add(new job(begin,comp));
                ans+="C";
                continue;
            }
            else{
                ans="IMPOSSIBLE";
                break;
            }
            
        }


        System.out.println("Case #"+x+": "+ans);
        x++;
       }
    }
}


class job{
    int start, end;
    job(int start,int end){
        this.start=start;
        this.end=end;
    }
}