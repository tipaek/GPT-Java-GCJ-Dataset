import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int x=1; x<=t; x++){
            
        int n = sc.nextInt();
        int[][] ar = new int[n][n];
        long sum = 0;
        int rsize = 0;
        
           for(int i=0;i<n;i++){
           for(int j=0;j<n;j++)
            ar[i][j] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            Set<Integer> r = new HashSet<>();
           for(int j=0;j<n;j++){
               r.add(ar[i][j]);
            if(i == j){
                sum = sum + ar[i][j]; 
            }
        }
        int dup = n- r.size()+1;
        if(dup != 1 && dup>rsize ){
            rsize = dup;
        }
        r.clear();
        }
        int csize = 0;
        boolean flag = false;
            for(int i=0;i<n;i++){
            Set<Integer> c = new HashSet<>();
           for(int j=0;j<n;j++)
                c.add(ar[j][i]);
        
       int dup = n- c.size()+1;
        if(dup != 1 && dup>csize ){
            csize = dup;
        }
        c.clear();
        }
        
        System.out.println("Case #"+x+": "+sum+" "+rsize+" "+csize);
        }
    }
}