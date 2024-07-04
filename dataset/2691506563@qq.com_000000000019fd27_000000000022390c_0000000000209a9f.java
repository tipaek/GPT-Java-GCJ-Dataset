import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int num=sca.nextInt();
		for (int q = 0; q < num; q++) {
			int cur=0;
			StringBuilder key=new StringBuilder();
			String val=sca.next();
			for(int i:val.toCharArray()) {
				if(cur<i-'0') {
					int d=i-'0'-cur;
					for(int j=0;j<d;j++) {
						key.append('(');
						cur++;
					}
				}else if(cur>i-'0') {
					int d=cur-i+'0';
					for(int j=0;j<d;j++) {
						key.append(')');
						cur--;
					}
				}
				key.append(i-'0');
			}
			for(int j=0;j<cur;j++) {
				key.append(')');
			}
			System.out.println("Case #"+q+": "+key);
		}
	}
}
