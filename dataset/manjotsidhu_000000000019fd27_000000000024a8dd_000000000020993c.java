import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

	    int cases = sc.nextInt();
	    for (int c = 1; c <= cases; c++) {
	        int s = sc.nextInt();
	        int arr[][] = new int[s][s];
            int rSum = 0;
            int rRows = 0;
            int rCols = 0;

	        for (int i = 0; i < s; i++) {
                HashSet<Integer> tSet = new HashSet<>();
                for (int j = 0; j < s; j++) {
                    arr[i][j] = sc.nextInt();
                    tSet.add(arr[i][j]);

                    if (i == j)
                        rSum += arr[i][j];
                }

                if (tSet.size() < s)
                    rRows++;
            }

	        for (int i = 0; i < s; i++) {
	            HashSet<Integer> tSet = new HashSet<>();
	            for (int j = 0; j < s; j++) {
	                tSet.add(arr[j][i]);
                }

	            if (tSet.size() < s)
	                rCols++;
            }

	        System.out.println(String.format("Case #%d: %d %d %d", c, rSum, rRows, rCols));
        }
    }
}
