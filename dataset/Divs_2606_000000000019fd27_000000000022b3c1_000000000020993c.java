import java.util.Scanner;
import java.util.HashSet;
public class Solution
{
	public static void main(String[] args) {
	int t,cno=1;
	Scanner sc=new Scanner(System.in);
	t=sc.nextInt();
	for(int k=t;t>0;t--)
	    {
	        int n;
	        n=sc.nextInt();
	        int[][] ar=new int[n][n];
	        for(int i=0;i<n;i++)
	            {
	                for(int j=0;j<n;j++)
	                {
	                    ar[i][j]=sc.nextInt();
	                }
	            }
	       int sum=0;     
	       for(int i=0;i<n;i++)
	            {
	                for(int j=0;j<n;j++)
	                {
	                    if(i==j)
	                    {
	                        sum=sum+ar[i][j];
	                    }
	                }
	            }
	       int col=0;
	       boolean cc=false,rc=false;
	       for(int i=0;i<n;i++)
	       {
	           HashSet<Integer> set = new HashSet<Integer>();
	           cc=false;
	           for(int j=0;j<n;j++)
	           {
	               if (set.contains(ar[j][i])) cc=true;
            set.add(ar[j][i]);
	           }if(cc) col++;
	       }
	       
	       int row=0;
	       for(int i=0;i<n;i++)
	       {
	           HashSet<Integer> set = new HashSet<Integer>();
	           rc=false;
	           for(int j=0;j<n;j++)
	           {
	               if (set.contains(ar[i][j])) rc=true;
            set.add(ar[i][j]);
	           }if(rc) row++;
	       }System.out.println("Case"+" "+"#"+cno+":"+" "+sum + " "+row+ " "+col);
	       cno++;
	    }
	}
}
