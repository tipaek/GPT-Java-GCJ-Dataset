import java.io.*;
import java.util.*;
class Main{
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int k=1;
        while(k<=t){
            int n=sc.nextInt();
            int arr[][]=new int[n][n];
            int sum=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                    if(i==j)sum+=arr[i][j];
                }
            }
            
            
            int r=0,c=0;
            for(int i=0;i<n;i++){
                Set<Integer> s=new HashSet<>();
                for(int j=0;j<n;j++)s.add(arr[i][j]);
                if(s.size()<n)r++;
            }
            for(int j=0;j<n;j++){
                Set<Integer> s=new HashSet<>();
                for(int i=0;i<n;i++){
                    s.add(arr[i][j]);
                }
                if(s.size()<n)c++;
            }
            System.out.println("Case #"+k+": "+sum+" "+r+" "+c);
            k++;
        }
    }
}