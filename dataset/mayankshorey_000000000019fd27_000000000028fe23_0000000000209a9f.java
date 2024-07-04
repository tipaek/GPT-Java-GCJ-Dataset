import java.util.Scanner;

 class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int tc=1;tc<=t;++tc) {
			String s = input.next();
			StringBuilder resBuilder = new StringBuilder();
			int len = s.length();
			int openedBrackets=0;
			int closedBrackets=0;
			int prevNum=0;
			for(int i=0;i<len;++i) {
				int num = s.charAt(i)-'0';
				if(num>prevNum) {
					for(int j=0;j<num-prevNum;++j) {
						resBuilder.append("(");
						openedBrackets++;
					}
				}
				else {
					for(int j=0;j<prevNum-num;++j) {
						resBuilder.append(")");
						closedBrackets++;
					}
				}
				resBuilder.append(s.charAt(i));
				prevNum=num;
				while(i+1<len && s.charAt(i)==s.charAt(i+1)) {
					resBuilder.append(s.charAt(i+1));
					i++;
				}				
				
			}
			for(int i=0;i<openedBrackets-closedBrackets;++i)
			{
				resBuilder.append(")");
			}
			System.out.println("Case #"+tc+": "+resBuilder.toString());
		}
	}

}
