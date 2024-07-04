import java.util.*;

class Calculator{
	public static int count_r(int[][] arr, int n) {
		Set<Integer> dupeChecker = new HashSet<>();
		int rows = arr.length,count_row=0;
		for (int rowIndex = 0; rowIndex < n; ++rowIndex) {
			int columns = arr[rowIndex].length;
			for (int colIndex = 0; colIndex < n; ++colIndex) {
				int value = arr[rowIndex][colIndex];
				if (!dupeChecker.add(value)) {
					count_row++;
					break;
				}
			}
		}
		return count_row;
	}
	public static int count_c(int[][] arr, int n) {
		Set<Integer> dupeChecker = new HashSet<>();
		int count_col=0;
		for (int colIndex = 0; colIndex < n; ++colIndex) {
			for (int rowIndex = 0; rowIndex < n; ++rowIndex) {
				{
					int value = arr[rowIndex][colIndex];
					if (!dupeChecker.add(value)) {
						count_col++;
						break;
					}
				}
			}
			
		}
		return count_col;
	}
		public static void main(String args[]){
			int t,n,i,j,k=0,r=0,c=0;
			int[][] arr;
			Scanner s = new Scanner(System.in);
			if(s.hasNext()){
			t = s.nextInt();
			while(t>0){
				n = s.nextInt();
				arr = new int[n][n];
				for(i=0;i<n;i++) {
					for(j=0;j<n;j++) {
						arr[i][j] = s.nextInt();
						if(i==j) {
							k+=arr[i][j];
						}
					}
				}
				r = count_r(arr,n);
				c = count_c(arr,n);

				System.out.printf("Case #%d: %d %d %d",t,k,r,c);
				t--;
			}

			}
		}
	}