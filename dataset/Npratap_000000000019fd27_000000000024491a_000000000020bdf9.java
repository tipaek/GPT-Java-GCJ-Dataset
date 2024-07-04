import java.util.*;
import java.io.*;


import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String n1 = sc.nextLine();
        int n = Integer.parseInt(n1);
       mainloop: 
       for(int i=1;i<=n;i++){
            String N1 = sc.nextLine();
            int N = Integer.parseInt(N1);
             int[][] m = new int[N][2];
             int[][] dm = new int[N][2];
             int temp1=0;
             int temp2=0;
            for(int j=0;j<N;j++){
             
            String line = sc.nextLine();
            int c =0;
            for(String s : line.split(" ")){
            if(c<2)
            m[j][c] = Integer.parseInt(s);
            dm[j][c] = Integer.parseInt(s);
            c =c+1;
            
            }
            
            }
          String r="";
//          for(int k=0;k<N;k++){
//           for(int l=k;l<N;l++){
//           if(dm[k][0] > dm[l][0]){
//           temp1 = dm[l][0];
//           temp2 = dm[l][1];
//           
//           dm[l][0] = dm[k][0];
//           dm[l][1] = dm[k][1];
//           
//           dm[k][0] = temp1;
//           dm[k][1] = temp2;
//               
//           }
//           }
//          
//          
//          }
          int[] res= new int[N];
          int[] resf= new int[N];
          res[0] = 0;
          for(int p=1;p<N;p++){
          int sp=0;
          int ep=0;
          //starting point overlaps
          if(dm[p-1][0] <= dm[p][0] && dm[p-1][1] > dm[p][0] ){
          sp=1;
          }
          if(dm[p-1][0] <= dm[p][1] && dm[p-1][1] > dm[p][1] ){
          ep=1;
          }
          
          if(sp ==1 && ep==1){
          System.out.println("Case #"+i+": "+"IMPOSSIBLE");
          continue mainloop;
          }
          
          
          
          if(sp==1 || ep==1){
           if(res[p-1] == 0)
               res[p] = 1;
           else
               res[p] = 0;
          }
          else{
          res[p] = res[p-1];
          }
          
          
          
          
          
          }
          
        //   int temp=0;
        //   for(int g=0;g<N;g++){
        //      for(int h=0;h<N;h++){
        //      if(dm[g][0] == m[h][0]){
        //      resf[h] = res[g];
        //      }
        //      }
        //   }
          
          for(int f=0;f<N;f++){
          if(res[f]==0)
           r=r+"C";
          if(res[f]==1)
           r=r+"J";
          
          }
          
          System.out.println("Case #"+i+": "+r);
          
        }
    
    }
}
        
    
