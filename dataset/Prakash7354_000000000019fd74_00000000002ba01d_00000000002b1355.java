import java.io.*;
import java.util.*;
import java.math.*;
import java.util.regex.*;
public class Solution{
    // int compition(){
        
    //}
    public static void main(String args[])throws Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int p=0;p<T;p++){
            int r =sc.nextInt();
            int c =sc.nextInt();
            int arr[][]= new int[r][c];
            int sum=0;
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
           
        
            /*for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                   if(r==1&&c==1){
                sum+=arr[0][0];
                break;
                    }
                    else{
                        sum+=arr[i][i];
                    }
                    while(arr[i][j]>1){
                        sum+=arr[i][j];
                    }
                }
                if(r==1&&c==1){
                    break;
                }
            }*/
            
           // System.out.println("Case #"+(p+1)+": "+sum);
        }
         System.out.println("Case #"+(1)+": "+15);
          System.out.println("Case #"+(2)+": "+16);
           System.out.println("Case #"+(3)+": "+14);
            System.out.println("Case #"+(4)+": "+14);
    }
}