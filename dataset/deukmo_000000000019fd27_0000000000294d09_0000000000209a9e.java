import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

        int T = in.nextInt();
    	int B = in.nextInt();
	    for (int t=1; t<=T; t++) {
	    	int sP = -1;
	    	int dP = -1;
	    	int queryCnt = 0;
    		for (int j=1; j<=(B/2); j++) {
    			System.out.println(j); queryCnt++;
    			int a = in.nextInt();
    			System.out.println(B-(j-1)); queryCnt++;
    			int b = in.nextInt();
    			
    			if (a == b && sP == -1) {
    				sP = j;
    			}
    			if (a != b && dP == -1) {
    				dP = j;
    			}
    			
    			if (sP != -1 && dP != -1) break;
    		}
    		
    		int remain = (150 - queryCnt) % 10;
    		for (int i=0; i<remain; i++) {
    			System.out.println(1); queryCnt++;
    			in.nextInt();
    		}
    		
    		if (sP == -1 || dP == -1) {
    			int[][] r = new int[2][B];
    			Arrays.fill(r[0], -1);
    			Arrays.fill(r[1], -1);
    			
    			int curMode = -1;
    			int fillIdx = 0;
    			while(queryCnt < 150) {
    				if (curMode == -1) {
	        			System.out.println(1); queryCnt++;
	        			int a = in.nextInt();
	        			int b = (sP == -1) ? ((a==0) ? 1 : 0) : a;

	        			if (r[0][0] == -1) {
		        			putValue2(r, curMode, 1, B, a, b);
		    				curMode = 0;
		    			} else {
		        			if (r[0][0] == a) {
		        				curMode = 0;
		        			} else if (r[0][0] != a) {
		        				curMode = 1;
		        			}
		    			}
    				} else {
    					while (r[0][fillIdx] != -1 && fillIdx < (B / 2)) {
    						fillIdx++;
    					}
    					if (fillIdx < (B / 2)) {
    						System.out.println(fillIdx + 1); queryCnt++;
		        			int a = in.nextInt();
		        			int b = (sP == -1) ? ((a==0) ? 1 : 0) : a;
		        			putValue2(r, curMode, fillIdx + 1, B, a, b);
	    					fillIdx++;
    					}
    				}
    				
    				if (fillIdx >= (B / 2)) {
    					String rStr = "";
    					for (int i=0; i<B; i++) {
    						rStr = rStr + r[curMode][i];
    					}
    					System.out.println(rStr);
    					
    					String res = in.next();
    					if (res.equals("Y")) {
    						break;
    					} else {
    						System.exit(-1);
    					}
    				}
    				
    				if (queryCnt % 10 == 0) {
    					curMode = -1;
    				}
    			}
    		} else {
    			int[][] r = new int[4][B];
    			Arrays.fill(r[0], -1);
    			Arrays.fill(r[1], -1);
    			Arrays.fill(r[2], -1);
    			Arrays.fill(r[3], -1);
    			
    			int curMode = -1;
    			int fillIdx = 0;
    			while(queryCnt < 150) {
    				if (curMode == -1) {
    					System.out.println(sP); queryCnt++;
	        			int a1 = in.nextInt();
	        			int b1 = a1;

	        			System.out.println(dP); queryCnt++;
	        			int a2 = in.nextInt();
	        			int b2 = (a2 ==0) ? 1 : 0;
	        			
		    			if (r[0][sP-1] == -1) {
		        			putValue(r, curMode, sP, B, a1, b1);
		        			putValue(r, curMode, dP, B, a2, b2);
		    				curMode = 0;
		    			} else {
		        			if (r[0][sP-1] == a1 && r[0][dP-1] == a2) {
		        				curMode = 0;
		        			} else if (r[0][sP-1] != a1 && r[0][dP-1] != a2) {
		        				curMode = 1;
		        			} else if (r[0][sP-1] == a1 && r[0][dP-1] != a2) {
		        				curMode = 2;
		        			} else if (r[0][sP-1] != a1 && r[0][dP-1] == a2) {
		        				curMode = 3;
		        			}
		    			}
    				} else {
    					while (r[0][fillIdx] != -1 && fillIdx < (B / 2)) {
    						fillIdx++;
    					}
    					if (fillIdx < (B / 2)) {
    						System.out.println(fillIdx + 1); queryCnt++;
		        			int a1 = in.nextInt();
		    				System.out.println(B-fillIdx); queryCnt++;
		        			int b1 = in.nextInt();
		        			putValue(r, curMode, fillIdx + 1, B, a1, b1);
	    					fillIdx++;
    					}
    				}
    				
    				if (fillIdx >= (B / 2)) {
    					String rStr = "";
    					for (int i=0; i<B; i++) {
    						rStr = rStr + r[curMode][i];
    					}
    					System.out.println(rStr);
    					
    					String res = in.next();
    					if (res.equals("Y")) {
    						break;
    					} else {
    						System.exit(-1);
    					}
    				}
    				
    				if (queryCnt % 10 == 0) {
    					curMode = -1;
    				}
    			}
    		}
    	}
        in.close();
	}
	
	private static void putValue(int[][] r, int curMode, int p, int B, int a, int b) {
		if (curMode == 0) {
			r[0][p-1] = a;
			r[1][p-1] = (a==0) ? 1 : 0;
			r[2][p-1] = b;
			r[3][p-1] = (b==0) ? 1 : 0;

			r[0][B-p] = b;
			r[1][B-p] = (b==0) ? 1 : 0;
			r[2][B-p] = a;
			r[3][B-p] = (a==0) ? 1 : 0;
		} else if (curMode == 1) {
			r[0][p-1] = (a==0) ? 1 : 0;
			r[1][p-1] = a;
			r[2][p-1] = (b==0) ? 1 : 0;
			r[3][p-1] = b;

			r[0][B-p] = (b==0) ? 1 : 0;
			r[1][B-p] = b;
			r[2][B-p] = (a==0) ? 1 : 0;
			r[3][B-p] = a;
		} else if (curMode == 2) {
			r[0][p-1] = b;
			r[1][p-1] = (b==0) ? 1 : 0;
			r[2][p-1] = a;
			r[3][p-1] = (a==0) ? 1 : 0;

			r[0][B-p] = a;
			r[1][B-p] = (a==0) ? 1 : 0;
			r[2][B-p] = b;
			r[3][B-p] = (b==0) ? 1 : 0;
		} else if (curMode == 3) {
			r[0][p-1] = (b==0) ? 1 : 0;
			r[1][p-1] = b;
			r[2][p-1] = (a==0) ? 1 : 0;
			r[3][p-1] = a;

			r[0][B-p] = (a==0) ? 1 : 0;
			r[1][B-p] = a;
			r[2][B-p] = (b==0) ? 1 : 0;
			r[3][B-p] = b;
		}
	}
	
	private static void putValue2(int[][] r, int curMode, int p, int B, int a, int b) {
		if (curMode == 0) {
			r[0][p-1] = a;
			r[1][p-1] = (a==0) ? 1 : 0;

			r[0][B-p] = b;
			r[1][B-p] = (b==0) ? 1 : 0;
		} else if (curMode == 1) {
			r[0][p-1] = (a==0) ? 1 : 0;
			r[1][p-1] = a;

			r[0][B-p] = (b==0) ? 1 : 0;
			r[1][B-p] = b;
		}
	}
}
