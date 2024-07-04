import java.util.*;
    import java.io.*;
    public class Solution 
    {
      public static void main(String[] args) 
     	{
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) 
       		{
          int n = in.nextInt();
          int ar[][] =new int[n][n];
          int sum=0;
          int r=0, c=0;
          for(int j=0;j<n;j++){
          	for(int k=0;k<n;k++){
          		ar[j][k]=in.nextInt();
          		}
          		}
          for(int j=0;j<n;j++)
          sum+=ar[j][j];
          
          for(int k=0;k<n;k++)
         			{
          	int temp=0;
          String s="" ;
          for(int l=0;l<n;l++)
         				{
          	if(s.indexOf(Integer.toString(ar[k][l]))!=-1)
          	temp=1;
          	s+=ar[k][l];
         				}
          r+=temp;
         			}
         			
           for(int k=0;k<n;k++)
         		{
          	int temp=0;
          String s="" ;
          for(int l=0;l<n;l++)
         			{
          	if(s.indexOf(Integer.toString(ar[l][k]))!=-1)
          	temp=1;
          	s+=ar[l][k];
         			}
          c+=temp;
         		}
          System.out.println("Case #" + i + ": " + sum + " " +r+" " +c);
       		}
     	}
    }
  