import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution
{
    static int[][] mat;
    static boolean[][] visited;
    static int n;
    static boolean solve(int x,int y)
    {
        boolean flag=true;
        boolean flag1=true;
        for(int i=0;i<n;i++)
        {
            HashSet<Integer> set=new HashSet<>();
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    flag1=false;
                    continue;
                }
                if(set.contains(mat[i][j]))
                {
                    flag=false;
                    break;
                }
                set.add(mat[i][j]);
            }
        }
        if(flag==false)
            return false;
        for(int i=0;i<n;i++)
        {
            HashSet<Integer> set=new HashSet<>();
            for(int j=0;j<n;j++)
            {
                if(mat[j][i]==0)
                    continue;
                if(set.contains(mat[j][i]))
                {
                    flag=false;
                    break;
                }
                set.add(mat[j][i]);
            }
        }
        if(flag==false)
            return false;
        if(flag1==true)
            return true;
        for(int i=1;i<=n;i++)
        {
            if(y+1<n && !visited[x][y+1])
            {
                mat[x][y+1]=i;
                visited[x][y+1]=true;
                if(solve(x,y+1)==true)
                    return true;
                mat[x][y+1]=0;
                visited[x][y+1]=false;
                
            }
            else if(y-1>=0 && !visited[x][y-1])
            {
                mat[x][y-1]=i;
                visited[x][y-1]=true;
                if(solve(x,y-1)==true)
                    return true;
                mat[x][y-1]=0;
                visited[x][y-1]=false;
            }
            else if(x+1<n && !visited[x+1][y])
            {
                mat[x+1][y]=i;
                visited[x+1][y]=true;
                if(solve(x+1,y)==true)
                    return true;
                mat[x+1][y]=0;
                visited[x+1][y]=false;
                
            }
            else if(x-1>=0 && !visited[x-1][y])
            {
                mat[x-1][y]=i;
                visited[x-1][y]=true;
                if(solve(x-1,y)==true)
                    return true;
                mat[x-1][y]=0;
                visited[x-1][y]=false;
            }
            else if(y+1<n && x+1<n && !visited[x+1][y+1])
            {
                mat[x+1][y+1]=i;
                visited[x+1][y+1]=true;
                if(solve(x+1,y+1)==true)
                    return true;
                mat[x+1][y+1]=0;
                visited[x+1][y+1]=false;
                
            }
            else if(y+1<n && x-1>=0 && !visited[x-1][y+1])
            {
                mat[x-1][y+1]=i;
                visited[x-1][y+1]=true;
                if(solve(x-1,y+1)==true)
                    return true;
                mat[x-1][y+1]=0;
                visited[x-1][y+1]=false;
                
            }
            else if(y-1>=0 &&  x+1<n && !visited[x+1][y-1])
            {
                mat[x+1][y-1]=i;
                visited[x+1][y-1]=true;
                if(solve(x+1,y-1)==true)
                    return true;
                mat[x+1][y-1]=0;
                visited[x+1][y-1]=false;
            }
            else if(y-1>=0 && x-1>=0 && !visited[x-1][y-1])
            {
                mat[x-1][y-1]=i;
                visited[x-1][y-1]=true;
                if(solve(x-1,y-1)==true)
                    return true;
                mat[x-1][y-1]=0;
                visited[x-1][y-1]=false;
                
            }
            
        }
        return false;
    }
    public static void main(String[] args)
    {
        Scanner in =new Scanner(System.in);
        int t=in.nextInt();
        int test=1;
        while(t>0)
        {
            t--;
            System.out.print("Case #"+test+": ");
            test++;
            n=in.nextInt();
            int k=in.nextInt();
            mat=new int[n][n];
            visited=new boolean[n][n];
            int[] arr=new int[n];
            for(int i=0;i<n;i++)
                arr[i]=n;
            if(k<n+2)
            {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            int diff=0;
            int start=0;
            int i=0;
            while(diff<n*n-k)
            {
                diff++;
                if(i-start<n-2)
                {
                    arr[i]--;
                    i++;
                }
                else
                {
                    arr[start]--;
                    start++;
                    i++;
                    if(start==2)
                    {
                        i=start;
                        start=0;
                        //diff--;
                    }
                }
            }
            for(i=0;i<n;i++)
            {
                mat[i][i]=arr[i];
                visited[i][i]=true;
            }
            solve(0,0);
        }
        System.out.println("POSSIBLE");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                System.out.print(mat[i][j]+" ");
            System.out.println(); 
        }
    }

}
