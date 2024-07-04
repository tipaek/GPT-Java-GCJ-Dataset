import java.util.*;

class Solution{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int p=0;p<t;p++){
            int n=in.nextInt();
            int k=in.nextInt();
            solve(n,k,p+1);
        }
    }
    
    static void solve(int n,int k,int p){
        if(n%2!=0)
        {
        int[][] mat=new int[n][n];
        int z=1;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                {
                  if(i!=0)
                    mat[i][j]=(mat[i-1][j]%n)+1;
                  else
                    mat[i][j]=z++;
                }
         System.out.println("Case #"+p+": POSSIBLE");
         for(int i=0;i<n;i++)
            {for(int j=0;j<n;j++)
                System.out.print(mat[i][j]);
             System.out.println();
            }
        }
        else
         System.out.println("Case #"+p+": IMPOSSIBLE");
        
    }
}