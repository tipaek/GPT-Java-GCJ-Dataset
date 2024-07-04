import java.util.*;
import java.io.*;
class Solution{
    public static void main(String arf[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int q=0;
        
        while(q++<t){
            int i;
            String ans="";
            System.out.print("Case #"+q+": ");
            ArrayList<Integer[]>a=new ArrayList<Integer[]>();
            ArrayList<Integer[]>b=new ArrayList<Integer[]>();
            int n=sc.nextInt();
            while(n-->0){
                // System.out.println(n);
                int x=sc.nextInt();
                int y=sc.nextInt();
                for(i=0;i<a.size();i++){
                    Integer r[]=a.get(i);
                    if(y<=r[0] ||x>=r[1])
                        continue;
                    else
                        break;
                }
                if(i==a.size()){
                    Integer e[]=new Integer[2];
                    e[0]=x;
                    e[1]=y;
                    a.add(e);
                    ans+="C";
                }else{
                    for(i=0;i<b.size();i++){
                        Integer r[]=b.get(i);
                        if(y<=r[0] ||x>=r[1])
                            continue;
                        else
                            break;
                    }
                    if(i==b.size()){
                        Integer e[]=new Integer[2];
                        e[0]=x;
                        e[1]=y;
                        b.add(e);
                        ans+="J";
                    }
                    else
                        break;
                }
            }
            if(n!=-1)
                ans="IMPOSSIBLE";
            while(n-->0){
                sc.next();
                sc.next();
            }
            System.out.println(ans);
            // System.out.println(n);
            
                
        }
    }
}