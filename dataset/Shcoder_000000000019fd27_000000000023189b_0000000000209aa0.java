import java.lang.*;
import java.io.*;
import java.util.*;

public class Solution{
    
    public static boolean sol(int n,int k){
        if(n==2 && (k!=2 || k!=4))return false;
        
        if(k<n || k>3*n)return false;
        
        Set<Integer> set=new HashSet<Integer>();
        
        for(int i=1;i<=n;i++){
            int sum=3*i;
            if(sum==k)return true;
            if(sum>k)break;
        }
        
        int allSum=(n*(n+1))/2;
        
        return allSum==k;
        
    }
    
    public static void main(String[] args){
         Scanner in=new Scanner(System.in);
        
        int t=in.nextInt();
        in.nextLine();
        for(int i=0;i<t;i++){
            int n=in.nextInt();
            int k=in.nextInt();
            in.nextLine();
            System.out.println("Case #"+(i+1)+": "+(sol(n,k)?"POSSIBLE":"IMPOSSIBLE"));
        }
    }
}