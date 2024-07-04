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
			createPeppurrPath(X, Y, moves, peppurrPAth);
			boolean possible = false;
			for(int i = 0; i<moves.length();i++ ) {
				int moveNumber = i+1;
				if(Math.abs(peppurrPAth.X.get(i))+Math.abs(peppurrPAth.Y.get(i))<=moveNumber) {
					System.out.println(String.format("Case #%s: %s",usease+1,moveNumber));
					possible = true;
					break;
				}
			}
			if(!possible) {
				System.out.println(String.format("Case #%s: IMPOSSIBLE",usease+1));

			}
			
			
			
			
			
			
//			int myX = 1;
//			for(int i =0;i<X;i++) {
//				myPath.X.add(myX);
//				myPath.Y.add(0);
//				myX++;
//			}
//
//
//			if(X< moves.length() ) {
//				int index = X;			
//				int myY = 0;//before move
//				int foundOn = -1;
//				for(int i = index;i<moves.length();i++ ) {
//					if(myY > peppurrPAth.Y.get(i+1)) {
//						if((myY - peppurrPAth.Y.get(i+1))!=0) {
//							myY--;
//							myPath.Y.add(myY);
//						}
//					}
//					else if(myY < peppurrPAth.Y.get(i+1)) {
//						if((peppurrPAth.Y.get(i+1)-myY)!=0) {
//							myY++;
//							myPath.Y.add(myY);
//						}
//					}
//					else {
//						foundOn = i+1;
//						break;
//					}
//				}
//				if(foundOn==-1) {
//					lastCheck(usease, moves.length(), peppurrPAth,myPath);
//
//				}
//				else {
//					System.out.println(String.format("Case #%s: %s",usease+1,foundOn));
//				}
//
//			}
//			else if(X==moves.length()) {
//				lastCheck(usease, moves.length(), peppurrPAth,myPath);
//			}
//			else {
//				System.out.println(String.format("Case #%s: IMPOSSIBLE",usease+1));
//
//			}


		}
	}


	private static void createPeppurrPath(int X, int Y, String moves, Path peppurrPAth) {
//		peppurrPAth.X.add(X);
//		peppurrPAth.Y.add(Y);

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
	}


	private static void lastCheck(int usease, int X, Path peppurrPAth, Path myPath) {
		if(peppurrPAth.Y.get(peppurrPAth.Y.size()-1)==myPath.Y.get(myPath.Y.size()-1)) {
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