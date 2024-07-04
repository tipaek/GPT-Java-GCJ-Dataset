import java.util.*;
import java.io.*;
class Solution 
{
  public static void main(String[] args)throws Exception 
  {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for(int c=1;c<=t;c++)
    {
      int n=Integer.parseInt(br.readLine());
      ArrayList<TimeSettings> list = new ArrayList<TimeSettings>();
      HashMap<Integer,String> hm = new HashMap<Integer,String>();
      for(int i=0;i<n;i++)
      {
        String[] s=br.readLine().split("\\s+");
        list.add(new TimeSettings(Integer.parseInt(s[0]),i+1,true,false));
        list.add(new TimeSettings(Integer.parseInt(s[1]),i+1,false,true));
      }
      Collections.sort(list,new SortDuration());  
      StringBuilder newString=new StringBuilder();
      boolean C = true, J = true, flag=true;
      for(int i=0;i<list.size();i++)
      {
        if(list.get(i).started)
        {
          if(C||J)
          {
            if(C)
            {
              C=false;
              String st="C";
              hm.put(list.get(i).task,st);
            }
            else
            {
              J=false;
              String st="J";
              hm.put(list.get(i).task,st);
            }
          }
          else
          {
            newString.replace(0,newString.length(),"IMPOSSIBLE");
            flag=false;
            break;
          }
        }
        else
        {
          Integer index = list.get(i).task;
          String str = hm.get(index);
          if("C".equals(str))
          {
            C=true;
          }
          else
          {
            J=true;
          }
        }
      }
      if(flag)
      {
        for(int i=0;i<n;i++)
        {
          Integer in=i+1;
          newString.append(hm.get(in));
        }
      }
      System.out.println("Case #"+c+": "+newString);
    }
  }
}
class TimeSettings
{
  int value = 0 , task = -1;
  boolean started = true, finished = true; 
  public TimeSettings(int v,int t,boolean s,boolean e)
  {
    value = v;
    task = t;
    started = s;
    finished = e;
  }
}

class SortDuration implements Comparator
{  
  public int compare(Object o1,Object o2)
  {  
    TimeSettings s1=(TimeSettings)o1;  
    TimeSettings s2=(TimeSettings)o2;  
    if(s1.value == s2.value)
    {
      if(s1.started && s2.finished)
      {
        return 1;
      }
      else if(s2.started && s1.finished)
      {
        return -1;
      }
      else
      {
        return 0;
      }
    }
    else if(s1.value>s2.value)  
    {
      return 1;    
    }
    else
    {
      return -1;    
    }  
  }
}  