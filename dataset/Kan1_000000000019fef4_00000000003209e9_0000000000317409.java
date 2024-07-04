import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Solution {


	static Solution sol = new Solution();
	 
	 
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);  // Create a Scanner object
		int T = scann.nextInt();


		for(int usease = 0; usease< T;usease++) {
			int X = scann.nextInt();
			int Y = scann.nextInt();
			String moves =  scann.next();

			
			Path myPath = new Path();
			myPath.X.add(0);
			myPath.Y.add(0);

			
			Path peppurrPAth = new Path();
			peppurrPAth.X.add(X);
			peppurrPAth.Y.add(Y);
			
			int lastX = X;
			int lastY = Y;
			
			for(char c : moves.toCharArray()) {
				
				switch (c) {
				case 'N':
					lastY++;
					peppurrPAth.X.add(lastX);
					peppurrPAth.Y.add(lastY);
					break;
				case 'S':
					lastY--;
					peppurrPAth.X.add(lastX);
					peppurrPAth.Y.add(lastY);
					break;
				}
			}
			
			if(X< moves.length() ) {
				
			
			int index = X;			
			int myY = 0;
			int foundOn = -1;
			for(int i = index;i<moves.length();i++ ) {
				if(myY > peppurrPAth.Y.get(i)) {
					if((myY - peppurrPAth.Y.get(i))>1) {
						myY--;
					}
				}
				else if(myY < peppurrPAth.Y.get(i)) {
					if((peppurrPAth.Y.get(i)-myY)>1) {
						myY++;
					}
				}
				else {
					foundOn = i;
					break;
				}
			}
			if(foundOn==-1) {
				lastCheck(usease, moves.length(), peppurrPAth);

			}
			else {
				System.out.println(String.format("Case #%s: %s",usease+1,foundOn));

			}
			
			}
			else if(X== moves.length()) {
				lastCheck(usease, moves.length(), peppurrPAth);

			}
			else {
				System.out.println(String.format("Case #%s: IMPOSSIBLE",usease+1));

			}
			
//			int nbMove = moves.length();
//			lastX = myPath.X.get(myPath.X.size()-1);
//			lastY = myPath.Y.get(myPath.Y.size()-1);
//			if(!(moves.contains("E") && moves.contains("W"))){
//				for(int i = 0 ;i< X;i++) {
//					lastX++;
//					myPath.X.add(lastX);
//					myPath.Y.add(lastY);
//				}
//			}
			
			
	
				


		}
	}


	private static void lastCheck(int usease, int X, Path peppurrPAth) {
		if(peppurrPAth.Y.get(peppurrPAth.Y.size()-1)==0) {
			System.out.println(String.format("Case #%s: %s",usease+1,X));

		}
		else{
			System.out.println(String.format("Case #%s: IMPOSSIBLE",usease+1));

		}
	}
	





}
class Path{
	List<Integer> X = new ArrayList<Integer>();
	List<Integer> Y = new ArrayList<Integer>();

	
	
}