//package unix;
import java.util.*;
class Glad
{
	public static void main(String args[])
	{
		Scanner sc =new Scanner(System.in);
		int n,t,i,j,k,row_count,col_count,trace;
		t=sc.nextInt();
		for(i=0;i<t;i++)
		{
			n=sc.nextInt();
			HashMap<Integer,Integer> row[]=new HashMap[n];
			HashMap<Integer,Integer> col[]=new HashMap[n];
			int r[]=new int[n];
			int c[]=new int[n];
			trace=row_count=col_count=0;
			int a[][]=new int[n][n];
           for(j=0;j<n;j++)
           {
        	   row[j]=new HashMap<Integer,Integer>();
        	   for(k=0;k<n;k++)
        	   {
        	   if(j==0)
        		   col[k]=new HashMap<Integer,Integer>();
        	   a[j][k]=sc.nextInt();
        	   if(col[k].containsKey(a[j][k]) && c[k]!=1)
        	   {  c[k]=1;
        		   col_count++;
        	   }
        	   else
        		   col[k].put(a[j][k],1);
        	   if(row[j].containsKey(a[j][k]) && r[k]!=1)
        	   { r[j]=1;
				row_count++;
        	   }
				else
					row[j].put(a[j][k],1);
        	   if(j==k)
        		   trace+=a[j][k];
        	   }
        	   
           }
           System.out.println("Case #"+(i+1)+":"+" "+trace+" "+row_count+" "+col_count);
		}
	}
}




  

