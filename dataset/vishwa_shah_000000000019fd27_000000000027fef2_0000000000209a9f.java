import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.hasNext() ? scanner.nextInt() : 0;
		for(int t=1; t<=testCase ; t++){
			String s = scanner.hasNext() ? scanner.next() : "";
			StringBuilder answer = new StringBuilder("");
			char[] c = s.toCharArray();
			int opCount = 0;
			for(int i=0; i<s.length() ; i++){
				if(c[i] == 0){
					answer.append('0');
					continue;
				}
				int num = Integer.parseInt(String.valueOf(c[i]));
				if(num == opCount){
					answer.append(num);
					continue;
				}else if(num > opCount){
					int d = num - opCount;
					opCount = opCount + d;
					while(d>0){
						answer.append('(');
						d--;
					}
					answer.append(num);
				}else if(num < opCount){
					int d = opCount - num;
					opCount = opCount - d;
					while(d>0){
						answer.append(')');
						d--;
					}
						answer.append(num);
				}
				
			}
			if(opCount > 0){
				while(opCount > 0){
					answer.append(')');
					opCount --;
				}
			}
			System.out.println("Case #" + t + ": " + answer.toString());
		}
	}

}