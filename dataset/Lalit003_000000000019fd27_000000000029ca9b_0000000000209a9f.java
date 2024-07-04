//package datastructure;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
class Test{
    
    	static String nestingDepth(String str) {
		String result="";
		int leftBracket=0,rightBracket=0;
		for(int i=0;i<str.length();i++) {
			
			int indexValue=Character.getNumericValue(str.charAt(i));
			int diff=indexValue-(leftBracket-rightBracket);
			if(diff<0) {
				while(diff!=0 && rightBracket<leftBracket) {
					result+=')';
					rightBracket++;
					diff++;
				}
			}
			else if(rightBracket-leftBracket==0 && indexValue>0) {
				for(int j=0;j<indexValue;j++) {
					result+='(';
					leftBracket++;
				}
			}
			else {
				while(diff!=0) {
					result+='(';
					leftBracket++;
					diff--;
				}
			}
			result+=String.valueOf(indexValue);
		}
		while(leftBracket!=rightBracket) {
			result+=')';
			rightBracket++;
		}
		return result;
	}
	
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int i = 1; i <= t; ++i) {
	    	String S = in.next();
	    	S=nestingDepth(S);
	    	System.out.println("Case #" + i + ": " + S);
	    }
	}
}