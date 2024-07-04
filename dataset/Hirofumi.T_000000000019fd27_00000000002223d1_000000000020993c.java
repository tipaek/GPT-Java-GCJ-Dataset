import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner input = new Scanner(System.in);
        int numberT = input.nextInt();

        for (int caseNum = 1; caseNum <= numberT; caseNum++) {
            int numN = input.nextInt();
        	Integer[][] fields = new Integer[numN][numN];
            for (int i = 0; i < numN; i++) {
            	for (int j = 0; j < numN; j++) {
                	int row = input.nextInt();
            		fields[i][j] = row;
            	}
            }
            int[] answer = solver(numN, fields);
            System.out.println("Case #"+caseNum+": "
                + answer[0] + " " + answer[1] + " " + answer[2]);
        }
    }

    private static int[] solver(int numN, Integer[][] fields) {
    	int rowAnsCount = 0;
    	int columnAnsCount = 0;
    	HashSet<Integer> ansSet = new HashSet<>();
    	for (int i = 0; i < numN; i++) {
    		for (int j = 0; j < numN; j++) {
    			if (!ansSet.add(fields[i][j])) {
    				rowAnsCount++;
    				break;
    			}
    		}
        	ansSet.clear();
    	}
    	ansSet.clear();
    	for (int i = 0; i < numN; i++) {
    		for (int j = 0; j < numN; j++) {
    			if (!ansSet.add(fields[j][i])) {
    				columnAnsCount++;
    				break;
    			}
    		}
        	ansSet.clear();
    	}
    	
    	int sum = 0;
    	for (int i = 0; i < numN; i++) {
    		sum += fields[i][i];
    	}
    	
    	int[] ans = {sum, rowAnsCount, columnAnsCount};

    	return ans;
    }
}
