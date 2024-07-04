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

			int[][] ma = new int[size][2];

			for (int iz = 0; iz < size; iz++) {
				String inp = reader.readLine();

				String s[] = inp.split(" ");

				for (int ix = 0; ix < 2; ix++) {

					ma[iz][ix] = Integer.parseInt(s[ix]);
				}

			}
			
			
			Collections.sort(Arrays.asList(ma), new IntervalComparator());
			

			ArrayList<Integer> C= new ArrayList<>();
			ArrayList<Integer> J= new ArrayList<>();
			boolean passer=false;
			StringBuilder sb = new StringBuilder();
			for(int row=0; row<size; row++) {
				if(C.size()==0 || ma[row][0] >= C.get(C.size()-1)){
					C.add(ma[row][0]);
					C.add(ma[row][1]);
					sb.append("C");
				}else if(ma[row][0] < C.get(C.size()-1) && J.size()==0) {
					J.add(ma[row][0]);
					J.add(ma[row][1]);
					sb.append("J");
				}else if(ma[row][0] < C.get(C.size()-1) && ma[row][0] < J.get(J.size()-1)){
					System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
					passer=true;
					break;
				}
				else if(ma[row][0] >= J.get(J.size()-1)) {
					J.add(ma[row][0]);
					J.add(ma[row][1]);
					sb.append("J");
				}
				
			}
			if(passer==false) System.out.println("Case #"+(i+1)+": "+sb);
			
//			System.out.println("=============================");
//			
//			System.out.println("C " +C);
//			System.out.println("J "+J);
//			
//			System.out.println(Arrays.deepToString(ma));
		}

		

	}

}
