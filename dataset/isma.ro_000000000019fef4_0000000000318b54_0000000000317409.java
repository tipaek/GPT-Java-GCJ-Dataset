

////////////////////////////////////////
////////////////////////////////////////
////////////////////////////////////////

import java.util.*;


public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		in.nextLine();
		for (int a = 0; a < T; a++) {
			String sol="";
			String line = in.nextLine();

			String [] data =line.split(" ");
	
			int x = Integer.parseInt(data[0]);
			int y = Integer.parseInt(data[1]);
			String cm = data[2].trim();
			boolean done =false;
			for (int i = 0; i < cm.length(); i++) {
				if (Math.abs(x)+Math.abs(y)<=i && !done){
					sol = i+"";
					done=true;
				}
				if(cm.charAt(i)=='S'){
					y--;
				}
				if(cm.charAt(i)=='W'){
					x--;
				}
				if(cm.charAt(i)=='E'){
					x++;
				}
				if(cm.charAt(i)=='N'){
					y++;
				}
				
			}
			
			if (Math.abs(x)+Math.abs(y)<=cm.length() && !done){
				sol = cm.length()+"";
				done=true;
			}
			if(!done){
				sol= "IMPOSSIBLE";
			}
			
			System.out.println("Case #"+(a+1)+": "+sol);
			
			
			
		}

	}

}