

import java.util.Scanner;

class Solution{
	public static void main(String[] args) {
		Scanner inpScanner = new Scanner(System.in);
		int test = inpScanner.nextInt();
		for(int k = 0;k<test;k++) {
			String string = inpScanner.next();
			StringBuffer stringBuffer = new StringBuffer();
			StringBuffer finalStringBuffer = new StringBuffer();
			stringBuffer.append("0");
			stringBuffer.append(string);
			stringBuffer.append("0");
			//char[] charStr = stringBuffer.toString().toCharArray();
			for(int i = 0;i<stringBuffer.length()-1;i++) {
				
				int num = Character.getNumericValue(stringBuffer.charAt(i+1)) - Character.getNumericValue(stringBuffer.charAt(i));
				if(num==0) {
					finalStringBuffer.append(stringBuffer.charAt(i+1));
				}else if(num>0) {
					for(int j = 0;j<num;j++) {
						finalStringBuffer.append("(");
					}
					finalStringBuffer.append(stringBuffer.charAt(i+1));
				}else {
					int neg = Math.abs(num);
					for(int j = 0;j<neg;j++) {
						finalStringBuffer.append(")");
					}
					finalStringBuffer.append(stringBuffer.charAt(i+1));
				}
			}
			int subLen = finalStringBuffer.length();
			String finalString = finalStringBuffer.substring(0, subLen-1);
			System.out.println("Case #"+(k+1)+": "+finalString);
		}
		
// 		System.out.println("Hello");
	}

}
