import java.io.*;
class Solution
	{
	    public static int duplicate_row(int d[][], int l)
	    {
	        int q=0;
	        for(int i=0;i<l;i++)
	        {
	            int k=0,count=0;
	            for(int j=1;j<l;j++)
	            {
	                if(d[i][k]==d[i][j])
	                ++count;
	            }
	            k++;
	            if(count>0)
	            {
	                q++;
	            }
	        }
	        return q;
	    }
	    public static int duplicate_column(int e[][], int z)
	    { 
	        int w=0;
	        for(int i=0;i<z;i++)
	        {
	            int k=0,count=0;
	            for(int j=1;j<z;j++)
	            {
	                if(e[k][i]==e[j][i])
	                ++count;
	            }k++;
	            if(count>0)
	            {
	                w++;
	            }
	        }
	        return w;
	    }
	    
	    public static int trace(int c[][],int v)
	    {
	    int  sum=0;
	    for(int y=0;y<v;y++)
	    {
	    sum =sum+c[y][y];
	    }
	    return sum;
	    }
	    public static void output(int c,int b[][], int u)
	    {
	        int t = trace(b,u);
	        int dr= duplicate_row(b,u);
	        int dc= duplicate_column(b,u);
	        System.out.println();
	        System.out.println("Case #"+c+":"+" "+t+" "+dr+" "+dc);
	    }
	    public static void main(String[] args)throws IOException
	    {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int t=Integer.parseInt(br.readLine());
	        for(int i=1;i<=t;i++)
	        {
	            int size=Integer.parseInt(br.readLine());
	            int a[][]=new int[size][size];
	            for(int j=0;j<size;j++)
	            {
	                String s=br.readLine();
	                String[] integerStrings = s.split(" ");
	                for(int k=0;k<size;k++)
	                {
	                    a[k][j] = Integer.parseInt(integerStrings[k]);
	                }    
	            }
	                output(i,a,size);
	        }
	    }
	}
