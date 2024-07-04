import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	static int actX;
	static int actY;
	static String ansString;
	static boolean AnsFound;
	
	public static void main(String[] args) {
		
		
		
		 Scanner scanner = new Scanner(System.in);
		 int cases = scanner.nextInt();
		
		 for (int i = 0; i < cases; i++) {
			AnsFound = false;
			ansString = "";
			actX = scanner.nextInt();
			actY = scanner.nextInt();
			findPath(0, 0, 0, i);
			if(!AnsFound){
				System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
			}
		 }
	}
	
	private static void findPath(int x, int y, int i, int cs) {
		if(!AnsFound && Math.abs(x)<=Math.abs(actX) && Math.abs(y)<=Math.abs(actY)){
		int[][] posP = possiblePaths(x,y,i);
		for(int j=0;j<4;j++){
			if(posP[j][0] == actX && posP[j][1] == actY){
				AnsFound = true;
				switch (posP[j][2]) {
				case 0: ansString+="N";
						break;
				case 1: ansString+="E";
						break;
				case 2: ansString+="S";
					break;
				case 3: ansString+="W";
			
				}
				System.out.println("Case #"+(cs+1)+": "+ansString);
				return;
			} else {
				switch (posP[j][2]) {
					case 0: ansString+="N";
							break;
					case 1: ansString+="E";
							break;
					case 2: ansString+="S";
						break;
					case 3: ansString+="W";
				
				}
				findPath(posP[j][0],posP[j][1],i+1,cs);
				ansString = ansString.substring(0,i);
			}
		}	
		}
		
	}
	
	private static int[][] possiblePaths(int x, int y, int i) {
		int[][] posP = new int[4][3];
		i = (int) Math.pow(2, i);
		
			posP[0][0] = x;
			posP[0][1] = y+i;
			posP[0][2] = 0;

			posP[1][0] = x+i;
			posP[1][1] = y;
			posP[1][2] = 1;

			posP[2][0] = x;
			posP[2][1] = y-i;
			posP[2][2] = 2;

			posP[3][0] = x-i;
			posP[3][1] = y;
			posP[3][2] = 3;
		return posP;
	}


}
