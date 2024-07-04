import java.io.*;
import java.util.*;
public class Solution
{
    static int dp[][]=new int[501][501];
    static int row[]={-1,-1,0,0,1,1};
    static int col[]={-1,0,-1,1,0,1};
    static boolean visited[][];
    static ArrayList<Pair> ans;
    public static void main(String ag[])
    {
        Scanner sc=new Scanner(System.in);
        int i,j,k;
        int T=sc.nextInt();
        k=1;
        dp[1][1]=1;
        for(i=2;i<=500;i++)
        {
            for(j=1;j<=i;j++)
            {
                dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
            }
        }
        while(T-- >0)
        {
            int N=sc.nextInt();
            visited=new boolean[501][501];
            ans=new ArrayList<>();
            if(N==1)
            {
                System.out.println("Case #"+k+":");
                System.out.println(1+" "+1);
            }
            else
            {
                ArrayList<Pair> al=new ArrayList<>();
                al.add(new Pair(1,1));
                System.out.println("Case #"+k+":");
                DFS(N-1,al,1,1,visited);
                for(i=0;i<ans.size();i++)
                System.out.println(ans.get(i).x+" "+ans.get(i).y);
            }
            
            k++;
        }
    }
    public static void DFS(int S,ArrayList<Pair> al,int x,int y,boolean visited[][])
    {
            visited[x][y]=true;
            if(S==0&&ans.size()==0)
            {
                for(int i=0;i<al.size();i++)
                ans.add(new Pair(al.get(i).x,al.get(i).y));
                return;
            }
            for(int i=0;i<6;i++)
            {
                int X=x+row[i];
                int Y=y+col[i];
                if(isValid(X,Y,visited,S))
                {
                    al.add(new Pair(X,Y));
                    DFS(S-dp[X][Y],al,X,Y,visited);
                    al.remove(al.size()-1);
                }
            }
        
    }
    public static boolean isValid(int x,int y,boolean visited[][],int S)
    {
        if(x>=1&&x<=500&&y>=1&&y<=500&&!visited[x][y]&&S-dp[x][y]>=0&&dp[x][y]!=0&&ans.size()==0)
        return true;
        return false;
        
    }
}
class Pair 
{
    int x,y;
    Pair(int a,int b)
    {
        x=a;
        y=b;
    }
}