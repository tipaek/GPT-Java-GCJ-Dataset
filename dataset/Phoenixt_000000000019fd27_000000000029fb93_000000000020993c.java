import java.util.*;

class Solution{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int n=in.nextInt();
            int mat[][]=new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    mat[i][j]=in.nextInt();
            solve(mat,n,t);
        }
    }
    
    static void solve(int[][] mat,int n,int r){
        int trace=0,rc=0,cc=0;
        for(int i=0;i<n;i++){
             HashSet<Integer> hs=new HashSet<Integer>(); 
             int t=0;
             for(int j=0;j<n;j++){
                 if(hs.add(mat[i][j])==false)
                    t=1; 
             }
             rc+=t;
            
        }
        for(int i=0;i<n;i++){
             HashSet<Integer> hs=new HashSet<Integer>(); 
             int t=0;
             for(int j=0;j<n;j++){
                 if(hs.add(mat[j][i])==false)
                    t=1; 
             }
             cc+=t;
            
        }
        
        for(int i=0;i<n;i++){
            trace+=mat[i][i];
        }
        
        System.out.println("Case #"+r+": "+trace+" "+rc+" "+cc);

    }
}