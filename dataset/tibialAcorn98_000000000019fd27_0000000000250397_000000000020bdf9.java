import java.io.*;
import java.lang.*;
import java.util.*;

  public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int  t= in.nextInt();
        for(int k=0; k<t; k++){
            int n=in.nextInt();
            int[][] arr=new int[n][2];
            for(int i=0;i<n;i++){
                arr[i][0]=in.nextInt();
                arr[i][1]=in.nextInt();
            }
            mergeSort(arr);
            System.out.println("Case #"+(k+1)+": "+solve(arr));
        }
        
    }
    
    public static String solve(int[][]arr) {
        String ans="";
        int c=0;int j=0;
        for(int i=0;i<arr.length;i++){
            if(c<=arr[i][0]){
                ans+="C";
                c=arr[i][1];
            }
            else if(j<=arr[i][0]){
                ans+="J";
                j=arr[i][1];
            }
            else{
                return "IMPOSSIBLE";
            }
        }
        
        return ans;
    }
    
     public static int[][] mergeSort(int[][] a0){
       int n0,i,j,ind=0,top,n=a0.length;
       if(n==1)
        return a0;
       n0=(n/2);
       int[][] a=new int[n0][2];
       int[][] b=new int[n-n0][2];
       top=0;
       //divide step
       for(int i1=0;i1<n;i1++){
           if(ind<n0){
               a[ind]=a0[i1];
               ind++;
               //System.out.print("arr1"+a0[i1]+" ");
           }
           else{//System.out.print("arr2"+a0[i1]+" ");
               b[top]=a0[i1];
               top++;
           }
       }
       ind=0;
       a=mergeSort(a);
       b=mergeSort(b);
       //conqure
       i=0;j=0;
       while(i<n0&&j<top){
           if(a[i][0]>b[j][0]){
               a0[ind]=b[j];
               ind++; j++;
           }
           else{
               a0[ind]=a[i];
               i++; ind++;
           }
       }
       while(i<n0){
           a0[ind]=a[i];
           i++;
           ind++;
       }
       while(j<top){
           a0[ind]=b[j];
           j++;
           ind++;
       }
      return a0;
    }
    
}






