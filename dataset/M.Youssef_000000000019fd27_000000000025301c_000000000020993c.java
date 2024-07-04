/**
 * 
 */
package hash;

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Diab
 *
 */
public class Hashes {

    public static boolean checkDuplicates(String[] input){
        List inputList = Arrays.asList(input);
        Set inputSet = new HashSet(inputList);
        if(inputSet.size()< inputList.size())
            return true;
        
        return false;
    }
  
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        try {
        	//Scanner scanner = new Scanner (new File("D:/input.txt"));
        	Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			//Discard first line
			String noOfTestCases = scanner.nextLine();
			
			for(int counter = 1; counter < Integer.parseInt(noOfTestCases) + 1; counter++)
			{
				int counterCol = 0;
				int counterRow = 0;
				int traceCount = 0;
				
				String arraySize = scanner.nextLine();
				int arraySizeInt = Integer.parseInt(arraySize);
				String[][] fullArr = new String[arraySizeInt][arraySizeInt];
				String[][] fullArrTranspose = new String[arraySizeInt][arraySizeInt];
				
				//Check duplicates in row and construct full array
				for(int arrySizeConstruct = 0; arrySizeConstruct < arraySizeInt; arrySizeConstruct++)
				{
					//Check duplicates in row
					String readLines = scanner.nextLine();
					String [] readLinesArr = readLines.split("\\s+");
					for(int j =0; j < arraySizeInt; j++)
					{
						fullArr[arrySizeConstruct][j] = readLinesArr[j];
					}
					if(checkDuplicates(fullArr[arrySizeConstruct]))
					{
						counterRow++;
					}
				}
				
				//Transpose matrix
				for (int i = 0; i < arraySizeInt; i++) {
			        for (int j = 0; j < arraySizeInt; j++) {
			        	fullArrTranspose[j][i] = fullArr[i][j];
			        }
			        traceCount += Integer.parseInt(fullArr[i][i]);
			        
			    }
				
				//Check duplicates in column
				for(int arrySizeConstruct = 0; arrySizeConstruct < arraySizeInt; arrySizeConstruct++)
				{
					if(checkDuplicates(fullArrTranspose[arrySizeConstruct]))
					{
						counterCol++;
					}
				}
				
				System.out.println("Case #" + counter + ": " + traceCount + " " + counterRow + " " + counterCol);
			}
		}
		catch(Exception e){
	     System.out.println(e);
	    }
	}
}
