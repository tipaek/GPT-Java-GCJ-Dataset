import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int testcase = 0;
		
		while(testcase < t) {
			testcase++;
			int n = sc.nextInt();
			int arr[][] = new int [n][n];
			int dupRows = 0;
			int dupCols = 0;
			List<Integer> nList = new ArrayList<Integer>();
			for(int i=0; i<n; i++) {
				nList.add(i+1);
			}
			
			for (int i=0; i<n; i++) {
				List<Integer> rowList = new ArrayList<Integer>();
				rowList.addAll(nList);
				boolean checkRowDup = true;
				for (int j=0; j<n; j++) {
					arr[i][j] = sc.nextInt();
					
					if(checkRowDup) {
						if(rowList.remove((Integer)arr[i][j]) == false) {
							dupRows++;
							checkRowDup = false;
						}
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				List<Integer> columnList = new ArrayList<Integer>();
				columnList.addAll(nList);
				boolean checkColDup = true;
				for (int j=0; j<n; j++) {
					if(checkColDup) {
						if(columnList.remove((Integer)arr[j][i]) == false) {
							dupCols++;
							checkColDup = false;
						}
					}
				}
			}
			
			System.out.println("Case #"+testcase+": "+calcTrace(arr,n)+" "+dupRows+" "+dupCols);
		}
		
		sc.close();
	}

	private static int calcTrace(int[][] arr, int n) {
		int sum = 0;
		for (int i=0; i<n; i++) {
			sum+=arr[i][i];
		}
		return sum;
	}
}
