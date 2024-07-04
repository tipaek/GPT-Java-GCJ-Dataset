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
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int i=0;i<T;i++) {
			String S = scanner.next();
			String S=nestingDepth(S);
			System.out.println("Case #"+(i+1)+": "+S);
		}
	}
}