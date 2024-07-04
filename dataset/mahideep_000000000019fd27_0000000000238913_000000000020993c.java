
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int testCaseCount = Integer.parseInt(sc.nextLine());

		for (int t = 0; t < testCaseCount; t++) {

			int N = Integer.parseInt(sc.nextLine());
			int arr[][] = new int[N][N];

			for (int k = 0; k < N; k++) {

				String r = sc.nextLine();

				String row[] = r.split("\\s+");

				int[] array = Arrays.asList(row).stream().mapToInt(Integer::parseInt).toArray();

				arr[k] = array;
				

				//System.out.println(Arrays.toString(arr[k]));
			}

			Set<Integer> rowSet=new HashSet<>();
			Set<Integer> columnSet=new HashSet<>();

			checkForDuplicate(arr,rowSet,columnSet,t+1);
			//System.out.println("2 D Array here is "+ Arrays.deepToString(arr));

		}
		sc.close();

	}
	
	static void checkForDuplicate(int[][] arr, Set<Integer> rowSet,Set<Integer> columnSet,int caseCount) {
		
		int k=0,r=0,c=0;
		
		for(int i=0;i<arr.length;i++) {
			
			rowSet=new HashSet<>();
			columnSet=new HashSet<>();
			boolean dupRowFound = false;
			boolean dupColumnFound = false;
			for(int j=0;j<arr[i].length;j++) {
			
				if(i==j) 
					k+=arr[i][j];
				
				
				if(rowSet.contains(arr[i][j])) 
					dupRowFound=true;
				
				else
					rowSet.add(arr[i][j]);
				
				
				if(columnSet.contains(arr[j][i]))		
					dupColumnFound=true;
				else
					columnSet.add(arr[j][i]);
			}
			
			if(dupColumnFound) c++;
			if(dupRowFound) r++;

		}
		
		System.out.println("Case #"+caseCount+": "+k +" "+r+" "+c);
		
	}
}
