import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
    	int T = scan.nextInt();
    	for (int cs = 1; cs <= T; cs++) {
    	    int N = scan.nextInt();
    	    int[][] M = new int[N + 2][N + 2];
    	    int k = 0;
    	    int r = 0;
    	    int c = 0;
    	    for (int i = 0; i < N; i++) {
    		    for (int j = 0; j < N; j++) {
    		        M[i][j] = scan.nextInt();
    		        if (i == j) {
    			        k += M[i][j];
    		        }
    		    }
    	    }
    
    	    for (int i = 0; i < N; i++) {
    		    boolean foundDuplicate = false;
    		    int[] flag = new int[N + 2];
    		    for (int j = 0; j < N; j++) {
    		        flag[M[i][j]]++;
    		        if (flag[M[i][j]] > 1) {
    			        foundDuplicate = true;
    			        break;
    		        }
    		    }
        		if (foundDuplicate) {
        		    r++;
        		}
    	    }
    
    	    for (int i = 0; i < N; i++) {
        		boolean foundDuplicate = false;
        		int[] flag = new int[N + 2];
        		for (int j = 0; j < N; j++) {
        		    flag[M[j][i]]++;
        		    if (flag[M[j][i]] > 1) {
            			foundDuplicate = true;
            			break;
        		    }
        		}
        		if (foundDuplicate) {
        		    c++;
        		}
    	    }
    	    System.out.println("Case #" + cs + ": " + k + " " + r + " " + c);
    	}
    	scan.close();
    }
}