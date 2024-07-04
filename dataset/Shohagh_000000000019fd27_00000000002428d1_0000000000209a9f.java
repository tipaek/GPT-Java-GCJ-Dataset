import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution {
    class BracketCalcDS {
    	int value = 0;
    	int leftBracketNumber = 0;
    	int rightBracketNumber = 0;
    
    	BracketCalcDS(int val, int left, int right) {
    	    value = val;
    	    leftBracketNumber = left;
    	    rightBracketNumber = right;
    	}
    
    	void incLeft() {
    	    leftBracketNumber++;
    	}
    
    	void incRight() {
    	    rightBracketNumber++;
    	}
    
    	int getValue() {
    	    return value;
    	}
    
    	int getLeftBracketNumber() {
    	    return leftBracketNumber;
    	}
    
    	int getRightBracketNumber() {
    	    return rightBracketNumber;
    	}
    }

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	int T = scan.nextInt();
    	for (int cs = 1; cs <= T; cs++) {
    	    String S = scan.next();
    	    Solution obj = new Solution();
    	    List<Integer> positionList[] = new ArrayList[10];
    	    for (int i = 0; i < 10; i++) {
    		    positionList[i] = new ArrayList<Integer>();
    	    }
    	    List<BracketCalcDS> resultList = new ArrayList<BracketCalcDS>();
    	    for (int i = 0; i < S.length(); i++) {
        		int value = S.charAt(i) - '0';
        		BracketCalcDS cur = obj.new BracketCalcDS(value, 0, 0);
        		resultList.add(cur);
        		positionList[value].add(i);
    	    }
    	    for (int i = 9; i > 0; i--) {
        		List<Integer> positions = positionList[i];
        		Collections.sort(positions);
    		    for (int j = 0; j < positions.size(); j++) {
        		    int left = positions.get(j);
        		    int right = positions.get(j);
        		    int k = j;
        		    while (k + 1 < positions.size()
        			    && right + 1 == positions.get(k + 1)) {
            			right++;
            			k++;
        		    }
        		    // update left to right
        		    resultList.get(left).incLeft();
        		    resultList.get(right).incRight();
    
        		    // insert these into next list
        		    positionList[i - 1].addAll(positions.subList(j, k + 1));
        		    if (k != j) {
            			j = k;
        		    }
    		    }
    	    }
    	    StringBuilder resultStr = new StringBuilder();
    	    for (BracketCalcDS cur : resultList) {
        		resultStr
        			.append(getBracketStr(cur.getLeftBracketNumber(), '('));
        		resultStr.append(cur.getValue());
        		resultStr
        			.append(getBracketStr(cur.getRightBracketNumber(), ')'));
    	    }
    	    System.out.println("Case #" + cs + ": " + resultStr.toString());
    	}
    	scan.close();
    }

    static String getBracketStr(int number, char c) {
    	StringBuilder result = new StringBuilder();
    	for (int i = 0; i < number; i++) {
    	    result.append(c);
    	}
    	return result.toString();
    }
}