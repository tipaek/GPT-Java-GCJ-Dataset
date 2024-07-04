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
             
             
             
             for(int j=0;j<N;j++){
             //System.out.println(N);
            String line = sc.nextLine();
            int ca =0;
            for(String s : line.split(" ")){
            if(ca<2){
            m[j][ca] = Integer.parseInt(s);
            dm[j][ca] = Integer.parseInt(s);}
            ca =ca+1;
            
            }
            
            }
             
//             for(int j=0;j<N;j++){
//             
//            String line = sc.nextLine();
//            int ca =0;
//            for(String s : line.split(" ")){
//            if(ca<2){
//            m[j][ca] = Integer.parseInt(s);
//            dm[j][ca] = Integer.parseInt(s);
//            ca =ca+1;
//            }
//                      
//            }
//            
//            }
             String r="";
             int[] res= new int[N];
             for(int r1=0;r1<N;r1++)
                 res[r1] =0;
             //real algo
             //System.out.println("Program Started.......");
             int[][] ov = new int[N][N];
             int[][] ovd = new int[N][N];
             for(int k=0;k<N;k++){
                 in: 
                 for(int l=0;l<N;l++){
                 
                     if(k==l){
                     ov[k][l] =0;
                     ovd[k][l] =0;
                     continue in;}
                     
                     if((m[k][0] >= m[l][0] && m[l][1] > m[k][0]) ||( m[k][1] >m[l][0] && m[l][1] >= m[k][1]) ){
                     ov[k][l] =1;
                     ovd[k][l] =1;
                     continue in;
                     }
                     
                     else if(m[k][0] == m[l][1]){
                     ov[k][l] =0;
                     ovd[k][l] =0;
                     continue in;
                     }
                     
                     else{
                     ov[k][l] =0;
                     ovd[k][l] =0;
                     continue in;
                     }
                                    
                     
                 }
             }
             
             //System.out.println("Overlap calculated.......");
             int sum=1000;
             
             while(sum!=0){
             outer:
             for(int p=0;p<N;p++){
                 int no=0;
                 int c=0;
                 int pos=-1;
             for(int y=0;y<N;y++){
             if(ov[p][y]==1)
             {
                 pos = y;
                 c = c+1;
                 no=1;
             }
                      
             }
             
              if(no==0 && res[p]==0){
                  res[p] =1;
                  continue outer;
             }
             
             
              
              for(int q=0;q<N;q++){
              
                  if(ov[p][q]==1 && res[p]==0 && res[q] ==0){
                  
                      res[p] = 1;
                      res[q] =2;
                      ov[p][q] = 0;
                      ov[q][p] = 0;
                  }
                  
                  if(ov[p][q]==1 && res[p]!=0 && res[q] ==0){
                      if(res[p]==1)
                          res[q] =2;
                      if(res[p]==2)
                          res[q]=1;
                      ov[p][q] =0;
                      ov[q][p] = 0;
                  }
                  if(ov[p][q]==1 && res[p]==0 && res[q] !=0){
                      if(res[q]==1)
                          res[p] =2;
                      if(res[q]==2)
                          res[p]=1;
                      ov[p][q] =0;
                      ov[q][p] = 0;
                  }
                  if(ov[p][q]==1 && res[p]!=0 && res[q] !=0){
                  //int flag=0;
                  if((res[p]==1 && res[q]==1) ||(res[p]==2 && res[q]==2)  ){
                      for(int cm=0;cm<N;cm++){
                      if(ovd[p][cm] == 1 && ovd[q][cm]==1){
                          System.out.println("Case #"+i+": "+"IMPOSSIBLE");
                      continue mainloop;
                      
                      }
                      else{
                      if(res[p]==1)
                          res[p] =2;
                      if(res[p]==2)
                          res[p]=1;
                      for(int de=0;de<N;de++){
                      
                          if(ovd[p][de]==1){
                          if(res[de]==1)
                          res[de] =2;
                          if(res[de]==2)
                          res[de]=1;
                      
                          }
                      }
                      
                      ov[p][q]=0;
                      ov[q][p]=0;
                  
                          
                      }
                      }
                  
                    //  flag=1;
                      
          
                  }
                  
                      
                  }
              }
              sum=0;
              //System.out.println("Print Overlap.......");
                     
             for(int a1=0;a1<N;a1++){
             
                 for(int a2=0;a2<N;a2++){
                     //System.out.print(ov[a1][a2]);
                 sum = sum +ov[a1][a2];
                 }
                 //System.out.println();
             }
             }
       }
             
             
             
             
             
             

      
          
         
          for(int f=0;f<N;f++){
          if(res[f]==1)
           r=r+"C";
          if(res[f]==2)
           r=r+"J";
          
          }
          
          System.out.println("Case #"+i+": "+r);
          
        }
    
    }
}
        
    
