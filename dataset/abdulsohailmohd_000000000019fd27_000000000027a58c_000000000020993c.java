import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
		return 1L;
    }

	private static final Scanner scanner = new Scanner(System.in);
	
	public static int[] vestigium(int[][] matrix) {

		int matrixSize = matrix.length;
	
		int k = 0, r = 0, c = 0;
	
		for (int i = 0; i < matrixSize; i++) {
			// System.out.print(" i >>"+ i +" ");
			HashMap hm = new HashMap<Integer, Boolean>();
			Boolean repeat = false;
			for (int j = 0; j < matrixSize; j++) {
				// Compute trace
				// System.out.println("Element>>"+matrix[i][j]);
				if (i == j) {
					k += matrix[i][j];
				}

				// System.out.println(hm.containsKey(matrix[i][j]));

				if ((Boolean) hm.containsKey(matrix[i][j])) {
					repeat = true;
				} else {
					hm.put(matrix[i][j], true);
				}
				// hm[matrix[i][j]] = hm[matrix[i][j]] ? hm[matrix[i][j]] + 1 : 1;
			}
	
			if (repeat) {
				r++;
			}
	
			hm = new HashMap<Integer, Boolean>();
			repeat = false;
			for (int j = 0; j < matrixSize; j++) {
				if ((Boolean) hm.containsKey(matrix[j][i])) {
					repeat = true;
				} else {
					hm.put(matrix[j][i], true);
				}
			}
	
			if (repeat) {
				c++;
			}
		}
		// System.out.println(k);
		// System.out.println(r);
		// System.out.println(c);
		return new int[]{k, r, c};
	}

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(""));

        int testCases = Integer.parseInt(scanner.nextLine());//.split(" ");

        // int n = Integer.parseInt(nm[0]);

        // int m = Integer.parseInt(nm[1]);

        // int[][] queries = new int[m][3];

        for (int i = 1; i <= testCases; i++) {
            // String[] queriesRowItems = scanner.nextLine().split(" ");
			// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			
			int matrixSize = Integer.parseInt(scanner.nextLine());

			int[][] matrix = new int[matrixSize][matrixSize];
			
			for (int x = 0; x < matrixSize; x++) {
				for (int y = 0; y < matrixSize; y++) {
					matrix[x][y] = Integer.parseInt(scanner.nextLine());
				}
			}

			// System.out.println(matrix);
			int[] res = vestigium(matrix);

			System.out.println("Case #"+i+": "+res[0]+" "+res[1]+" "+res[2]+"");
			
            // for (int j = 0; j < 3; j++) {
            //     int queriesItem = Integer.parseInt(queriesRowItems[j]);
            //     queries[i][j] = queriesItem;
            // }
        }

        // long result = arrayManipulation(n, queries);

		// System.out.println("Hmm"+String.valueOf(result));
        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
