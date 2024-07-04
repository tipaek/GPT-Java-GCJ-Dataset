

import java.util.*;
import java.io.*;

public class Solution {

	static class IntervalComparator implements Comparator<int[]> {
		@Override
		public int compare(int[] a, int[] b) {
			return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int totInp = Integer.valueOf(reader.readLine());

		for (int i = 0; i < totInp; i++) {

			int size = Integer.valueOf(reader.readLine());

			int[][] ma = new int[size][3];

			for (int iz = 0; iz < size; iz++) {
				String inp = reader.readLine();

				String s[] = inp.split(" ");

				for (int ix = 0; ix < 2; ix++) {

					ma[iz][ix] = Integer.parseInt(s[ix]);
					
				}
				ma[iz][2]=iz;

			}
			
			
			Collections.sort(Arrays.asList(ma), new IntervalComparator());
			

			ArrayList<Integer> C= new ArrayList<>();
			ArrayList<Integer> J= new ArrayList<>();
			
			char [] timer = new char[size];
			
			boolean passer=false;
			StringBuilder sb = new StringBuilder();
			for(int row=0; row<size; row++) {
				if(C.size()==0){ //if C empty, initial
					C.add(ma[row][0]);
					C.add(ma[row][1]);
					timer[ma[row][2]]='C';
					
				}else if(J.size()==0) { //if J empty, intial
					J.add(ma[row][0]);
					J.add(ma[row][1]);
					timer[ma[row][2]]='J';


				}else if(ma[row][0] >= C.get(C.size()-1)){ //if the last end time of C is smaller or eq than nxt starting time, VALID
					C.add(ma[row][0]);
					C.add(ma[row][1]);
					timer[ma[row][2]]='C';
				}else if(ma[row][0] < C.get(C.size()-1) && ma[row][0] < J.get(J.size()-1)){ // if nxt starting is smaller than both end times
					System.out.print("Case #"+(i+1)+": "+"IMPOSSIBLE");
					passer=true;
					break;
				}
				else if(ma[row][0] >= J.get(J.size()-1)) { // //if the last end time of J is smaller or eq than nxt starting time, VALID
					J.add(ma[row][0]);
					J.add(ma[row][1]);
					timer[ma[row][2]]='J';
				}
				
			}
			if(passer==false) {
				System.out.print("Case #"+(i+1)+": ");
				for(int it=0;it<timer.length; it++) {
					System.out.print(timer[it]);
				}
			}
			System.out.println();
//			System.out.println("=============================");
//			
//			System.out.println("C " +C);
//			System.out.println("J "+J);
//			
			//System.out.println(Arrays.deepToString(ma));
		}

		

	}

}
