
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
     
      for(int j=0;j<n;j++)
      {
        boolean flag=true;
        int temp=arr[i][j];
        for(int q=j+1;q<n;q++)
        {
        
        if(arr[i][q]==temp)
        {
          d_row++;
          flag=false;
          break;
        }
        }
    if(!flag)
      break; 
      }
    }
      int d_col=0;
    for(int i=0;i<n;i++)
    {
      for(int j=0;j<n;j++)
      {
        boolean flag=true;
        int temp=arr[j][i];
        for(int q=j+1;q<n;q++)
        {
               if(arr[q][i]==temp)
        {
          d_col++;
       flag=false;
       break;
        }
               }
        if(!flag)
          break;

       
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
