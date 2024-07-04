import java.util.*;
import java.io.*;
import java.lang.*;


class Solution{
    int start, end;
    Solution(int start,int end){
        this.start=start;
        this.end=end;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        int x=1;
            
       while(x<=test){
        int n=sc.nextInt();
        ArrayList<Solution> arrJam=new ArrayList<Solution>();
        ArrayList<Solution> arrCam=new ArrayList<Solution>();
        String ans="";
        Solution check;
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
                arrJam.add(new Solution(begin, comp));
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
                arrCam.add(new Solution(begin,comp));
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

