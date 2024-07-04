import java.util.ArrayList;
import java.util.Scanner;


public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1; i <= T; i++){
			int X = sc.nextInt();
			int Y = sc.nextInt();
			
			char[] p = sc.next().toCharArray();
			int[] current = {X,Y};
			int y = 1500;
			for(int j = 1; j <= p.length; j++){
				char direction = p[j-1];
				int[] newPos = {current[0], current[1]};
				switch(direction){
				case 'N':
					newPos[1]++;
					break;
				case 'S':
					newPos[1]--;
					break;
				case 'W':
					newPos[0]--;
					break;
				case 'E':
					newPos[0]++;
					break;
				}
				//System.out.println("At round t = " + j + " x " +newPos[0]+" y " +newPos[1]);
				if(Math.abs(newPos[0])+Math.abs(newPos[1]) <=j)
					y = Math.min(Math.max(j, Math.abs(newPos[0])+Math.abs(newPos[1])), y);
				current = newPos;
			}
			if(y == 1500)
				System.out.println("Case #"+i+ ": IMPOSSIBLE");
			else{

				System.out.println("Case #"+i+ ": "+y);
			}
		}
		sc.close();
	}

}
