import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          long arr[]=new long[n];
          int d = in.nextInt();
          for(int j=1; j<=n; j++)
          {
              arr[j-1]=in.nextLong();
          }
          Arrays.sort(arr);
          if(n==1)
          {
              System.out.println("Case #" + i + ": " + (d-arr[0]));
          }
          else if(n>=d)
          {
              int k=0; int count=1;
              for(int j=k+1;j<n;j++)
              {
                  if(arr[k]==arr[j])
                  {
                      count++;
                      if(count==d)
                      {
                          break;
                      }
                  }
                  else
                  {
                      count=1;
                      k++;
                  }
              }
              if(count==d)
              {
              System.out.println("Case #" + i + ": 0");
              }
              
              else{
                  long slice=1;
              long cut=0;
              int ki=1;
                  while(slice<d)
                  {
                      long small=arr[0];
                      if(arr[ki]%small==0)
                      {
                          cut=cut+(arr[ki]/small)-1;
                          slice=slice+(arr[ki]/small);
                      if(slice>d)
                      {
                          cut=cut-(slice-d)+1;
                          slice=d;
                          
                          
                      }
                      ki++;
                      }
                      else{
                          cut=cut+(arr[ki]/small);
                           slice=slice+(arr[ki]/small);
                      if(slice>d)
                      {
                          cut=cut-(slice-d);
                          slice=d;
                          
                          
                      }
                      ki++;
                      }
                      
                      
                  }
                  System.out.println("Case #" + i + ": "+cut);
              }
          }
          
          else {
              long sum=0;
              long cut=0;
              for (int ii=0;ii<n;ii++)
              {
                  sum=sum+arr[ii];
              }
              long cu=sum/d;
              long slice=0;
              for(int ii=0;ii<n;ii++)
              {
              if(arr[ii]%cu==0)
              {
                  cut=cut+(arr[ii]/cu)-1;
                  slice=slice+(arr[ii]/cu);
                      if(slice>d)
                      {
                          cut=cut-(slice-d)+1;
                          slice=d;
              }
              }
              else{
                  cut=cut+(arr[ii]/cu);
                  slice=slice+(arr[ii]/cu);
                      if(slice>d)
                      {
                          cut=cut-(slice-d);
                          slice=d;
              }
              }
                  
          }
          System.out.println("Case #" + i + ": "+cut);
        }
        
	}
}
}