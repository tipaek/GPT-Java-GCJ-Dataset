import java.io.*;
import java.util.*;
class gcj1{
	public static void main (String[] args)throws IOException {
	    DataInputStream in = new DataInputStream(System.in);
	    int x=0;
		int t=Integer.parseInt(in.readLine());
		int r[][] = new int[t][3];
		if(1<=t&&t<=100)
		{
		    for (int c=0;c<t;c++)
		    {
		        int n = Integer.parseInt(in.readLine());
		        int a[][]=new int[n][n];
		        if(1<=n&&n<=100);else x++;
		        int sum=0;
		        int rows=0;
		        int columns=0;
		        
		        for(int i=0;i<n;i++)
		        {
		            int temp=0;
		            String s =in.readLine();
		            StringTokenizer stk=new StringTokenizer(s);
		            for(int j=0;j<n;j++)
		            {
		                a[i][j]=Integer.parseInt(stk.nextToken());
		                if(1<=a[i][j]&&a[i][j]<=n);else x++;
		                if(i==j)
		                sum=sum+a[i][j];
		            }
		            for(int j=0;j<n;j++)
		            {
		                for(int k=j+1;k<n;k++)
		                if(a[i][j]==a[i][k])
		                {
		                    temp++;
		                    break;
		                }
		            }
		            if(temp>0)
		            rows=rows+1;
		        }

                for(int i=0;i<n;i++)
                {
                    int temp=0;
                    for(int j=0;j<n;j++)
		            {
		                for(int k=j+1;k<n;k++)
		                if(a[j][i]==a[k][i])
		                {
		                    temp++;
		                    break;
		                }
		            }
		            if(temp>0)
		            columns=columns+1;
                }
                
		        r[c][0]=sum;
		        r[c][1]=rows;
		        r[c][2]=columns;
		        sum=0;
		    }
		    
		    if(x==0)
		    for(int i=0;i<t;i++)
		    System.out.println("Case #"+(i+1)+": "+r[i][0]+" "+r[i][1]+" "+r[i][2]);
		}
	}
}