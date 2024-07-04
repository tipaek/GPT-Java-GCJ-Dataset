import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=sc.nextInt();
       
        for(int o=1;o<=t;o++){
            int s=sc.nextInt();
        int a[][]=new int[s][s];
        for(int i=0;i<s;i++){
            for(int j=0;j<s;j++){
                a[i][j]=sc.nextInt();
                System.out.print(" ");
            }
        }
        int sum=0;
        for(int i=0;i<s;i++){
            for(int j=0;j<s;j++){
                if(i==j){
                    sum=sum+(a[i][j]);
                }
                
            }
        }
        /*int row=0,col=0,cr=0,cc=0;
        for(int i=0;i<s-1;i++){
            for(int j=0;j<s-1;j++){
                if(a[i][j]==a[i][j+1]){
                    row=1;
                }
                if(a[i][j]==a[i+1][j]){
                    col=1;
                }
            }
                if(row==1){
                    cr++;
                }
                
                if(col==1){
                    cc++;
                }
                
            }
            if(cr>0){
                cr=cr+1;
            }
            if(cc>0){
                cc=cc+1;
            }*/
        int row=0,col=0,cr=0,cc=0;
       
       int al=0,la=0; 
        for(int i=0;i<s;i++){
           
          for(int j=0;j<s;j++){
            al=0;
           
            for(int k=0;k<s;k++){
        
              if(a[i][j]==a[k][j] && i!=k){
                al=1;
            
                }
                }
          }
          if(al>0){
             cr++;
             
              }
        }
          
            for(int i=0;i<s;i++){
           
            la=0;
          for(int j=0;j<s;j++){
            
                for(int k=0;k<s;k++){
                  int m=a[i][j],n=a[i][k];
                  if(a[i][j]==a[i][k] && j!=k){
                    la=1;
                    }
                  }
            }
           
             if(la >0){
                cc++;
               
                }
            
        }
        
        System.out.println("case #"+o+": "+ sum+" "+cc+" "+cr);
        }
       // System.out.println();
    }
}
