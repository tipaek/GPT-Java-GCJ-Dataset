import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		//System.out.println("GfG!");
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		for(int i=0;i<test;i++)
		{
		    int ord=sc.nextInt();
		    int arr[][]=new int[ord][ord];
		    for(int j=0;j<ord;j++)
		    {
		        for(int k=0;k<ord;k++)
		        {
		         arr[j][k]=sc.nextInt();   
		        }
		    }
		    int trace=0;
		    for(int j=0;j<ord;j++)
		    {
		       
		        for(int k=0;k<ord;k++)
		        {
		            if(j==k)
		              trace=trace+arr[j][k];
		              
		        }
		    }
		    int row=0,col=0;
		    for(int j=0;j<ord;j++)
		    {
		        Arrays.sort(arr[j]);
		        for(int k=0;k<ord-1;k++)
		        {
		            if(arr[j][k]==arr[j][k+1]){
		            row++;
		            break;
		            }
		        }
		    }
		    
		    for(int j=0;j<ord;j++)
		    {
                boolean flag=false;	        
		        for(int k=0;k<ord-1;k++)
		        {
		            int x=arr[k][j];
		            for(int y=k+1;y<ord;y++)
		            {
		                 if(x==arr[y][k])
		                  {
		                   col++;
		                   flag=true;
		                    break;
		                  }
		            }
		            if(flag==true)
		               break;
		        }
		    }
		    System.out.println("Case #"+(i+1)+": "+trace+" "+row+" "+col);
		        
		    
		}
		
	}
}