import java.io.*;
import java.util.*;
class Main 
{
  public static void main(String[] args) 
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = 0; 
    ArrayList<HashSet<Integer>> arr = new ArrayList<HashSet<Integer>>();
    try
    {
      t = Integer.parseInt(br.readLine());
      for(int h = 1; h <= t; h++)
      {
        int n = 0, row = 0, col = 0, trace = 0;
        n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++)
        {
          HashSet<Integer> hs = new HashSet<Integer>();
          String line = br.readLine();
          String list[] = line.split(" ");
          for(int j=0;j<n;j++)
          {
            int k = Integer.parseInt(list[j]);
            if(i==j)
            {
              trace += k;
            }
            if(arr.size() > j)
            {
              HashSet x = arr.get(j);
              x.add(k);
              arr.set(j,x);
            }
            else
            {
              HashSet<Integer> x = new HashSet<Integer>();
              x.add(k);
              arr.add(x);
            }
            hs.add(k);
          }
          if(hs.size()!=n)
          {
            row++;
          }
        }
        for(int i=0;i<n;i++)
        {
          HashSet x = arr.get(i);
          if(x.size()!=n)
          {
            col++;
          }
        }
        System.out.println("Case #" + h + ": " + trace + " " + row + " " + col);
      }
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}