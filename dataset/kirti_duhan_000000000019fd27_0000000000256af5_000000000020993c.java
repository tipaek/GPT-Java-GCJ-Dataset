import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
      Scanner scn=new Scanner(System.in);
      int t=scn.nextInt();
      for(int i1=1;i1<=t;i1++){
         int n=scn.nextInt();
         int[][]arr=new int[n][n];
         for(int i2=0;i2<n;i2++){
             for(int j1=0;j1<n;j1++){
                 arr[i2][j1]=scn.nextInt();
             }
         }
         int row=0;
         int col=0;
         for(int i3=0;i3<n;i3++){
              int flag=0;
             for(int j2=0;j2<n-1;j2++){
                  int x=arr[i3][j2];
                 for(int k=1+j2;k<n;k++){
                     if(x==arr[i3][k]){
                     row++;
                     flag=1;
                     break;
                    }
                 }
                 if(flag==1)
                 break;
                 
             }
         }
         
         for(int j3=0;j3<n;j3++){
             int flag1=0;
             for(int i4=0;i4<n-1;i4++){
                 int y=arr[i4][j3];
                 for(int k=1+i4;k<n;k++){
                    if(y==arr[k][j3]){
                     col++;
                     flag1=1;
                     break;
                    } 
                }
                if(flag1==1)
                break;
                 
             }
         }
         int trace=0;
         for(int i5=0;i5<n;i5++){
             trace+=arr[i5][i5];
         }
         System.out.println("Case"+" "+"#"+i1+":  "+trace+" "+row+" "+col);
      }
      
    }
}