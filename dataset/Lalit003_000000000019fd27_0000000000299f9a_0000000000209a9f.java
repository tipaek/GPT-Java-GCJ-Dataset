class Test{
    
    	static String nestingDepth(String str) {
		String result="";
		int leftBracket=0,rightBracket=0;
		for(int i=0;i<str.length();i++) {
			
			int indexValue=Character.getNumericValue(str.charAt(i));
			//result+=addBrackets(leftBracket, indexValue, rightBracket, result);
			int diff=indexValue-(leftBracket-rightBracket);
			//System.out.println("iteration "+(i+1)+" ");
			//System.out.println("charati, leftBracket, diff, rightBracket: "+indexValue+"  "+leftBracket+"  "+diff+"  "+rightBracket);
			
			if(diff<0) {//if left brackets are higher than the current number add right bracket
				while(diff!=0 && rightBracket<leftBracket) {
					//System.out.println("loop1");
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
					//System.out.println("loop2");
					result+='(';
					leftBracket++;
					diff--;
				}
			}
			result+=String.valueOf(indexValue);
			//System.out.println("sub values are: "+result);
		}
		while(leftBracket!=rightBracket) {
			//System.out.println("loop3");
			result+=')';
			rightBracket++;
		}
		//System.out.println("value is: "+result);
		return result;
	}
	
	
	
	public static void main(String[] args) {
		//101    54321
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		//StringBuilder str = new StringBuilder();
		for(int i=0;i<count;i++) {
			String str = scanner.next();
			String result=nestingDepth(str);
			System.out.println("Case #"+(i+1)+": "+result);
		}
	}
}