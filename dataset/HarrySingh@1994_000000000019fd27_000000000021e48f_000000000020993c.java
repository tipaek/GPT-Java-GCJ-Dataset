import java.util.Scanner;

class MainClass {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Enter the roral test cases");
		int cases=scan.nextInt();
		int[] finalResult=new int[cases*3];	
		int finalResultCount=0;
		
		
		
		
		for(int newCase=0;newCase<cases;newCase++)
		{
			int traceValue=0;
			System.out.println("Enter the size of the matrix to explore..");
			int sizeOfMatrix=scan.nextInt();
			int[][] newMatrix=new int[sizeOfMatrix][sizeOfMatrix];
			int[] rowDuplicate=new int[sizeOfMatrix];
			int columnDuplicateCount=0;
			int rowDuplicateCount=0;
			boolean columnDuplicateFound=false;
			boolean rowDuplicateFound=false;
			for(int row=0;row<sizeOfMatrix;row++)
			{
				for(int column=0;column<sizeOfMatrix;column++)
				{
					System.out.println("Enter the valu for array["+row+"]["+column+"]" );
					newMatrix[row][column]=scan.nextInt();
				}
			}
			
			for(int row=0;row<sizeOfMatrix;row++)
			{
				traceValue+=newMatrix[row][row];
			}
			
			
			
			for(int i=0;i<sizeOfMatrix;i++)
			{
				columnDuplicateFound=false;
		
				for(int j=0;j<sizeOfMatrix;j++)
				{
					rowDuplicateFound=false;
					int k=i;
					int l=j;
					while(l+1<=sizeOfMatrix-1)
					{
						if(!columnDuplicateFound)
						{
							if(newMatrix[i][l+1]==newMatrix[i][j])
							{
								columnDuplicateCount++;
								columnDuplicateFound=true;
								l++;
							}
							else
							{
								l++;
							}
						}
						else
						{
							break;
						}
					}
					
					
					if(rowDuplicate[j]!=1)
					{												
							while(k+1<=sizeOfMatrix-1)
							{
								if(!rowDuplicateFound)
								{
									if(newMatrix[k+1][j]==newMatrix[i][j])
									{
										rowDuplicateCount++;
										k++;
										rowDuplicateFound=true;
										rowDuplicate[j]=1;
									}
									else
									{
										k++;
									}
								}
								else
								{
									k++;
								}
						}
						
					}	
					
					
				}
			}
			
			
			
			
			finalResult[finalResultCount]=traceValue;
			finalResultCount++;
			finalResult[finalResultCount]=columnDuplicateCount;
			finalResultCount++;
			finalResult[finalResultCount]=rowDuplicateCount;
			finalResultCount++;
			
			
			
			
			
			
			
			
			
			
		}
	for(int i=0;i<finalResultCount;i++)
	{
		System.out.println("Case #"+i+1+":"+finalResult[i] + "   "+ finalResult[i+1]+ "   "+finalResult[i+2]);
		i=i+2;
		System.out.println();

	}
		
		
	}
}