import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int numCases = Integer.parseInt(in.nextLine());
        
        for (int currCase = 1; currCase <= numCases; currCase++) {
        	char[] charArr = in.nextLine().toCharArray();
        	StringBuffer sb = new StringBuffer();
        	long bracketCnt = 0;
        	
        	for (int i = 0; i < charArr.length; i++) {
        		int currInt = charArr[i] - '0';
        		
        		while (bracketCnt < currInt) {
        			sb.append("(");
        			bracketCnt++;
        		}
        		
        		while (bracketCnt > currInt) {
        			sb.append(")");
        			bracketCnt--;
        		}
        		
        		sb.append(currInt + "");
        	}
        	
        	while (bracketCnt > 0) {
        		sb.append(")");
        		bracketCnt--;
        	}
        	
        	System.out.println("Case #" + currCase + ": " + sb.toString());
        }
	}
}