import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*; 
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.File;
import java.io.FileInputStream;

public class Solution {

	public static void sortbyColumn(int arr[][], int col) 
    { 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  // End of function call sort(). 
    } 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Scanner scanner = new Scanner (new File("D:/input.txt"));
        	Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			//Discard first line
			String noOfTestCases = scanner.nextLine();
			
			for(int counter = 1; counter < Integer.parseInt(noOfTestCases) + 1; counter++)
			{
				String arraySize = scanner.nextLine();
				int arraySizeInt = Integer.parseInt(arraySize);
				int COcc = 0;
				int JOcc = 0;
				int[][] fullArr = new int[arraySizeInt][4];
				
				//Construct full array
				for(int arrySizeConstruct = 0; arrySizeConstruct < arraySizeInt; arrySizeConstruct++)
				{
					String readLines = scanner.nextLine();
					String [] readLinesArr = readLines.split("\\s+");
					//Construct the timing
					for(int j =0; j < 2; j++)
					{
						fullArr[arrySizeConstruct][j] = Integer.parseInt(readLinesArr[j]);
					}
					//Add position of array
					fullArr[arrySizeConstruct][2] = arrySizeConstruct;
					//The responsible person
					fullArr[arrySizeConstruct][3] = 0;
				}
				
				//SortArray
				sortbyColumn(fullArr, 0);
				
				//Assign persons
				//1 for C and 2 for J and if impossible break and write impossible.
				for(int arrySizeConstruct = 0; arrySizeConstruct < arraySizeInt; arrySizeConstruct++)
				{
					
					if(COcc == 0)
					{
						//First allocation of C
						COcc = fullArr[arrySizeConstruct][1];
						fullArr[arrySizeConstruct][3] = 1;
					}
					else if (JOcc == 0 && COcc != 0)
					{
						//First allocation of J
						JOcc  = fullArr[arrySizeConstruct][1];
						fullArr[arrySizeConstruct][3] = 2;
					}
					else if(COcc <= fullArr[arrySizeConstruct][0])
					{
						//allocate to C
						COcc  = fullArr[arrySizeConstruct][1];
						fullArr[arrySizeConstruct][3] = 1;
					}
					else if(JOcc <= fullArr[arrySizeConstruct][0])
					{
						//allocate to J
						JOcc  = fullArr[arrySizeConstruct][1];
						fullArr[arrySizeConstruct][3] = 2;
					}
					else
					{
						//Impossible
						break;
					}
				}
				
				//SortArray back to original
				sortbyColumn(fullArr, 2);
				
				String outputSt = "";
				
				for(int arrySizeConstruct = 0; arrySizeConstruct < arraySizeInt; arrySizeConstruct++)
				{
					if(fullArr[arrySizeConstruct][3] == 1)
					{
						outputSt += "C";
					}
					else if(fullArr[arrySizeConstruct][3] == 2)
					{
						outputSt += "J";
					}
					else
					{
						outputSt = "IMPOSSIBLE";
						break;
					}
				}
				System.out.println("Case #" + counter + ": " + outputSt);
			}
		}
		catch(Exception e){
		     System.out.println(e);
	    }
		
	}

}
