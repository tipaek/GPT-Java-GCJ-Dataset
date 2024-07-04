import java.io.*;
class Main
{
	public static void main(String[] args)throws IOException
	{
	    int i,j,k,t,size,a[][],flag=0;
	    BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		int x=Integer.parseInt(BR.readLine());
		int o[][]=new int [x][3];
		for(i=0;i<x;i++)
		    for(j=0;j<3;j++)
		        o[i][j]=0;
		for(t=0;t<x;t++)
		{
		    size=Integer.parseInt(BR.readLine());
		    a=new int[size][size];
		    for(i=0;i<size;i++)
		        for(j=0;j<size;j++)
		        {
		             a[i][j]=Integer.parseInt(BR.readLine());
		             if(i==j)
		                o[t][0]=o[t][0]+a[i][j];
		        }
		    for(i=0;i<size;i++)
		        for(j=0;j<size;j++)
		            {
		                flag=0;
		                for(k=j+1;k<size;k++)
		                    if(a[i][j]==a[i][k])
		                    {
		                        o[t][1]=o[t][1]+1;
		                        flag=1;
		                        break;
		                    }
		                if(flag==1)
		                    break;
		            }
		    for(j=0;j<size;j++)
		        for(i=0;i<size;i++)
		        {
		            flag=0;
		            for(k=i+1;k<size;k++)
		                if(a[i][j]==a[k][j])
		                {
		                    o[t][2]=o[t][2]+1;
		                    flag=1;
		                    break;
		                }
		            if(flag==1)
		                break;
		        }
		}
		for(i=0;i<x;i++)
	    {  
		    System.out.print("Case #"+(i+1)+": ");
		    for(j=0;j<3;j++)
    		    System.out.print(o[i][j]+" ");
    	    System.out.println("");
		}
	}
}