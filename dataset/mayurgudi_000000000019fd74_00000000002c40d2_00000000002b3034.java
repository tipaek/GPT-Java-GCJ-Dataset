import java.util.*;
import java.io.*;
class Solution 
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line;
    line = br.readLine();
    int t = Integer.parseInt(line);
    for(int i=1;i<=t;i++)
    {
      line = br.readLine();
      int n = Integer.parseInt(line);
      String desstr = "";
      String desend = "";
      String desres = "";
      ArrayList<String> midarr = new ArrayList<String>();
      for(int j=0;j<n;j++)
      {
        line = br.readLine();
        if(line.startsWith("*")&&!line.endsWith("*"))
        {
          String newdesend = line.substring(1);
          if(newdesend.endsWith(desend))
          {
            desend = newdesend;
          }
          else if(desend.endsWith(newdesend))
          {

          }
          else
          {
            desres = "*";
          }
        }
        else if(line.endsWith("*")&&!line.startsWith("*"))
        {
          String newdesstr = line.substring(0,line.length()-1);
          if(newdesstr.startsWith(desstr))
          {
            desstr = newdesstr;
          }
          else if(desstr.startsWith(newdesstr))
          {
            
          }
          else
          {
            desres = "*";
          }
        }
        else
        {
          if(line.startsWith("*"))
          {
            line = line.substring(1,line.length()-1);
            String arr[] = line.split("\\*");
            for(int g=0;g<arr.length;g++)
            {
              midarr.add(arr[g]);
            }
          } 
          else
          {
            int fs = line.indexOf("*");
            int ls = line.lastIndexOf("*");
            String newdesstr = line.substring(0,fs);
            String newdesend = line.substring(ls+1);
            line = line.substring(fs+1,ls);
            String arr[] = line.split("\\*");
            for(int g=0;g<arr.length;g++)
            {
              midarr.add(arr[g]);
            }
            if(newdesstr.startsWith(desstr) || desstr.startsWith(newdesstr))
            {
              if(newdesstr.length()>desstr.length())
              {
                desstr = newdesstr;
                if(midarr.contains(desstr))
                {
                  midarr.remove(desstr);
                }
              }
            }
            if(newdesend.endsWith(desend) || desend.endsWith(newdesend))
            {
              if(newdesend.length()>desend.length())
              {
                desend = newdesend;
                if(midarr.contains(desstr))
                {
                  midarr.remove(desstr);
                }
              }
            }
          }
        }
      } 
      //System.out.println(desstr + " , " + desend + " , " + midarr.size());
      if(desres.length() == 0)
      {
        for(String f : midarr)
        {
          desres += f;
        }
        if(desstr.length() == 0 && desend.length() == 0)
        {

        }
        else if(desstr.length() == 0)
        {
          desres += desend;
        }
        else if(desend.length() == 0)
        {
          desres = desstr + desres;
        }
        else
        {
          if(midarr.size() != 0)
          {
            desres = desstr + desres + desend;
          }
          else
          {
            String common = desend;
            desres += desstr;
            int index = desend.length();
            while(!desstr.endsWith(common))
            {
              common = common.substring(0,index);
              index--;
            }
            desres += desend.substring(0,index);
          }
        }
      }
      System.out.println("Case #"+i+": "+desres);
    }
  }
}