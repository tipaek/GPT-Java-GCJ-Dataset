import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void solution(int [][] grid,int pos)
    {
        List<HashSet<Integer>> setList=new ArrayList<>();
        List<String> coupleList=new ArrayList<>();
        for(int i=0;i<grid.length;i++)
        {
            if(i%2==0)
            {
                coupleList.add(i,"C");
            }
            else
            {
                coupleList.add(i,"J");
            }
            HashSet <Integer> overLap=new HashSet<>();
            overLap.add(i);
            dfs(grid,overLap,i+1,grid[i][1],grid[i][0]);
            if(overLap.size()==2)
            {
                setList.add(overLap);
            }
            if(overLap.size()>2)
            {
                setList.add(overLap);
                System.out.println("Case #"+pos+": IMPOSSIBLE");
                return;
            }

        }
        String response="";
        for(int a=0;a<setList.size();a++)
        {
            HashSet<Integer> hashSet=setList.get(a);
            int hashSize=hashSet.size();
            if(hashSize==2)
            {
                Iterator<Integer> indy=hashSet.iterator();
                while(indy.hasNext())
                {
                    int pos1=indy.next();
                    int pos2=indy.next();
                    if(pos1%2==0 && pos2%2==0)
                    {
                        coupleList.set(pos2,"J");
                    }
                    if(pos1%2!=0 && pos2%2!=0)
                    {
                        coupleList.set(pos2,"C");
                    }

                }
            }
        }

        if(response.isEmpty())
        {
            response="Case #"+pos+": ";
            for(int b=0;b<coupleList.size();b++)
            {
                response+=coupleList.get(b);
            }
        }
        System.out.println(response);
    }
    public static void dfs(int[][] grid,HashSet <Integer> overLap,int i,int max,int min)
    {
        if(i>=grid.length || i<0)
        {
            return;
        }
        if(grid[i][0] < max && grid[i][0] > min)
        {
            if(!overLap.contains(i))
            {
                overLap.add(i);
            }
        }
        dfs(grid,overLap,i+1,max,min);
    }
    public static void processSolution()
    {
            Scanner in=new Scanner(System.in);
            int cases=in.nextInt();
            for(int a=1;a<=cases; a++)
            {
                int size=in.nextInt();
                int [][] grid=new int[size][size];
                in.nextLine();
                for(int b=0;b<size;b++)
                {
                    String nextLane=in.nextLine().trim();
                    String[] cols=nextLane.split(" ");
                    for(int c=0;c<cols.length;c++)
                    {
                        grid[b][c]=Integer.parseInt(cols[c]);
                    }
                }
                solution(grid,a);
            }
            in.close();
    }
    public static void main (String [] args)
    {
        processSolution();
    }
}
