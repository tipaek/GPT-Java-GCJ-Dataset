import java.util.*;
import java.io.*;
import java.lang.*;

class Paras{
    public static void main(String[] args)throws java.lang.Exception{
        try{
            Scanner scan=new Scanner(System.in);
            int t=scan.nextInt();
            for(int k=1;k<=t;k++){
             
             int n=scan.nextInt();
             int trace=0,row=0,col=0;
             int[][] a=new int[n][n];
             
             for(int i=0;i<n;i++){
                 for(int j=0;j<n;j++){
                    a[i][j]=scan.nextInt();     
                }
             }
             for(int i=0;i<n;i++){
                 for(int j=0;j<n;j++){
                     if(i==j){
                         trace+=a[i][j];
                     }
                 }
             }
             for(int i=0;i<n;i++){
                 int[] finder=new int[n+1];
                 for(int j=0;j<n;j++){
                    if(finder[a[i][j]]==0){
                        finder[a[i][j]]++;   
                    }
                    else{
                        row++;
                        break;
                    }
                 }
             }
             for(int j=0;j<n;j++){
                int[] find=new int[n+1];
                for(int i=0;i<n;i++){
                    if(find[a[i][j]]==0){
                        find[a[i][j]]++;
                    }
                    else{
                        col++;
                        break;
                    }
                } 
             }
             System.out.println("Case #"+k+": "+trace+" "+row+" "+col);
            }
        }catch(Exception e){
            System.out.println(e);
        }            
    }
}