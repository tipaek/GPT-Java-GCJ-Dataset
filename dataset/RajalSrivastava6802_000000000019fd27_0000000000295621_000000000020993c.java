
import java.util.*;
class Vestigium
{
    public static int trace(int arr[][],int N)
    {
        int t=0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(i==j)
                t+=arr[i][j];
            }
        }
        return t;
    }
     public static int duplicate(int arr[][],int N)
    {
    	boolean b=false;
        int r=0;
        for(int i=0;i<N;i++)
        {  
        	b=false;
        	Arrays.sort(arr[i]);
            for(int j=0;j<N-1;j++)
            {
                if(arr[i][j]==arr[i][j+1])
                {
                	b=true;
                	break;
            
                }
            }
            
            if(b==true)
            r++;
            	
        }
        return r;
        
        
    }
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int T=in.nextInt();
        int resarr[][]=new int[T][3];
        
        for(int i=0;i<T;i++)
        {
        	int r=0,c=0,t=0;
            int N=in.nextInt();
            int arr[][]=new int[N][N];
            for(int j=0;j<N;j++)
            {
                for(int k=0;k<N;k++)
                {
                    arr[j][k]=in.nextInt();
                }
            }
            int arr2[][]=new int[N][N];
            for(int j=0;j<N;j++)
            {
                for(int k=0;k<N;k++)
                {
                    arr2[j][k]=arr[k][j];
                }
                
            }
            
            t=trace(arr,N);
            
            r=duplicate(arr,N);
           
            c=duplicate(arr2,N);
            
           
            resarr[i][0]=t;
            resarr[i][1]=r;
            resarr[i][2]=c;
        }
        
        for(int i=0;i<T;i++)
        {
        	 System.out.print("Case #"+(i+1)+": ");
        	for(int j=0;j<3;j++)
        	System.out.print(resarr[i][j]+" ");
        	System.out.println();
        }
            
        in.close();
            
    }
}


  