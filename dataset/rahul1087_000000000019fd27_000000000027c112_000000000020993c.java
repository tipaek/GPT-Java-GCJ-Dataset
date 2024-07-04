import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));;
        int t = sc.nextInt();
        for(int x=1; x<=t; x++){
            
        int n = sc.nextInt();
        
        int[][] ar = new int[n][n];
        int sum = 0;
        int rsize = 0;
        
           for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
            ar[i][j] = sc.nextInt();
           }
        }
        for(int i=0;i<n;i++){
            Set<Integer> r = new HashSet<>();
           for(int j=0;j<n;j++){
               r.add(ar[i][j]);
            if(i==j){
                sum = sum + ar[i][j]; 
            }
        }
   
        if(r.size()!= n){
            rsize = rsize +1;
        }
        r.clear();
        }
        int csize = 0;
            for(int i=0;i<n;i++){
            Set<Integer> c = new HashSet<>();
           for(int j=0;j<n;j++){
                c.add(ar[j][i]);
           }
    
         if(c.size()!= n){
            csize = csize +1;
        }
        c.clear();
        }
        
        System.out.println("Case #"+x+": "+sum+" "+rsize+" "+csize);
        }
    }
}