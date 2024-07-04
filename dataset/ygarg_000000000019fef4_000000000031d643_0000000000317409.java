import java.io.*;
import java.util.*;

public class Solution {
	public static ArrayList<ArrayList<Integer>> cords;
	
	
	public static boolean canReach (int minute) {
		
		int required = Math.abs(cords.get(minute).get(0)) + Math.abs(cords.get(minute).get(1));
		if (required > minute)
			return false;
		
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(in.readLine());
		
		for (int t = 0; t < test; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String path = st.nextToken();
			
			cords = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(x);
			temp.add(y);
			ArrayList<Integer> temp1 = new ArrayList<Integer>(temp);
			cords.add(temp1);
			
			for (int i = 0; i < path.length(); i++) {
				if (path.substring(i, i+1).equals("N")) {
					temp.set(1, temp.get(1) + 1);
					ArrayList<Integer> temp2 = new ArrayList<Integer>(temp);
					cords.add(temp2);
				}
				if (path.substring(i, i+1).equals("E")) {
					temp.set(0, temp.get(0) + 1);
					ArrayList<Integer> temp2 = new ArrayList<Integer>(temp);
					cords.add(temp2);
				}
				if (path.substring(i, i+1).equals("S")) {
					temp.set(1, temp.get(1) - 1);
					ArrayList<Integer> temp2 = new ArrayList<Integer>(temp);
					cords.add(temp2);
				}
				if (path.substring(i, i+1).equals("W")) {
					temp.set(0, temp.get(0) - 1);
					ArrayList<Integer> temp2 = new ArrayList<Integer>(temp);
					cords.add(temp2);
				}
			} //cords is made
			
//			System.out.println(cords);
			
//			int doesItReach = -1;
//			for (int m = 0; m < cords.size(); m++) {
//				if (canReach(m)) {
//					doesItReach = m;
//					break;
//				}
//			}
			
			if (!canReach(path.length())) {
				System.out.println("Case #" + (t+1) + ": IMPOSSIBLE");
			}
			else {
				int beg = 0;
				int end = path.length();
				while (end > beg) {
					int mid = (beg+end)/2;
					boolean works = canReach(mid);
					if (works)
						end = mid;
					else
						beg = mid+1;
				}
				System.out.println("Case #" + (t+1) + ": " + beg);
			}
			
			
			
			
			
		}
		
		
	}
}
