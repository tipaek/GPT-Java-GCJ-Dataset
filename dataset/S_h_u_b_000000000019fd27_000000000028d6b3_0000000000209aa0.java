import java.util.Scanner;
class SwapV {
  static void printLatin(int n,int k)
  {
	   k = n+1;
	  for(int i =1;i<=n; i++)
	  {
		  int temp = k;
		  while(temp<=n)
		  {
			  System.out.print(temp +" ");
			  temp++;
		  }
		  for(int j =1;j<k; j++)
			  System.out.print(j+" ");
		    k--;
		    System.out.println();
	  }
  }
	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  int t=sc.nextInt();
	  int i;
	  for(i=1;i<=t;i++)
	  {
	  int n =sc.nextInt();
	  
	  int k=sc.nextInt();
	  
	  printLatin(n,k);
	  }
	  
}
}


