import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Main
{
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
		int t=in.nextInt();
		
		for(int k=0;k<t;k++)
		{
		   int n=in.nextInt();
		   int arr[][]=new int[n][n];
			int trace=0,countr=0,countc=0;
		   for(int i=0;i<n;i++)
		   {
			   for(int j=0;j<n;j++)
			   {
					arr[i][j]=in.nextInt();

					if(i==j)trace+=arr[i][j];
			   }
		   }
		   int i=0,j=0;

		   
		   for( i=0;i<n;i++)
		   {
			   HashSet set =new HashSet<Integer>();
				// if(arr[i][0]==arr[i][n-1]){countr++;i++;}
				
				// else
				// {
			   		for( j=0;j<n;j++)
			  		{
						set.add(arr[i][j]);
					}
					
					if(set.size()<n)countr++;
				// }
				
		   }
		   for( j=0;j<n;j++)
		   {

				HashSet set =new HashSet<Integer>();

				// if(arr[0][j]==arr[n-1][j]){countc++;j++;}
				
			   		for( i=0;i<n;i++)
			  		{

						set.add(arr[i][j]);
					}

					if(set.size()<n)countc++;
					   
		   }
		   System.out.println("Case #"+(k+1)+":"+" "+trace+" "+countr+" "+countc);

		}
    }
   
}