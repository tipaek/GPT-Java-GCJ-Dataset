import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class Solution {
    static int trace(int arr[][],int n){
     int sum=0;
        for(int i=0;i<n;i++){
     for(int j=0;j<n;j++){
     if(i==j)
         sum+=arr[i][j];
     }
    }
        return sum;
}
   
        static int rowsrep(int arr[][],int n){
     int sum=0;
        for(int i=0;i<n;i++){
            HashSet hm=new HashSet();
     for(int j=0;j<n;j++){
     hm.add(arr[i][j]);
         
     }
     if(hm.size()!=n)
         sum++;
    }
        return sum;
}
           static int colsrep(int arr[][],int n){
     int sum=0;
        for(int j=0;j<n;j++){
            HashSet hm=new HashSet();
     for(int i=0;i<n;i++){
     hm.add(arr[i][j]);
         
     }
     if(hm.size()!=n)
         sum++;
    }
        return sum;
}
    
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t_case=sc.nextInt();
        for(int i=1;i<=t_case;i++){
        int n=sc.nextInt();
        int arr[][]=new int[n][n];
        for(int j=0;j<n;j++){
        for(int k=0;k<n;k++){
        arr[j][k]=sc.nextInt();
        }
        }
           int trans,col,row;
           trans=trace(arr,n);
            row=rowsrep(arr,n);
             col=colsrep(arr,n);
             System.out.println("Case #"+t_case+":"+" "+trans+" "+row+" "+col);                  //Case #1: 4 0 0
        }
    }
}