
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
    for(int k=0;k<t;k++)
    {
      String a=br.readLine();
      char ch[]=a.toCharArray();
      int arr[]=new int[ch.length];
      for(int i=0;i<arr.length;i++)
      {
        arr[i]=Integer.parseInt(Character.toString(ch[i]));
      }
      int depth=arr[0];
      StringBuilder str=new StringBuilder("");
      for(int i=0;i<depth;i++)
        str.append("(");
      str.append(String.format("%d",arr[0]));
      for(int i=1;i<arr.length;i++)
      {
        if(arr[i]<arr[i-1])
        {
        for(int j=0;j<(arr[i-1]-arr[i]);j++)
        {
          str.append(")");
        }
        str.append(String.format("%d",arr[i]));
        depth-=(arr[i-1]-arr[i]); 
        }    
        else{
          for(int j=0;j<(arr[i]-arr[i-1]);j++)
            str.append("(");
          str.append(String.format("%d",arr[i]));
          depth+=(arr[i]-arr[i-1]);
        }
        
      }
      while(depth!=0)
      {
        str.append(")");
        depth--;
      }
        
      
      System.out.println(new String(str));
      
    }
		
		}
    
		catch(Exception e)
	{
	e.printStackTrace();	
	}
	

  }
}
