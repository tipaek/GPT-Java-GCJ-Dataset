import java.util.Scanner;
import java.util.regex.*;

public class Solution
{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T,N,i,j,k,sum=0,count1=0,count2=0;
		T=sc.nextInt();
		for(int x=0;x<T;x++)
		{
		    N=sc.nextInt();
		    int[][] M= new int[N][N];
		    for(i=0;i<N;i++)
		    {   for(j=0;j<N;j++)
		        {   M[i][j]=sc.nextInt();}}
		        
		        for(i=0;i<N;i++)
		        sum=sum+M[i][i];
		        
		        
		    for(i=0;i<N;i++){
		        outer:
		   	  for(j=0;j<N-1;j++){
		   	      for(k=j+1;k<N;k++){
		   	     if(M[i][j]==M[i][k]) 
		   	     {count1++;
		   	     break outer;
		   	     } 
		   	  }
		    }
		    continue;
		}
		
		   	  
		for(i=0;i<N;i++){
		    outer1:
		   	  for(j=0;j<N-1;j++){
		   	      for(k=j+1;k<N;k++){
		   	     if(M[j][i]==M[k][i]) 
		   	     {count2++;
		   	     break outer1;
		   	     } 
		   	  }
		    }
		    continue;
		}   	  
		System.out.print(sum+" "+count1+" "+count2);
		}
	    }   	  
		}