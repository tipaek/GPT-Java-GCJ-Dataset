import java.util.*;
public class Solution{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int [][] mat = new int[502][502];
        //fill pascal
        mat[0][0]=1;
        for(int r=1;r<501;r++)
        {
            for(int c=0;c<=r;c++)
            {
                if(c==0){ mat[r][c]=mat[r-1][0]; continue;}
                if(c==r){ mat[r][c]=mat[r-1][c-1]; continue;}
                mat[r][c]=mat[r-1][c-1]+mat[r-1][c];
            }
        }
        for(int t=1;t<=T;t++)
        {
            int N = sc.nextInt();
            
            boolean [][] visited = new boolean [502][502];
            ArrayList<int []> path = new ArrayList<>();
            dfs(N, mat, visited, path,0,0);
            System.out.println("Case #"+t+": ");
            for(int [] pos : path)
            System.out.println(pos[0]+" "+pos[1]);
        }
    }
    public static boolean dfs(int N, int [][] mat, 
    boolean [][] visited, ArrayList<int [] >path,
    int r, int c)
    {
        if(N<0)return false;
        if(N==0)return true;
        if(r<0 || c<0 || r>501 || c>501 || c>r) return false;
        if(visited[r][c])return false;
        visited[r][c]=true;
        for(int [] next : new int [][] {{0,1},{1,0},{1,1},{0,-1},{-1,-1},{-1,0}})
        {
            path.add(new int[]{r+1,c+1});
            if(dfs(N-mat[r][c],mat,visited,path,r+next[0],c+next[1]))
            {
                return true;
            }
            path.remove(path.size()-1);
        }
        
        return false;
    }
}