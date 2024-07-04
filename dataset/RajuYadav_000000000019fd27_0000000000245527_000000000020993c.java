import java.util.*;
public class Solution {

	public static int[] isLatinMatrix(int[][] latMatrix,int n){
		
		int rowCount = 0;
		int colCount = 0;
		int mainDiagonal = 0;

		int[] intArray = new int[3];

		// for Row
		 for (int i = 0; i < n; i++) 
        {
        	Map<Integer, Integer> rowMap = new HashMap<Integer, Integer>();
            for (int j = 0; j < n; j++) 
            {
                if(rowMap.containsKey(latMatrix[i][j])){
                	rowMap.put(latMatrix[i][j],  rowMap.get(latMatrix[i][j]) + 1);
                }else{
                	rowMap.put(latMatrix[i][j],0);
                }
            }

            for(int a :rowMap.values()){
            	if(a>0){
            		rowCount++;
            		break;
            	}
            }

            mainDiagonal = mainDiagonal + latMatrix[i][i];
        }

        // for col

         for (int i = 0; i < n; i++) 
        {
        	Map<Integer, Integer> colMap = new HashMap<Integer, Integer>();
            for (int j = 0; j < n; j++) 
            {
                if(colMap.containsKey(latMatrix[j][i])){
                	colMap.put(latMatrix[j][i],colMap.get(latMatrix[j][i]) + 1);
                }else{
                	colMap.put(latMatrix[j][i],0);
                }
            }
            for(int a :colMap.values()){
            	if(a>0){
            		colCount++;
            		break;
            	}
            }
        }
        intArray[0]= mainDiagonal;
        intArray[1] = rowCount;
        intArray[2] = colCount;
        //System.out.println("mainDiagonal "+mainDiagonal+" rowCount "+rowCount + " colCount "+colCount);
        return intArray;
	}

	public static void main(String[] args) {
	   Scanner input = new Scanner(System.in);
	   int numberOfTestCase = input.nextInt();
	   // N X N matrinx
	  
	   for(int p = 0 ; p < numberOfTestCase ; p++){
	   	   int n = input.nextInt();
	       int a[][] = new int[n][n];
	   	   for (int i = 0; i < n; i++) 
            {
                for (int j = 0; j < n; j++) 
                {
                    a[i][j] = input.nextInt();
                }
            }

            int[] returnValue = new int[3];
            returnValue = isLatinMatrix(a,n);
            int counter = p+1;
            System.out.println("Case #"+counter+":"+" "+returnValue[0] + " "+returnValue[1]+" "+returnValue[2]);

	   }
	}
}