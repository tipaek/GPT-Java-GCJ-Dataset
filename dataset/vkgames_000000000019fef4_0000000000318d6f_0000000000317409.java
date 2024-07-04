import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		int t = sc.nextInt();
		int c =0;
		while(t>0) {
			c++;
			t--;
			int x = sc.nextInt();
			int y = sc.nextInt();
			//represent as distances//shift
			String s = sc.next();
			int []xPos = new int[s.length()+1];
			int []yPos= new int[s.length()+1];
			xPos[0] = x; yPos[0] = y;
			for(int i=1;i<=s.length();i++) {
				xPos[i] = xPos[i-1]; yPos[i] = yPos[i-1];
				if(s.charAt(i-1)=='N') {
					yPos[i]++;
				}
				else if(s.charAt(i-1)=='E') {
					xPos[i]++;
				}
				else if(s.charAt(i-1)=='W') {
					xPos[i]--;
				}
				else {
					yPos[i]--;
				}
			}
			int minStep = 10000;
			for(int step=0;step<=s.length();step++) {
				//if achieveable
				if((Math.abs(xPos[step])+Math.abs(yPos[step]))<=step) {
					minStep = Math.min(minStep,step);
				}
			}
			if(minStep==10000) {
				System.out.println("Case #"+c+": "+"IMPOSSIBLE");
			}
			else {
				System.out.println("Case #"+c+": "+minStep);
			}
		}
	}
}
