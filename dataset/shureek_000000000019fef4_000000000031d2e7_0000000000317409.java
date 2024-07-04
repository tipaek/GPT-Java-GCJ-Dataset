import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class Solution {
	

	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int tNum = sc.nextInt();
		for(int tCurr = 1; tCurr<=tNum ; tCurr++) {
			

			String result="IMPOSSIBLE";
			
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			String m=sc.next();
			char[] mArr=m.toCharArray();
			
			int movesX=x;
			int movesY=y;
			
			if((x==0)&&(y==0)){result="0";}
			else {
				for(int i=0;i<m.length();i++) {
					
					if(mArr[i]=='S')movesY--;
					if(mArr[i]=='W')movesX--;
					if(mArr[i]=='N')movesY++;
					if(mArr[i]=='X')movesX++;
					
					
					if((i+1)>=(Math.abs(movesX)+Math.abs(movesY))){
						result=String.valueOf(i+1);
						break;
					}
					if((i+1)>(Math.abs(movesX)+Math.abs(movesY))){
						result=String.valueOf(i+1);
						break;
					}
				}
			}

			
			//"IMPOSSIBLE";
			

			
			

			

			
			System.out.println(String.format("Case #%d: %s" , tCurr, result));
			
		}

		
		
		System.out.flush();
	}

	


}