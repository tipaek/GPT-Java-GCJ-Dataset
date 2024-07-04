import java.util.*;
import java.io.*;

public class Solution{
   public static void main(String arg[]){
       
        Scanner read = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nCases=read.nextInt();
        
        for(int i=0;i<nCases;i++){
            int tasks=read.nextInt();
            int cEnd=0,jEnd=0;
            int hours[][]=new int[tasks][3];
            StringBuilder result=new StringBuilder("");
            boolean prev[]=new boolean[tasks];
            
            for(int j=0;j<tasks;j++){
               hours[j][0]=read.nextInt();
               hours[j][1]=read.nextInt();
               hours[j][2]=j;
            }
            Arrays.sort(hours, (a, b) -> Double.compare(a[0], b[0]));
            
            for(int j=0;j<tasks;j++){
               int tStart=hours[j][0];
               int tEnd=hours[j][1];
               if(cEnd<=tStart){//C can take it
                  cEnd=tEnd;
                  prev[hours[j][2]]=false;//C
                  continue;
               }
               if(jEnd<=tStart){//J can take it
                  jEnd=tEnd;
                  prev[hours[j][2]]=true;//J
                  continue;
               }
               result=new StringBuilder("IMPOSSIBLE");
               break;
            }
            if(result.length()==0){
               for(int j=0;j<tasks;j++){
                  if(prev[j]){
                     result.append('J');
                  }else{
                     result.append('C');               
                  }
               }
            }
            System.out.println("Case #"+(i+1)+": "+result);
        }
   }
}