import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;



public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int k= in.nextInt();
			
			
			long start = System.currentTimeMillis();
			String result = sol.processData(n, k);
			System.out.println("Case #" + i + ": " + result);
			long end = System.currentTimeMillis();
			//System.out.println("total time = " + (end-start));
		}
	}

	public String processData(int n, int k) {

		//String mat[][] = new String[n][n];
		int tmpArr[] = new int[k];
		
		ArrayList<int[]> traces = this.recurseForNumbers(tmpArr, 0, k, n, k, 0);
		for (int[] ar : traces) {
			int mat[][] = new int[n][n];
			//System.out.println(Arrays.toString(ar));
			//	Fill the matrix and recurse
			String rowUsedVals[] = new String[n];
			String colUsedVals[] = new String[n];
			boolean skipRecord=false;
			for (int i=0;i<n;i++) {
				if (ar[i]>n) {
					skipRecord=true;
					break;
				}
				mat[i][i]=ar[i];
				rowUsedVals[i]=ar[i]+"";
				colUsedVals[i]=ar[i]+"";
			}
			if(skipRecord) continue;
			
			boolean status = this.recurseForMatrix(mat, 0, 1, n,rowUsedVals,colUsedVals);
			if(status) {
				StringBuilder builder = new StringBuilder();
				builder.append("POSSIBLE\n");
				for (int i=0;i<n;i++) {
					builder.append(Arrays.toString(mat[i]));
					builder.append("\n");
				}
				return builder.toString();
			}
			
		}




		return "IMPOSSIBLE";
	}
	
	public HashMap<String,String> getPossibleValues(int size) {
		HashMap<String,String> possibleVals = new HashMap<String,String>();
		for (int i=1;i<=size;i++) {
			possibleVals.put(i+"",i+"");
		}
		return possibleVals;
	}
	
	
	public boolean recurseForMatrix(int [][] mat, int row, int col, int size,String rowUsedVals[], String colUsedVals[] ) {
		if(row>=size || col>=size)
			return true;
		int nextRow=row;
		int nextCol=col+1;
		if(nextCol==size) {
			nextRow=row+1;
			nextCol=0;
		}
		if(nextRow==size) {
			return true;
		}
		
		String[] valsToConsider;
		
		int val = mat[row][col];
		if(val!=0) {
			valsToConsider = new String[1];
			valsToConsider[0]=val+"";
		}
		else
			//valsToConsider = this.computePossibleValuesForCell(mat, size, row, col,rowUsedVals,colUsedVals);
			valsToConsider = this.computePossibleValuesForCell(mat, size, row, col);
		
		if(valsToConsider.length<=0) {
			return false;
		}
		
		
		//String prevRowUsedVal = rowUsedVals[row];
		//String prevColUsedVal = colUsedVals[col];
		for(String valToConsider : valsToConsider) {
			mat[row][col]=new Integer(valToConsider).intValue();
			
			//rowUsedVals[row]=prevRowUsedVal+","+valToConsider;
			//colUsedVals[col]=prevColUsedVal+","+valToConsider;
			long start1 = System.currentTimeMillis();
			boolean matRet = this.recurseForMatrix(mat, nextRow, nextCol, size,rowUsedVals,colUsedVals);
			long end1 = System.currentTimeMillis();
			//System.out.println("Inside recur = " + (end1-start1));
			if(matRet) {
				
				return true;
			}
		}
		
		return false;
		
	}

	public String[] computePossibleValuesForCell(int[][] mat, int size, int rowNum, int colNum,String rowUsedVals[], String colUsedVals[] ) {
		long start = System.currentTimeMillis();
		HashMap<String,String> possibleVals = this.getPossibleValues(size);
		for (String usedVal : rowUsedVals[rowNum].split(",")) {
			possibleVals.remove(usedVal);
		}
		for (String usedVal : colUsedVals[colNum].split(",")) {
			possibleVals.remove(usedVal);
		}
		
		String arr[] = possibleVals.keySet().toArray(new String[0]);
		//System.out.println(Arrays.toString(arr));
		long end = System.currentTimeMillis();
		//System.out.println("compare time = " + (end-start));
		return arr;
	}

	public String[] computePossibleValuesForCell(int[][] mat, int size, int rowNum, int colNum) {
		long start = System.currentTimeMillis();
		ArrayList<Integer> usedVals = new ArrayList<Integer>();
		int val =0;
		for (int i=0;i<size;i++) {
			val = mat[rowNum][i];
			if(val!=0) {
				usedVals.add(val);
			}
		}
		
		for (int i=0;i<size;i++) {
			val = mat[i][colNum];
			if(val!=0) {
				usedVals.add(val);
			}
		}
		
		HashMap<String,String> possibleVals = this.getPossibleValues(size);
		for (Integer usedVal : usedVals) {
			possibleVals.remove(usedVal.intValue()+"");
		}
		
		String arr[] = possibleVals.keySet().toArray(new String[0]);
		//System.out.println(Arrays.toString(arr));
		long end = System.currentTimeMillis();
		//System.out.println("old compare time = " + (end-start));
		return arr;

	}



	public ArrayList<int[]> recurseForNumbers(int tmpArr[], int index, int actualNum, int maxNumOfDigits, int currentVal, int numOfDigits) {
		ArrayList<int[]> retVal = new ArrayList<int[]>();
		if(numOfDigits>maxNumOfDigits)
			return retVal;
		if(currentVal==0)
		{		
			if(numOfDigits==maxNumOfDigits)
				retVal.add(Arrays.copyOfRange(tmpArr.clone(),0,maxNumOfDigits));
			return retVal;
		}

		if(currentVal<0)
		{
			return retVal;
		}

		int startVal = 1;
		if(index!=0)
			startVal=tmpArr[index-1];

		for (int i=startVal; i<= actualNum; i++) {
			tmpArr[index]=i;
			retVal.addAll(this.recurseForNumbers(tmpArr, index+1, actualNum, maxNumOfDigits, currentVal-i, numOfDigits+1));
		}
		return retVal;
	}



}
