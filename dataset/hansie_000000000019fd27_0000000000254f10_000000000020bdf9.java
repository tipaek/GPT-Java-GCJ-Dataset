
import java.util.*;

import java.io.*;
import java.lang.*;

public class  Solution{

	public static void main(String args[])
	{
		try
		{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
    for(int k=1;k<=t;k++)
    {
      String answer="";
      int n=Integer.parseInt(br.readLine());
      ArrayList<Pair<Integer,Integer>> al=new ArrayList<Pair<Integer,Integer>>();
      for(int i=0;i<n;i++)
      {
        String a[]=br.readLine().split(" ");
        int u=Integer.parseInt(a[0]);
        int v=Integer.parseInt(a[1]);
        al.add(new Pair<Integer,Integer>(u,v));
      }
      int start=al.get(0).first();
      int stop=al.get(0).second();
      answer+="C";
      int n_start=al.get(1).first();
      int n_stop=al.get(1).second();
      if((n_stop<=start)||(n_start>=stop))
      {
      start=n_start;
      stop=n_stop;
      answer+="C";
      n_stop=0;
      n_start=0;
      }
      else
      {
      answer+="J";
      }
      for(int i=2;i<al.size();i++)
      {
        int u=al.get(i).first();
        int v=al.get(i).second();
        if(v<=start||u>=stop)
        {
        start=u;
        stop=v;
        answer+="C";
        }
        else if(v<=n_start||u>=n_stop)
        {
          n_start=u;
          n_stop=v;
          answer+="J";
        }
        else{
          answer="IMPOSSIBLE";
          break;
        }
        
      }
      
                    
     
     System.out.println("Case #"+k+": "+answer); 
    }
		
		}
    
		catch(Exception e)
	{
	e.printStackTrace();	
	}
	

  }
}
class Pair<A,B>{
  
  A _first;
  B _second;
  public Pair(A _first,B _second)
  {
    this._first=_first;
    this._second=_second;
  }
  A first()
  {
    return _first; 
  }
  B second()
  {
    return _second;
  }
}
