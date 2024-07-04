import java.util.Scanner;

class Solution {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=0; i<t; i++) {
			String s = sc.next();
			String newStr = "";
			int count = 0;
			
			for(int j=0; j<s.length(); j++) {
				int num = Integer.parseInt(s.substring(j, j+1));
				if(num == count) {
					newStr += num;
				} else {
					while(num > count) {
						newStr += "(";
						count ++;
					}
					while(num < count) {
						newStr += ")";
						count --;
					}
					newStr += num;
				}
			}
			while(count != 0) {
				newStr += ")";
				count --;
			}
			System.out.println("Case #"+(i+1)+": "+newStr);
		}
	}
}