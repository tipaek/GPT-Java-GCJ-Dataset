import java.util.Scanner;

public class Solution {
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int test=1; test<=t ; test++) {
			System.out.print("Case #" + test + ": ");
			String s = sc.next();
			for(int i=0; i<s.length(); i++) {
				if(Integer.parseInt(Character.toString(s.charAt(i))) > count ) {
					int tmp = Integer.parseInt(Character.toString(s.charAt(i))) - count;
					for(int k=0; k<tmp; k++) {
						printOpenPara();						
					}
					System.out.print(s.charAt(i));
				} else if(Integer.parseInt(Character.toString(s.charAt(i))) == count) {
					System.out.print(s.charAt(i));
				} else {
					int tmp = count - Integer.parseInt(Character.toString(s.charAt(i))) ;
					for(int k=0; k<tmp; k++) {
						printClosePara();					
					}
					System.out.print(s.charAt(i));
				}
			}
			if(count != 0 ) {
				int tmp = count;
				for(int k=0 ;k<tmp; k++) {
					printClosePara();
				}
			}
			System.out.println();
		}
	}
	
	static void printOpenPara() {
		System.out.print("(");
		count++;
	}
	static void printClosePara() {
		System.out.print(")");
		count--;
	}
	static void checkNext(char c, char c1) {
		if(c == c1) {
			System.out.print(c);
		}
	}
}
