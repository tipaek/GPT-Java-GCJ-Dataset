import java.io.*;
import java.util.*;
class Solution 
{
  public static void main(String[] args) 
  {
    try
    {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int h = 0;
      h = Integer.parseInt(br.readLine());
      for(int t=1;t<=h;t++)
      {
        int n = 0;
        n = Integer.parseInt(br.readLine());
        String output = new String();
        ArrayList<Integer> clower = new ArrayList<Integer>();
        ArrayList<Integer> cupper = new ArrayList<Integer>();
        ArrayList<Integer> jlower = new ArrayList<Integer>();
        ArrayList<Integer> jupper = new ArrayList<Integer>();
        int totalbr = 0;
        for(int i=0;i<n;i++)
        {
          String line = br.readLine();    
          String arr[] = line.split(" ");
          int e_l = Integer.parseInt(arr[0]);
          int e_u = Integer.parseInt(arr[1]);
          int brs = 0;
          for(int k=0; k<clower.size(); k++)
          {
            if(!(clower.get(k) >= e_u || cupper.get(k) <= e_l))
            {
              brs = 1;
              break;
            }
          }
          if(brs == 0)
          {
            clower.add(e_l);
            cupper.add(e_u);
            output += "C";
          }
          else
          {
            brs = 0;
            for(int k=0; k<jlower.size(); k++)
            {
              if(!(jlower.get(k) >= e_u || jupper.get(k) <= e_l))
              {
                brs = 1;
                break;
              } 
            }
            if(brs == 0)
            {
              jlower.add(e_l);
              jupper.add(e_u);
              output += "J";
            }
            else
            {
              totalbr = 1;      
            }
          }
        }
        if(totalbr == 1)
        {
          System.out.print("Case #" + t + ": IMPOSSIBLE\n");  
        }
        else
        {
          System.out.print("Case #" + t + ": " + output + "\n");
        }
      }
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}