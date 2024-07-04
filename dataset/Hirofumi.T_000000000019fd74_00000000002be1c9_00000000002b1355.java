import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner input = new Scanner(System.in);
        int numberT = input.nextInt();

        for (int caseNum = 1; caseNum <= numberT; caseNum++) {
            int numR = input.nextInt();
            int numC = input.nextInt();
            int[][] dancers =  new int[numR][numC];
            for (int i = 0; i < numR; i++) {
            	for (int j = 0; j < numC; j++) {
            		dancers[i][j] = input.nextInt();
            	}
            }
            int answer = solver(numR, numC, dancers);
            System.out.println("Case #"+caseNum+": " + answer);
        }
    }

    private static int solver(int numR, int numC, int[][] dancers) {
    	int roundSum = 0;
    	int beforeSum = 0;
    	int answer = 0;
    	ArrayList<int[]> list = new ArrayList<>();
    	while (true) {
    		for (int r = 0; r < numR; r++) {
    			for (int c = 0; c < numC; c++) {
    				roundSum += dancers[r][c];
    				int vsSkil = 0;
    				int i = r - 1;
    				int count = 0;
    				while (true) {
    					if (i < 0) {
    						count++;
    						break;
    					}
    					if (dancers[i][c] != 0) {
    						vsSkil += dancers[i][c];
    						break;
    					}
    					i--;
    					if (i < 0) {
    						count++;
    						break;
    					}
    				}
    				i = r + 1;
    				while (true) {
    					if (i >= numR) {
    						count++;
    						break;
    					}
    					if (dancers[i][c] != 0) {
    						vsSkil += dancers[i][c];
    						break;
    					}
    					i++;
    					if (i >= numR) {
    						count++;
    						break;
    					}
    				}
    				i = c - 1;
    				while (true) {
    					if (i < 0) {
    						count++;
    						break;
    					}
    					if (dancers[r][i] != 0) {
    						vsSkil += dancers[r][i];
    						break;
    					}
    					i--;
    					if (i < 0) {
    						count++;
    						break;
    					}
    				}
    				i = c + 1;
    				while (true) {
    					if (i >= numC) {
    						count++;
    						break;
    					}
    					if (dancers[r][i] != 0) {
    						vsSkil += dancers[r][i];
    						break;
    					}
    					i++;
    					if (i >= numC) {
    						count++;
    						break;
    					}
    				}
    				float ave = 0;
    				if (count < 4) {
    					ave = (float)vsSkil / (4 - count);
    				}

    				if (dancers[r][c] < ave) {
    					int [] eli = {r ,c};
    					list.add(eli);
    				}
    			}
    		}
    		if (roundSum == beforeSum) {
    			break;
    		}
    		answer += roundSum;
    		beforeSum = roundSum;
    		roundSum = 0;
    		for (int[] eli: list) {
    			dancers[eli[0]][eli[1]] = 0;
    		}
    	}
    	return answer;
    }
}
