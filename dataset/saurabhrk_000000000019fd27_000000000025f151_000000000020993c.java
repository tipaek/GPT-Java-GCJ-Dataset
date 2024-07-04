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
			List<List<Long>> a = new ArrayList<>();
			for(int line=0;line<n;line++) {
				StringTokenizer stk = new StringTokenizer(br.readLine());
				a.add(new ArrayList<Long>());
				for(int i=0;i<n;i++) {
					a.get(line).add(Long.parseLong(stk.nextToken()));
				}				
			}
			
			long trace = getTrace(a);
			long numRowWithDup = rowsWithDup(a);
			long numColWithDup = colsWithDup(a);
			
			System.out.println("Case #"+test+": "+trace+" "+numRowWithDup+" "+numColWithDup);
		}

	}

	private static long colsWithDup(List<List<Long>> a) {
		int n = a.size();
		long colCount = 0;
		for(int j=0;j<n;j++) {
			Set<Long> h = new HashSet<>();
			for(int i=0;i<n;i++) {
				long k = a.get(i).get(j);
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

	private static long rowsWithDup(List<List<Long>> a) {
		int n = a.size();
		long rowCount = 0;
		for(int i=0;i<n;i++) {
			Set<Long> h = new HashSet<>();
			for(int j=0;j<n;j++) {
				long k = a.get(i).get(j);
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

	private static long getTrace(List<List<Long>> a) {
		long sum = 0;
		int r = a.size();		
		for(int i=0;i<r;i++) {
			sum += a.get(i).get(i);
		}
		return sum;
	}

}
