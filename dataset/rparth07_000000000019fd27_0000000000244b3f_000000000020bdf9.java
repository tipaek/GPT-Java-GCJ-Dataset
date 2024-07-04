import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
    
    Scanner y = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t=y.nextInt();    
    for(int i=0;i<t;i++)
    {  
		int p=0,m=0,h=0,z=0;
		char g;
		int[] temp=new int[2];
        int n=y.nextInt();
        
        char[] b=new char[n];
        
        int[] ri=new int[n];
        int[] le=new int[n];
        
        int[][] a=new int[n][2];
        int[] v=new int[n];
        for(int j=0;j<n;j++)
        {
            for(int k=0;k<2;k++)
            {
                a[j][k]=y.nextInt();
				v[j]=j;
            }
        }
		h=0;
        for(int j=0;j<n;j++)
        {
            for(int k=j+1;k<n;k++)
            {
                if(a[j][0]>=a[k][0])
                {
					h=v[j];
					v[j]=v[k];
					v[k]=h;
                    temp[0]=a[j][0];
                    temp[1]=a[j][1];
                    a[j][0]=a[k][0];
                    a[j][1]=a[k][1];
                    a[k][0]=temp[0];
                    a[k][1]=temp[1];
                }
            }
        }
        
        for(int j=0;j<n;j++)
        {
            ri[j]=a[j][1];
        }
        for(int j=1;j<n;j++)
        {
            le[0]=0;
            le[j]=a[j][0];
        }
            z=0;
            p=1;
            b[z]='C';
            z++;
            b[z]='J';
            z++;
            for(int k=2,j=0,x=1;k<n;k++)
            {
                if(ri[j]<=le[k])
                {
                    b[z]='C';
                    if(j<=x)
                    {
                        while(j<=x)
                        {
                            j++;
                        }
                    }
                    else
                    {
                        j++;
                    }
                    z++;
                }
                else if(ri[x]<=le[k])
                {
                    b[z]='J';
                    if(x<=j)
                    {
                        while(x<=j)
                        {
                            x++;
                        }
                        
                    }
                    else
                    {
                        x++;
                    }
                    z++;
                }
                else
                {
                    
                    k=n;
					h=5;
                }
            }
			if(h!=5)
			{
				for(int j=0;j<n;j++)
				{
					for(int k=0;k<n;k++)
					{
					   g=b[j];
					   b[j]=b[v[j]];
					   b[v[j]]=g;
					}
				}
					String str = String.valueOf(b);
					System.out.println("Case #" + (i+1) + ": " +str);
			}
			else
			{
				System.out.println("Case #" + (i+1) + ": "+"IMPOSSIBLE");
			}

        
    }
    
    }
    
}