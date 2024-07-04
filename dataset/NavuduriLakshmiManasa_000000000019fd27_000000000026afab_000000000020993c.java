import java.util.Scanner;
import java.util.*;
public class Solution{
    public static void main(String args[]){
         int tccount=1;
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        while(tc>0){
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            int t;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                    //trace adding
                    if(i==j)
                    t+=arr[i];
                }
            }
            int nr=0,nc=0;
           
            
            for(int i=0;i<n;i++){
                //for each row 
         HashSet<Integer>hsr=new HashSet<>();
                for(int j=0;j<n;j++)
                hsr.add(arr[i][j]);
                if(hsr.size()<n)
                nr++;
            }
            for(int j=0;j<n;j++){
                //for each col
         HashSet<Integer>hsc=new HashSet<>();
                for(int i=0;i<n;i++)
                hsr.add(arr[i][j]);
                if(hsc.size()<n)
                nc++;
            }
            //for each tc
            //o/p
            System.out.println("Case #"+tccount+": "+t+" "+nr+" "+nc);
            tccount++;
            tc--;
        }
    }
}