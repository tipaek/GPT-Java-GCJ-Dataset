
import java.io.*;
import java.util.*;

public class Solution
{
     static Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static class data
    {
        int n;
        int[][] data=new int[n][n];
        public data(int n,int[][] at)
        {
            this.n=n;
            data=at;
           
         
           
            
        }
    }
    public static void main(String[] args)
    {
        int tc=sc.nextInt();
        List<data> list=new ArrayList<>();
        int in=0;
        while(in<tc)
        {
            int tn=sc.nextInt();
            int[][] ta=new int[tn][tn];
            for(int i=0;i<tn;i++)
            {
                for(int j=0;j<tn;j++)
                {
                    try
                    {
                    ta[i][j]=sc.nextInt();
                    }
                    catch(Exception e)
                    {
                        
                    }
                }
            }
            data d=new data(tn,ta);
            list.add(d);
            in++;
            
        }
        for(int tt=0;tt<tc;tt++)
        {
             Set<Integer> row = new HashSet<>(); 
              Set<Integer> col = new HashSet<>(); 
              int rowcount=0;
              int colcount=0;
              int trace=0;
              for(int i=0;i<list.get(tt).n;i++)
              {
                  for(int j=0;j<list.get(tt).n;j++)
                  {
                      if(i==j)
                      trace+=list.get(tt).data[i][j];
                      row.add(list.get(tt).data[i][j]);
                      col.add(list.get(tt).data[j][i]);
                  }
                  if(row.size()!=list.get(tt).n)
                  rowcount++;
                  if(col.size()!=list.get(tt).n)
                  colcount++;
                  row.clear();
                  col.clear();
              }
              System.out.println("Case #"+tt+":"+" "+trace+" "+rowcount+" "+colcount);
        }
       
        
    }
}






