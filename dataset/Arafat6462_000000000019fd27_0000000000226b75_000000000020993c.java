import java.util.Scanner;
public class Google1 {

	static Scanner in= new Scanner(System.in);
	public static void main(String[] args) {

		int t=in.nextInt();

		
		
		//test case
		for(int i=0; i<t; i++)
		{
			int n=in.nextInt();
			
			int [][] arr=new int[n][n];
			
			
			
			// input
			for(int j=0; j<n; j++)
			{
				for(int k=0; k<n; k++)
				{
					arr[k][j]=in.nextInt();

				}
				
			}
			

//			// output
//			for(int j=0; j<n; j++)
//			{
//				for(int k=0; k<n; k++)
//				{
//					System.out.print(arr[k][j]+" "); 
//
//				}
//				System.out.println( ); 
//
//				
//			}
			
//			1
//			4
//			1 2 3 4
//			2 1 4 3
//			3 4 1 2
//			4 3 2 1
//			1 2 3 4 
//			2 1 4 3 
//			3 4 1 2 
//			4 3 2 1
////			
			
			
			int[] row=new int[n];

	        // row
			for(int j=0; j<n; j++)
			{
			for(int k=0; k<n; k++)
				{
				for(int l=k; l<n-1; l++)
				{
				
 					if(arr[k][j]==arr[l+1][j])
					{
 						row[j]=1;
 						break;
  					}
					
				}
 
				}
				
			}
			
			
			
			

	        // coliumn
			
			int[] column=new int[n];
			for(int j=0; j<n; j++)
			{
			for(int k=0; k<n; k++)
				{
				for(int l=k; l<n-1; l++)
				{
				
 					if(arr[j][k]==arr[j][l+1])
					{
 						column[j]=1;
 						break;
  					}
					
				}
 
				}
				
			}
			
			
			
			// diagonal
			int sum=0,ro=0,co=0;
			
			for(int p=0; p<n; p++)
			{
				sum+=arr[p][p];
				if(row[p]==1)
				{
					ro++;
				}
				if(column[p]==1)
				{
					co++;
				}
			}
			
			
			
			
			System.out.println("Case #"+(i+1)+": "+sum+" "+ro+" "+co);
			
		}
 
	
	
	}

}
