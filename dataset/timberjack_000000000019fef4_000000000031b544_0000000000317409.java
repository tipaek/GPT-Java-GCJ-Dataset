package lastchance;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner=new Scanner(System.in);
		int T=scanner.nextInt();
		for(int t=0;t<T;t++) {
			boolean possible=false;
			int x=scanner.nextInt();
			int y=scanner.nextInt();
			String M=scanner.next();
			int time=M.length();
			System.out.println("Case #"+(t+1)+": ");
			int abstand=x+y;
			int ns=y;
			int we=-x;
			
			for(int i=0;i<=time;i++) {
				if(i>=abstand) {
					System.out.println(i);
					possible=true;
					break;
				}
				if(i<time) {
				if(M.charAt(i)=='N')ns++;
				else if(M.charAt(i)=='S')ns--;
				else if(M.charAt(i)=='E')we--;
				else if(M.charAt(i)=='W')we++;
				abstand=Math.abs(ns)+Math.abs(we);
				}
				
			}
			if(possible==false)System.out.println("IMPOSSIBLE");
		}
	}

}
