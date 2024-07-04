import java.util.Scanner;

public class Solution {

	public static String printPara(boolean type, int count) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		char c = (type) ? '(' : ')';
		while (i++ < count)
			sb.append(c);
		return sb.toString();

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numTests = input.nextInt();
		for (int i = 0; i < numTests; i++) {
			StringBuilder sb = new StringBuilder();
			int l = 0;
			String s = input.next();
			char[] arr = s.toCharArray();
			boolean isStart = true;
			for(char c : arr) {
				int n = c-'0';
				if(isStart) {
					sb.append(printPara(true, n)).append(c);
					l+=n;
					isStart=false;
				}
				else{
					int extraLeft = l-n;
					if(extraLeft>0) {
						sb.append(printPara(false, extraLeft)).append(c);
						l-=extraLeft;
					}else if(extraLeft<0) {
						sb.append(printPara(true, Math.abs(extraLeft))).append(c);
						l+=Math.abs(extraLeft);
					}else {
						sb.append(c);
					}
					
				}
			}
			sb.append(printPara(false, l));
			System.out.printf("Case #%d: ",i+1);
			System.out.println(sb.toString());
		}

	}
}
