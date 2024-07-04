

import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int count_r = 0;
       int count_c = 0;
       
       
       int size;
       int check;
     
        int T=sc.nextInt();
        int f[] = new int[T];
       int z[] = new int[T];
       int diag[] =new int[T];
       
        for(int t=0;t<T;t++){
            count_c=0;
            count_r=0;
            diag[t]=0;
            check=0;
            
          //enter the size of matrix
            size=sc.nextInt();
           int r=size;
           int c=size;
          int arr[][]=new int[size][size]; 
          
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
          
 
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                 check=arr[i][j];
                 
                    for(int l=j+1;l<r;l++){
                      if(check==arr[i][l]){
                        count_r=count_r+1;
                        break;
                    }
                      
                  }
                }
                    if(count_r==1){
                       f[t]=f[t]+1;
                      }
                }
           

                for(int j=0;j<c;j++){
                     for(int i=0;i<r;i++){
                
                      check=arr[i][j];
                      
                    for(int l=j+1;l<r;l++){
                      if(check==arr[l][i]){
                        count_c=count_c+1;
                        break;
                      }
                    }                 
                      
                 }
                      if(count_c==1){
                       z[t]=z[t]+1;
                      }
                }
 
           //diagonal sum
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    if(i==j){
                        diag[t]=diag[t]+arr[i][j];
                    }
                }
            } 
      
        }  
        
        for(int i=0;i<T;i++){
            System.out.println("Case #"+(i+1)+":"+" "+diag[i]+" "+f[i]+" "+z[i]);
        }
    }
    
}
