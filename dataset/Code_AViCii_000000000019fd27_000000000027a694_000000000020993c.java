import java.util.*;
import java.io.*;

public class Solution
{
	public static void main(String[] args)throws IOException
	{
		Scanner sc=new Scanner(System.in);
		//Scanner sc=new Scanner(new File("inp.txt"));
		
		int p,t,i,j,a[][],rows,cols,trace,n;
        boolean flag;
        HashSet<Integer> set;
        ArrayList<Integer> ls;

		p=t=sc.nextInt();

		while(t-->0)
		{
			n=sc.nextInt();

            a=new int[n][n];
            rows=cols=trace=0;
            
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    a[i][j]=sc.nextInt();
                    if(i==j)
                        trace+=a[i][j];
                }
            }

            ls=new ArrayList<Integer>();

            for(i=1;i<=n;i++)
                ls.add(i);

            for(i=0;i<n;i++)
            {
                set=new HashSet<Integer>(ls);
                flag=false;
                for(j=0;j<n;j++)
                {
                    if(set.contains(a[i][j]))
                    {
                        set.remove(a[i][j]);
                    }
                    else
                    {
                        flag=true;
                        break;
                    }
                }
                if(flag||set.size()>0)
                    rows++;
            }
            for(i=0;i<n;i++)
            {
                set=new HashSet<Integer>(ls);
                flag=false;
                for(j=0;j<n;j++)
                {
                    if(set.contains(a[j][i]))
                    {
                        set.remove(a[j][i]);
                    }
                    else
                    {
                        flag=true;
                        break;
                    }
                }
                if(flag||set.size()>0)
                    cols++;
            }

			System.out.println("Case #"+(p-t)+": "+trace+" "+rows+" "+cols);
		}
	}
}