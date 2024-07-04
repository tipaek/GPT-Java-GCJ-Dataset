import java.util.Scanner;
import java.util.regex.*;

public class Solution
{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T,N,i,j,k,temp1,temp2,sum=0,count1=0,count2=0;
		T=sc.nextInt();
		for(int x=0;x<T;x++)
		{
		    N=sc.nextInt();
		    int[][] M= new int[N][N];
		    for(i=0;i<N;i++)
		    {   for(j=0;j<N;j++)
		        {   M[i][j]=sc.nextInt();}}
		        
		    for(i=0;i<N;i++){
		        sum=sum+M[i][i];
		        outer:
		   	  for(j=0;j<N-1;j++){
		   	      for(k=j+1;j<N;j++){
		   	     if(M[i][j]==M[i][k]) 
		   	     {count1++;
		   	     break outer;
		   	     } 
		   	  }
		    }
		}
		   	  
		for(i=0;i<N;i++){
		    outer1:
		   	  for(j=0;j<N-1;j++){
		   	      for(k=j+1;j<N;j++){
		   	     if(M[j][i]==M[k][i]) 
		   	     {count2++;
		   	     break outer1;
		   	     } 
		   	  }
		    }
		}   	  
		System.out.print(sum+" "+count1+" "+count2);
		}
	    }   	  
		}