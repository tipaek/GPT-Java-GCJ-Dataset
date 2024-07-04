import java.util.*;
public class Solution {

	public static void main(String[] args) 
	{
		int T,N,i,j,k,trace,r,c,currVal;
		HashSet<Integer> hs1;
		int[][] arr;
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for(i=0;i<T;i++)
		{
		    N=sc.nextInt();
		    arr=new int[N][N];
		    for(j=0;j<N;j++)
		    {
		        for(k=0;k<N;k++)
		        {
		            arr[j][k]=sc.nextInt();
		        }
		    }
		    
		    trace=0;
		    for(j=0;j<N;j++)
		    {
		        trace=trace+arr[j][j];
		    }
		    
		    r=0;
		    for(j=0;j<N;j++)
		    {
		        hs1=new HashSet<>();
		        for(k=0;k<N;k++)
		        {
		            currVal=arr[j][k];
		            if(hs1.contains(currVal))
		            {
		                r++;
		                break;
		            } 
		            else
		            {
		                hs1.add(currVal);
		            }
		        }
		    }
		    
		    c=0;
		    for(j=0;j<N;j++)
		    {
		        hs1=new HashSet<>();
		        for(k=0;k<N;k++)
		        {
		            currVal=arr[k][j];
		            if(hs1.contains(currVal))
		            {
		                c++;
		                break;
		            } 
		            else
		            {
		                hs1.add(currVal);
		            }
		        }
		    }
		    System.out.println(trace+" "+r+" "+c);
		}
	}

}
