import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		int q = 1;
		for(; t > 0; t--) {
			int n =  sc.nextInt();
			ArrayList<Integer> starts = new ArrayList<Integer>();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			ArrayList<Integer> ends = new ArrayList<Integer>();
			
			for(int i = 0; i < n; i++) {
				int a = sc.nextInt();
				starts.add(a);
				temp.add(a);
				ends.add( sc.nextInt());
			}
			
			
	
			int cstart = Collections.min(starts);
			int index = starts.indexOf(cstart);
			int cend = ends.get(index);
			starts.remove(index);
			ends.remove(index);
			char[] out = new char[n];
			out[index] = 'C';
			int jstart=0,jend=0;
			boolean imp = false;
			for(int i = 1; i < n; i++) {
				int newStart = Collections.min(starts);
				int newInd = starts.indexOf(newStart);
				int ind = temp.indexOf(newStart);
				
				if(newStart >= cend) {
					out[ind] = 'C';
					cstart = newStart;
					cend = ends.get(newInd);
					starts.remove(newInd);
					ends.remove(newInd);
				} else if(newStart >= jend) {
					out[ind] = 'J';
					jstart = newStart;
					jend = ends.get(newInd);
					starts.remove(newInd);
					ends.remove(newInd);
				} else {
					imp = true;
					i=n;
				}
			}
			if(imp) {
				System.out.println("Case #" + q + ": " + "IMPOSSIBLE");
			} else {
				String print = "";
				for(int z = 0; z < n; z++) {
					print += out[z];
				}
				System.out.println("Case #" + q + ": " + print);
			}
			q++;
		}
	}

}
