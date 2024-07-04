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
    static HashMap<Integer,HashSet<Integer>> row=new HashMap<>();
    static HashMap<Integer,HashSet<Integer>> col=new HashMap<>();
    static int filled;
    static boolean solve(int x,int y)
    {
        if(filled==n*n)
            return true;
        /*boolean flag=true;
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
            return true;*/
        for(int i=1;i<=n;i++)
        {
            if(y+1<n && !visited[x][y+1])
            {
                if((row.get(x)).contains(i) || (col.get(y+1)).contains(i))
                    continue;
                mat[x][y+1]=i;
                visited[x][y+1]=true;
                filled++;
                (row.get(x)).add(i);
                (col.get(y+1)).add(i);
                if(solve(x,y+1)==true)
                    return true;
                filled--;
                (row.get(x)).remove(i);
                (col.get(y+1)).remove(i);
                mat[x][y+1]=0;
                visited[x][y+1]=false;
                
            }
            else if(y-1>=0 && !visited[x][y-1])
            {
                if((row.get(x)).contains(i) || (col.get(y-1)).contains(i))
                    continue;
                mat[x][y-1]=i;
                visited[x][y-1]=true;
                filled++;
                (row.get(x)).add(i);
                (col.get(y-1)).add(i);
                if(solve(x,y-1)==true)
                    return true;
                filled--;
                (row.get(x)).remove(i);
                (col.get(y-1)).remove(i);
                mat[x][y-1]=0;
                visited[x][y-1]=false;
            }
            else if(x+1<n && !visited[x+1][y])
            {
                if((row.get(x+1)).contains(i) || (col.get(y)).contains(i))
                    continue;
                mat[x+1][y]=i;
                visited[x+1][y]=true;
                filled++;
                (row.get(x+1)).add(i);
                (col.get(y)).add(i);
                if(solve(x+1,y)==true)
                    return true;
                filled--;
                (row.get(x+1)).remove(i);
                (col.get(y)).remove(i);
                mat[x+1][y]=0;
                visited[x+1][y]=false;
                
            }
            else if(x-1>=0 && !visited[x-1][y])
            {
                if((row.get(x-1)).contains(i) || (col.get(y)).contains(i))
                    continue;
                mat[x-1][y]=i;
                visited[x-1][y]=true;
                filled++;
                (row.get(x-1)).add(i);
                (col.get(y)).add(i);
                if(solve(x-1,y)==true)
                    return true;
                filled--;
                (row.get(x-1)).remove(i);
                (col.get(y)).remove(i);
                mat[x-1][y]=0;
                visited[x-1][y]=false;
            }
            else if(y+1<n && x+1<n && !visited[x+1][y+1])
            {
                if((row.get(x+1)).contains(i) || (col.get(y+1)).contains(i))
                    continue;
                mat[x+1][y+1]=i;
                visited[x+1][y+1]=true;
                filled++;
                (row.get(x+1)).add(i);
                (col.get(y+1)).add(i);
                if(solve(x+1,y+1)==true)
                    return true;
                filled--;
                (row.get(x+1)).remove(i);
                (col.get(y+1)).remove(i);
                mat[x+1][y+1]=0;
                visited[x+1][y+1]=false;
                
            }
            else if(y+1<n && x-1>=0 && !visited[x-1][y+1])
            {
                if((row.get(x-1)).contains(i) || (col.get(y+1)).contains(i))
                    continue;
                mat[x-1][y+1]=i;
                visited[x-1][y+1]=true;
                filled++;
                (row.get(x-1)).add(i);
                (col.get(y+1)).add(i);
                if(solve(x-1,y+1)==true)
                    return true;
                filled--;
                (row.get(x-1)).remove(i);
                (col.get(y+1)).remove(i);
                mat[x-1][y+1]=0;
                visited[x-1][y+1]=false;
                
            }
            else if(y-1>=0 &&  x+1<n && !visited[x+1][y-1])
            {
                if((row.get(x+1)).contains(i) || (col.get(y-1)).contains(i))
                    continue;
                mat[x+1][y-1]=i;
                visited[x+1][y-1]=true;
                filled++;
                (row.get(x+1)).add(i);
                (col.get(y-1)).add(i);
                if(solve(x+1,y-1)==true)
                    return true;
                filled--;
                (row.get(x+1)).remove(i);
                (col.get(y-1)).remove(i);
                mat[x+1][y-1]=0;
                visited[x+1][y-1]=false;
            }
            else if(y-1>=0 && x-1>=0 && !visited[x-1][y-1])
            {
                if((row.get(x-1)).contains(i) || (col.get(y-1)).contains(i))
                    continue;
                mat[x-1][y-1]=i;
                filled++;
                (row.get(x-1)).add(i);
                (col.get(y-1)).add(i);
                visited[x-1][y-1]=true;
                if(solve(x-1,y-1)==true)
                    return true;
                filled--;
                (row.get(x-1)).remove(i);
                (col.get(y-1)).remove(i);
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
            filled=0;
            if(k==n+1)
            {
                System.out.println("IMPOSSIBLE");
                continue;
            }
            if(k==n)
            {
                for(int i=0;i<n;i++)
                    arr[i]=1;
            }
            else
            {
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
                    }
                    if(i==n)
                    {
                        i=start;
                        start=0;
                    }
                }
            }
            for(int i=0;i<n;i++)
            {
                mat[i][i]=arr[i];
                HashSet<Integer> s1=new HashSet<Integer>();
                HashSet<Integer> s2=new HashSet<Integer>();
                s1.add(arr[i]);
                s2.add(arr[i]);
                row.put(i,s1);
                col.put(i,s2);
                filled++;
                visited[i][i]=true;
            }
            boolean f=solve(0,0);
            if(f==false)
            {
                System.out.println("IMPOSSIBLE");
                /*for(int i=0;i<n;i++)
                {
                    for(int j=0;j<n;j++)
                        System.out.print(mat[i][j]+" ");
                    System.out.println(); 
                }*/
                continue;
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

}
