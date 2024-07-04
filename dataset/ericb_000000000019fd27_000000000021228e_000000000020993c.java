import java.util.*;
public class Problem1{
	static int testCases = 0;
	static Scanner s;
	public static void main(String[] args){
		s = new Scanner(System.in);
		testCases = s.nextInt();
		String output = "";
		for(int i=0;i<testCases;i++){
			output = output + runTestCase(i+1);
		}

		System.out.println(output);
	}

	public static String runTestCase(int c){
		int size = s.nextInt();
		s.nextLine();
		int[][] values = new int[size][size];
		String[] tokens;
		for(int i=0;i<size;i++){
			
			tokens = s.nextLine().split(" ");
			for(int j=0;j<size;j++){
				values[i][j] = Integer.parseInt(tokens[j]);
			}
		}
		
		return "Case #"+c+": "+ calcTrace(values) 
			+" " + cntDupRow(values)
			+" " + cntDupColumn(values) +"\n";
	}	
	public static int calcTrace(int[][] arr){
		int sum=0;
		for(int i=0;i<arr.length;i++){
			sum = sum + arr[i][i];
		}
		return sum;
	}
	public static int cntDupColumn(int[][] arr){
		int colDupes=0;
		int[] col = new int[arr.length];
		for(int i=0;i<arr.length;i++){
			// for each row, count duplicates...
			col = new int[arr.length];
			for(int j=0;j<arr.length;j++){
				col[j] = arr[j][i];
			}
			if(hasDuplicate(col)){
				colDupes++;
			}	
		}
		return colDupes;
	}
	public static int cntDupRow(int[][] arr){
		int rowDupes=0;
		for(int i=0;i<arr.length;i++){
			// for each row, count duplicates...
			if(hasDuplicate(arr[i])){
				rowDupes++;
			}	
		}
		return rowDupes;
	}
	public static boolean hasDuplicate(int[] arr){
		
		for(int i=0;i<arr.length;i++){
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[i] == arr[j]){
					return true;
				}
			}
		}
		return false;
	}

}