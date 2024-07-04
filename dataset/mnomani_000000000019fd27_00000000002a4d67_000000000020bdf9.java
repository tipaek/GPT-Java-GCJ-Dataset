import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		int q = 1;
		for(; t > 0; t--) {
			int n =  sc.nextInt();
			ArrayList<Integer> starts = new ArrayList<Integer>();
			int[] temp = new int[n];
			ArrayList<Integer> ends = new ArrayList<Integer>();
			
			for(int i = 0; i < n; i++) {
				int a = sc.nextInt();
				starts.add(a);
				temp[i] = a;
				ends.add( sc.nextInt());
			}
			
			String out = "";
	
			int cstart = Collections.min(starts);
			int index = starts.indexOf(cstart);
			int cend = ends.get(index);
			starts.remove(index);
			ends.remove(index);
			out += 'C';
			int jstart=0,jend=0;
			for(int i = 1; i < n; i++) {
				int newStart = Collections.min(starts);
				int newInd = starts.indexOf(newStart);
				
				if(newStart >= cend) {
					out += 'C';
					cstart = newStart;
					cend = ends.get(newInd);
					starts.remove(newInd);
					ends.remove(newInd);
				} else if(newStart >= jend) {
					out += 'J';
					jstart = newStart;
					jend = ends.get(newInd);
					starts.remove(newInd);
					ends.remove(newInd);
				} else {
					out = "IMPOSSIBLE";
					i=n;
				}
			}
			System.out.println("Case #" + q + ": " + out);
			q++;
		}
	}

}
