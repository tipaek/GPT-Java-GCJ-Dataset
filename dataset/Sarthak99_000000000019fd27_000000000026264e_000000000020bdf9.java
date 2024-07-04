import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
	
	/**
	 *Cameron and Jamie's kid is almost 3 years old! 
	 *However, even though the child is more independent now, scheduling kid activities and domestic necessities is still a challenge for the couple.
	 *Cameron and Jamie have a list of N activities to take care of during the day.
	 *Each activity happens during a specified interval during the day.
	 *They need to assign each activity to one of them, so that neither of them is responsible for two activities that overlap.
	 *An activity that ends at time t is not considered to overlap with another activity that starts at time t.
	 *For example, suppose that Jamie and Cameron need to cover 3 activities: one running from 18:00 to 20:00, another from 19:00 to 21:00 and another from 22:00 to 23:00.
	 *One possibility would be for Jamie to cover the activity running from 19:00 to 21:00, with Cameron covering the other two. Another valid schedule would be for Cameron to cover the activity from 18:00 to 20:00 and Jamie to cover the other two.
	 *Notice that the first two activities overlap in the time between 19:00 and 20:00, so it is impossible to assign both of those activities to the same partner.
	 *Given the starting and ending times of each activity, find any schedule that does not require the same person to cover overlapping activities, or say that it is impossible.
	 */
	
	private static String val = "";
	
	public static void planner(ArrayList<ArrayList<Integer>> matrix) {
//		System.out.println("Total tasks");
//		System.out.println(matrix);
			
		ArrayList<ArrayList<Integer>> J = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> C = new ArrayList<ArrayList<Integer>>();
		int X0,X1,X_0,X_1=0;
		
		J.add(matrix.get(0));
//		System.out.println("Slot given to J:"+matrix.get(0));
		for(int x=1; x<matrix.size(); x++) {
			
			X0 = matrix.get(x).get(0);
			X1 = matrix.get(x).get(1);
			X_0 = matrix.get(x-1).get(0);
			X_1 = matrix.get(x-1).get(1);
			
			if(X0 >= X_1 && mySlot(matrix.get(x), J)) {
//				System.out.println("Slot given to J:"+matrix.get(x));
				J.add(matrix.get(x));
			} 
			else if(X0 >= X_0 && X0 <= X_1 && mySlot(matrix.get(x), C)) {
//				System.out.println("Slot given to C:"+matrix.get(x));
				C.add(matrix.get(x));
			} 
			else if(X0 <= X_0) {				
				if(X1 >= X_0 && X1 <= X_1 && mySlot(matrix.get(x), C)) {
//					System.out.println("Slot given to C:"+matrix.get(x));
					C.add(matrix.get(x));
				}
				else if(X1 <= X_0 && mySlot(matrix.get(x), J)) {
//					System.out.println("Slot given to J:"+matrix.get(x));
					J.add(matrix.get(x));
				}
				else if(X1 >= X_1 && mySlot(matrix.get(x), C)) {
//					System.out.println("Slot given to C:"+matrix.get(x));
					C.add(matrix.get(x));
				}
			}
		}
//		System.out.println("James has:");
//		System.out.println(J);
//		System.out.println("Carol has:");
//		System.out.println(C);		
		
		if(matrix.size() > (J.size()+C.size())) {
			val = "IMPOSSIBLE";
		}
//		
//		
//		if(validation(J) == -1) {
//			val = "IMPOSSIBLE";
////			System.out.println("J showed false");
//		} else if(validation(C) == -1) {
//			val = "IMPOSSIBLE";
////			System.out.println("C showed false");
//		} 
			else {		
			for(int i=0; i<matrix.size(); i++) {
				
				if(J.contains(matrix.get(i))) {
					val+="J";
				} else {
					val+="C";
				}			
			}
		}
		
//		System.out.println(val);
	}
	
	/*public static int validation(ArrayList<ArrayList<Integer>> parent) {
		
		int possible = -1;		
		int X0current,X1current,X0next,X1next=0;
		
		if(parent.size() == 1) {
			possible = 1;
		} else if(parent.size() == 0) {
			possible = 0;
		} else {
			for(int i=0; i<parent.size(); i++) {
				X0current = parent.get(i).get(0);X1current = parent.get(i).get(1);
//				System.out.println("X0current:"+X0current+" X1current:"+X1current);
				for(int j=0; j<parent.size();j++) {
					X0next = parent.get(j).get(0);
					X1next = parent.get(j).get(1);		
//					System.out.println("X0next:"+X0next+" X1next:"+X1next);
					if(X0current > X0next && X0current < X1next) {
//						System.out.println(X0current+ ">" +X0next+"&&"+ X0current +"<"+ X1next);
						possible = -1;
						break;
					}
					else if(X1current > X0next && X1current < X1next) {
//						System.out.println(X1current+ ">" +X0next+"&&"+ X1current +"<"+ X1next);
						possible = -1;
						break;
					} else {
//						System.out.println("showing true");
						possible = 0;
					}
				}
				if(possible == -1) {
					break;
				}
			}
		}
		return possible;
		
	} */
	
	public static boolean mySlot(ArrayList<Integer>current,  ArrayList<ArrayList<Integer>> parent) {
		
		int Xcur,Ycur,Xother,Yother=0;
		boolean assign = false;
		Xcur=current.get(0);
		Ycur=current.get(1);
		
		
		if(parent.size() == 0) {
			assign = true;
		} else {
			for(int i=0; i<parent.size(); i++) {
				
				Xother = parent.get(i).get(0);
				Yother = parent.get(i).get(1);
				
//				System.out.println("myslot: comparing "+current+" with"+parent.get(i) );
				
				if(Xcur > Xother && Xcur < Yother) {
					assign = false;
					break;
				}
				else if(Ycur >Xother && Ycur < Yother) {
					assign = false;
					break;
				}
				else {
					assign = true;
				}
			}
		}
		
		return assign;
		
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = 0;
		int N = 0;
		ArrayList<Integer> cols = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> rows = new ArrayList<ArrayList<Integer>>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=(Integer.parseInt(br.readLine()));
		for (int t=0; t<T; t++) {
			N = (Integer.parseInt(br.readLine()));
			for (int n=0; n<N; n++) {
				String[] arow = br.readLine().split(" ");
				cols.add(Integer.parseInt(arow[0]));
				cols.add(Integer.parseInt(arow[1]));
				rows.add(n, (ArrayList<Integer>) cols.clone());
				cols.clear();
			}
			planner(rows);
			System.out.println("Case #"+(t+1)+": "+val);
			val ="";
			N=0;
			rows.clear();
		}
	}
}