

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;



class ParentingCodejam {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  t = Integer.parseInt(br.readLine());
        while(t-- >0){
            int  N = Integer.parseInt(br.readLine());
            Integer[] []start=new Integer[N][2];
           
            int[] c= new int[1441];
            int[] j= new int[1441];
            
            for(int i=0;i<N;i++){
                StringTokenizer token = new StringTokenizer(br.readLine());
                start[i][0]=Integer.parseInt(token.nextToken());
                start[i][1]=Integer.parseInt(token.nextToken());
               }

               boolean impossible=false;
               StringBuilder str = new StringBuilder();
              x: for(int i=0;i<N;i++){
                int starttime=start[i][0];
                int endtime=start[i][1];
                boolean iscfree=true;
                boolean isjfree=true;
                for(int k=starttime;k<endtime;k++){
                    if(c[k]!=0){
                        iscfree=false;
                        break;
                    }

                }
                if(iscfree){
                    for(int k=starttime;k<endtime;k++){
                    
                        c[k]=1;
                       
                 }
                     str.append('C');
             
                }
                 else{
                    for(int k=starttime;k<endtime;k++){
                        if(j[k]!=0){
                            isjfree=false;
                            
                            impossible=true;
                           break x;
                        }
    
                    }
                    if(isjfree){
                        for(int k=starttime;k<endtime;k++){
                            j[k]=1;
                    }
                    str.append('J');
                 }
                }

               }
               if(impossible){
                   System.out.println("IMPOSSIBLE");
                   
               }
               else{
                   System.out.println(str);
               }
                   
               
            
            
        }
    }

}