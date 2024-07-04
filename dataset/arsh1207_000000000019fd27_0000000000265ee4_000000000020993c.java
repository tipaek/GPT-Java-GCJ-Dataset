import java.io.*;
import java.util.*; 

class CodeJam1 {

	public static void main(String args[]) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			int test = Integer.parseInt(br.readLine());
			for (int t = 0; t < test; t++) {
				int N = Integer.parseInt(br.readLine());
				int mat[][] = new int[N][N];
				for (int i = 0; i < N; i++) {
					String line = br.readLine();
					String line_array[] = line.split(" ");
					for (int j = 0; j < N; j++) {
						mat[i][j] = Integer.parseInt(line_array[j]);
					}
				}
				// logic
				int trace = 0;
				for (int i = 0; i < N; i++) {
					trace += mat[i][i];
				}
				int row_counter = 0;
				int column_counter = 0;
				for (int i = 0; i < N; i++) {
					Integer arr[] = new Integer[N];
					for (int j = 0; j < N; j++) {
						 arr[j] = mat[i][j];
					}
					List<Integer> list = Arrays.asList(arr);
					Collections.sort(list);
					for(int k = 0 ; k < N-1; k++) {
						if(list.get(k) == list.get(k+1)) {
							row_counter += 1;
							break;
						}								
					}
					// for column
					for (int j = 0; j < N; j++) {
						 arr[j] = mat[j][i];
					}
					List<Integer> list2 = Arrays.asList(arr);
					Collections.sort(list2);
					for(int k = 0 ; k < N-1; k++) {
						if(list2.get(k) == list2.get(k+1)) {
							column_counter += 1;
							break;
						}				
					}
				}
				System.out.println("Case #"+(t+1)+": "+trace+" "+row_counter+" "+column_counter);
			}

		} catch (

		Exception e) {
			System.out.println(e.getMessage());
		}
	}
}