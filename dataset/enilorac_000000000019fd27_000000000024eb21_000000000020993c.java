import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {
	public static int c = 0, rr = 0, rc = 0;

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int T = inputScanner.nextInt();
        for(int i = 0; i < T; i++){
            int N = inputScanner.nextInt();
            int[][] a = new int[N][N];
            for(int j = 0; j < N; ++j){
                for(int k = 0; k < N; ++k){
                    a[j][k] = inputScanner.nextInt();
                }
            }
            trace(a, i);
            c = 0;
            rr = 0;
            rc = 0;
        }
        inputScanner.close();
    }

    static void trace(int[][] a, int n){
    	counting(a, 1);
    	counting(a, 0);
        System.out.print(String.format("\nCase #%d: %d %d %d", n+1, c, rr, rc));

    }
    
    static void counting(int[][]a, int k) {
    	for (int i = 0; i < a.length; i++) {
    		HashSet hs = new HashSet<Integer>();
    		for (int j = 0; j < a.length; j++) {
    			int tmp = 0;
    			if (k == 0) {
    				tmp = a[i][j];
    				if (i == j) c += tmp;
    			} else {
    				tmp = a[j][i];
    			}
    			hs.add(tmp);
    		}
    		if (hs.size() < a.length) {
    			if (k == 0) rr++;
    			else rc++;
    		}
    	}
    }
}