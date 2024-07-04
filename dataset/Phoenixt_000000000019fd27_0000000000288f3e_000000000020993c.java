import java.util.*;

class Solution{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();
            int mat[][]=new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    mat[i][j]=in.nextInt();
            solve(mat,n);
        }
    }
    
    static void solve(int[][] mat,int n){
        int trace=0,rc=0,cc=0;
        for(int i=0;i<n;i++){
             HashSet<Integer> hs=new HashSet<Integer>(); 
             int t=0;
             for(int j=0;j<n;j++){
                 if(hs.add(mat[i][j])==false)
                    t=1;
                 if(i==j)
                    trace+=mat[i][j];
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
        
        System.out.println(trace+" "+rc+" "+cc);

    }
}