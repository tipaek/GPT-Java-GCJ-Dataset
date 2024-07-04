import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		int numberOfTestCases = Integer.parseInt(bufferedReader.readLine());
		String answers[] = new String[numberOfTestCases];
		int matrixSize;
		int matrix[][] = new int[100][100];
		String matrixRowArray[] = new String[100];
		String matrixRow;
		int matrixRowInstance;
		int matrixColumnInstance;
		int matrixDiagnalSum;
		int rowRepeatCount;
		int columnRepeatCount;
		for(int testCaseInstance = 0;testCaseInstance < numberOfTestCases;testCaseInstance++)
		{	
			answers[testCaseInstance]="";
			matrixDiagnalSum = 0;
			rowRepeatCount = 0;
			columnRepeatCount = 0;
			matrixSize = Integer.parseInt(bufferedReader.readLine());	
			int matrixRowDuplicateCount[][] = new int[matrixSize][matrixSize];
			int matrixColumnDuplicateCount[][] = new int[matrixSize][matrixSize];
			for(matrixRowInstance = 0;matrixRowInstance < matrixSize;matrixRowInstance++)
			{
				matrixRow = bufferedReader.readLine();
				matrixRowArray = matrixRow.split(" ");
				for(matrixColumnInstance = 0; matrixColumnInstance < matrixSize; matrixColumnInstance++)
				{
					matrix[matrixRowInstance][matrixColumnInstance] = Integer.parseInt(matrixRowArray[matrixColumnInstance]);
					matrixRowDuplicateCount[matrixRowInstance][matrix[matrixRowInstance][matrixColumnInstance]-1]++;
					matrixColumnDuplicateCount[matrixColumnInstance][matrix[matrixRowInstance][matrixColumnInstance]-1]++;
					if(matrixRowInstance == matrixColumnInstance)
					{
						matrixDiagnalSum += matrix[matrixRowInstance][matrixColumnInstance];
					}
				}
			}
			for(matrixRowInstance = 0;matrixRowInstance < matrixSize;matrixRowInstance++)
			{
				for(matrixColumnInstance = 0;matrixColumnInstance < matrixSize;matrixColumnInstance++)
				{
					if(matrixRowDuplicateCount[matrixRowInstance][matrixColumnInstance]>1)
						{
							rowRepeatCount++;
							break;
						}
				}
				for(matrixColumnInstance = 0;matrixColumnInstance < matrixSize;matrixColumnInstance++)
				{
					if(matrixColumnDuplicateCount[matrixRowInstance][matrixColumnInstance]>1)
						{
							columnRepeatCount++;
							break;
						}
				}
			}
			answers[testCaseInstance]=String.valueOf(matrixDiagnalSum)+" "+String.valueOf(rowRepeatCount)+" "+String.valueOf(columnRepeatCount);
			
		}
		for(int j=0;j<numberOfTestCases;j++)
		{
			System.out.println("Case #"+(j+1)+": "+answers[j]);
		}
	}
}