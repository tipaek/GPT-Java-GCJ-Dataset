import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Vestigium {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int test=1;test<=t;test++) {
			int n = Integer.parseInt(br.readLine());
			List<List<Integer>> a = new ArrayList<>();
			for(int line=0;line<n;line++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				a.add(new ArrayList<Integer>());
				for(int i=0;i<n;i++) {
					a.get(line).add(Integer.parseInt(stk.nextToken()));
				}				
			}
			
			int trace = getTrace(a);
			int numRowWithDup = rowsWithDup(a);
			int numColWithDup = colsWithDup(a);
			
			System.out.printf("Case #%d: %d %d %d\n",test,trace,numRowWithDup,numColWithDup);
		}

	}

	private static int colsWithDup(List<List<Integer>> a) {
		int n = a.size();
		int colCount = 0;
		for(int j=0;j<n;j++) {
			Set<Integer> h = new HashSet<>();
			for(int i=0;i<n;i++) {
				int k = a.get(i).get(j);
				if(!h.contains(k)) {
					h.add(k);
				} else {
					colCount++;
					break;
				}
			}
		}
		return colCount;
	}

	private static int rowsWithDup(List<List<Integer>> a) {
		int n = a.size();
		int rowCount = 0;
		for(int i=0;i<n;i++) {
			Set<Integer> h = new HashSet<>();
			for(int j=0;j<n;j++) {
				int k = a.get(i).get(j);
				if(!h.contains(k)) {
					h.add(k);
				} else {
					rowCount++;
					break;
				}
			}			
		}
		return rowCount;
	}

	private static int getTrace(List<List<Integer>> a) {
		int sum = 0, r = a.size();		
		for(int i=0;i<r;i++) {
			sum += a.get(i).get(i);
		}
		return sum;
	}

}
