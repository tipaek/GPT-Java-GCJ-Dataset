import java.lang.*;
import java.util.*;
class Matrix{
   void value (){
Scanner sc = new Scanner(System.in);
      int N=sc.nextInt();
	    int a[][]=new int[N][N];
	    for (int i=0;i<N;i++){
	        for (int j=0;j<N;j++)
                   {
	            a[i][j]=sc.nextInt();
	           }
                  }
                   for (int i=0;i<N;i++){
	        for (int j=0;j<N;j++)
                   {
	            System.out.print(a[i][j]);
	           }
                  System.out.println();
                  }
int sum=0;
  for (int i=0;i<N;i++)
{

sum=sum+a[i][i];
}
System.out.println(sum);
}
}
class Program
{
	public static void main(String args[]) {
	    Scanner sc = new Scanner(System.in);
	    int T=sc.nextInt();
	    Matrix m1 = new Matrix();
	    for (int a=0;a<T;a++)
	    {
	       m1.value(); 
	    }
	  
	    
	    
	}
}
