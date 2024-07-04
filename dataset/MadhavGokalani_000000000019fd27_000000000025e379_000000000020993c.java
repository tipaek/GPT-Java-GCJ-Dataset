import java.util.*;
public class Solution
{
 	public static void main(String[] args)
 	 {
	   Scanner s=new Scanner(System.in);
 	   int t=s.nextInt();
           int k=t+1;
 	   while(t>0)
 	   {
             int n=s.nextInt();
	     int a[][]=new int[n][n];
             int ans=0;
	     for(int i=0;i<n;i++)
	      {
		for(int j=0;j<n;j++)
 	   	 {
                   a[i][j]=s.nextInt();
                   if(i==j)
		    ans+=a[i][j];
	           
 		  }
	      } 
             int r=0;
             int c=0;
             for(int i=0;i<n;i++)
                {
                  HashSet<Integer> h=new HashSet<>();
		  for(int j=0;j<n;j++)
                   {
	             if(h.contains(a[i][j]))
 	  	 	{
			  r++;
			  break;
			 }
 		     else
                         h.add(a[i][j]);
                     }
                 }
                     for(int j=0;j<n;j++)
                {
                  HashSet<Integer> h=new HashSet<>();
		  for(int i=0;i<n;i++)
                   {
	             if(h.contains(a[i][j]))
 	  	 	{
			  c++;
			  break;
			 }
 		     else
                         h.add(a[i][j]);
                     }
                 }
                System.out.println();
                System.out.print("Case #"+(k-t)+":"+" "+ans+" "+r+" "+c);

            t--;
	   }
	}
}