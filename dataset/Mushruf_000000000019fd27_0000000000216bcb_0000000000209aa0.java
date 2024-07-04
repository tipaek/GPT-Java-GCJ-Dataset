import java.lang.*;
import java.util.*;
class Program
{
	public static void main(String args[]) {
	    Scanner sc = new Scanner(System.in);
	    
	    
	        int N=sc.nextInt();
	    int b[][]=new int[N][N];
	    for (int i=0;i<N;i++){
	        for (int j=0;j<N;j++)
                   {
	            b[i][j]=sc.nextInt();
	           
                  }
	    }
int sum=0;
  for (int i=0;i<N;i++)
{

sum=sum+b[i][i];
}
System.out.println("case 1 Impossible");	    
}
}