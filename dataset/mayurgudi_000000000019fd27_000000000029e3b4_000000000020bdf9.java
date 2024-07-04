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
        int lower[] = new int[n];
        int upper[] = new int[n];
        int pos[] = new int[n];

        for(int g=0;g<n;g++)
        {
          String line = br.readLine();    
          String arr[] = line.split(" ");
          int e_l = Integer.parseInt(arr[0]);
          int e_u = Integer.parseInt(arr[1]);
          lower[g] = e_l;
          upper[g] = e_u;
          pos[g] = g;
        }
        for(int g=0;g<n-1;g++)
        {
          for(int x=g+1;x<n;x++)
          {
            if(lower[g] > lower[x])
            {
              int temp = lower[g];
              lower[g] = lower[x];
              lower[x] = temp;
              temp = upper[g];
              upper[g] = upper[x];
              upper[x] = temp;
              temp = pos[g];
              pos[g] = pos[x];
              pos[x] = temp;
            }
          }
        }
        ArrayList<Integer> clower = new ArrayList<Integer>();
        ArrayList<Integer> cupper = new ArrayList<Integer>();
        ArrayList<Integer> jlower = new ArrayList<Integer>();
        ArrayList<Integer> jupper = new ArrayList<Integer>();
        int totalbr = 0;
        for(int i=0;i<n;i++)
        {
          int e_l = lower[i];
          int e_u = upper[i];
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
          if(totalbr == 1)
          {
            break;
          }
        }
        if(totalbr == 1)
        {
          System.out.println("Case #" + t + ": IMPOSSIBLE");  
        }
        else
        {
          String newoutput = new String("");
          for(int g=0; g<n ;g++)
          {
            int index = pos[g];
            newoutput += output.charAt(index);
          }
          System.out.println("Case #" + t + ": " + newoutput);
        }
      }
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}