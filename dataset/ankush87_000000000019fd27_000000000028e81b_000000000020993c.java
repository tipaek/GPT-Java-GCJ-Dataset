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
		int matrixSizeSum;
		int rowRepeatCount;
		int columnRepeatCount;
		for(int testCaseInstance = 0;testCaseInstance < numberOfTestCases;testCaseInstance++)
		{	
			answers[testCaseInstance]="";
			matrixDiagnalSum = 0;
			matrixSizeSum = 0;
			rowRepeatCount = 0;
			columnRepeatCount = 0;
			matrixSize = Integer.parseInt(bufferedReader.readLine());	
			int matrixRowSum[] = new int[matrixSize];
			int matrixColumnSum[] = new int[matrixSize];
			for(matrixRowInstance = 0;matrixRowInstance < matrixSize;matrixRowInstance++)
			{
				matrixRow = bufferedReader.readLine();
				matrixRowArray = matrixRow.split(" ");
				for(matrixColumnInstance = 0; matrixColumnInstance < matrixSize; matrixColumnInstance++)
				{
					matrix[matrixRowInstance][matrixColumnInstance] = Integer.parseInt(matrixRowArray[matrixColumnInstance]);
					matrixRowSum[matrixRowInstance] += matrix[matrixRowInstance][matrixColumnInstance];
					matrixColumnSum[matrixColumnInstance] += matrix[matrixRowInstance][matrixColumnInstance];
					if(matrixRowInstance == matrixColumnInstance)
					{
						matrixDiagnalSum += matrix[matrixRowInstance][matrixColumnInstance];
					}
				}
				matrixSizeSum += (matrixRowInstance+1);
			}
			for(matrixRowInstance = 0;matrixRowInstance < matrixSize;matrixRowInstance++)
			{
				if(matrixRowSum[matrixRowInstance] != matrixSizeSum)
				{
					rowRepeatCount++;
				}
					
				if(matrixColumnSum[matrixRowInstance] != matrixSizeSum)
				{
					columnRepeatCount++;
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

