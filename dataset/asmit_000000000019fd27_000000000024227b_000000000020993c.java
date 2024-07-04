import java.io.*;
import java.util.*;
class vestigium
{
    int x,k,r,c;int q=0;
    public void main()throws IOException
    {
        Scanner sc=new Scanner(new BufferedInputStream(System.in));
        int T=Math.abs(sc.nextInt());
        int ar[]=new int[3*T]; 
        for(int h=1;h<=T;h++)
        {
            int size=Math.abs(sc.nextInt());          
            int arr[][]=new int[size][size];
            for(int v=0;v<size;v++)
            {
                int row;                
                row=Math.abs(sc.nextInt());
                for(int y=size-1;y>=0;y--)
                {
                arr[v][y]=row%10;
                row=row/10;
                }
            }
            {
                int f=0;
                for(int d=0;d<size;d++)
                {
                    f=f+arr[d][d];
                }
                k=f;
                ar[q]=k;
                q=q+1;
            }
            {
                int z=0,y=0;
                for(int j=0;j<size;j++)
                {
                    for(int k=1;k<=size;k++)
                    {
                        z=z+k;
                    }
                    for(int l=0;l<size;l++)
                    {
                        z=z-arr[j][l];
                    }
                    if(z!=0)
                    y=y+1;
                }
                r=y;
                ar[q]=r;
                q=q+1;
            }
            {
                int v=0,x=0;
                for(int s=0;s<size;s++)
                {
                    for(int k=1;k<=size;k++)
                    {
                        v=v+k;
                    }
                    for(int l=0;l<size;l++)
                    {
                        v=v-arr[l][s];
                    }
                    if(v!=0)
                    x=x+1;
                }
                c=x;
                ar[q]=c;
                q=q+1;
            }                    
        }
        {
            int u=0;
            for(int a=1;a<=T;a++)
            {
                System.out.println("Case#"+a+":"+ar[u]+ar[u+1]+ar[u+2]);
                u=u+3;
            }
        }        
    }
}

      