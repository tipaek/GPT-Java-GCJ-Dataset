
import java.util.*;

import java.io.*;
import java.lang.*;

public class A {

	public static void main(String args[])
	{
		try
		{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
    for(int k=0;k<t;k++)
    {

    int n=Integer.parseInt(br.readLine());
    int arr[][]=new int[n][n];
    for(int i=0;i<n;i++)
    {
      String a[]=br.readLine().split(" ");
      for(int j=0;j<n;j++)
      {
        arr[i][j]=Integer.parseInt(a[j]);
      }
    }
    int trace=0;
    for(int i=0;i<n;i++)
    {
      trace+=arr[i][i];
    }
    int d_row=0;
    for(int i=0;i<n;i++)
    {
      int temp=arr[i][0];
      for(int j=1;j<n;j++)
      {
        if(arr[i][j]==temp)
        {
          d_row++;
          break;
        }
      }
    }
      int d_col=0;
    for(int i=0;i<n;i++)
    {
      int temp=arr[0][i];
      for(int j=1;j<n;j++)
      {
        if(arr[j][i]==temp)
        {
          d_col++;
          break;
        }
       
    }
    }
    
    System.out.println("Case #"+k+": "+trace+" "+d_row+" "+d_col);
    } 
      
		
		}
    
		catch(Exception e)
	{
	e.printStackTrace();	
	}
	

  }
}
