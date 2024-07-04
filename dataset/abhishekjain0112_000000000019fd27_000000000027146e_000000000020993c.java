/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CODEJAM;

import java.util.Scanner;

/**
 *
 * @author Abhishek
 */
public class Program1 {
 
    
    public static void main(String[] args) {
        
        Scanner sc =new Scanner(System.in);
       
          int t=sc.nextInt();
          
      int n=0,rowcount=0,columcount=0,ck=0;

    for(int c=0;c<t;c++){

   n=sc.nextInt();
           
       int [][]mat=new int[n][n]; 
        rowcount=0;columcount=0;   
        int sum=0;
        
         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){         
              mat[i][j]=sc.nextInt();
               if(i==j)
                   sum+=mat[i][j];
            }
         }
// for row         
         for(int i=0;i<n;i++){
             l1: for(int k=1;k<=n;k++){  
               ck=0;
             for(int j=0;j<n;j++){
                if(k==mat[i][j])
                    ck++;
                 if(ck==2){
                  rowcount++;
                  ck=0;
                  break l1;
                 }
             }
           }
         }
 // for column
                for(int i=0;i<n;i++){
         l1:   for(int k=1;k<=n;k++){  
               ck=0;
             for(int j=0;j<n;j++){
                if(k==mat[j][i])
                    ck++;
                 if(ck==2){
                  columcount++;
                  ck=0;
                  break l1;
                 }
             }
           }
         }//
           System.out.println("Case #"+(c+1)+":"+" "+sum+" "+rowcount+" "+columcount);     
                
 
        }
          
          
        
    }
    
    
    
}
