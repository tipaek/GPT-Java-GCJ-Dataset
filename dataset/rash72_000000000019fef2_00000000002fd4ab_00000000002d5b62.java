import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner scan=new Scanner(System.in);
        int tc=scan.nextInt();
        int iter=0;
        while(iter++<tc){
            int x=scan.nextInt(),y=scan.nextInt();
            int limit=Math.abs(x)+Math.abs(y);
            String direction="";
            ArrayList<Integer> arrL=new ArrayList<Integer>();
            
            int i=0,inst=0;
            while(inst<limit){
                int t=(int)Math.pow(2,i);
                inst+=t;
                arrL.add(t);
                ++i;
            }
            int end=arrL.size()-1;
            while(end>-1){
                int t=arrL.get(end);
                // System.out.print(t+" ");
                int xt=Math.abs(x),yt=Math.abs(y);
                int maxi=Math.max(xt,yt);
                
                if(maxi==xt){
                    if(x>0){
                        x=x+(t*-1);
                        direction="E"+direction;
                    }
                    else{
                        x=x+t;
                        direction="W"+direction;
                    }
                }
                else{
                    if(y>0){
                        y=y+(t*-1);
                        direction="N"+direction;
                    }
                    else{
                        y=y+t;
                        direction="S"+direction;
                    }
                }
                end--;
            }
            
            
            System.out.printf("Case #%d: %s\n",iter,(x==0 && y==0)?direction:"IMPOSSIBLE");
        }
        
    }
}